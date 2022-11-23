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
			System.out.print("선택 : ");
			try {
				choice = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println();
				System.out.println("숫자를 입력해주세요.");
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
				System.out.println("프로그램을 종료합니다.");
				scanner.close();
				break;
			case 8:
			}
			if (choice == 7)
				break;
		}
	}
}
