package app.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import app.data.Serie;
import app.service.SerieServiceImpl;

public class SerieController extends Controller<Serie> {
	
	private SerieServiceImpl service;

	public SerieController(SerieServiceImpl service) {
		super();
		this.service = service;
	}

	public SerieController() {
		super();
	}

	@Override
	public void create(Serie t) {
		try {
			service.create(t);
		} catch (IOException e) {
			System.out.println("Problem creating the serie");
			e.printStackTrace();
		}
		
	}

	@Override
	public Serie read(String name) {
		Serie serie = null;
		try {
			serie = service.read(name);
		} catch (IOException e) {
			System.out.println("The serie could not be read");
			e.printStackTrace();
		}
		System.out.println(serie);
		return serie;
	}

	@Override
	public void update(Serie t) {
		try {
			service.update(t);
		} catch (IOException e) {
			System.out.println("The desired serie could not be modified");
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Serie t) {
		try {
			service.delete(t);
		} catch (IOException e) {
			System.out.println("The desired movie could not be deleted");
			e.printStackTrace();
		}
		
	}

	@Override
	public void createWhitList() {
		List<Serie> serieWhitList = new ArrayList<>();
		try {
			serieWhitList = service.createWhitList();
			
		} catch (IOException e) {
			System.out.println("esto no va muy bien ");
			e.printStackTrace();
		}
		if(!serieWhitList.isEmpty()) {
			serieWhitList.forEach(serie->System.out.println(serie.toString()));
		}else{
			System.out.println("la lista esta vacia");
		}
		
	}

	@Override
	public void orderByName() {
		List<Serie> seriesOrder = null;
		try {
			seriesOrder = service.orderByName();
		} catch (IOException e) {
			System.out.println("Error when ordering");
			e.printStackTrace();
		}
		if(!seriesOrder.isEmpty()) {
			seriesOrder.forEach(film->System.out.println(film.toString()));
		}else{
			System.out.println("la lista esta vacia");
		}
	}

	@Override
	public List<Serie> readAll() {
		List<Serie> series = null;
		try {
			series = service.readAll();
			for (Serie serie : series) {
				System.out.println(serie);
			}
		} catch (IOException e) {
			System.out.println("Error when find all");
			e.printStackTrace();
		}
		return series;
	}
	/*
	 * methods that take all the data and put it in a list
	 */
	public List<Serie> findByCategory(String category){
		List<Serie> series = null;
		try {
			series = service.findByCategory(category);
			for (Serie serie : series) {
				System.out.println(serie);
			}
		} catch (IOException e) {
			System.out.println("Error when find all");
			e.printStackTrace();
		}
		return series;
	}
	/*
	 * methods that take all the data and put it in a list
	 */
	public List<Serie> findByPuntuation(String puntuation){
		List<Serie> series = null;
		try {
			series = service.findByPuntuation(puntuation);
			for (Serie serie : series) {
				System.out.println(serie);
			}
		} catch (IOException e) {
			System.out.println("Error when find all");
			e.printStackTrace();
		}
		return series;
	}
	public SerieServiceImpl getService() {
		return service;
	}

	public void setService(SerieServiceImpl service) {
		this.service = service;
	}

}
