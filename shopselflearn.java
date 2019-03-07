import java.util.*;

class weaponShop{
	//Weapon Price		//Id
	static int shortKnife = 10;//1
	static int longSword = 20; //2
	static int crossBow = 30;	//3
	static int longBow = 40;	//4
	static int rapier = 50;	//5
	static int currGold = 100000;
	// initial stock
	static int stockSK = 50;
	static int stockLS = 50;
	static int stockCB = 50;
	static int stockLB = 50;
	static int stockR  = 50;
	static int meat = 0;
	
	static int transaction(int weaponId) {
		if(weaponId == 1) {
			stockSK -= 1;
			currGold += shortKnife;
			return shortKnife;
		}
		else if(weaponId == 2) {
			stockLS -= 1;
			currGold += longSword;
			return longSword;
		}
		else if(weaponId == 3) {
			stockCB -= 1;
			currGold += crossBow;
			return crossBow;
		}
		else if(weaponId == 4) {
			stockLB -= 1;
			currGold += longBow;
			return longBow;
		}
		else {
			stockR -= 1;
			currGold += rapier;
			return rapier;
		}
	}

	
}



class hunter{
	String custName;
	int Huntergold;
	int age;
	int weaponId = 0;
	String custAddress;
	hunter(int weaponId){
		this.Huntergold -= weaponShop.transaction(weaponId);
	}
	
	void personalStat() {
		System.out.println("Name		: " + custName);
		System.out.println("Age		: " + age);
		if(weaponId == 1) {
			System.out.println("Buy		: Short Knife");			
		}
		else if(weaponId == 2) {
			System.out.println("Buy		: Long Sword");
		}
		else if(weaponId == 3) {
			System.out.println("Buy		: Cross bow");
		} 
		else if(weaponId == 4) {
			System.out.println("Buy		: Long Bow");
		}
		else if(weaponId == 5) {
			System.out.println("Buy		: Rapier");
		}
		else { 
			System.out.println("Buy		: NULL");
		}
		System.out.println();
	}
	
	void information() {
		System.out.println("Name		: " + custName);
		System.out.println("Age		: " + age);
		System.out.println("Address		: " + custAddress);
		System.out.println();
	}
	
}

class event{
	ArrayList<hunter> list = new ArrayList<hunter>();
	int gold = 100;
	
	void regist(hunter name) {
		list.add(name);
	}
	
	void viewAllTransaction() {
		int counter = 1;
		for(hunter name : list) {
			System.out.printf("Customer #%d\n",counter++);
			name.personalStat();
		}
		if(list.size()<= 0) {
			System.out.println("No Customer Yet...");
		}
	}
	
	int size() {
		return list.size();
	}
	
	void custInfo() {
		int counter = 1;
		for(hunter name : list) {
			System.out.printf("Contact #%d\n",counter++);
			name.information();
		}
		if(list.size()<=0) {
			System.out.println("No Contact Available");
			return;
		}
	}
	
	void deleteInfo(int idx) {
		list.remove(idx);	
	}
}


public class shopselflearn {
	static void transit() {
		for(int i = 0 ; i < 35 ;i ++) {
			System.out.println();
		}
	}
	
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		weaponShop arcane = new weaponShop();
		int choose = 0;
		int choice = 0;
		int ageRand;
		String name;
		String address;
		Double weaponId;
		boolean validity;
		event shop = new event();
		do {	
			do {
				validity = true;
				try {
				transit();		
				System.out.printf("Current Gold	: %d\n",weaponShop.currGold); 
				System.out.println("======================");
				System.out.println("# Arcane Weapon Shop #");
				System.out.println("======================");
				System.out.printf("SK : %d | LS : %d | CB : %d | LB : %d | R : %d\n",weaponShop.stockSK,weaponShop.stockLS,weaponShop.stockCB,weaponShop.stockLB,weaponShop.stockR);
				System.out.println("1. Sell Weapon");
				System.out.println("2. Customer Information");
				System.out.println("3. Delete Information");
				System.out.println("4. View All Transaction");
				System.out.println("5. Exit");
				System.out.print(">> ");
				choose = input.nextInt();
				}catch(Exception e) {
					validity = false;
				}
				input.nextLine();
			}while(!validity || choose < 1 || choose > 5);
			
			switch(choose) {
			case 1 :
				
				System.out.println("Manager : Welcome to the shop");
				do {
					System.out.println("What is Your name [>=3] ?");
					name = input.nextLine();
				}while(name.length() < 3);
			
				System.out.println("\nManager : We only Sold High Quality weapon here");
				System.out.println("Manager : Take it or Leave it\n");
				
				do {
					validity = true;
					try {
					System.out.println("===============================");
					System.out.println("Weapon Type		Price");
					System.out.println("===============================");
					System.out.println("1. Short Knife	  	 10");
					System.out.println("2. Long Sword		 20");
					System.out.println("3. CrossBow		 30");
					System.out.println("4. LongBow		 40");
					System.out.println("5. Rapier		 50");
					System.out.print(">> ");
					choice = input.nextInt();
					}catch(Exception e) {
						validity = false;
					}
					input.nextLine();
				}while(!validity || choice < 1 || choice > 5);
				
				ageRand = (int)(Math.random() * 50 + 19);
				
				do {
					System.out.print("Manager : Not to invade your privacy , but include your address as well in case my weapon is not as good as your expectation\n");
					System.out.print("Address [5-30] : ");
					address = input.nextLine();
				}while(address.length() < 5 || address.length() > 30);
				
				hunter info = new hunter(choice);
				info.custName = name;
				info.weaponId = choice;
				info.age = ageRand;
				info.custAddress = address;
				shop.regist(info);
				System.out.println("Thanks for Purchasing");
				break;
				
			case 2 :
				shop.custInfo();
				input.nextLine();
				break;
				
			case 3 :
				int size = shop.size();
				if(size <= 0) {
					System.out.println("No Contact Available");
					input.nextLine();
					break;
				}
				do { 
					validity = true;
					try {
					shop.custInfo();
					System.out.println("Input Contact to Delete");
					choice = input.nextInt();
					}catch(Exception e) {
						validity = false;
					}
					input.nextLine();
				}while(!validity || choice > size || choice < 1);
				shop.deleteInfo(choice - 1);
				break;
				
				
			case 4 :
				shop.viewAllTransaction();
				input.nextLine();
				break;
				
			case 5 :
				for(int i = 0 ; i < 35 ;i ++) {
					System.out.println();
				}		
				System.out.print("Thanks for using this program\n");
				System.out.print("Terminating program...\n");
  				System.exit(0);
			}
			
		}while(true);
		
	}
}
