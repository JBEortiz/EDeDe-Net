package app.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import app.data.Film;
import app.data.Season;
import app.data.Serie;
import app.data.Song;
import app.enums.Category;
import app.enums.Punctuation;
import app.repository.SerieRepositoryImpl;
import app.utils.Constant;
/*
 * Class where all the business
 * logic is inserted
 */
public class SerieServiceImpl extends Service<Serie> {

	private SerieRepositoryImpl repository;

	public SerieServiceImpl(SerieRepositoryImpl repository) {
		super();
		this.repository = repository;
	}

	public SerieServiceImpl() {
		super();
	}

	/*
	 * method where we will include
	 * the logic necessary to create a serie
	 */
	@Override
	public void create(Serie createSerie) throws IOException {
		
		/*
		 * We extract the data from the repository
		 * to later update and add the new serie
		 */
		Map<String, Serie> listSeries = repository.readAll();

		
		Scanner sc = new Scanner(System.in);
		System.out.println("write the title");
		createSerie.setName(sc.next());
		System.out.println("write the year");
		createSerie.setYear(sc.next());
		System.out.println("write the category");
		System.out.println("1 TERROR, 2 LOVE, 3 FIGHTS, 4 ACTION, 5 DRAMA, 6 COMEDY");
		int option = sc.nextInt();
		/*
		 * METHOD REFACTOR
		 */
		optionCategory(option,createSerie);

		System.out.println("write the Puntuation");
		System.out.println("1 VERY_BAD, 2  BAD, 3 GOOD, 4 VERYGOOD, 5 EXCELENT");
		int optionPuntiation = sc.nextInt();
		/*
		 * METHOD REFACTOR
		 */
		optionPuntuation(optionPuntiation,createSerie);
		String season="";
		System.out.println("enter the number of seasons you want your series to have");
		int numberSeason=sc.nextInt();
		List<Season> listNewSeason= new ArrayList<>();
		for (int i = 0; i < numberSeason; i++) {
			System.out.println("Seasin: "+ (i+1)+" Name:");
			season=sc.next();
			listNewSeason.add(new Season(season));
		}
		
		createSerie.setSeasons(listNewSeason);
		listSeries.put(createSerie.getName(), createSerie);
		Writer formate = null;
		File archivo = new File(Constant.FILE_NAME_SERIE);
		try (BufferedWriter b = new BufferedWriter(new FileWriter(archivo))) {
			/*
			 * METHOD REFACTOR
			 */
			writeFile(listSeries,b,formate);
			System.out.println("creado correcatmente");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/*
	 * in this method we search by the name
	 */
	@Override
	public Serie read(String name) throws IOException {
		Scanner sc = new Scanner(System.in);
		Serie findSerie = null;
		System.out.println("Enter the movie you want to find");
		String nameSerie = sc.nextLine();

		/*
		 * We extract the data from the repository
		 * to later find the Serie
		 */
		Map<String, Serie> listSeries = repository.readAll();

		findSerie = listSeries.get(nameSerie);

		/*
		 * we extract by name and return that object
		 */
		return findSerie;
	}

	@Override
	public void update(Serie updateSerie) throws IOException {
		/*
		 * It will ask for the desired data of the request to modify
		 * and it will search for it
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the serie you want to find");
		String nameSerie = sc.nextLine();

		/*
		 * we read the data from the repository
		 */
		Map<String, Serie> listSeries = repository.readAll();

		updateSerie = listSeries.get(nameSerie);
		
		System.out.println("write the year");
		updateSerie.setYear(sc.next());
		System.out.println("write the category");
		System.out.println("1 TERROR, 2 LOVE, 3 FIGHTS, 4 ACTION, 5 DRAMA, 6 COMEDY");
		int option = sc.nextInt();
		optionCategory(option,updateSerie);

		System.out.println("write the Puntuation");
		System.out.println("1 VERY_BAD, 2  BAD, 3 GOOD, 4 VERYGOOD, 5 EXCELENT");
		int optionPuntiation = sc.nextInt();
		optionPuntuation(optionPuntiation,updateSerie);
		/*
		 * we format both 
		 * series and seasons
		 */
		listSeries.put(updateSerie.getName(), updateSerie);
		Writer formate = null;
		File archivo = new File(Constant.FILE_NAME_SERIE);
		try (BufferedWriter b = new BufferedWriter(new FileWriter(archivo))) {
				writeFile(listSeries,b,formate);
			System.out.println("creado correcatmente");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*
	 * in this method you will receive a serie but 
	 * we will search for it by name
	 */
	@Override
	public void delete(Serie t) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the movie you want to find");
		String nameSerie = sc.nextLine();

		/*
		 * we bring the data
		 * from the repository
		 */
		Map<String, Serie> listSerie = repository.readAll();

		Writer formate = null;
		if (!listSerie.isEmpty()) {
			listSerie.remove(nameSerie);
			File archivo = new File(Constant.FILE_NAME_SERIE);
			/*
			 * write if File
			 */
			try (BufferedWriter b = new BufferedWriter(new FileWriter(archivo))) {
				writeFile(listSerie,b,formate);
				System.out.println("creado correcatmente");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Serie> createWhitList() throws IOException {
		/*
		 * we instantiate a list where we will put the desired movies
		 */
		List<Serie> serieWhitList = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		String nameSerie = null;
		System.out.println("Name the WhitList");
		String nameWhitList = sc.nextLine();
		/*
		 * leemos las películas del repositorio 
		 */
		Map<String, Serie> listSeries = repository.readAll();
		/*
		 * we will introduce names if it contains it, it includes it until exit is written
		 */
		
		do {
			System.out.println("Enter the movie you want to find ");
			System.out.println("write exit to finish");
			nameSerie = sc.nextLine();
			
			for (Map.Entry<String, Serie> film : listSeries.entrySet()) {
				if (film.getKey().equalsIgnoreCase(nameSerie)) {
					serieWhitList.add(film.getValue());
				}
			}
		} while (!nameSerie.equalsIgnoreCase("exit"));

		/*
		 * once the films are selected then 
		 * we will write in another 
		 * file asking the user to enter the name of their 
		 * wish list which will be the same as the name
		 */
		Writer formate = null;
		if (!serieWhitList.isEmpty()) {
			File archivo = new File(nameWhitList);
			/*
			 * escribimos en fichero
			 */
			try (BufferedWriter b = new BufferedWriter(new FileWriter(archivo))) {
				 writeFile(listSeries,b,formate);
				
				System.out.println("creado correcatmente");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return serieWhitList;
	}
	/*
	 * method that will sort by the desired score
	 * and that returns a list
	 */
	@Override
	public List<Serie> orderByName() throws IOException {
		Map<String, Serie> listSeries = repository.readAll();
		List<Serie> series = createList(listSeries);
		/*
		 * we use compareTo 
		 */
		series.sort(new Comparator<Serie>() {
			public int compare(Serie puntuation1, Serie puntuation2) {
				return puntuation1.getName().compareToIgnoreCase(puntuation2.getName());
			}
		});

		return series;
	}
	/*
	 * methods that take all the data and put it in a list
	 */
	@Override
	public List<Serie> readAll() throws IOException {
		Map<String, Serie> listSeries = repository.readAll();
		List<Serie> series = createList(listSeries);
		return series;
	}
	
	/*
	 * method that receives a string like category
	 * to select the desired one and filter by the one searched
	 */
	public List<Serie> findByCategory(String category) throws IOException {

		Scanner sc = new Scanner(System.in);
		List<Serie> findFilms = new ArrayList<>();
		System.out.println("By Category the movie you want to find");
		System.out.println("TERROR,	LOVE, FIGHTS, ACTION, DRAMA, COMEDY");
		category = sc.nextLine();

		Map<String, Serie> listFilms = repository.readAll();

		/*
		 * create a list and add according to the filter
		 */
		for (Map.Entry<String, Serie> film : listFilms.entrySet()) {
			if (category.equals(film.getValue().getCategory().toString()) && category != null) {
				findFilms.add(film.getValue());
			}

		}

		return findFilms;
	}
	/*
	 * method that receives a string like category
	 * to select the desired one and filter by the one searched
	 */
	public List<Serie> findByPuntuation(String puntuation) throws IOException {

		Scanner sc = new Scanner(System.in);
		List<Serie> findSeries = new ArrayList<>();
		System.out.println("By puntuation the movie you want to find");
		System.out.println("VERY_BAD,  BAD,  GOOD,  VERYGOOD,  EXCELENT");
		puntuation = sc.nextLine();

		Map<String, Serie> listSeries = repository.readAll();

		/*
		 * create a list and add according to the filter
		 */
		for (Map.Entry<String, Serie> film : listSeries.entrySet()) {
			if (puntuation.equals(film.getValue().getPuntuation().toString()) && puntuation != null) {
				findSeries.add(film.getValue());
			}

		}

		return findSeries;
	}
	/*
	 * method REFACTOR selected
	 */
	public void optionCategory(int optionCategory, Serie serie) {
		switch (optionCategory) {
		case 1:
			serie.setCategory(Category.TERROR);
			break;
		case 2:
			serie.setCategory(Category.LOVE);
			break;
		case 3:
			serie.setCategory(Category.FIGHTS);
			break;
		case 4:
			serie.setCategory(Category.ACTION);
			break;
		case 5:
			serie.setCategory(Category.DRAMA);
			break;
		case 6:
			serie.setCategory(Category.COMEDY);
			break;
		}

	}
	/*
	 * method REFACTOR selected
	 */
	public void optionPuntuation(int optionPuntiation, Serie serie) {
		switch (optionPuntiation) {
		case 1:
			serie.setPuntuation(Punctuation.VERY_BAD);
			break;
		case 2:
			serie.setPuntuation(Punctuation.BAD);
			break;
		case 3:
			serie.setPuntuation(Punctuation.GOOD);
			break;
		case 4:
			serie.setPuntuation(Punctuation.VERYGOOD);
			break;
		case 5:
			serie.setPuntuation(Punctuation.EXCELENT);
			break;
		}

	}
	/*
	 * method that writes to file to save code
	 * and give standard format
	 */
	public BufferedWriter writeFile(Map<String, Serie> listSeries, BufferedWriter b, Writer formate) throws IOException {
		for (Map.Entry<String, Serie> serie : listSeries.entrySet()) {
			formate = b.append(serie.getValue().getName().concat(",").concat(serie.getValue().getYear())
					.concat(",").concat(String.valueOf(serie.getValue().getCategory()))
					.concat(",").concat(String.valueOf(serie.getValue().getPuntuation()).concat(",")));

			List<Season> listSeason = serie.getValue().getSeasons();
			for (Season listSeasonToString : listSeason) {
				formate = formate.append(String.valueOf(listSeasonToString)).append(Constant.SEPARATOR_SEASON);
			}
			formate = formate.append("\n");
		}
		b.close();
		return b;
	}
	/*
	 * From map to lists
	 */
	private List<Serie> createList(Map<String, Serie> listSeries) {
		List<Serie> list= new ArrayList<>();
		for (Map.Entry<String, Serie> serie : listSeries.entrySet()) {
			list.add(serie.getValue());
		}
		return list;
	}
	public SerieRepositoryImpl getRepository() {
		return repository;
	}

	public void setRepository(SerieRepositoryImpl repository) {
		this.repository = repository;
	}

	

}
