package app.repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import app.data.Song;
import app.main.App;
import app.utils.Constant;

/*
 * Class in charge of data access
 */
public class SongRepositoryImpl implements IGenericRepository<Song, String> {

	/*
	 * Map music
	 */
	private Map<String, Song> songs;

	public SongRepositoryImpl(Map<String, Song> songs) {
		super();
		this.songs = new HashMap<String, Song>();
	}

	public SongRepositoryImpl() {
		super();
		this.songs = new HashMap<String, Song>();
	}
	/*
	 * method to create music
	 */

	@Override
	public void create(Song song) {
		songs.put(song.getName(), song);
	}

	/*
	 * method to find music
	 */
	@Override
	public Song read(String name) {
		return songs.get(name);
	}

	/*
	 * method to modify music
	 */
	@Override
	public void update(Song song) {
		songs.put(song.getName(), song);
	}

	/*
	 * method to deleted music
	 */
	@Override
	public void delete(Song song) {
		songs.remove(song.getName());
	}

	/*
	 * this is the method of accessing data in this case to a file as if it were a
	 * database
	 */
	@Override
	public Map<String, Song> readAll() throws IOException {

		/*
		 * we check if the file exists
		 */
		if (!(new File(Constant.FILE_NAME_SONG)).exists()) {
			System.out.println("File example.txt not found");
		}

		FileReader reader = new FileReader(new File(Constant.FILE_NAME_SONG));
		BufferedReader br = new BufferedReader(reader);
		String input;
		/*
		 * We read all the lines and we use a split to separate each attribute with its
		 * part of the object that we will later insert in Map
		 */
		while ((input = br.readLine()) != null) {
			if (!input.isEmpty()) {
				Song song = new Song();
				String[] value = input.split(Constant.SEPARATOR);
				song.setName(value[0]);
				song.setAutor(value[1]);
				song.setDuration(value[2]);
				songs.put(song.getName(), song);
			} else {
				input = "no hay Song disponibles";
				System.out.println(input);
			}
		}

		br.close();
		return songs;
	}

	public Map<String, Song> getSeries() {
		return songs;
	}

	public void setSeries(Map<String, Song> songs) {
		this.songs = songs;
	}

}
