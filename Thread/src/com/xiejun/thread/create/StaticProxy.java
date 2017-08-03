package com.xiejun.thread.create;

/**
 * ��̬���� ���ģʽ 1����ʵ��ɫ 2�������ɫ����ʵ��ɫ������ 3������ ʵ����ͬ�ӿ�
 * 
 * @author Administrator
 * 
 */
public class StaticProxy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// �������ǽ�ɫ
		Marry you = new You();
		// ���������ɫ+��ʵ��ɫ������
		WeddingCompany company = new WeddingCompany(you);
		//ִ������
		company.marry();
	}

}

// �ӿ�
interface Marry {
	void marry();
}

// ��ʵ��ɫ
class You implements Marry {

	@Override
	public void marry() {
		System.out.println("you and �϶����ˡ�������");
	}

}

// �����ɫ
class WeddingCompany implements Marry {
	private Marry you;

	public WeddingCompany(Marry you) {
		super();
		this.you = you;
	}

	private void before() {
		System.out.println("�����·���������");
	}

	private void after() {
		System.out.println("�ֶ�����������");
	}

	@Override
	public void marry() {
		before();
		you.marry();
		after();
	}

}
