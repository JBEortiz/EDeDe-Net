package app.controller;

import java.io.IOException;
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
		// TODO Apéndice de método generado automáticamente
		return null;
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
		// TODO Apéndice de método generado automáticamente
		
	}

	@Override
	public List<Song> orderByPuntuation() {
		List<Song> songsOrder = null;
		try {
			songsOrder = service.orderByPuntuation();
			for (Song song : songsOrder) {
				System.out.println(song.toString());
			}
		} catch (IOException e) {
			System.out.println("Error when ordering");
			e.printStackTrace();
		}
		return songsOrder;
	}

	@Override
	public List<Song> readAll() {
		List<Song> songs = null;
		try {
			songs = service.readAll();
			for (Song film : songs) {
				System.out.println(film);
			}
		} catch (IOException e) {
			System.out.println(e+"Error when find all");
			e.printStackTrace();
		}
		return songs;
	}


	public SongServiceImpl getService() {
		return service;
	}


	public void setService(SongServiceImpl service) {
		this.service = service;
	}

	
}
