package com.xiejun.thread.status;

public class StopDemo01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Study s=new Study();
		new Thread(s).start();
		//�ⲿ����
		for(int i=0;i<100;i++){
			if(i==50){
				s.stop();
			}
			System.out.println("main...--->"+i);
		}
	}

}

class Study implements Runnable {
	// �߳����ж����߳���ʹ�õı�ʶ
	private boolean flag=true;

	@Override
	public void run() {
		// �߳���ʹ�øñ�ʶ
		while (flag) {
			System.out.println("study thread...");
		}

	}
	//�����ṩ�����ı��ʶ
	public void stop(){
		this.flag=false;
	}
}
