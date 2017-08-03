package com.xj.chainOfResp;

public class Director extends Leader {

	public Director(String name) {
		super(name);
	}

	@Override
	public void handleRequest(LeaveRequest request) {
		if (request.getLeaveDays() < 3) {
			System.out.println("����ͨ��");
		} else {
			this.nextLeader.handleRequest(request);
		}
	}

}
