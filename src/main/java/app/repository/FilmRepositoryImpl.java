package app.repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import app.data.Film;
import app.data.Serie;
import app.enums.Category;
import app.enums.Punctuation;
import app.main.App;
import app.utils.Constant;

/*
 * Class in charge of data access
 */
public class FilmRepositoryImpl implements IGenericRepository<Film, String> {

	/*
	 * Map films
	 */
	private Map<String, Film> films;

	public FilmRepositoryImpl(Map<String, Film> films) {
		super();
		this.films = new HashMap<String, Film>();
	}

	public FilmRepositoryImpl() {
		super();
		this.films = new HashMap<String, Film>();
	}

	/*
	 * method to create movies
	 */
	@Override
	public void create(Film film) {
		films.put(film.getName(), film);
	}

	/*
	 * method to find movies
	 */
	@Override
	public Film read(String name) {
		return films.get(name);
	}

	/*
	 * method to modify movies
	 */
	@Override
	public void update(Film film) {
		films.put(film.getName(), film);
	}

	/*
	 * method to deleted movies
	 */
	@Override
	public void delete(Film film) {
		films.remove(film.getName());
	}

	/*
	 * this is the method of accessing data in this case to a file as if it were a
	 * database
	 */
	@Override
	public Map<String, Film> readAll() throws IOException {

		/*
		 * we check if the file exists
		 */
		if (!(new File(Constant.FILE_NAME_FILMS)).exists()) {
			System.out.println("File example.txt not found");
		}

		FileReader reader = new FileReader(new File(Constant.FILE_NAME_FILMS));
		BufferedReader br = new BufferedReader(reader);
		String input;
		/*
		 * We read all the lines and we use a split to separate each attribute with its
		 * part of the object that we will later insert in Map
		 */
		while ((input = br.readLine()) != null) {
			if (!input.isEmpty()) {
				Film film = new Film();
				String[] value = input.split(Constant.SEPARATOR);
				film.setName(value[0]);
				film.setYear(value[1]);
				film.setCategory(Category.valueOf(value[2]));
				film.setPuntuation(Punctuation.valueOf(value[3]));
				film.setDuration(value[4]);
				films.put(film.getName(), film);
			} else {
				input = "no hay films disponibles";
				System.out.println(input);
			}
		}
		/*
		 * We close file
		 */
		br.close();
		return films;
	}

	public Map<String, Film> getFilms() {
		return films;
	}

	public void setFilms(Map<String, Film> films) {
		this.films = films;
	}

}
