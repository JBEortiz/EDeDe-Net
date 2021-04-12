package app.repository;

import java.io.IOException;
import java.util.Map;

public interface IGenericRepository<T,E> {
	
	void create(T t) throws IOException;
	
	T read(String name);
	
	void update(T t);
	
	void delete(T t);
	
	public Map<E,T> readAll() throws IOException;
	
	
}
