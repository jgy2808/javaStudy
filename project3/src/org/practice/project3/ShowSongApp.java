package org.practice.project3;

public class ShowSongApp {
	public static class Song {
		private String title;
		private String artist;
		private String album;
		private String[] composer = new String[3];
		private int year;
		private int track;
		
		Song(){
			title = "";
			artist = "";
			album = "";
			for (int i = 0; i < composer.length; i++) {
				composer[i] = "";
			}
			year = 0;
			track = 0;
		}
		Song(String t, String ar, String al, String com1, int y, int tr){
			title = t;
			artist = ar;
			album = al;
			composer[0] = com1;
			year = y;
			track = tr;
		}
		Song(String t, String ar, String al, String com1, String com2, int y, int tr){
			title = t;
			artist = ar;
			album = al;
			composer[0] = com1;
			composer[1] = com2;
			year = y;
			track = tr;
		}
		Song(String t, String ar, String al, String com1, String com2, String com3, int y, int tr){
			title = t;
			artist = ar;
			album = al;
			composer[0] = com1;
			composer[1] = com2;
			composer[2] = com3;
			year = y;
			track = tr;
		}
		
		public void Show() {
			System.out.println("���� : " + title);
			System.out.println("���� : " + artist);
			System.out.println("�ٹ� : " + album);
			System.out.print("�۰ : ");
			for (int i = 0; i < composer.length; i++) {
				System.out.print(composer[i]);
				if (i < composer.length - 1) System.out.print(", ");
			}System.out.println();
			System.out.println("�⵵ : " + year);
			System.out.println("Ʈ�� ��ȣ : " + track);
		}
	}
	public static void main(String[] args) {
		Song s = new Song("Dancing Queen", "ABBA", "ABBA Gold", "Benny Andersson", "Stig Anderson", "Ulvaeus", 2008, 1);
		s.Show();
	}
}
