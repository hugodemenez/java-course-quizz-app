package isen.quiz.view;

import isen.quiz.App;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class HomeScreenController {
    @FXML
    private void handleLaunchButton() throws IOException {
        App.setRoot("view/QuizOverview");
    }

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}