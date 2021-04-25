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

/*
 * Class in charge of data access
 */
public class SerieRepositoryImpl implements IGenericRepository<Serie, String> {
	/*
	 * Map series
	 */
	private Map<String, Serie> series;

	public SerieRepositoryImpl(Map<String, Serie> series) {
		super();
		this.series = new HashMap<String, Serie>();
	}

	public SerieRepositoryImpl() {
		super();
		this.series = new HashMap<String, Serie>();

	}

	/*
	 * method to create series
	 */
	@Override
	public void create(Serie serie) throws IOException {
		series.put(serie.getName(), serie);

	}

	/*
	 * method to find series
	 */
	@Override
	public Serie read(String name) {
		return series.get(name);
	}

	/*
	 * method to modify series
	 */
	@Override
	public void update(Serie serie) {
		series.put(serie.getName(), serie);

	}

	/*
	 * method to deleted series
	 */
	@Override
	public void delete(Serie serie) {
		series.remove(serie.getCategory());

	}

	/*
	 * this is the method of accessing data in this case to a file as if it were a
	 * database
	 */
	@Override
	public Map<String, Serie> readAll() throws IOException {
		/*
		 * we check if the file exists
		 */
		if (!(new File(Constant.FILE_NAME_SERIE)).exists()) {
			System.out.println("File example.txt not found");
		}

		FileReader reader = new FileReader(new File(Constant.FILE_NAME_SERIE));
		BufferedReader br = new BufferedReader(reader);

		String input;
		String inputSeasons = null;
		/*
		 * We read all the lines and we use a split to separate each attribute with its
		 * part of the object that we will later insert in Map
		 */
		while ((input = br.readLine()) != null) {
			if (!input.isEmpty()) {

				List<Season> seasonsAll = new ArrayList<>();
				Serie serie = new Serie();
				String[] value = input.split(Constant.SEPARATOR);
				serie.setName(value[0]);
				serie.setYear(value[1]);
				serie.setCategory(Category.valueOf(value[2]));
				serie.setPuntuation(Punctuation.valueOf(value[3]));
				inputSeasons = value[4];

				/*
				 * for each series it has a list of seasons that we will have to separate in
				 * another array
				 */
				String[] valueSeaseons = inputSeasons.split(Constant.SEPARATOR_SEASON);
				for (int i = 0; i < valueSeaseons.length; i++) {
					seasonsAll.add(new Season(valueSeaseons[i]));

				}
				/*
				 * we set the list of seasons to their corresponding series
				 */
				serie.setSeasons(seasonsAll);
				series.put(serie.getName(), serie);
			} else {
				input = "Series not available the database is empty";
				System.out.println(input);
			}
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
