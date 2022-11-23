package Cafe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CafeProgram {
	CustomerManager Manager = new CustomerManager();
	Menu menu = new Menu();
	Scanner scanner = new Scanner(System.in);

	public CafeProgram() {
		menu.createBasicMenu();
	}

	public int order() {
		String name, size;
		int mileageValue = 0;

		menu.showMenu();
		System.out.print("주문하신 메뉴는 무엇입니까?(영문으로 동일하게 입력) : ");
		name = scanner.next();
		Menu chooseMenu = new Menu(name);

		chooseMenu = menu.search(chooseMenu);

		System.out.print("R사이즈를 하시겠습니까? L사이즈를 주문하시겠습니까?(R/L) : ");
		size = scanner.next();

		if (chooseMenu == null)
			System.out.println("없는 메뉴입니다.");
		else if (size.equals("L") && chooseMenu != null) {
			System.out.println("가격은 " + (chooseMenu.getPrice() + 500) + "원 입니다.");
			mileageValue = (int) (chooseMenu.getPrice() + 500);
		} else {
			System.out.println("가격은 " + chooseMenu.getPrice() + "원 입니다.");
			mileageValue = (int) (chooseMenu.getPrice());
		}

		return mileageValue;
	}

	public void useMileage(int mileageValue) {
		String name;
		String phoneNumber;
		int price = 0;
		
		System.out.print("이름 : ");
		name = scanner.next();
		System.out.print("전화번호 : ");
		phoneNumber = scanner.next();
		
		mileageValue *= 10;
		price -= mileageValue;
		
		Manager.mileageStore(new CustomerInfo(name, phoneNumber), price);
	}
	
	public void isMember(int mileageValue) {
		String name, choice, phoneNumber;

		System.out.print("마일리지 고객입니까?(Y/N) : ");
		choice = scanner.next();

		if (choice.equals("Y")) {
			System.out.print("마일리지를 이용하여 결제하시겠습니까?(Y/N) : ");
			choice = scanner.next();
			
			if (choice.equals("Y")) {
				useMileage(mileageValue);
			}
			else {
				System.out.print("이름 : ");
				name = scanner.next();
				System.out.print("전화번호 : ");
				phoneNumber = scanner.next();
	
				Manager.mileageStore(new CustomerInfo(name, phoneNumber), mileageValue);
			}
		}
	}
	
	public void changeMenu() {
		int choice;
		
		System.out.print("메뉴의 추가를 원하면 1번, 삭제를 원하면 2번을 입력해주세요 : ");
		
		try {
			choice = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println();
			System.out.println("숫자를 입력해주세요.");
			scanner.nextLine();
			choice = 3;
		}
		switch (choice) {
			case 1:
				menu.createMenu();
				break;
			case 2:
				menu.deleteMenu();
				break;
			case 3:
		}
	}

	public void createCustomerInfo() {
		String name;
		String phoneNumber;

		System.out.print("이름 : ");
		name = scanner.next();
		System.out.print("전화번호 : ");
		phoneNumber = scanner.next();

		
		Manager.create(name, phoneNumber);
	}

	public void modifyCustomerInfo() {
		CustomerInfo person;
		String name;
		String phoneNumber;

		System.out.print("찾고자 하는 이름 : ");
		name = scanner.next();
		System.out.print("찾고자 하는 전화번호 : ");
		phoneNumber = scanner.next();

		person = new CustomerInfo(name, phoneNumber);
		Manager.changeInfo(person);
	}

	public void display() {
		String answer;
		Manager.allDisplay();

		System.out.print("찾고 싶은 고객이 있습니까?(Y/N) : ");
		answer = scanner.next();

		if (answer.equals("Y")) {
			Manager.display();
		}
	}

	public void deleteInfo() {
		String name;
		String phoneNumber;

		System.out.print("삭제하고자 하는 이름 : ");
		name = scanner.next();
		System.out.print("삭제하고자 하는 전화번호 : ");
		phoneNumber = scanner.next();

		Manager.delete(name, phoneNumber);
	}

	public void showMenu() {
		System.out.println("-------------Menu--------------");
		System.out.println();
		System.out.println("1.    주문");
		System.out.println("2.    메뉴 수정");
		System.out.println("3.    고객 정보 생성");
		System.out.println("4.    고객 정보 수정");
		System.out.println("5.    고객 정보 표시");
		System.out.println("6.    고객 정보 삭제");
		System.out.println("7.    종료");
	}
}