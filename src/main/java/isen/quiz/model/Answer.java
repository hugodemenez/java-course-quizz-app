package isen.quiz.model;

public class Answer {

	private String text;

	private boolean goodAnswer;

	public Answer(String text, boolean goodAnswer) {
		super();
		this.text = text;
		this.goodAnswer = goodAnswer;
	}

	public String getText() {
		return text;
	}

	public boolean isGoodAnswer() {
		return goodAnswer;
	}

}
