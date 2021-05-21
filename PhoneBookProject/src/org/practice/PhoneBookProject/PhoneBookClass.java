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
	
	public static boolean FoundKey(String name, HashMap map) {
		Set<String> keys = map.keySet();
		Iterator<String> it = keys.iterator();
		String key;
		while(it.hasNext()) {
			key = it.next();
			if (key.equals(name)) {
				return true;
			}
		}
		return false;
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

					if (FoundKey(name, map)) {
						System.out.println(name + "��(��) �̹� �����ϴ� ����Դϴ�.");
						break;
					}
					else {
						p = new Phone(address, phoneNum);
						map.put(name, p);
					}
					
					keys = map.keySet();
					it = keys.iterator();
					while (it.hasNext()) {
						key = it.next();
						if (name.equals(key)) {
							System.out.println(key + "��(��) �̹� �����ϴ� ����Դϴ�.");
							name = "";
							break;
						}
					}
					if (name != "") {
						p = new Phone(address, phoneNum);
						map.put(name, p);
					}
					break;
				case 1:
					System.out.print("������ �̸� >>");
					name = sc.next();
					keys = map.keySet();
					it = keys.iterator();
					int size = map.size();
					while (it.hasNext()) {
						key = it.next();
						if (name.equals(key)) {
							map.remove(key);
							System.out.println(key + "��(��) �����Ǿ����ϴ�.");
							break;
						}
					}
					if (size == map.size()) {
						System.out.println(name + "��(��) ��ϵ��� ���� ����Դϴ�.");
					}
					break;
				case 2:
					System.out.print("�̸� >>");
					name = sc.next();
					keys = map.keySet();
					it = keys.iterator();
					p = null;
					while (it.hasNext()) {
						key = it.next();
						if (name.equals(key)) {
							p = map.get(key);
							System.out.println(key + " " + p.getAddress() + " " + p.getPhoneNum());
							break;
						}
					}
					if (p == null) {
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
