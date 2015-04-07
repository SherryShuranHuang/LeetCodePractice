package Inheritance;

public abstract class Animal {
	private String name = "animal";
	public Animal(){
		System.out.println("this is " + name);
	}
	protected Animal(String name){
		this.name = name;
		System.out.println("this animal's name is "+name );
	}
	public void eat(){
		System.out.println(name + "eat");
	}
	public abstract void sound();
	
}
