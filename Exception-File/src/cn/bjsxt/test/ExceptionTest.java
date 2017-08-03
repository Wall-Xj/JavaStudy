package cn.bjsxt.test;


public class ExceptionTest {
	public static void main(String[] args) {
		// Scanner scanner=new Scanner(System.in);
		// int a=scanner.nextInt();
		// System.out.println(a);
		try {
			String str = "123456dsds";
			Integer i = new Integer(str);
			System.out.println(i.toString());
		} catch (Exception ex) {
			ex.printStackTrace();	
		}
	}
}
