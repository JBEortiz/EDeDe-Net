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
import app.data.Song;
import app.enums.Category;
import app.enums.Punctuation;
import app.repository.FilmRepositoryImpl;
import app.utils.Constant;
/*
 * Class where all the business
 * logic is inserted
 */

public class FilmServiceImpl extends Service<Film> {
	
	/*
	 * FilmRepositoryImpl repository
	 */
	private FilmRepositoryImpl repository;

	public FilmServiceImpl(FilmRepositoryImpl repository) {
		super();
		this.repository = repository;
	}

	public FilmServiceImpl() {
		super();
	}

	/*
	 * method where we will include
	 * the logic necessary to create a movie
	 */
	@Override
	public void create(Film createFilm) throws IOException {

		/*
		 * We extract the data from the repository
		 * to later update and add the new movie
		 */
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
		optionCategory(option,createFilm);

		System.out.println("write the Puntuation");
		System.out.println("1 VERY_BAD, 2  BAD, 3 GOOD, 4 VERYGOOD, 5 EXCELENT");
		int optionPuntiation = sc.nextInt();
		optionPuntuation(optionPuntiation,createFilm);
		/*
		 * once the desired data is inserted
		 * we put in the Map
		 */
		listFilms.put(createFilm.getName(), createFilm);
		/*
		 * Once the map is updated, we overwrite the file
		 */
		File archivo = new File(Constant.FILE_NAME_FILMS);
		try (BufferedWriter b = new BufferedWriter(new FileWriter(archivo))) {
			//METHODS REFACTOR
			writeFile(listFilms, b);
			System.out.println("creado correcatmente");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/*
	 * in this method we search by the name
	 */
	@Override
	public Film read(String name) throws IOException {
		Scanner sc = new Scanner(System.in);
		Film findFilm = null;
		System.out.println("Enter the movie you want to find");
		String nameFlim = sc.nextLine();

		/*
		 * We extract the data from the repository
		 * to later find the movie
		 */
		Map<String, Film> listFilms = repository.readAll();

		findFilm = listFilms.get(nameFlim);

		/*
		 * we extract by name and return that object
		 */
		return findFilm;
	}
	
	/*
	 * method to create a wish list
	 */
	@Override
	public List<Film> createWhitList() throws IOException {
		/*
		 * we instantiate a list where we will put the desired movies
		 */
		List<Film> filmsWhitList = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		String nameFlim = null;
		System.out.println("Name the WhitList");
		String nameWhitList = sc.nextLine();
		/*
		 * leemos las películas del repositorio 
		 */
		Map<String, Film> listFilms = repository.readAll();
		/*
		 * we will introduce names if it contains it, it includes it until exit is written
		 */
		
		do {
			System.out.println("Enter the movie you want to find");
			System.out.println("write exit to finish");
			nameFlim = sc.nextLine();
			
			for (Map.Entry<String, Film> film : listFilms.entrySet()) {
				if (film.getKey().contains(nameFlim)) {
					filmsWhitList.add(film.getValue());
				}
			}
		} while (!nameFlim.equalsIgnoreCase("exit"));

		/*
		 * once the films are selected then 
		 * we will write in another 
		 * file asking the user to enter the name of their 
		 * wish list which will be the same as the name
		 */
		File archivo = new File(nameWhitList + ".txt");
		try (BufferedWriter b = new BufferedWriter(new FileWriter(archivo))) {
			for (Film film : filmsWhitList) {
				b.append(film.getName().concat(Constant.SEPARATOR).concat(film.getYear()).concat(Constant.SEPARATOR)
						.concat(String.valueOf(film.getCategory())).concat(Constant.SEPARATOR)
						.concat(String.valueOf(film.getPuntuation())).concat(Constant.SEPARATOR)
						.concat(film.getDuration())).append(Constant.LINE_BREAK);
			}

			/*
			 * close file
			 */
			b.close();
			System.out.println("creado correcatmente");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return filmsWhitList;
	}
	
	/*
	 * method that orders by name
	 */
	@Override
	public List<Film> orderByName() throws IOException {
		Map<String, Film> listFilms = repository.readAll();
		//METHODS REFACTOR
		List<Film> listOrder = createList(listFilms);

		listOrder.sort(new Comparator<Film>() {
			public int compare(Film puntuation1, Film puntuation2) {
				return puntuation1.getName().compareToIgnoreCase(puntuation2.getName());
			}
		});

		return listOrder;
	}

	/*
	 * method to modify a movie
	 */
	@Override
	public void update(Film updateFilm) throws IOException {

		/*
		 * It will ask for the desired data of the request to modify
		 * and it will search for it
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the movie you want to find");
		String nameFlim = sc.nextLine();

		/*
		 * we read the data from the repository
		 */
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
		//METHODS REFACTOR
		optionCategory(option,updateFilm);
		
		System.out.println("write the Puntuation");
		System.out.println("1 VERY_BAD, 2  BAD, 3 GOOD, 4 VERYGOOD, 5 EXCELENT");
		int optionPuntiation = sc.nextInt();
		//METHODS REFACTOR
		optionPuntuation(optionPuntiation,updateFilm);
		/*
		 * once the desired data is inserted
		 * we put in the Map
		 */
		listFilms.put(updateFilm.getName(), updateFilm);

		/*
		 * Once the map is updated, we overwrite the file
		 */
		File archivo = new File(Constant.FILE_NAME_FILMS);
		try (BufferedWriter b = new BufferedWriter(new FileWriter(archivo))) {
			//METHODS REFACTOR
			writeFile(listFilms, b);
			System.out.println("creado correcatmente");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * in this method you will receive a movie but 
	 * we will search for it by name
	 */
	@Override
	public void delete(Film t) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the movie you want to find");
		String nameFlim = sc.nextLine();

		Map<String, Film> listFilms = repository.readAll();
		/*
		 * once found and deleted we will rewrite the file
		 */
		listFilms.remove(nameFlim);
		File archivo = new File(Constant.FILE_NAME_FILMS);
		try (BufferedWriter b = new BufferedWriter(new FileWriter(archivo))) {
			//METHODS REFACTOR
			writeFile(listFilms, b);
			System.out.println("deleted correcatmente");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/*
	 * methods that take all the data and put it in a list
	 */
	@Override
	public List<Film> readAll() throws IOException {
		Map<String, Film> listFilms = repository.readAll();
		//METHODS REFACTOR
		List<Film> listOrder = createList(listFilms);
		return listOrder;
	}

	/*
	 * METHODS THAT ARE NOT IN COMMON SPECIFIC TO THE ENTITY
	 */

	/*
	 * method that will sort by the desired score
	 * and that returns a list
	 */
	public List<Film> orderByPuntuation() throws IOException {
		Map<String, Film> listFilms = repository.readAll();
		//METHODS REFACTOR
		List<Film> listOrder = createList(listFilms);
		/*
		 * we use compareTo 
		 */
		listOrder.sort(new Comparator<Film>() {
			public int compare(Film puntuation1, Film puntuation2) {
				return puntuation1.getPuntuation().compareTo(puntuation2.getPuntuation());
			}
		});

		return listOrder;
	}

	/*
	 * method that receives a string like category
	 * to select the desired one and filter by the one searched
	 */
	public List<Film> findByCategory(String category) throws IOException {

		Scanner sc = new Scanner(System.in);
		List<Film> findFilms = new ArrayList<>();
		System.out.println("By Category the movie you want to find");
		System.out.println("TERROR,	LOVE, FIGHTS, ACTION, DRAMA, COMEDY");
		category = sc.nextLine();

		Map<String, Film> listFilms = repository.readAll();

		/*
		 * create a list and add according to the filter
		 */
		for (Map.Entry<String, Film> film : listFilms.entrySet()) {
			if (category.equals(film.getValue().getCategory().toString()) && category != null) {
				findFilms.add(film.getValue());
			}

		}

		return findFilms;
	}

	/*
	 * method that receives a string like puntuation
	 * to select the desired one and filter by the one searched
	 */
	public List<Film> findByPuntuation(String puntuation) throws IOException {
		Scanner sc = new Scanner(System.in);
		List<Film> findFilms = new ArrayList<>();
		System.out.println("By Puntuation the movie you want to find");
		System.out.println("VERY_BAD,  BAD,  GOOD,  VERYGOOD,  EXCELENT");
		puntuation = sc.nextLine();

		Map<String, Film> listFilms = repository.readAll();

		/*
		 * create a list and add according to the filter
		 */
		for (Map.Entry<String, Film> film : listFilms.entrySet()) {
			if (puntuation.equals(film.getValue().getPuntuation().toString()) && puntuation != null) {
				findFilms.add(film.getValue());
			}

		}

		return findFilms;
	}

	/*
	 * METHODS REFACTOR
	 *
	 */
	private List<Film> createList(Map<String, Film> listFilms) {
		List<Film> list= new ArrayList<>();
		for (Map.Entry<String, Film> film : listFilms.entrySet()) {
			list.add(film.getValue());
		}
		return list;
	}
	
	
	public void optionCategory(int optionCategory, Film film) {
		switch (optionCategory) {
		case 1:
			film.setCategory(Category.TERROR);
			break;
		case 2:
			film.setCategory(Category.LOVE);
			break;
		case 3:
			film.setCategory(Category.FIGHTS);
			break;
		case 4:
			film.setCategory(Category.ACTION);
			break;
		case 5:
			film.setCategory(Category.DRAMA);
			break;
		case 6:
			film.setCategory(Category.COMEDY);
			break;
		}

	}

	public void optionPuntuation(int optionPuntiation, Film film) {
		switch (optionPuntiation) {
		case 1:
			film.setPuntuation(Punctuation.VERY_BAD);
			break;
		case 2:
			film.setPuntuation(Punctuation.BAD);
			break;
		case 3:
			film.setPuntuation(Punctuation.GOOD);
			break;
		case 4:
			film.setPuntuation(Punctuation.VERYGOOD);
			break;
		case 5:
			film.setPuntuation(Punctuation.EXCELENT);
			break;
		}

	}

	/*
	 * method that writes to file to save code
	 * and give standard format
	 */
	public BufferedWriter writeFile(Map<String, Film> listFilms, BufferedWriter b) throws IOException {
		for (Map.Entry<String, Film> film : listFilms.entrySet()) {
			b.append(film.getValue().getName().concat(Constant.SEPARATOR).concat(film.getValue().getYear())
					.concat(Constant.SEPARATOR).concat(String.valueOf(film.getValue().getCategory()))
					.concat(Constant.SEPARATOR).concat(String.valueOf(film.getValue().getPuntuation()))
					.concat(Constant.SEPARATOR).concat(film.getValue().getDuration())).append(Constant.LINE_BREAK);
		}
		b.close();
		return b;
	}

	public FilmRepositoryImpl getRepository() {
		return repository;
	}

	public void setRepository(FilmRepositoryImpl repository) {
		this.repository = repository;
	}

}
