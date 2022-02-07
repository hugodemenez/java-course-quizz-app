package isen.quiz.model;

import java.util.ArrayList;
import java.util.List;

public class Question {

	private String question;

	private List<Answer> answers;

	public Question(String question, Answer answer1, Answer answer2, Answer answer3) {
		super();
		this.question = question;
		this.answers = new ArrayList<>();
		this.answers.add(answer1);
		this.answers.add(answer2);
		this.answers.add(answer3);
	}

	public String getQuestion() {
		return question;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

}