module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens isen.quiz to javafx.fxml;
    exports isen.quiz;
    exports isen.quiz.view;
    opens isen.quiz.view to javafx.fxml;
}