package com.chilicode.JFroniusTBot;

public class Response {

	public Response() {

	}

	public Response(String line) {
		super();
		this.line = line;

	}

	/**
	 * @return the line
	 */
	public String getLine() {
		return line;
	}

	/**
	 * @param line the line to set
	 */
	public void setLine(String line) {
		this.line = line;
	}

	private String line;

	@Override
	public String toString() {
		return "Response [line =" + line + "]";
	}

}
