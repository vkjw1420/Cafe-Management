package Cafe;

public class CustomerInfo {
	private String name;
	private String phoneNumber;
	MileageValue mileageValue;

	CustomerInfo(String phoneNumber) {
		this("", phoneNumber);
		mileageValue = new MileageValue();
	}

	CustomerInfo(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		mileageValue = new MileageValue();
	}

	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "이름 : " + name + ", " + "전화번호 : " + phoneNumber + ", " + mileageValue;
	}

	@Override
	public boolean equals(Object obj) {
		CustomerInfo customer = (CustomerInfo) obj;
		if (this.name.equals(customer.name) && this.phoneNumber.equals(customer.phoneNumber)) {
			return true;
		}
		return false;
	}
}
