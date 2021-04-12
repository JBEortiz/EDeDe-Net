package app.repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import app.data.Season;
import app.data.Serie;
import app.enums.Category;
import app.enums.Punctuation;
import app.main.App;

public class SerieRepositoryImpl implements IGenericRepository<Serie, String> {

	private Map<String,Serie> series;
	
	
	
	public SerieRepositoryImpl(Map<String, Serie> series) {
		super();
		this.series = new HashMap<String, Serie>();
	}

	
	public SerieRepositoryImpl() {
		super();
		this.series = new HashMap<String, Serie>();
		
	}


	@Override
	public void create(Serie serie) throws IOException {
		series.put(serie.getName(), serie);

	}

	@Override
	public Serie read(String name) {
		return series.get(name);
	}

	@Override
	public void update(Serie serie) {
		series.put(serie.getName(), serie);
		
	}

	@Override
	public void delete(Serie serie) {
		series.remove(serie.getCategory());

	}

	@Override
	public Map<String, Serie> readAll() throws IOException {
		List<Season> seasons = new ArrayList<>();

		FileReader reader = new FileReader(new File("serie.txt"));
		BufferedReader br = new BufferedReader(reader);

		String input;
		String inputSeasons = null;
		while ((input = br.readLine()) != null) {
			Serie serie = new Serie();
			String[] value = input.split(",");
			serie.setName(value[0]);
			serie.setYear(value[1]);
			serie.setCategory(Category.valueOf(value[2]));
			serie.setPuntuation(Punctuation.valueOf(value[3]));
			inputSeasons = value[4];

			String[] valueSeaseons = inputSeasons.split("/");
			for (int i = 0; i < valueSeaseons.length; i++) {
				seasons.add(new Season(valueSeaseons[i]));
			}

			serie.setSeasons(seasons);

			series.put(serie.getName(), serie);
		}

		br.close();
		return series;
	}
	
	public Map<String, Serie> getSeries() {
		return series;
	}


	public void setSeries(Map<String, Serie> series) {
		this.series = series;
	}

	
	
}
