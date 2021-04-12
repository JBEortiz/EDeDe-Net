package app.controller;

import java.io.IOException;
import java.util.List;

import app.data.Film;
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
	void create(Serie t) {
		// TODO Apéndice de método generado automáticamente
		
	}

	@Override
	Serie read(String name) {
		// TODO Apéndice de método generado automáticamente
		return null;
	}

	@Override
	void update(Serie t) {
		// TODO Apéndice de método generado automáticamente
		
	}

	@Override
	void delete(Serie t) {
		// TODO Apéndice de método generado automáticamente
		
	}

	@Override
	void createWhitList() {
		// TODO Apéndice de método generado automáticamente
		
	}

	@Override
	List<Serie> orderByPuntuation() {
		// TODO Apéndice de método generado automáticamente
		return null;
	}

	@Override
	public List<Serie> readAll() {
		List<Serie> films = null;
		try {
			films = service.readAll();
			for (Serie film : films) {
				System.out.println(film);
			}
		} catch (IOException e) {
			System.out.println("Error when find all");
			e.printStackTrace();
		}
		return films;
	}

	public SerieServiceImpl getService() {
		return service;
	}

	public void setService(SerieServiceImpl service) {
		this.service = service;
	}

}
