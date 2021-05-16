package org.pratice.inheritance;

import java.util.Scanner;

public class AllProductClass {
	static Scanner sc = new Scanner(System.in);
	
	public static class Product{
		private int productId;
		private String productInfo;
		private String producer;
		private int productPrice;
		
		
		public void Addproduct() {
			System.out.print("��ǰ ����>>");
			sc.nextLine();
			productInfo = sc.nextLine();
			System.out.print("������>>");
			producer = sc.nextLine();
			System.out.print("����>>");
			productPrice = sc.nextInt();
		}
		
		public void ShowProductInfo() {
			System.out.println("��ǰ ����>>" + productInfo);
			System.out.println("������>>" + producer);
			System.out.println("����>>" + productPrice);
		}
	}
	public static class CompactDisk extends Product {
		private String albumTitle;
		private String singer;
		
		public void Addproduct() {
			super.Addproduct();
			System.out.print("�ٹ� ����>>");
			sc.nextLine();
			albumTitle = sc.nextLine();
			System.out.print("����>>");
			singer = sc.next();
		}
		
		public void ShowProductInfo() {
			super.ShowProductInfo();
			System.out.println("�ٹ� ����>>" + albumTitle);
			System.out.println("����>>" + singer);
		}
	}
	public static class Book extends Product {
		private String numberISBN;
		private String author;
		private String bookTitle;
		
		public void Addproduct() {
			super.Addproduct();
			System.out.print("ISBN>>");
			numberISBN = sc.next();
			System.out.print("����>>");
			sc.nextLine();
			author = sc.nextLine();
			System.out.print("å ����>>");
			bookTitle = sc.nextLine();
		}
		
		public void ShowProductInfo() {
			super.ShowProductInfo();
			System.out.println("ISBN>>" + numberISBN);
			System.out.println("����>>" + author);
			System.out.println("å ����>>" + bookTitle);
		}
		
	}
	public static class ConversationBook extends Book {
		private String language;
		
		public void Addproduct() {
			super.Addproduct();
			System.out.print("���>>");
			language = sc.next();
		}
		public void ShowProductInfo() {
			super.ShowProductInfo();
			System.out.println("���>>" + language);
		}
	}
	
	public static void main(String[] args) {
		Product[] p = new Product[10];
		int sw, pCount = 0;
		while(true) {
			try {
				System.out.print("��ǰ�߰�<1>, ��� ��ǰ ��ȸ<2>, ������<3> >>");
				sw = sc.nextInt();
				switch (sw) {
				case 1:
					System.out.print("��ǰ ���� å<1>, ����CD<2>, ȸȭå<3> >>");
					sw = sc.nextInt();
					switch(sw) {
					case 1:
						p[pCount] = new Book();
						p[pCount++].Addproduct();
						break;
					case 2:
						p[pCount] = new CompactDisk();
						p[pCount++].Addproduct();
						break;
					case 3:
						p[pCount] = new ConversationBook();
						p[pCount++].Addproduct();
						break;
					default :
						System.out.println("�ٽ� �Է����ּ���.");
					}
					break;
				case 2:
					for (int i = 0; i < pCount; i++) {
						System.out.println("��ǰID>>" + i);
						p[i].ShowProductInfo();
					}
					break;
				case 3:
					return;
				}
			} catch(Exception e) {
				sc = new Scanner(System.in);
				System.out.println("�ٽ� �Է����ּ���.");
			}
		}
	}

}
