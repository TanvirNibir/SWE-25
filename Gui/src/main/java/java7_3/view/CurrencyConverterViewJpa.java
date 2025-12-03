package java7_3.view;

import entity.Currency;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java7_3.controller.CurrencyController;
import java7_3.dao.CurrencyJpaDao;
import java7_3.model.CurrencyModel;

public class CurrencyConverterViewJpa extends Application {

    @Override
    public void start(Stage stage) {
        CurrencyJpaDao dao = new CurrencyJpaDao();
        CurrencyModel model;
        CurrencyController controller;
        try {
            model = new CurrencyModel(dao);
            controller = new CurrencyController(model, dao);
        } catch (Exception e) {
            showStartupError("Database error on startup: " + e.getMessage());
            return;
        }

        BorderPane root = new BorderPane();
        root.setPadding(new Insets(15));

        Label title = new Label("Currency Converter (JPA)");
        title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        BorderPane.setAlignment(title, Pos.CENTER);
        root.setTop(title);

        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(10));

        Label amountLabel = new Label("Amount:");
        TextField amountField = new TextField();

        Label fromLabel = new Label("From Currency:");
        ComboBox<Currency> fromCurrency = new ComboBox<>(model.getCurrencies());
        fromCurrency.getSelectionModel().selectFirst();

        Label toLabel = new Label("To Currency:");
        ComboBox<Currency> toCurrency = new ComboBox<>(model.getCurrencies());
        if (model.getCurrencies().size() > 1) {
            toCurrency.getSelectionModel().select(1);
        }

        Label resultLabel = new Label("Converted:");
        TextField resultField = new TextField();
        resultField.setEditable(false);

        Button convertButton = new Button("Convert");
        Button addCurrencyButton = new Button("Add Currency");

        grid.add(amountLabel, 0, 0);
        grid.add(amountField, 1, 0);
        grid.add(fromLabel, 0, 1);
        grid.add(fromCurrency, 1, 1);
        grid.add(toLabel, 0, 2);
        grid.add(toCurrency, 1, 2);
        grid.add(resultLabel, 0, 3);
        grid.add(resultField, 1, 3);
        grid.add(convertButton, 1, 4);
        grid.add(addCurrencyButton, 1, 5);

        root.setCenter(grid);

        Label instructions = new Label("Enter amount, select currencies, then click Convert. Use 'Add Currency' to add new ones.");
        root.setBottom(instructions);
        BorderPane.setAlignment(instructions, Pos.CENTER);

        convertButton.setOnAction(e -> {
            try {
                double result = controller.handleConversion(
                        amountField.getText(),
                        fromCurrency.getValue(),
                        toCurrency.getValue()
                );
                resultField.setText(String.format("%.2f", result));
            } catch (Exception ex) {
                controller.showError(ex.getMessage());
            }
        });

        addCurrencyButton.setOnAction(e -> {
            AddCurrencyView addView = new AddCurrencyView(controller);
            addView.show(stage);
            // after window closes, combo boxes see updated model because they share the same ObservableList
        });

        Scene scene = new Scene(root, 450, 340);
        stage.setTitle("Currency Converter (JPA)");
        stage.setScene(scene);
        stage.show();
    }

    private void showStartupError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR, message, ButtonType.OK);
        alert.showAndWait();
    }
}


