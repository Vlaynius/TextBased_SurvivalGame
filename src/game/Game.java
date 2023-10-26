package game;


import java.util.Scanner;

public class Game {

	public Player player;
	public Location location;
	Scanner scan = new Scanner(System.in);
	
	public void startUp() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to the Survival Game");
		System.out.println("Please Enter the Character Name : ");
		String playerName = "Survivor";
		Player player = new Player(playerName);
		player.selectChar();
		start();
	}
	
	public void start() {
		while(true) {
		System.out.println();
		System.out.println("*********************************************************");
		System.out.println();
		System.out.println("Location Menu");
		
		System.out.println("1.SafeHouse	--> Safe spot, No Enemies.");
		System.out.println("2.Cave --> Warning! Zombies.");
		System.out.println("3.Forest --> Warning! Vampiers. ");
		System.out.println("4.River --> Warning! Bear.");
		System.out.println("5.ToolStore --> You can perhase Weopens and Armors.");
		
		System.out.print("Choose A Location :");
		int selectLocation = scan.nextInt();
		while(selectLocation < 0 || selectLocation >5){
			System.out.print("Geçerli bir yer Seçin :");
			selectLocation = scan.nextInt(); 
		}
		
		switch(selectLocation) {
		case 1:
			location = new SafeHouse(player);
			break;
		case 2:
			location = new Cave(player);
			break;
		case 3:
			location = new Forest(player);
			break;
		case 4:
			location = new River(player);
			break;
		case 5:
			location = new ToolStore(player);
			break;
		default:
			location = new SafeHouse(player);
			}
		
		if(location.getClass().getName().equals("SafeHouse")) {
			if(player.getInventory().isFirewood() && player.getInventory().isFood() && player.getInventory().isWater()) {
				System.out.println("Tebrikler Oyunu Kazandınız !");
				break;
			}
		}
		if(! location.getLocation()) {
			System.out.println("Game Over");
			break;
		}
		
		
		}	
	}
	
	
	
}
