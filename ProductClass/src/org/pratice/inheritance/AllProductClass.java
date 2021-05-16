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
			System.out.print("상품설명>>");
			productInfo = sc.next();
			System.out.print("생산자>>");
			producer = sc.next();
			System.out.print("가격>>");
			productPrice = sc.nextInt();
		}
	}
	public static class CompactDisk extends Product {
		private String albumTitle;
		private String singer;
		
		public void AddCD() {
			Addproduct();
			System.out.print("앨범 제목>>");
			albumTitle = sc.next();
			System.out.print("가수>>");
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
			System.out.print("저자>>");
			author = sc.next();
			System.out.print("책 제목>>");
			bookTitle = sc.next();
		}
		
	}
	public static class ConversationBook extends Book {
		private String language;
		
		public void AddConvBook() {
			AddBook();
			System.out.print("언어>>");
			language = sc.next();
		}
	}
	
	public static void main(String[] args) {
		Product[] p = new Product[10];
		int sw;
		while(true) {
			try {
				System.out.print("상품추가<1>, 모든 상품 조회<2>, 끝내기<3> >>");
				sw = sc.nextInt();
				switch (sw) {
				case 1:
					
				}
			} catch(Exception e) {
				sc = new Scanner(System.in);
				System.out.println("다시 입력해주세요.");
			}
		}
	}

}
