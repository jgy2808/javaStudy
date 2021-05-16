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
			System.out.print("상품 설명>>");
			sc.nextLine();
			productInfo = sc.nextLine();
			System.out.print("생산자>>");
			producer = sc.nextLine();
			System.out.print("가격>>");
			productPrice = sc.nextInt();
		}
		
		public void ShowProductInfo() {
			System.out.println("상품 설명>>" + productInfo);
			System.out.println("생산자>>" + producer);
			System.out.println("가격>>" + productPrice);
		}
	}
	public static class CompactDisk extends Product {
		private String albumTitle;
		private String singer;
		
		public void Addproduct() {
			super.Addproduct();
			System.out.print("앨범 제목>>");
			sc.nextLine();
			albumTitle = sc.nextLine();
			System.out.print("가수>>");
			singer = sc.next();
		}
		
		public void ShowProductInfo() {
			super.ShowProductInfo();
			System.out.println("앨범 정보>>" + albumTitle);
			System.out.println("가수>>" + singer);
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
			System.out.print("저자>>");
			sc.nextLine();
			author = sc.nextLine();
			System.out.print("책 제목>>");
			bookTitle = sc.nextLine();
		}
		
		public void ShowProductInfo() {
			super.ShowProductInfo();
			System.out.println("ISBN>>" + numberISBN);
			System.out.println("저자>>" + author);
			System.out.println("책 제목>>" + bookTitle);
		}
		
	}
	public static class ConversationBook extends Book {
		private String language;
		
		public void Addproduct() {
			super.Addproduct();
			System.out.print("언어>>");
			language = sc.next();
		}
		public void ShowProductInfo() {
			super.ShowProductInfo();
			System.out.println("언어>>" + language);
		}
	}
	
	public static void main(String[] args) {
		Product[] p = new Product[10];
		int sw, pCount = 0;
		while(true) {
			try {
				System.out.print("상품추가<1>, 모든 상품 조회<2>, 끝내기<3> >>");
				sw = sc.nextInt();
				switch (sw) {
				case 1:
					System.out.print("상품 종류 책<1>, 음악CD<2>, 회화책<3> >>");
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
						System.out.println("다시 입력해주세요.");
					}
					break;
				case 2:
					for (int i = 0; i < pCount; i++) {
						System.out.println("상품ID>>" + i);
						p[i].ShowProductInfo();
					}
					break;
				case 3:
					return;
				}
			} catch(Exception e) {
				sc = new Scanner(System.in);
				System.out.println("다시 입력해주세요.");
			}
		}
	}

}
