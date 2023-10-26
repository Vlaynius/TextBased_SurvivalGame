package game;

public class SafeHouse extends NormalLoc {

	public SafeHouse(Player player) {
		super(player, "SafeHouse");
		
	}

	@Override
	public boolean getLocation() {
		player.setHP(player.getMaxHP());
		System.out.println("HP fulled !!!");
		System.out.println("You are at SafeHouse");
		return true;
	}

	
}
