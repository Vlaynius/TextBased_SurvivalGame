package game;

public class ToolStore extends NormalLoc{

	

	public ToolStore(Player player) {
		super(player, "Store");
		
	}
	

	public void Menu() {
		
	}
	
	public void buy() {
		
	}


	@Override
	public boolean getLocation() {
		System.out.println("GOLD: "+ getPlayer().getGold());
		System.out.println("1.Armors");
		System.out.println("2.Weopens");
		System.out.println("3.Exit");
		System.out.print("Your Coise: ");
		int selectTool = scan.nextInt();
		int selectItemID;
		switch (selectTool) {
		case 1: {
			selectItemID = weopenMenu();
			buyWeopen(selectItemID);
			break;
		}
		case 2:
			selectItemID = armorMenu();
			buyArmor(selectItemID);
			break;
			
			
		default:
			break;
		}
		
		
		
		return true;
	}
	
	
	
	public int weopenMenu() {
		System.out.println("1.Tabanca\t <Para : 25 - Hasar : 2>");
		System.out.println("2.Kılıç\t <Para : 35 - Hasar : 3>");
		System.out.println("3.Tabanca\t <Para : 45 - Hasar : 7>");
		System.out.println("4.Exit");
		System.out.print("Silah Seçiniz : ");
		int selWeopenID = scan.nextInt();
		return selWeopenID;
	}
	
	public int armorMenu() {
		
			System.out.println("1.Hafif\t <Para : 15 - Engelleme : 1>");
			System.out.println("2.Orta\t <Para : 25 - Engelleme : 3>");
			System.out.println("3.Ağır\t <Para : 40 - Engelleme : 5>");
			System.out.println("4.Exit");
			System.out.print("Zırh Seçiniz : ");
			int selArmorID = scan.nextInt();
			return selArmorID;
		
	}
	
	public void buyWeopen(int itemID) {
		int damage= 0, price = 0;
		String wName = null;
		
		switch(itemID) {
		case 1:
			damage = 2;
			wName = "Tabanca";
			price = 25;
			break;
		case 2:
			damage = 3;
			wName = "Kılıç";
			price = 35;
			break;
		case 3:
			damage = 7;
			wName = "Tüfek ";
			price = 45;
			break;
		case 4: 
				System.out.println("Çıkış yapılıyor...");
			break;
		default:	
			System.out.println("Geçersiz işlem !!");
		}
	if(price > 0) {	
		if(player.getGold() > price) {
			getPlayer().getInventory().setDamage(damage);
			getPlayer().getInventory().setwName(wName);
			getPlayer().setGold(player.getGold()-price);
			System.out.println(wName+" satın aldınız, Önceki Hasar:"+ getPlayer().getDamage() + "Yeni Hasar : " + player.getTotalDamage());
			System.out.println("Kalan Para: "+ player.getGold());	
		}else {
			System.out.println("Bakiye Yetersiz!");
			}
		}	
	}
	
	public void buyArmor(int ItemID){
		int price = 0 , armor = 0;
		String aName= null;
		
		switch(ItemID) {
		case 1:
			armor = 1;
			aName = "Hafif";
			price = 15;
			break;
		case 2:
			armor = 3;
			aName = "orta";
			price = 25;
			break;
		case 3:
			armor = 5;
			aName = "Ağır";
			price = 40;
			break;
		case 4: 
				System.out.println("Çıkış yapılıyor...");
			break;
		default:	
			System.out.println("Geçersiz işlem !!");
		}
		if(price > 0) {	
			if(player.getGold() > price) {
				getPlayer().getInventory().setArmor(armor);;
				getPlayer().getInventory().setaName(aName);;
				getPlayer().setGold(player.getGold()-price);
				System.out.println(aName+" satın aldınız" + "Yeni Kalkan : " + player.getInventory().getArmor());
				System.out.println("Kalan Para: "+ player.getGold());	
			}else {
				System.out.println("Bakiye Yetersiz!");
				}
			}	
	}
	
}
