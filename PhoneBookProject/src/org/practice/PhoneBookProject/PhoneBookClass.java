package org.practice.PhoneBookProject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class PhoneBookClass {
	public static class Phone {
		private String address;
		private String phoneNum;

		public Phone(String address, String phoneNum) {
			this.address = address;
			this.phoneNum = phoneNum;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getPhoneNum() {
			return phoneNum;
		}

		public void setPhoneNum(String phoneNum) {
			this.phoneNum = phoneNum;
		}

	}

	public static void main(String[] args) {
		System.out.println("-----------------------------------");
		System.out.println("��ȭ��ȣ�θ� �����մϴ�. ���Ͽ� ������� �ʽ��ϴ�.");
		System.out.println("-----------------------------------");

		Scanner sc = new Scanner(System.in);
		HashMap<String, Phone> map = new HashMap<String, Phone>();
		int sw;
		String name, address, phoneNum, key;
		Phone p;
		Set<String> keys;
		Iterator<String> it;
		while (true) {
			try {
				System.out.print("���� : 0, ���� : 1, ã�� : 2, ��ü���� : 3, ���� : 4 >>");
				sw = sc.nextInt();
				switch (sw) {
				case 0:
					System.out.print("�̸� >>");
					name = sc.next();
					System.out.print("�ּ� >>");
					address = sc.next();
					System.out.print("��ȭ��ȣ >>");
					phoneNum = sc.next();

					if (map.containsKey(name)) {
						System.out.println(name + "��(��) �̹� �����ϴ� ����Դϴ�.");
					}
					else {
						p = new Phone(address, phoneNum);
						map.put(name, p);
					}
					break;
				case 1:
					System.out.print("������ �̸� >>");
					name = sc.next();
					if (map.containsKey(name)) {
						map.remove(name);
						System.out.println(name + "��(��) �����Ǿ����ϴ�.");
					}
					else {
						System.out.println(name + "��(��) ��ϵ��� ���� ����Դϴ�.");
					}
					break;
				case 2:
					System.out.print("ã�� �̸� >>");
					name = sc.next();
					if (map.containsKey(name)) {
						p = map.get(name);
						System.out.println(name + " " + p.getAddress() + " " + p.getPhoneNum());
					}
					else {
						System.out.println(name + "��(��) ��ϵ��� ���� ����Դϴ�.");
					}
					break;
				case 3:
					keys = map.keySet();
					it = keys.iterator();
					while (it.hasNext()) {
						key = it.next();
						p = map.get(key);
						System.out.println(key + " " + p.getAddress() + " " + p.getPhoneNum());
					}
					break;
				case 4:
					System.out.println("���α׷��� �����մϴ�.");
					return;
				default:
					System.out.println("�ٽ� �Է����ּ���:");
				}
			} catch (Exception e) {
				sc = new Scanner(System.in);
				System.out.println("�ٽ� �Է����ּ���.");
			}
		}
	}
}