package app.repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import app.data.Film;
import app.enums.Category;
import app.enums.Punctuation;
import app.main.App;

public class FilmRepositoryImpl implements IGenericRepository<Film,String>{

	@Override
	public void create(Film t) {
	}

	@Override
	public Film read(String name) {
		return null;
	}

	@Override
	public void update(Film t) {
	}

	@Override
	public void delete(Film t) {
	}

	@Override
	public Map<String, Film> readAll() throws IOException {
		Map<String, Film> films = new TreeMap<String, Film>();

		FileReader reader = new FileReader(new File(App.constants.FILE_NAME_FILMS));
		BufferedReader br = new BufferedReader(reader);
		String input;
		while ((input = br.readLine()) != null) {
			Film film = new Film();
			String[] value = input.split(App.constants.SEPARATOR);
			film.setName(value[0]);
			film.setYear(value[1]);
			film.setDuration(value[2]);
			film.setCategory(Category.valueOf(value[2]));
			film.setPuntuation(Punctuation.valueOf(value[3]));
			film.setDuration(value[4]);
			films.put(film.getName(), film);
		}

		br.close();
		return films;
	}

	

}
