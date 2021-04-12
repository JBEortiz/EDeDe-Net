package app.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import app.data.Film;
import app.enums.Category;
import app.enums.Punctuation;
import app.main.App;
import app.repository.FilmRepositoryImpl;

public class FilmServiceImpl extends Service<Film> {

	private FilmRepositoryImpl repository;

	public FilmServiceImpl(FilmRepositoryImpl repository) {
		super();
		this.repository = repository;
	}

	public FilmServiceImpl() {
		super();
	}

	@Override
	public void create(Film createFilm) throws IOException {

		Map<String, Film> listFilms = repository.readAll();

		Scanner sc = new Scanner(System.in);
		System.out.println("write the title");
		createFilm.setName(sc.next());
		System.out.println("write the year");
		createFilm.setYear(sc.next());
		System.out.println("write the duration");
		createFilm.setDuration(sc.next());
		System.out.println("write the category");
		System.out.println("1 TERROR, 2 LOVE, 3 FIGHTS, 4 ACTION, 5 DRAMA, 6 COMEDY");
		int option = sc.nextInt();
		switch (option) {
		case 1:
			createFilm.setCategory(Category.TERROR);
			break;
		case 2:
			createFilm.setCategory(Category.LOVE);
			break;
		case 3:
			createFilm.setCategory(Category.FIGHTS);
			break;
		case 4:
			createFilm.setCategory(Category.ACTION);
			break;
		case 5:
			createFilm.setCategory(Category.DRAMA);
			break;
		case 6:
			createFilm.setCategory(Category.COMEDY);
			break;
		}

		System.out.println("write the Puntuation");
		System.out.println("1 VERY_BAD, 2  BAD, 3 GOOD, 4 VERYGOOD, 5 EXCELENT");
		int optionPuntiation = sc.nextInt();
		switch (optionPuntiation) {
		case 1:
			createFilm.setPuntuation(Punctuation.VERY_BAD);
			break;
		case 2:
			createFilm.setPuntuation(Punctuation.BAD);
			break;
		case 3:
			createFilm.setPuntuation(Punctuation.GOOD);
			break;
		case 4:
			createFilm.setPuntuation(Punctuation.VERYGOOD);
			break;
		case 5:
			createFilm.setPuntuation(Punctuation.EXCELENT);
			break;
		}

		listFilms.put(createFilm.getName(), createFilm);

		File archivo = new File("films.txt");
		try (BufferedWriter b = new BufferedWriter(new FileWriter(archivo))) {
			for (Map.Entry<String, Film> film : listFilms.entrySet()) {
				b.append(film.getValue().getName().concat(",").concat(film.getValue().getYear()).concat(",")
						.concat(String.valueOf(film.getValue().getCategory())).concat(",")
						.concat(String.valueOf(film.getValue().getPuntuation())).concat(",")
						.concat(film.getValue().getDuration())).append("\n");
			}
			b.close();
			System.out.println("creado correcatmente");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Film read(String name) throws IOException {
		Scanner sc = new Scanner(System.in);
		Film findFilm = null;
		System.out.println("Enter the movie you want to find");
		String nameFlim = sc.nextLine();

		Map<String, Film> listFilms = repository.readAll();
		
		findFilm = listFilms.get(nameFlim);
		

		return findFilm;
	}

	@Override
	public List<Film> createWhitList() throws IOException {
		List<Film> filmsWhitList = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		String nameFlim = null;
		do {
			System.out.println("Enter the movie you want to find");
			nameFlim = sc.nextLine();
			Map<String, Film> listFilms = repository.readAll();
			for (Map.Entry<String, Film> film : listFilms.entrySet()) {
				if (film.getKey().contains(nameFlim)) {
					filmsWhitList.add(film.getValue());
				}
			}
		} while (nameFlim.equalsIgnoreCase("exit"));

		return filmsWhitList;
	}

	@Override
	public List<Film> orderByPuntuation() throws IOException {
		List<Film> listOrder = new ArrayList<>();
		Map<String, Film> listFilms = repository.readAll();
		for (Map.Entry<String, Film> film : listFilms.entrySet()) {
			listOrder.add(film.getValue());
		}

		listOrder.sort(new Comparator<Film>() {
			public int compare(Film puntuation1, Film puntuation2) {
				return puntuation1.getCategory().compareTo(puntuation2.getCategory());
			}
		});

		return listOrder;
	}

	@Override
	public void update(Film updateFilm) throws IOException {
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the movie you want to find");
		String nameFlim = sc.nextLine();

		Map<String, Film> listFilms = repository.readAll();

		updateFilm = listFilms.get(nameFlim);

		System.out.println(updateFilm.toString());
		
		System.out.println("write the year");
		updateFilm.setYear(sc.next());
		System.out.println("write the duration");
		updateFilm.setDuration(sc.next());
		System.out.println("write the category");
		System.out.println("1 TERROR, 2 LOVE, 3 FIGHTS, 4 ACTION, 5 DRAMA, 6 COMEDY");
		int option = sc.nextInt();
		switch (option) {
		case 1:
			updateFilm.setCategory(Category.TERROR);
			break;
		case 2:
			updateFilm.setCategory(Category.LOVE);
			break;
		case 3:
			updateFilm.setCategory(Category.FIGHTS);
			break;
		case 4:
			updateFilm.setCategory(Category.ACTION);
			break;
		case 5:
			updateFilm.setCategory(Category.DRAMA);
			break;
		case 6:
			updateFilm.setCategory(Category.COMEDY);
			break;
		}

		System.out.println("write the Puntuation");
		System.out.println("1 VERY_BAD, 2  BAD, 3 GOOD, 4 VERYGOOD, 5 EXCELENT");
		int optionPuntiation = sc.nextInt();
		switch (optionPuntiation) {
		case 1:
			updateFilm.setPuntuation(Punctuation.VERY_BAD);
			break;
		case 2:
			updateFilm.setPuntuation(Punctuation.BAD);
			break;
		case 3:
			updateFilm.setPuntuation(Punctuation.GOOD);
			break;
		case 4:
			updateFilm.setPuntuation(Punctuation.VERYGOOD);
			break;
		case 5:
			updateFilm.setPuntuation(Punctuation.EXCELENT);
			break;
		}

		listFilms.put(updateFilm.getName(), updateFilm);

		File archivo = new File("films.txt");
		try (BufferedWriter b = new BufferedWriter(new FileWriter(archivo))) {
			for (Map.Entry<String, Film> film : listFilms.entrySet()) {
				b.append(film.getValue().getName().concat(",").concat(film.getValue().getYear()).concat(",")
						.concat(String.valueOf(film.getValue().getCategory())).concat(",")
						.concat(String.valueOf(film.getValue().getPuntuation())).concat(",")
						.concat(film.getValue().getDuration())).append("\n");
			}
			b.close();
			System.out.println("creado correcatmente");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Film t) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the movie you want to find");
		String nameFlim = sc.nextLine();

		Map<String, Film> listFilms = repository.readAll();
		listFilms.remove(nameFlim);
		File archivo = new File("films.txt");
		try (BufferedWriter b = new BufferedWriter(new FileWriter(archivo))) {
			for (Map.Entry<String, Film> film : listFilms.entrySet()) {
				b.append(film.getValue().getName().concat(",").concat(film.getValue().getYear()).concat(",")
						.concat(String.valueOf(film.getValue().getCategory())).concat(",")
						.concat(String.valueOf(film.getValue().getPuntuation())).concat(",")
						.concat(film.getValue().getDuration())).append("\n");
			}
			b.close();
			System.out.println("creado correcatmente");
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}
	@Override
	public List<Film> readAll() throws IOException {
		Map<String, Film> filmsMap = repository.readAll();

		List<Film> listOrder = new ArrayList<>();
		for (Map.Entry<String, Film> film : filmsMap.entrySet()) {
			listOrder.add(film.getValue());
		}

		return listOrder;
	}

	public FilmRepositoryImpl getRepository() {
		return repository;
	}

	public void setRepository(FilmRepositoryImpl repository) {
		this.repository = repository;
	}

	

}
