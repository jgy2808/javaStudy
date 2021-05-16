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
			System.out.print("��ǰ����>>");
			productInfo = sc.next();
			System.out.print("������>>");
			producer = sc.next();
			System.out.print("����>>");
			productPrice = sc.nextInt();
		}
	}
	public static class CompactDisk extends Product {
		private String albumTitle;
		private String singer;
		
		public void AddCD() {
			Addproduct();
			System.out.print("�ٹ� ����>>");
			albumTitle = sc.next();
			System.out.print("����>>");
			singer = sc.next();
		}
		
	}
	public static class Book extends Product {
		private String numberISBN;
		private String author;
		private String bookTitle;
		
		public void AddBook() {
			Addproduct();
			System.out.print("ISBN>>");
			numberISBN = sc.next();
			System.out.print("����>>");
			author = sc.next();
			System.out.print("å ����>>");
			bookTitle = sc.next();
		}
		
	}
	public static class ConversationBook extends Book {
		private String language;
		
		public void AddConvBook() {
			AddBook();
			System.out.print("���>>");
			language = sc.next();
		}
	}
	
	public static void main(String[] args) {
		Product[] p = new Product[10];
		int sw;
		while(true) {
			try {
				System.out.print("��ǰ�߰�<1>, ��� ��ǰ ��ȸ<2>, ������<3> >>");
				sw = sc.nextInt();
				switch (sw) {
				case 1:
					
				}
			} catch(Exception e) {
				sc = new Scanner(System.in);
				System.out.println("�ٽ� �Է����ּ���.");
			}
		}
	}

}
