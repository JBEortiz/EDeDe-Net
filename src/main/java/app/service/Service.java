package app.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import app.data.Film;

public abstract class Service<T>  {


	abstract void create(T t) throws IOException;
	
	abstract T read(String name) throws IOException;
	
	abstract void update(T t) throws IOException;
	
	abstract void delete(T t) throws IOException;
	
	abstract List<T> createWhitList() throws IOException;
	
	abstract List<T> orderByPuntuation() throws IOException;
	
	abstract List<T> readAll() throws IOException;
	
}
