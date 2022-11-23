package Cafe;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MileageValue {
	private int mileage;
	private Date createDay;

	MileageValue() {
		this.mileage = 0;
		createDay = new Date();
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = (int) (mileage * 0.1);
	}

	@Override
	public String toString() {
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return (String) ("���ϸ��� : " + mileage + "�� , " + "������ : " + date.format(createDay));
	}
}
