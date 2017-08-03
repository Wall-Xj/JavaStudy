package com.xj.chainOfResp;

public class Manager extends Leader {

	public Manager(String name) {
		super(name);
	}

	@Override
	public void handleRequest(LeaveRequest request) {
		if (request.getLeaveDays() < 10) {
			System.out.println("����ͨ��");
		} else {
			this.nextLeader.handleRequest(request);
		}
	}

}
