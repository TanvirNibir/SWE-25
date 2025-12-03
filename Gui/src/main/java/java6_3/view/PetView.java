package java6_3.view;


import java6_3.controller.PetController;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.Pet;

public class PetView extends Application {
    private double targetX = -1;
    private double targetY = -1;

    @Override
    public void start(Stage stage) {
        Pet pet = new Pet(400, 300);
        PetController controller = new PetController(pet);

        Canvas canvas = new Canvas(800, 600);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Image petImage = new Image(getClass().getResourceAsStream("/8603071.png"), 140, 140, true, true);

        canvas.addEventHandler(MouseEvent.MOUSE_MOVED, e -> {
            targetX = e.getX();
            targetY = e.getY();
        });

        canvas.addEventHandler(MouseEvent.MOUSE_EXITED, e -> {
            targetX = -1;
            targetY = -1;
        });

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (targetX >= 0 && targetY >= 0) {
                    controller.update(targetX, targetY);
                }

                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

                double[] head = pet.getSegments().get(0);
                gc.drawImage(petImage, head[0] - petImage.getWidth() / 2, head[1] - petImage.getHeight() / 2);
            }
        }.start();

        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root);

        stage.setTitle("Virtual Pet");
        stage.setScene(scene);
        stage.show();
    }
}
