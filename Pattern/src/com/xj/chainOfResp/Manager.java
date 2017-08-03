package com.xj.chainOfResp;

public class Manager extends Leader {

	public Manager(String name) {
		super(name);
	}

	@Override
	public void handleRequest(LeaveRequest request) {
		if (request.getLeaveDays() < 10) {
			System.out.println("经理通过");
		} else {
			this.nextLeader.handleRequest(request);
		}
	}

}
