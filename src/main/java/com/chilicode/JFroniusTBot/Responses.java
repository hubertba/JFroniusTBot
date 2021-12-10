package com.chilicode.JFroniusTBot;

import java.util.ArrayList;
import java.util.List;

public class Responses {
	private List<Response> responseList;

	public List<Response> getResponseList() {
		if (responseList == null) {
			responseList = new ArrayList<>();
		}
		return responseList;
	}

	public void setResponseList(List<Response> responseList) {
		this.responseList = responseList;
	}

	public Responses getAllPResponses() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addResponse(String string) {
		// TODO Auto-generated method stub

	}

}
