package game;

public abstract class BattleLoc extends Location {

	private Obstacle obstacle;
	private String reward;
	
	public BattleLoc(Player player, String name , Obstacle obstacle,String reward) {
		super(player);
		this.name = name;
		this.obstacle = obstacle;
		this.reward = reward;
	}

	public boolean getLocation() {
		int obsCount = obstacle.obstCount();
		System.out.println("Şu an buradasınız "+ this.getName() );
		System.out.println("Dikkatli ol! Burada "+ obsCount + "tane "+ obstacle.getName() + "yaşıyor !");
		System.out.println("<S>avaş veya <K>aç");
		String selCase = scan.next();
		selCase = selCase.toUpperCase();
		if(selCase.equals("S")) {
			if(combat(obsCount)) {
				System.out.println(this.getName()+" bölgesindeki tüm düşmaları temizlediniz");
				if(this.reward.equals("food") && player.getInventory().isFood() == false) {
					System.out.println(this.reward +" kazandınız.");
					player.getInventory().setFood(true);;
				}else if(this.reward.equals("water") && player.getInventory().isWater() == false) {
					System.out.println(this.reward +" kazandınız.");
					player.getInventory().setWater(true);
					}else if(this.reward.equals("firewood") && player.getInventory().isFirewood() == false) {
						System.out.println(this.reward +" kazandınız.");
						player.getInventory().setFirewood(true);}
				return true;
			}else {
				System.out.println("ÖLDÜNÜZ");
				System.out.println("Game Over");
				return false;
			}
		}
		return true;
	}
	
	
	public boolean combat(int obsCount) {
		for(int i=0; i<obsCount ; i++) {
			int defaultObsHP = obstacle.getHealth();
			playerStats();
			enemyStats();
			while(player.getHP() > 0 && obstacle.getHealth() > 0) {
				System.out.println("<V>ur veya <K>aç");
				String selCase = scan.next();
				selCase = selCase.toUpperCase();
				if(selCase.equals("V")) {
					System.out.println("Siz Saldırdınız");
					obstacle.setHealth(obstacle.getHealth() - player.getTotalDamage());
					afterHit();
					if(obstacle.getHealth() > 0) {
						System.out.println(obstacle.getName() + " size vurdu !");
						player.setHP(player.getHP()- (obstacle.getDamage()-player.getInventory().getArmor()));
						afterHit();
					}
				}else
					return false;
			}
			
			
			if(obstacle.getHealth()< player.getHP()) {
				System.out.println(obstacle.getName()+" düşmanını öldürdünüz.");
				player.setGold(player.getGold()+ obstacle.getReward());
				System.out.println("Güncel paranız: "+player.getGold());
				obstacle.setHealth(defaultObsHP);
			}else {
				return false;
					}
		}
		
		return true;
	}

	public void afterHit() {
		System.out.println("Oyuncunun Canı: "+ player.getHP());
		System.out.println(obstacle.getName() + " canı: "+ obstacle.getHealth());
		System.out.println();
	}
	
	public void playerStats(){
		System.out.println("Player Status\n---------------");
		System.out.println("HP: " + player.getHP());
		System.out.println("Damage: "+ player.getDamage());
		System.out.println("Gold: "+ player.getGold());
		if(player.getInventory().getDamage() > 0) {
			System.out.println("Weopen: "+ player.getInventory().getwName());
			
		}
		if(player.getInventory().getArmor() > 0) {
			System.out.println("Armor: "+ player.getInventory().getaName());
		}
	}
	
	public void enemyStats() {
		System.out.println("\"Enemy Status\n---------------\"");
		System.out.println(obstacle.getName());
		System.out.println("HP: "+ obstacle.getHealth());
		System.out.println("Damage: "+ obstacle.getDamage());	
		System.out.println("Reward: "+ obstacle.getReward());
	}
	
	public Obstacle getObstacle() {
		return obstacle;
	}

	public void setObstacle(Obstacle obstacle) {
		this.obstacle = obstacle;
	}

	public String getReward() {
		return reward;
	}

	public void setReward(String reward) {
		this.reward = reward;
	}
	
}
