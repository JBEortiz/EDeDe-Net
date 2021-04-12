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

public class SongRepositoryImpl implements IGenericRepository<Song, String> {

	private Map<String,Song> songs;
	
	public SongRepositoryImpl(Map<String, Song> songs) {
		super();
		this.songs = new HashMap<String, Song>();
	}

	
	public SongRepositoryImpl() {
		super();
		this.songs = new HashMap<String, Song>();
	}


	@Override
	public void create(Song song) {
		songs.put(song.getName(), song);
	}

	@Override
	public Song read(String name) {
		return songs.get(name);
	}

	@Override
	public void update(Song song) {
		songs.put(song.getName(), song);
	}

	@Override
	public void delete(Song song) {
		songs.remove(song.getName());
	}

	@Override
	public Map<String, Song> readAll() throws IOException {

	
		FileReader reader = new FileReader(new File("song.txt"));
		BufferedReader br = new BufferedReader(reader);
		String input;
		while ((input = br.readLine()) != null) {
			Song song = new Song();
			String[] value = input.split(",");
			song.setName(value[0]);
			song.setAutor(value[1]);
			song.setDuration(value[2]);
			songs.put(song.getName(), song);
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
