package app.controller;

import java.io.IOException;
import java.util.List;

import app.data.Film;
import app.service.FilmServiceImpl;



public class FilmController extends Controller<Film> {

	private FilmServiceImpl service;

	public FilmController() {
		super();
	}

	public FilmController(FilmServiceImpl service) {
		super();
		this.service = service;
	}

	public FilmServiceImpl getService() {
		return service;
	}

	public void setService(FilmServiceImpl service) {
		this.service = service;
	}

	@Override
	public void create(Film t) {

		try {
			service.create(t);
		} catch (IOException e) {
			System.out.println("Problem creating the movie");
			e.printStackTrace();
		}
	}

	@Override
	public Film read(String name) {
		Film film = null;
		try {
			film = service.read(name);
		} catch (IOException e) {
			System.out.println("The movie could not be read");
			e.printStackTrace();
		}
		System.out.println(film);
		return film;
	}

	@Override
	public void update(Film t) {
		try {
			service.update(t);
		} catch (IOException e) {
			System.out.println("The desired movie could not be modified");
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Film t) {
		try {
			service.delete(t);
		} catch (IOException e) {
			System.out.println("The desired movie could not be deleted");
			e.printStackTrace();
		}
	}

	@Override
	public void createWhitList() {
		try {
			List<Film> filmsWhitList = service.createWhitList();
			for (Film film : filmsWhitList) {
				System.out.println(film.toString());
			}
		} catch (IOException e) {
			System.out.println("esto no va muy bien ");
			e.printStackTrace();
		}

	}

	@Override
	public List<Film> orderByPuntuation() {

		List<Film> filmsOrder = null;
		try {
			filmsOrder = service.orderByPuntuation();
			for (Film film : filmsOrder) {
				System.out.println(film.toString());
			}
		} catch (IOException e) {
			System.out.println("Error when ordering");
			e.printStackTrace();
		}
		return filmsOrder;
	}

	@Override
	public List<Film> readAll() {
		List<Film> films = null;
		try {
			films = service.readAll();
			for (Film film : films) {
				System.out.println(film);
			}
		} catch (IOException e) {
			System.out.println("Error when find all");
			e.printStackTrace();
		}
		return films;
	}
	
	
	public List<Film> orderByName(){
		List<Film> films = null;
		try {
			films = service.orderByName();
			for (Film film : films) {
				System.out.println(film);
			}
		} catch (IOException e) {
			System.out.println("Error when find all");
			e.printStackTrace();
		}
		return films;
		
	}

	public List<Film> findByCategory(String category){
		List<Film> films = null;
		try {
			films = service.findByCategory(category);
			for (Film film : films) {
				System.out.println(film);
			}
		} catch (IOException e) {
			System.out.println("Error when find all");
			e.printStackTrace();
		}
		return films;
		
	}
	
	public List<Film> findByPuntuation(String puntuation){
		List<Film> films = null;
		try {
			films = service.findByPuntuation(puntuation);
			for (Film film : films) {
				System.out.println(film);
			}
		} catch (IOException e) {
			System.out.println("Error when find all");
			e.printStackTrace();
		}
		return films;
		
	}
}
