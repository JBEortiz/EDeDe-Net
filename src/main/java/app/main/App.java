package app.main;

import java.util.Scanner;

import app.utils.Constant;

public class App {
	public static Constant constants;

	public static void main(String[] args) {

		prinMenu();
		swicht();

	}

	private static void prinMenu() {
		try {
			String ededeNet = "WELCOME TO : Edede-Net";
			for (int i = 0; i < ededeNet.length(); i++) {
				Thread.sleep(1 * 100);
				System.out.print(ededeNet.charAt(i));
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void swicht() {
		Scanner sc = new Scanner(System.in);
		int select =0;
		do {
			System.out.println();
			System.out.println("1 FILMS");
			System.out.println("2 SERIES");
			System.out.println("3 MUSIC SONG");
			System.out.println("4 EXIT");
			select = sc.nextInt();
			MenuConfig.loading();
			switch (select) {

			case 1:
				MenuConfig.printFilms();
				break;
			case 2:
				MenuConfig.printSeries();
				break;
			case 3:
				MenuConfig.printSongs();
				break;
			case 0:
				break;


			}
		} while (select!=0);
		
	}
}
