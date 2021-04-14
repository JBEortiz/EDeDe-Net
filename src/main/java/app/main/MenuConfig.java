package app.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import app.controller.FilmController;
import app.controller.SerieController;
import app.controller.SongController;
import app.data.Film;
import app.data.Serie;
import app.data.Song;
import app.repository.FilmRepositoryImpl;
import app.repository.SerieRepositoryImpl;
import app.repository.SongRepositoryImpl;
import app.service.FilmServiceImpl;
import app.service.SerieServiceImpl;
import app.service.SongServiceImpl;
import app.utils.Constant;

public class MenuConfig {

	public static Map<String, Film> films = new HashMap<String, Film>();
	public static FilmRepositoryImpl filmRepository = new FilmRepositoryImpl(films);
	public static FilmServiceImpl filmService = new FilmServiceImpl(filmRepository);
	public static FilmController filmController = new FilmController(filmService);

	public static Map<String, Serie> series = new HashMap<String, Serie>();
	public static SerieRepositoryImpl serieRepository = new SerieRepositoryImpl(series);
	public static SerieServiceImpl serieService = new SerieServiceImpl(serieRepository);
	public static SerieController serieController = new SerieController(serieService);

	public static Map<String, Song> songs = new HashMap<String, Song>();
	public static SongRepositoryImpl songsRepository = new SongRepositoryImpl(songs);
	public static SongServiceImpl songsService = new SongServiceImpl(songsRepository);
	public static SongController songsController = new SongController(songsService);

	public static void printFilms() {
		
		Film film = new Film();
		String name = null;
		Scanner sc = new Scanner(System.in);

		int select = 0;
		do {
			System.out.println("hello selec option");
			System.out.println("1 readAll");
			System.out.println("2 create");
			System.out.println("3 orderByPuntuation");
			System.out.println("4 delete");
			System.out.println("5 update");
			System.out.println("6 read");
			System.out.println("7 findByCategory");
			System.out.println("8 findByPuntuation");
			System.out.println("9 orderByName");
			System.out.println("10 createWhitList");
			
			select = sc.nextInt();
			switch (select) {

			case 1:
				filmController.readAll();
				break;
			case 2:
				filmController.create(film);
				break;
			case 3:
				filmController.orderByPuntuation();
				break;
			case 4:
				filmController.delete(film);
				break;
			case 5:
				filmController.update(film);
				break;
			case 6:
				filmController.read(name);
				break;
			case 7:
				filmController.findByCategory(name);
				break;
			case 8:
				filmController.findByPuntuation(name);
				break;
			case 9:
				filmController.orderByName();
				
			case 10:
				filmController.createWhitList();
				break;

			}
		} while (select != 0);

	}

	public static void printSeries() {
		
		Song song = new Song();
		String name = null;
		Scanner sc = new Scanner(System.in);
		int select = 0;
		do {
			System.out.println("hello selec option");
			System.out.println("1 readAll");
			System.out.println("2 create");
			System.out.println("3 orderByPuntuation");
			System.out.println("4 delete");
			System.out.println("5 update");
			System.out.println("6 read");
			System.out.println("3 orderByPuntuation");
			select = sc.nextInt();
			switch (select) {

			case 1:
				serieController.readAll();
				break;
			case 2:
				songsController.create(song);
				break;
			case 3:
				songsController.orderByName();
				break;
			case 4:
				songsController.delete(song);
				break;
			case 5:
				songsController.update(song);
				break;
			case 6:
				songsController.read(name);
				break;

			}
		} while (select != 0);
	}

	public static void printSongs() {
		
		Song song = new Song();
		String name = null;
		Scanner sc = new Scanner(System.in);
		int select = 0;
		do {
			System.out.println("hello selec option");
			System.out.println("1 readAll");
			System.out.println("2 create");
			System.out.println("3 orderByName");
			System.out.println("4 delete");
			System.out.println("5 update");
			System.out.println("6 read");
			System.out.println("7 createWhitList");
			System.out.println("8 findByAutor");
			System.out.println("9 orderByAutor");
			select = sc.nextInt();
		switch (select) {

		case 1:
			songsController.readAll();
			break;
		case 2:
			songsController.create(song);
			break;
		case 3:
			songsController.orderByName();
			break;
		case 4:
			songsController.delete(song);
			break;
		case 5:
			songsController.update(song);
			break;
		case 6:
			songsController.read(name);
		case 7:
			songsController.createWhitList();
			break;
		case 8:
			songsController.findByAutor(name);;
			break;
		case 9:
			songsController.orderByAutor();
			break;

		}
		}while(select!=0);
}

}
