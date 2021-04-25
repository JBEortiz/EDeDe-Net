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
			System.out.println("***HELLO SELECT OPTION FILMS***");
			System.out.println("1 Read all");
			System.out.println("2 Create new film");
			System.out.println("3 Order by puntuation");
			System.out.println("4 Deleted film");
			System.out.println("5 Update film");
			System.out.println("6 Read by name");
			System.out.println("7 Find by category");
			System.out.println("8 Find by puntuation");
			System.out.println("9 Order by name");
			System.out.println("10 Create new whitList films");
			System.out.println("11 HOME");

			select = sc.nextInt();
			loading();
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
				break;
			case 10:
				filmController.createWhitList();
				break;
			case 11:
				App.swicht();
				break;

			}
			System.out.println("________________");
			System.out.println("");
		} while (select != 0);

	}

	public static void printSeries() {

		Serie serie = new Serie();
		String name = null;
		Scanner sc = new Scanner(System.in);
		int select = 0;
		do {
			System.out.println("***HELLO SELECT OPTION SERIES***");
			System.out.println("1 Read all");
			System.out.println("2 Create new serie");
			System.out.println("3 Order by name");
			System.out.println("4 Deleted serie");
			System.out.println("5 Update serie");
			System.out.println("6 Read by name");
			System.out.println("7 Create new whitList serie");
			System.out.println("8 Find by category");
			System.out.println("9 Find by puntuation");
			System.out.println("10 HOME");
			select = sc.nextInt();
			switch (select) {

			case 1:
				serieController.readAll();
				break;
			case 2:
				serieController.create(serie);
				break;
			case 3:
				serieController.orderByName();
				break;
			case 4:
				serieController.delete(serie);
				break;
			case 5:
				serieController.update(serie);
				break;
			case 6:
				serieController.read(name);
				break;
			case 7:
				serieController.createWhitList();
				break;
			case 8:
				serieController.findByCategory(name);
				break;
			case 9:
				serieController.findByPuntuation(name);
				break;
			case 10:
				App.swicht();
				break;

			}
			System.out.println("________________");
			System.out.println("");
		} while (select != 0);
	}

	public static void printSongs() {

		Song song = new Song();
		String name = null;
		Scanner sc = new Scanner(System.in);
		int select = 0;
		do {
			System.out.println("***HELLO SELECT OPTION SONG MUSIC***");
			System.out.println("1 Read all");
			System.out.println("2 Create new song");
			System.out.println("3 Order by name");
			System.out.println("4 Deleted song");
			System.out.println("5 Update song");
			System.out.println("6 Read by name song");
			System.out.println("7 Create new whitList");
			System.out.println("8 Find by name autor");
			System.out.println("9 Order by name autor");
			System.out.println("10 HOME");
			loading();

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
				break;
			case 7:
				songsController.createWhitList();
				break;
			case 8:
				songsController.findByAutor(name);
				break;
			case 9:
				songsController.orderByAutor();
				break;
			case 10:
				App.swicht();
				break;
			}
			System.out.println("________________");
			System.out.println("\n");
		} while (select != 0);
	}

	public static void loading() {
		try {
			System.out.println("loading");
			for (int i = 0; i < 5; i++) {
				Thread.sleep(1 * 200);
				for (int j = 0; j < i; j++) {
					System.out.print("_");
				}
			}
			System.out.println();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
