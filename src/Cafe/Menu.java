package Cafe;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Menu {
	ArrayList<Menu> allMenu = new ArrayList<Menu>();
	Iterator<Menu> m;
	Scanner scanner = new Scanner(System.in);
	private String name;
	private int price;

	Menu() {
		this("", 0);
	}

	Menu(String name) {
		this(name, 0);
	}

	Menu(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	void createBasicMenu() {
		allMenu.add(new Menu("espresso", 5100));
		allMenu.add(new Menu("icedCoffee", 4100));
		allMenu.add(new Menu("americano", 4100));
		allMenu.add(new Menu("cappuccino", 4600));
		allMenu.add(new Menu("caffelatte", 4600));
		allMenu.add(new Menu("chocolate", 4900));
	}

	public void createMenu() {
		String name;
		int price;

		System.out.print("메뉴명 : ");
		name = scanner.next();
		System.out.print("가격 : ");
		try {
			price = scanner.nextInt();
			
			allMenu.add(new Menu(name, price));
		} catch (InputMismatchException e) {
			System.out.println();
			System.out.println("숫자를 입력해주세요.");
			scanner.nextLine();
		}
	}
	
	public void deleteMenu() {
		String name;

		System.out.print("삭제할 메뉴명 : ");
		name = scanner.next();
		
		allMenu.remove(search(new Menu(name)));
	}

	public Menu search(Menu menu) {
		m = allMenu.iterator();
		while (m.hasNext()) {
			Menu temp = m.next();
			if (temp.equals(menu)) {
				return temp;
			}
		}
		return null;
	}

	void showMenu() {
		m = allMenu.iterator();
		System.out.println("      Name         R     L");
		while (m.hasNext()) {
			Menu temp = m.next();
			System.out.println(temp);
		}
	}

	@Override
	public String toString() {
		int length = name.length();
		String space = "";
		for (int i = 0; length + i < 15; i++) {
			space += " ";
		}
		return "   " + name + space + ((double) price / 1000) + "   " + (((double) price + 500) / 1000);
	}

	@Override
	public boolean equals(Object obj) {
		Menu menu = (Menu) obj;
		if ((this.name).equals(menu.name)) {
			return true;
		}
		return false;
	}
}