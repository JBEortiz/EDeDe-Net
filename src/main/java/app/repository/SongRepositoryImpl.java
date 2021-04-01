package app.repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import app.data.Song;
import app.main.App;

public class SongRepositoryImpl implements IGenericRepository<Song, String> {

	@Override
	public void create(Song t) {
	}

	@Override
	public Song read(String name) {
		return null;
	}

	@Override
	public void update(Song t) {
	}

	@Override
	public void delete(Song t) {
	}

	@Override
	public Map<String, Song> readAll() throws IOException {

		Map<String, Song> songs = new TreeMap<String, Song>();
	
		FileReader reader = new FileReader(new File(App.constants.FILE_NAME_SONG));
		BufferedReader br = new BufferedReader(reader);
		String input;
		while ((input = br.readLine()) != null) {
			Song song = new Song();
			String[] value = input.split(App.constants.SEPARATOR);
			song.setName(value[0]);
			song.setAutor(value[1]);
			song.setDuration(value[2]);

			songs.put(song.getName(), song);
		}

		br.close();
		return songs;
	}

}
