package game;
import java.util.Random;

public class Obstacle {
	private String name;
	private int damage, health, reward, maxNumber;
	public Obstacle(String name, int damage, int health, int reward, int maxNumber) {
		this.name = name;
		this.damage = damage;
		this.health = health;
		this.reward = reward;
		this.maxNumber = maxNumber;
	}
	
	public int obstCount() {
		Random r = new Random();
		return r.nextInt(this.maxNumber) + 1;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getReward() {
		return reward;
	}
	public void setReward(int reward) {
		this.reward = reward;
	}
	public int getMaxNumber() {
		return maxNumber;
	}
	public void setMaxNumber(int maxNumber) {
		this.maxNumber = maxNumber;
	}
	
	
	
}
