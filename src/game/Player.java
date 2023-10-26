package game;

import java.util.Scanner;
public class Player {

	private String Name;
	private int Damage;
	private int Gold;
	private int HP;
	private int maxHP;
	private Inventory inventory;
	Scanner scan = new Scanner(System.in);
	
	public Player(String name) {
		Name = name;
		this.inventory = new Inventory();
	}
	
	public void selectChar() {
		switch (charMenu()) {
		case 1: {//Samurai
			setDamage(5);
			setHP(21);
			setGold(15);
			setMaxHP(HP);
			break;
		}
		case 2://archer
			setDamage(7);
			setHP(18);
			setGold(20);
			setMaxHP(HP);
			break;
			
		case 3: //knight
			setDamage(8);
			setHP(24);
			setGold(5);
			setMaxHP(HP);
			break;
		default:
		setDamage(5);
		setHP(21);
		setGold(15);
		setMaxHP(HP);
		} 
		
	printChar();	
	}
	
	public int getTotalDamage() {
		return this.getDamage()+ this.getInventory().getDamage();
	}
	
	public void printChar() {
		System.out.println("CHAMPION IS READY ");
		System.out.println("DAMAGE :\t" + getDamage());
		System.out.println("HP:\t" + getHP());
		System.out.println("GOLD:\t"+ getGold());
		
		}
	public int charMenu() {
		System.out.println("CHOOSE A CHARACTER :");
		System.out.println("1)SAMURAI   Damage: 5    HP: 21   GOLD : 15");
		System.out.println("2)ARCHER    Damage: 7    HP: 18   GOLD : 20");
		System.out.println("3)KNIGHT    Damage: 8    HP: 24   GOLD :  5");
		System.out.println("CHOOSE : ");
		int charID = scan.nextInt();
		
		while(charID < 0 || charID > 3) {
			System.out.println("Choose one character again : ");
			charID = scan.nextInt();
		}
		
		return charID;
	}
	
		public String getName() {
		return Name;
	}




	public void setName(String name) {
		Name = name;
	}




	public int getDamage() {
		return Damage;
	}


	public void setDamage(int damage) {
		Damage = damage;
	}


	public int getGold() {
		return Gold;
	}


	public void setGold(int gold) {
		Gold = gold;
	}


	public int getHP() {
		return HP;
	}


	public void setHP(int hP) {
		HP = hP;
	}




	public Inventory getInventory() {
		return inventory;
	}




	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public int getMaxHP() {
		return maxHP;
	}

	public void setMaxHP(int maxHP) {
		this.maxHP = maxHP;
	}
	
	
	
	
}