package CW7.ZAD1;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

public class BmiCalculator extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Kalkulator BMI");

        Slider weightSlider = new Slider(40, 150, 70);
        Slider heightSlider = new Slider(1.4, 2.2, 1.75);

        Label weightLabel = new Label();
        Label heightLabel = new Label();
        Label bmiLabel = new Label();

        StringConverter<Number> converter = new NumberStringConverter();

        Bindings.bindBidirectional(weightLabel.textProperty(), weightSlider.valueProperty(), converter);
        Bindings.bindBidirectional(heightLabel.textProperty(), heightSlider.valueProperty(), converter);

        bmiLabel.textProperty().bind(Bindings.createStringBinding(() -> {
            double weight = weightSlider.getValue();
            double height = heightSlider.getValue();
            double bmi = weight / Math.pow(height, 2);
            return String.format("Twoje BMI: %.2f", bmi);
        }, weightSlider.valueProperty(), heightSlider.valueProperty()));

        VBox vBox = new VBox(weightLabel, weightSlider, heightLabel, heightSlider, bmiLabel);
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(15));

        Scene scene = new Scene(vBox, 300, 200);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

