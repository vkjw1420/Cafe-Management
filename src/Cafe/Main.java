package Cafe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		CafeProgram cafe = new CafeProgram();
		Scanner scanner = new Scanner(System.in);
		int choice;

		while (true) {
			cafe.showMenu();
			System.out.print("���� : ");
			try {
				choice = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println();
				System.out.println("���ڸ� �Է����ּ���.");
				scanner.nextLine();
				choice = 8;
			}

			System.out.println();

			switch (choice) {
			case 1:
				cafe.isMember(cafe.order());
				break;
			case 2:
				cafe.changeMenu();
				break;
			case 3:
				cafe.createCustomerInfo();
				break;
			case 4:
				cafe.modifyCustomerInfo();
				break;
			case 5:
				cafe.display();
				break;
			case 6:
				cafe.deleteInfo();
				break;
			case 7:
				System.out.println("���α׷��� �����մϴ�.");
				scanner.close();
				break;
			case 8:
			}
			if (choice == 7)
				break;
		}
	}
}
