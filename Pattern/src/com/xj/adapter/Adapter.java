package com.xj.adapter;

/**
 * ��������
 * @author WanYin
 *
 */
public class Adapter extends Adaptee implements Target {
	@Override
	public void handleReq() {
		super.request();
	}
}
