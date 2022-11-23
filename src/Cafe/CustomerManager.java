package Cafe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class CustomerManager {
	ArrayList<CustomerInfo> customers = new ArrayList<CustomerInfo>();
	Iterator<CustomerInfo> c;
	Scanner scanner = new Scanner(System.in);

	public void create(String name, String phoneNumber) {
		customers.add(new CustomerInfo(name, phoneNumber));
	}

	public int searchIndex(CustomerInfo person) {
		c = customers.iterator();
		int index = 0;
		while (c.hasNext()) {
			CustomerInfo temp = c.next();
			if (temp.equals(person)) {
				return index;
			}
			index++;
		}
		return -1;
	}

	public void changeInfo(CustomerInfo person) {
		String correctionName;
		String correctionPhoneNumber;
		int index;

		index = searchIndex(person);
		if (index <= -1)
			System.out.println("없는 정보입니다.");
		else {
			person = customers.get(index);

			System.out.print("변경할 이름 : ");
			correctionName = scanner.next();
			System.out.print("변경할 전화번호 : ");
			correctionPhoneNumber = scanner.next();
			if (!correctionName.equals(""))
				person.setName(correctionName);
			if (!correctionPhoneNumber.equals(""))
				person.setPhoneNumber(correctionPhoneNumber);
		}
	}

	public void delete(String name, String phoneNumber) {
		CustomerInfo person = new CustomerInfo(name, phoneNumber);

		customers.remove(searchIndex(person));
	}

	public void mileageStore(CustomerInfo person, int mileageValue) {
		int index;
		int reverseMileage = 0;
		
		index = searchIndex(person);
		if (index <= -1)
			System.out.println("없는 정보입니다.");
		else {
			person = customers.get(index);
		}
		reverseMileage -= person.mileageValue.getMileage();
		if ((mileageValue < 0 && reverseMileage < person.mileageValue.getMileage()) || 
				(mileageValue < 0 && person.mileageValue.getMileage() == 0)) {
			System.out.println("마일리지가 부족합니다.");
		}
		else {
			mileageValue += person.mileageValue.getMileage();
			person.mileageValue.setMileage(mileageValue);
		}
	}

	public void allDisplay() {
		CustomerInfo person;
		for (int i = 0; i < customers.size(); i++) {
			person = customers.get(i);
			System.out.println(person.toString());
		}
	}

	public void display() {
		String name, phoneNumber;

		System.out.print("찾고 싶은 사람의 이름 : ");
		name = scanner.next();
		System.out.print("찾고 싶은 사람의  전화번호 : ");
		phoneNumber = scanner.next();

		CustomerInfo p = new CustomerInfo(name, phoneNumber);

		System.out.println(customers.get(searchIndex(p)));
	}
}
