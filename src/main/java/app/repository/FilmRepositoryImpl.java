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

public class FilmRepositoryImpl implements IGenericRepository<Film, String> {

	private Map<String, Film> films;

	public FilmRepositoryImpl(Map<String, Film> films) {
		super();
		this.films = new HashMap<String, Film>();
	}

	public FilmRepositoryImpl() {
		super();
		this.films = new HashMap<String, Film>();
	}

	@Override
	public void create(Film film) {
		films.put(film.getName(), film);
	}

	@Override
	public Film read(String name) {
		return films.get(name);
	}

	@Override
	public void update(Film film) {
		films.put(film.getName(), film);
	}

	@Override
	public void delete(Film film) {
		films.remove(film.getName());
	}

	@Override
	public Map<String, Film> readAll() throws IOException {

		FileReader reader = new FileReader(new File("films.txt"));
		BufferedReader br = new BufferedReader(reader);
		String input;
		while ((input = br.readLine()) != null) {
			Film film = new Film();
			String[] value = input.split(",");
			film.setName(value[0]);
			film.setYear(value[1]);
			film.setCategory(Category.valueOf(value[2]));
			film.setPuntuation(Punctuation.valueOf(value[3]));
			film.setDuration(value[4]);
			films.put(film.getName(), film);
		}

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
