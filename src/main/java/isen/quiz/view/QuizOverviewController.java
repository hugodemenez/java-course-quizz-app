package isen.quiz.view;

import isen.quiz.App;
import isen.quiz.model.Question;
import isen.quiz.service.QuestionService;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.io.IOException;
import java.util.List;

public class QuizOverviewController {
    @FXML
    private Text questionText;

    @FXML
    private Button answerButton1;

    @FXML
    private Button answerButton2;

    @FXML
    private Button answerButton3;


    @FXML
    private List<Question> questions;

    @FXML
    private int currentQuestionIndex;

    @FXML
    private int score;


    @FXML
    private Text scoreText;



    @FXML
    private void initialize() throws IOException {
        QuestionService service = QuestionService.getInstance();
        questions =  service.getQuestions();
        currentQuestionIndex = 0;
        score=0;
        showCurrentQuestion();
    }

    @FXML
    private void showCurrentQuestion() throws IOException {
        printQuestionNumber();
        questionText.setText(questions.get(currentQuestionIndex).getQuestion());
        answerButton1.setText(questions.get(currentQuestionIndex).getAnswers().get(0).getText());
        answerButton2.setText(questions.get(currentQuestionIndex).getAnswers().get(1).getText());
        answerButton3.setText(questions.get(currentQuestionIndex).getAnswers().get(2).getText());
    }

    @FXML
    private void gameOver() {
        questionText.setText("");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game over");
        alert.setHeaderText("Game over");
        alert.setContentText("You got "+ String.valueOf(score)+" out of "+String.valueOf(questions.size())+" questions");
        alert.showAndWait().filter(response -> response == ButtonType.OK).ifPresent(response -> Platform.exit());
    }

    @FXML
    private void gotoNextQuestion() throws IOException {
        currentQuestionIndex+=1;

        if (currentQuestionIndex == questions.size()){
            gameOver();
        }
        else {
            showCurrentQuestion();
        }
    }

    @FXML
    private void handleAnswer(int answerIndex) throws IOException {
        if(questions.get(currentQuestionIndex).getAnswers().get(answerIndex).isGoodAnswer()){
            incrementScore();
        }
        gotoNextQuestion();

    }

    @FXML
    private void incrementScore(){
        score+=1;
        printScore();
    }

    @FXML
    private void handleAnswerButton1() throws IOException {
        handleAnswer(0);
    }

    @FXML
    private void handleAnswerButton2() throws IOException {
        handleAnswer(1);
    }

    @FXML
    private void handleAnswerButton3() throws IOException {
        handleAnswer(2);
    }

    @FXML
    private void printScore(){
        scoreText.setText("score : "+ String.valueOf(score));
    }


    @FXML
    private TextFlow questionNumber;

    @FXML
    private void printQuestionNumber(){
        Text index = new Text(String.valueOf(currentQuestionIndex+1));
        index.setFill(Color.BLUE);
        index.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD,14));
        Text text1 = new Text(" Question #");
        text1.setFont(Font.font("Arial", FontWeight.NORMAL,12));
        Text text2 = new Text(" / "+String.valueOf(questions.size()));
        text2.setFont(Font.font("Arial", FontWeight.NORMAL,12));
        questionNumber.getChildren().setAll(text1,index, text2);


    }
}