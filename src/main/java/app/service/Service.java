package app.service;

import java.util.List;

public abstract class Service<T>  {


	abstract void create(T t);
	
	abstract T read(String name);
	
	abstract void update(T t);
	
	abstract void delete(T t);
	
	abstract void createWhitList(List<T> t);
	
	abstract List<T> orderByPuntuation(List<T> t);
	
}
