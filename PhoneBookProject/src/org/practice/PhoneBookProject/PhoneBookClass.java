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
		System.out.println("전화번호부를 시작합니다. 파일에 저장되지 않습니다.");
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
				System.out.print("삽입 : 0, 삭제 : 1, 찾기 : 2, 전체보기 : 3, 종료 : 4 >>");
				sw = sc.nextInt();
				switch (sw) {
				case 0:
					System.out.print("이름 >>");
					name = sc.next();
					System.out.print("주소 >>");
					address = sc.next();
					System.out.print("전화번호 >>");
					phoneNum = sc.next();

					if (FoundKey(name, map)) {
						System.out.println(name + "은(는) 이미 존재하는 사람입니다.");
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
							System.out.println(key + "은(는) 이미 존재하는 사람입니다.");
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
					System.out.print("삭제할 이름 >>");
					name = sc.next();
					keys = map.keySet();
					it = keys.iterator();
					int size = map.size();
					while (it.hasNext()) {
						key = it.next();
						if (name.equals(key)) {
							map.remove(key);
							System.out.println(key + "은(는) 삭제되었습니다.");
							break;
						}
					}
					if (size == map.size()) {
						System.out.println(name + "은(는) 등록되지 않은 사람입니다.");
					}
					break;
				case 2:
					System.out.print("이름 >>");
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
						System.out.println(name + "은(는) 등록되지 않은 사람입니다.");
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
					System.out.println("프로그램을 종료합니다.");
					return;
				default:
					System.out.println("다시 입력해주세요:");
				}

			} catch (Exception e) {
				sc = new Scanner(System.in);
				System.out.println("다시 입력해주세요.");
			}
		}

	}

}
