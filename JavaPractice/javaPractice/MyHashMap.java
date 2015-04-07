package javaPractice;

import java.util.LinkedList;
/**
 * A hashMap that uses chaining (linked lists) to handle collisions
 * ack like:
 * 
 * Java HashMap provides in-built hash collision detection and resolution.
	If the Key is present in Map then it will be replaced.
	If the Key is not present in Map then it will increment the modCount
	(number of times this HashMap has been structurally modified) and place new entry using addEntry() method(Java 7). 
 *http://www.quora.com/Does-the-Java-HashMap-have-in-built-hash-collision-detection-and-resolution
 * @author yellow
 *	
 * @param <K>
 * @param <V>
 */
public class MyHashMap<K,V> {
	private final int MAX_SIZE = 10;
	LinkedList<Cell<K,V>>[] items;
	
	public MyHashMap(){
		//items = new LinkedList<Cell<K,V>>[MAX_SIZE];     can not write like this
		//LinkedList<Integer>[] res2= new LinkedList[10];
		items = (LinkedList<Cell<K,V>>[]) new LinkedList[MAX_SIZE]; //like cast to a type?
	}
	
	public int hashCodeKey(K key){
		return key.toString().length()%items.length;
	}
	
	public void put(K key, V value){
		int i = hashCodeKey(key);
		if(items[i]==null){
			items[i] = new LinkedList<Cell<K,V>>();
		}
		
		LinkedList<Cell<K,V>> collided = items[i];
		
		for(Cell<K,V> c : collided){
			if(c.equivalent(key)){
				collided.remove(c);
				break;
			}
		}
		Cell<K,V> cell = new Cell<K,V>(key,value);
		collided.add(cell);
	}
	
	public V get(K key){
		int i = hashCodeKey(key);
		if(items[i]==null)
			return null;
		LinkedList<Cell<K,V>> collided = items[i];
		for(Cell<K,V> c: collided){
			if(c.equivalent(key))
				return c.getValue();
		}
		return null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
