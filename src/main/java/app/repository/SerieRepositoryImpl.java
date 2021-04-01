package app.repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import app.data.Season;
import app.data.Serie;
import app.enums.Category;
import app.enums.Punctuation;
import app.main.App;

public class SerieRepositoryImpl implements IGenericRepository<Serie, String> {

	@Override
	public void create(Serie t) {

	}

	@Override
	public Serie read(String name) {
		return null;
	}

	@Override
	public void update(Serie t) {

	}

	@Override
	public void delete(Serie t) {

	}

	@Override
	public Map<String, Serie> readAll() throws IOException {
		Map<String, Serie> series = new TreeMap<String, Serie>();
		List<Season> seasons = new ArrayList<>();

		FileReader reader = new FileReader(new File(App.constants.FILE_NAME_SERIE));
		BufferedReader br = new BufferedReader(reader);

		String input;
		String inputSeasons = null;
		while ((input = br.readLine()) != null) {
			Serie serie = new Serie();
			String[] value = input.split(App.constants.SEPARATOR);
			serie.setName(value[0]);
			serie.setYear(value[1]);
			serie.setCategory(Category.valueOf(value[2]));
			serie.setPuntuation(Punctuation.valueOf(value[3]));
			inputSeasons = value[4];

			String[] valueSeaseons = inputSeasons.split(App.constants.SEPARATOR_SEASON);
			for (int i = 0; i < valueSeaseons.length; i++) {
				seasons.add(new Season(valueSeaseons[i]));
			}

			serie.setSeasons(seasons);

			series.put(serie.getName(), serie);
		}

		br.close();
		return series;
	}

}
