package Inheritance;

import java.util.LinkedList;

public class Dog extends Animal {//if Animal is not a ab
	public String name = null;
	private Dog(){
		//System.out.println("dog's name is dog");
	}
	private Dog(String name){
		//super(name);
		this.name=name;
		//System.out.println("dog's name is " + name);
	}
	public void sound(){
		System.out.println(name+" wong");
	}
//	public void eat(){
//		System.out.println(name+"eat");
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog mark = new Dog("Mark");
		Animal jay = new Dog("Jay");
		mark.eat();
		jay.eat();
//		Animal[] res = new Animal[10];
		
		//LinkedList<Integer>[] res2= (LinkedList<Integer>[]) new LinkedList[10];
		System.out.println(0%3);
	}

}
