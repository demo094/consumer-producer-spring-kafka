package com.sample.common.model;

/**
 * Created by demo094 on 2019-03-31.
 */
public class ConsoleLog {
	private String text;

	public ConsoleLog() {
	}

	public ConsoleLog(String text) {
		this.text = text;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "ConsoleLog [text=" + this.text + "]";
	}
}
