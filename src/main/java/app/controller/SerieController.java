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
		// TODO Ap�ndice de m�todo generado autom�ticamente
		
	}

	@Override
	Serie read(String name) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return null;
	}

	@Override
	void update(Serie t) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		
	}

	@Override
	void delete(Serie t) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		
	}

	@Override
	void createWhitList() {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		
	}

	@Override
	List<Serie> orderByPuntuation() {
		// TODO Ap�ndice de m�todo generado autom�ticamente
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
