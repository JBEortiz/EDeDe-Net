package app.repository;

public interface IGenericRepository<T> {
	
	void create(T t);
	
	T read(String name);
	
	void update(T t);
	
	void delete(T t);
	
	
}
