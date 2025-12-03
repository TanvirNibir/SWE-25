package java6_2.view;

import dao.CurrencyDao;
import entity.Currency;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java6_2.controller.CurrencyController;
import java6_2.model.CurrencyModel;

import java.util.List;

public class CurrencyConverterView extends Application {

    @Override
    public void start(Stage stage) {
        CurrencyDao currencyDao = new CurrencyDao();
        CurrencyModel model;
        try {
            model = new CurrencyModel(currencyDao);
        } catch (Exception e) {
            // If the database is not available, fall back to an in-memory demo model
            model = createFallbackModel();
            showStartupWarning(
                    "Database is not available. Running with demo currency data only.\n\n"
                            + "Details: " + e.getMessage()
            );
        }
        CurrencyController controller = new CurrencyController(model, currencyDao);

        // Root layout
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(15));

        // Title
        Label title = new Label("Currency Converter");
        title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        BorderPane.setAlignment(title, Pos.CENTER);
        root.setTop(title);

        // Center layout
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(10));

        // Amount input
        Label amountLabel = new Label("Amount:");
        TextField amountField = new TextField();

        // From currency
        Label fromLabel = new Label("From Currency:");
        ComboBox<Currency> fromCurrency = new ComboBox<>(model.getCurrencies());
        fromCurrency.getSelectionModel().selectFirst();

        // To currency
        Label toLabel = new Label("To Currency:");
        ComboBox<Currency> toCurrency = new ComboBox<>(model.getCurrencies());
        toCurrency.getSelectionModel().select(1);

        // Result
        Label resultLabel = new Label("Converted:");
        TextField resultField = new TextField();
        resultField.setEditable(false);

        // Button
        Button convertButton = new Button("Convert");

        // Layout add
        grid.add(amountLabel, 0, 0);
        grid.add(amountField, 1, 0);
        grid.add(fromLabel, 0, 1);
        grid.add(fromCurrency, 1, 1);
        grid.add(toLabel, 0, 2);
        grid.add(toCurrency, 1, 2);
        grid.add(resultLabel, 0, 3);
        grid.add(resultField, 1, 3);
        grid.add(convertButton, 1, 4);

        root.setCenter(grid);

        // Instructions
        Label instructions = new Label("Enter amount, select currencies, then click Convert.");
        root.setBottom(instructions);
        BorderPane.setAlignment(instructions, Pos.CENTER);

        // Button event
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

        // Scene
        Scene scene = new Scene(root, 400, 300);
        stage.setTitle("Currency Converter");
        stage.setScene(scene);
        stage.show();
    }

    private CurrencyModel createFallbackModel() {
        List<Currency> demoCurrencies = List.of(
                new Currency("USD", "US Dollar", 1.0),
                new Currency("EUR", "Euro", 0.93),
                new Currency("GBP", "British Pound", 0.80),
                new Currency("JPY", "Japanese Yen", 147.0)
        );
        return new CurrencyModel(demoCurrencies);
    }

    private void showStartupWarning(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING, message, ButtonType.OK);
        alert.showAndWait();
    }
}

