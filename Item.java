package webstore;
import java.util.*;

public class Item {
	int itemID;
	double itemPrice;
	String itemName= null;
	static ArrayList<Item> items = new ArrayList<Item>();//Creates an array of class objects
	double itemPricePreComparable;//holds a variable to be used for conversion/comparable
	int itemPriceComparable;//holds converted integer to be used for comparing
	
	public Item(String name, double price, int iD) {
		this.itemName = name;
		this.itemPrice = price;
		this.itemID = iD;
		this.itemPricePreComparable = price*100;//converts to easily comparable number with no rounding
		this.itemPriceComparable = (int)itemPricePreComparable;//converts double to int for comparable
	}
	
	public String getName() {
		return this.itemName;
	}
	public double getPrice() {
		return this.itemPrice;
	}
	public int getID() {
		return this.itemID;
	}
	
	public static void main(String[] args) {
		//Item tv = new Item("tv", 210.87, 13200);
		//Item shirt = new Item("shirt", 15.99, 15877);
		//Item iPad = new Item("iPad", 180.99, 12345);
		items.add(new Item("tv", 210.87, 13200));
		items.add(new Item("shirt", 15.99, 15877));
		items.add(new Item("iPad", 180.99, 12345));
		//sorterID();//(Ipad, TV, Shirt)
		//sorterPrice();//shirt, ipad, tv)
		//sorterName();//(ipad, shirt, tv)
		}
	
	public static void sorterID() {//ID sorting method
		Collections.sort(items, new ItemIDComparator());
		for( Item i : items) {
			System.out.println(i.getName());}
	}
	public static void sorterPrice() {//Price Sorting method
		Collections.sort(items, new ItemPriceComparator());
		for( Item i : items) {
			System.out.println(i.getName());}
	}
	public static void sorterName() {//Name sorting method
		Collections.sort(items, new ItemNameComparator());
		for( Item i : items) {
			System.out.println(i.getName());}
	}
	
}
class ItemIDComparator implements Comparator<Item> {//custom comparable for Item ID
    public int compare(Item arg0, Item arg1) {
        return arg0.itemID - arg1.itemID;}
}
class ItemPriceComparator implements Comparator<Item>{//Custom comparable for Item Price
	public int compare(Item arg0, Item arg1) {
		return arg0.itemPriceComparable - arg1.itemPriceComparable;}
}
class ItemNameComparator implements Comparator<Item>{// custom comparable for Item Names
	public int compare(Item arg0, Item arg1) {
		return arg0.itemName.compareToIgnoreCase(arg1.itemName);}
}
