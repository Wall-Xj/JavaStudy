package com.xj.chainOfResp;

public class GeneralManager extends Leader {

	public GeneralManager(String name) {
		super(name);
	}

	@Override
	public void handleRequest(LeaveRequest request) {
		if (request.getLeaveDays() < 30) {
			System.out.println("总经理通过");
		} else {
			System.out.println("no");
		}
	}

}
