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
		System.out.print("�ֹ��Ͻ� �޴��� �����Դϱ�?(�������� �����ϰ� �Է�) : ");
		name = scanner.next();
		Menu chooseMenu = new Menu(name);

		chooseMenu = menu.search(chooseMenu);

		System.out.print("R����� �Ͻðڽ��ϱ�? L����� �ֹ��Ͻðڽ��ϱ�?(R/L) : ");
		size = scanner.next();

		if (chooseMenu == null)
			System.out.println("���� �޴��Դϴ�.");
		else if (size.equals("L") && chooseMenu != null) {
			System.out.println("������ " + (chooseMenu.getPrice() + 500) + "�� �Դϴ�.");
			mileageValue = (int) (chooseMenu.getPrice() + 500);
		} else {
			System.out.println("������ " + chooseMenu.getPrice() + "�� �Դϴ�.");
			mileageValue = (int) (chooseMenu.getPrice());
		}

		return mileageValue;
	}

	public void useMileage(int mileageValue) {
		String name;
		String phoneNumber;
		int price = 0;
		
		System.out.print("�̸� : ");
		name = scanner.next();
		System.out.print("��ȭ��ȣ : ");
		phoneNumber = scanner.next();
		
		mileageValue *= 10;
		price -= mileageValue;
		
		Manager.mileageStore(new CustomerInfo(name, phoneNumber), price);
	}
	
	public void isMember(int mileageValue) {
		String name, choice, phoneNumber;

		System.out.print("���ϸ��� ���Դϱ�?(Y/N) : ");
		choice = scanner.next();

		if (choice.equals("Y")) {
			System.out.print("���ϸ����� �̿��Ͽ� �����Ͻðڽ��ϱ�?(Y/N) : ");
			choice = scanner.next();
			
			if (choice.equals("Y")) {
				useMileage(mileageValue);
			}
			else {
				System.out.print("�̸� : ");
				name = scanner.next();
				System.out.print("��ȭ��ȣ : ");
				phoneNumber = scanner.next();
	
				Manager.mileageStore(new CustomerInfo(name, phoneNumber), mileageValue);
			}
		}
	}
	
	public void changeMenu() {
		int choice;
		
		System.out.print("�޴��� �߰��� ���ϸ� 1��, ������ ���ϸ� 2���� �Է����ּ��� : ");
		
		try {
			choice = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println();
			System.out.println("���ڸ� �Է����ּ���.");
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

		System.out.print("�̸� : ");
		name = scanner.next();
		System.out.print("��ȭ��ȣ : ");
		phoneNumber = scanner.next();

		
		Manager.create(name, phoneNumber);
	}

	public void modifyCustomerInfo() {
		CustomerInfo person;
		String name;
		String phoneNumber;

		System.out.print("ã���� �ϴ� �̸� : ");
		name = scanner.next();
		System.out.print("ã���� �ϴ� ��ȭ��ȣ : ");
		phoneNumber = scanner.next();

		person = new CustomerInfo(name, phoneNumber);
		Manager.changeInfo(person);
	}

	public void display() {
		String answer;
		Manager.allDisplay();

		System.out.print("ã�� ���� ���� �ֽ��ϱ�?(Y/N) : ");
		answer = scanner.next();

		if (answer.equals("Y")) {
			Manager.display();
		}
	}

	public void deleteInfo() {
		String name;
		String phoneNumber;

		System.out.print("�����ϰ��� �ϴ� �̸� : ");
		name = scanner.next();
		System.out.print("�����ϰ��� �ϴ� ��ȭ��ȣ : ");
		phoneNumber = scanner.next();

		Manager.delete(name, phoneNumber);
	}

	public void showMenu() {
		System.out.println("-------------Menu--------------");
		System.out.println();
		System.out.println("1.    �ֹ�");
		System.out.println("2.    �޴� ����");
		System.out.println("3.    �� ���� ����");
		System.out.println("4.    �� ���� ����");
		System.out.println("5.    �� ���� ǥ��");
		System.out.println("6.    �� ���� ����");
		System.out.println("7.    ����");
	}
}