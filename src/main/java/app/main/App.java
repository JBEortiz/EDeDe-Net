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
		System.out.println("hello selec option");
		System.out.println("1 flims");
		System.out.println("2 Series");
		System.out.println("3 song");
		
		
	}
	
	public static void swicht() {

		Scanner sc = new Scanner(System.in);
		int select  = sc.nextInt();
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

		}
	}
}
