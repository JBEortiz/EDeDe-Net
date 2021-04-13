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
import app.utils.Constant;

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
		
		if (! (new File(Constant.FILE_NAME_SERIE)).exists() ) {
			 System.out.println("File example.txt not found");
			 }
		
		List<Season> seasonsAll = new ArrayList<>();
		List<Season> seasonsFiler = new ArrayList<>();
		FileReader reader = new FileReader(new File(Constant.FILE_NAME_SERIE));
		BufferedReader br = new BufferedReader(reader);

		String input;
		String inputSeasons = null;
		while ((input = br.readLine()) != null) {
			seasonsAll.clear();
			
			Serie serie = new Serie();
			String[] value = input.split(Constant.SEPARATOR);
			serie.setName(value[0]);
			serie.setYear(value[1]);
			serie.setCategory(Category.valueOf(value[2]));
			serie.setPuntuation(Punctuation.valueOf(value[3]));
			inputSeasons = value[4];

			String[] valueSeaseons = inputSeasons.split(Constant.SEPARATOR_SEASON);
			for (int i = 0; i < valueSeaseons.length; i++) {
				seasonsAll.add(new Season(valueSeaseons[i]));
				
			}
			
			seasonsFiler = seasonsAll;
			serie.setSeasons(seasonsFiler);
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
