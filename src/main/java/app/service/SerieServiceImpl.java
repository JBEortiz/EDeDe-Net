package app.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import app.data.Film;
import app.data.Serie;
import app.repository.SerieRepositoryImpl;

public class SerieServiceImpl extends Service<Serie> {

	private SerieRepositoryImpl repository;
	

	public SerieServiceImpl(SerieRepositoryImpl repository) {
		super();
		this.repository = repository;
	}

	public SerieServiceImpl() {
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
	List<Serie> createWhitList() {
		return null;
		// TODO Apéndice de método generado automáticamente
		
	}

	@Override
	List<Serie> orderByName() throws IOException {
		List<Serie> series= new ArrayList<Serie>();
		Map<String, Serie> listSeries = repository.readAll();
		for (Map.Entry<String, Serie> serie : listSeries.entrySet()) {
			series.add(serie.getValue());
		}
		
		series.sort(new Comparator<Serie>() {
			public int compare(Serie puntuation1, Serie puntuation2) {
				return puntuation1.getName().compareTo(puntuation2.getName());
			}
		});
		
		return series;
	}

	public SerieRepositoryImpl getRepository() {
		return repository;
	}

	public void setRepository(SerieRepositoryImpl repository) {
		this.repository = repository;
	}

	@Override
	public List<Serie> readAll() throws IOException {
		Map<String, Serie> listSeries = repository.readAll();
		List<Serie> listOrder = new ArrayList<>();
		for (Map.Entry<String, Serie> film : listSeries.entrySet()) {
			listOrder.add(film.getValue());
		}

		return listOrder;
	}

	
}
