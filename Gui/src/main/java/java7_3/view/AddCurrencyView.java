package java7_3.view;

import entity.Currency;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java7_3.controller.CurrencyController;

public class AddCurrencyView {

    private final CurrencyController controller;

    public AddCurrencyView(CurrencyController controller) {
        this.controller = controller;
    }

    public void show(Stage owner) {
        Stage stage = new Stage();
        stage.initOwner(owner);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setTitle("Add Currency");

        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(15));

        Label abbrevLabel = new Label("Abbreviation:");
        TextField abbrevField = new TextField();

        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();

        Label rateLabel = new Label("Rate to USD:");
        TextField rateField = new TextField();

        Button saveButton = new Button("Save");
        Button cancelButton = new Button("Cancel");

        grid.add(abbrevLabel, 0, 0);
        grid.add(abbrevField, 1, 0);
        grid.add(nameLabel, 0, 1);
        grid.add(nameField, 1, 1);
        grid.add(rateLabel, 0, 2);
        grid.add(rateField, 1, 2);
        grid.add(saveButton, 0, 3);
        grid.add(cancelButton, 1, 3);

        GridPane.setMargin(saveButton, new Insets(10, 5, 0, 0));
        GridPane.setMargin(cancelButton, new Insets(10, 0, 0, 5));

        saveButton.setOnAction(e -> {
            try {
                controller.addCurrency(
                        abbrevField.getText(),
                        nameField.getText(),
                        rateField.getText()
                );
                stage.close();
            } catch (Exception ex) {
                controller.showError(ex.getMessage());
            }
        });

        cancelButton.setOnAction(e -> stage.close());

        Scene scene = new Scene(grid, 320, 200);
        stage.setScene(scene);
        stage.showAndWait();
    }
}


