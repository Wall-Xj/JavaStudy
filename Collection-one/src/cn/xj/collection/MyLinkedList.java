package cn.xj.collection;

public class MyLinkedList {
	private Node first;
	private Node last;
	private int size;
	
	public void add(Object obj){
		if(first==null){
			Node n=new Node();
			n.setPrevious(null);
			n.setObj(obj);
			n.setNext(null);
			
			first=n;
			last=n;
		}else{
			Node n=new Node();
			n.setPrevious(last);
			n.setObj(obj);
			n.setNext(null);
			last.setNext(n);
			last=n;
		}
		size++;
	}
	
	public int size(){
		return size;
	}
	
	public static void main(String[] args) {
		MyLinkedList list=new MyLinkedList();
		list.add("aaa");
		list.add("bbb");
		System.out.println(list.size());
		
	}
	
}
