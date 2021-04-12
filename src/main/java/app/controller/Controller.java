package app.controller;

import java.util.List;

public abstract class  Controller<T>  {


	abstract void create(T t);
	
	abstract T read(String name);
	
	abstract void update(T t);
	
	abstract void delete(T t);
	
	abstract void createWhitList();
	
	abstract List<T> orderByPuntuation();
	
	abstract List<T> readAll();
	

}
