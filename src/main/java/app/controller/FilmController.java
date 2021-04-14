package app.controller;

import java.io.IOException;
import java.util.ArrayList;
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
		List<Film> filmsWhitList = new ArrayList<>();
		try {
			filmsWhitList = service.createWhitList();
			
		} catch (IOException e) {
			System.out.println("esto no va muy bien ");
			e.printStackTrace();
		}
		if(!filmsWhitList.isEmpty()) {
			filmsWhitList.forEach(film->System.out.println(film.toString()));
		}else{
			System.out.println("la lista esta vacia");
		}

	}

	public List<Film> orderByPuntuation() {

		List<Film> filmsOrder = null;
		try {
			filmsOrder = service.orderByPuntuation();
		} catch (IOException e) {
			System.out.println("Error when ordering");
			e.printStackTrace();
		}
		if(!filmsOrder.isEmpty()) {
			filmsOrder.forEach(film->System.out.println(film.toString()));
		}else{
			System.out.println("la lista esta vacia");
		}
		return filmsOrder;
	}

	@Override
	public List<Film> readAll() {
		List<Film> films = new ArrayList<>();
		try {
			films = service.readAll();
		} catch (IOException e) {
			System.out.println("Error when find all");
			e.printStackTrace();
		}
		if(!films.isEmpty()) {
			films.forEach(film->System.out.println(film.toString()));
		}else{
			System.out.println("la lista esta vacia");
		}
		return films;
	}
	
	@Override
	public void orderByName(){
		List<Film> films = new ArrayList<>();
		try {
			films = service.orderByName();

		} catch (IOException e) {
			System.out.println("Error when find all");
			e.printStackTrace();
		}
		if(!films.isEmpty()) {
			films.forEach(film->System.out.println(film.toString()));
		}else{
			System.out.println("la lista esta vacia");
		}
		
	}

	public void findByCategory(String category){
		List<Film> films = new ArrayList<>();
		try {
			films = service.findByCategory(category);

		} catch (IOException e) {
			System.out.println("Error when find all");
			e.printStackTrace();
		}
		if(!films.isEmpty()) {
			films.forEach(film->System.out.println(film.toString()));
		}else{
			System.out.println("la lista esta vacia");
		}
		
	}
	
	public void findByPuntuation(String puntuation){
		List<Film> films = new ArrayList<>();
		try {
			films = service.findByPuntuation(puntuation);

		} catch (IOException e) {
			System.out.println("Error when find all");
			e.printStackTrace();
		}
		if(!films.isEmpty()) {
			films.forEach(film->System.out.println(film.toString()));
		}else{
			System.out.println("la lista esta vacia");
		}
		
	}
}
