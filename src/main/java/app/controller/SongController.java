package app.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import app.data.Song;
import app.service.SongServiceImpl;

public class SongController extends Controller<Song> {

	private SongServiceImpl service;

	public SongController(SongServiceImpl service) {
		super();
		this.service = service;
	}

	public SongController() {
		super();
	}

	@Override
	public void create(Song t) {
		try {
			service.create(t);
		} catch (IOException e) {
			System.out.println("Problem creating the movie");
			e.printStackTrace();
		}

	}

	@Override
	public Song read(String name) {
		Song song = null;
		try {
			song = service.read(name);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(song);
		return song;
	}

	public void findByAutor(String name) {
		List<Song> findByAutor = new ArrayList<>();

		try {
			findByAutor = service.findByAutor(name);
		} catch (IOException e) {
			System.out.println("esto no va muy bien ");
			e.printStackTrace();
		}

		if (!findByAutor.isEmpty()) {
			findByAutor.forEach(song -> System.out.println(song.toString()));
		} else {
			System.out.println("no se ha encontrado");
		}
	}

	public void orderByAutor() {
		List<Song> songs = new ArrayList<>();
		try {
			songs = service.orderByAutor();

		} catch (IOException e) {
			System.out.println("Error when find all");
			e.printStackTrace();
		}

		if (!songs.isEmpty()) {
			songs.forEach(song -> System.out.println(song.getAutor()+" "+song.getName()));
		} else {
			System.out.println("no se ha encontrado");
		}
	}

	@Override
	public void update(Song t) {
		try {
			service.update(t);
		} catch (IOException e) {
			System.out.println("The desired movie could not be modified");
			e.printStackTrace();
		}

	}

	@Override
	public void delete(Song t) {
		try {
			service.delete(t);
		} catch (IOException e) {
			System.out.println("The desired movie could not be deleted");
			e.printStackTrace();
		}

	}

	@Override
	public void createWhitList() {
		List<Song> songs = new ArrayList<>();
		try {
			songs = service.createWhitList();

		} catch (IOException e) {
			System.out.println("esto no va muy bien ");
			e.printStackTrace();
		}

		if (!songs.isEmpty()) {
			songs.forEach(song -> System.out.println(song.toString()));
		} else {
			System.out.println("no se ha encontrado");
		}
	}

	@Override
	public void orderByName() {
		List<Song> songsOrder = new ArrayList<>();
		try {
			songsOrder = service.orderByName();
		} catch (IOException e) {
			System.out.println("Error when ordering");
			e.printStackTrace();
		}
		if (!songsOrder.isEmpty()) {
			songsOrder.forEach(song -> System.out.println(song.toString()));
		} else {
			System.out.println("no se ha encontrado");
		}
	}

	@Override
	public List<Song> readAll() {
		List<Song> songs = new ArrayList<>();
		try {
			songs = service.readAll();
			songs.forEach(song -> System.out.println(song.toString()));
		} catch (IOException e) {
			System.out.println(e + "Error when find all");
			e.printStackTrace();
		}
		if (!songs.isEmpty()) {
			songs.forEach(song -> System.out.println(song.toString()));
			return songs;
		} else {
			System.out.println("no se ha encontrado");
			return songs;
		}
		
	}

	public SongServiceImpl getService() {
		return service;
	}

	public void setService(SongServiceImpl service) {
		this.service = service;
	}

}
