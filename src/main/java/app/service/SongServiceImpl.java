package app.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import app.data.Film;
import app.data.Serie;
import app.data.Song;
import app.repository.SongRepositoryImpl;
import app.utils.Constant;

public class SongServiceImpl extends Service<Song>{

	private SongRepositoryImpl repository;
	

	public SongServiceImpl(SongRepositoryImpl repository) {
		super();
		this.repository = repository;
	}
	
	public SongServiceImpl() {
		super();
	}


	@Override
   public void create(Song createSong) throws IOException {

		Map<String, Song> listSongs = repository.readAll();

		Scanner sc = new Scanner(System.in);
		System.out.println("write the title");
		createSong.setName(sc.next());
		System.out.println("write the Author");
		createSong.setAutor(sc.next());
		System.out.println("write the duration");
		createSong.setDuration(sc.next());
		listSongs.put(createSong.getName(), createSong);
		File archivo = new File("song.txt");
		try (BufferedWriter b = new BufferedWriter(new FileWriter(archivo))) {
			for (Map.Entry<String, Song> song : listSongs.entrySet()) {
				b.append(song.getValue().getName().concat(",")
						.concat(song.getValue().getAutor()).concat(",")
						.concat(song.getValue().getDuration())).append("\n");
			}
			b.close();
			System.out.println("creado correcatmente");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Song read(String name)throws IOException {
		Scanner sc = new Scanner(System.in);
		Song findSong = null;
		System.out.println("Enter the song you want to find");
		String nameSong = sc.nextLine();

		Map<String, Song> listSongs = repository.readAll();
		
		findSong = listSongs.get(nameSong);
		

		return findSong;
	}

	
	public List<Song> findByAutor(String name)throws IOException {
		Scanner sc = new Scanner(System.in);
		List<Song> listSongs = new ArrayList<>();
		System.out.println("By name the song you want to find");
		name = sc.nextLine();

		Map<String, Song> mapSongs = repository.readAll();

		/*
		 * create a list and add according to the filter
		 */
		for (Map.Entry<String, Song> film : mapSongs.entrySet()) {
			if (name.equals(film.getValue().getAutor().toString()) && name != null) {
				listSongs.add(film.getValue());
			}

		}

		return listSongs;
	}
	
	public List<Song> orderByAutor() throws IOException {
		List<Song> listOrder = new ArrayList<>();
		Map<String, Song> listSongs = repository.readAll();
		for (Map.Entry<String, Song> song : listSongs.entrySet()) {
			listOrder.add(song.getValue());
		}

		listOrder.sort(new Comparator<Song>() {
			public int compare(Song autor1, Song autor2) {
				return autor1.getAutor().compareTo(autor2.getAutor());
			}
		});

		return listOrder;
	}
	
	@Override
	public void update(Song updateSong) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the movie you want to find");
		String nameSong = sc.nextLine();

		Map<String, Song> listSongs = repository.readAll();

		updateSong = listSongs.get(nameSong);
		System.out.println(updateSong);

		
		System.out.println("write the Author");
		updateSong.setAutor(sc.nextLine());
		System.out.println("write the duration");
		updateSong.setDuration(sc.nextLine());
		listSongs.put(updateSong.getName(), updateSong);
		File archivo = new File("song.txt");
		try (BufferedWriter b = new BufferedWriter(new FileWriter(archivo))) {
			for (Map.Entry<String, Song> song : listSongs.entrySet()) {
				b.append(song.getValue().getName().concat(",")
						.concat(song.getValue().getAutor()).concat(",")
						.concat(song.getValue().getDuration())).append("\n");
			}
			b.close();
			System.out.println("creado correcatmente");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Song t) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the movie you want to find");
		String nameSong = sc.nextLine();

		Map<String, Song> listSongs = repository.readAll();

		listSongs.remove(nameSong);
		File archivo = new File("song.txt");
		try (BufferedWriter b = new BufferedWriter(new FileWriter(archivo))) {
			for (Map.Entry<String, Song> song : listSongs.entrySet()) {
				b.append(song.getValue().getName().concat(",")
						.concat(song.getValue().getAutor()).concat(",")
						.concat(song.getValue().getDuration())).append("\n");
			}
			b.close();
			System.out.println("creado correcatmente");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	@Override
	public List<Song> orderByName() throws IOException {
		List<Song> listOrder = new ArrayList<>();
		Map<String, Song> listSongs = repository.readAll();
		for (Map.Entry<String, Song> song : listSongs.entrySet()) {
			listOrder.add(song.getValue());
		}

		listOrder.sort(new Comparator<Song>() {
			public int compare(Song puntuation1, Song puntuation2) {
				return puntuation1.getName().compareTo(puntuation2.getName());
			}
		});

		return listOrder;
	}

	@Override
	public List<Song> readAll() throws IOException {
		Map<String, Song> songsMap = repository.readAll();

		List<Song> listOrder = new ArrayList<>();
		for (Map.Entry<String, Song> song : songsMap.entrySet()) {
			listOrder.add(song.getValue());
		}

		return listOrder;
	}
	
	/*
	 * method to create a wish list
	 */
	@Override
	public List<Song> createWhitList() throws IOException {
		/*
		 * we instantiate a list where we will put the desired movies
		 */
		List<Song> songsWhitList = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		String nameSongs = null;
		System.out.println("Name the WhitList");
		String nameWhitList = sc.nextLine();
		/*
		 * leemos las películas del repositorio 
		 */
		Map<String, Song> listSongs = repository.readAll();
		/*
		 * we will introduce names if it contains it, it includes it until exit is written
		 */
		
		do {
			System.out.println("Enter the movie you want to find");
			nameSongs = sc.nextLine();
			
			for (Map.Entry<String, Song> song : listSongs.entrySet()) {
				if (song.getKey().contains(nameSongs)) {
					songsWhitList.add(song.getValue());
				}
			}
		} while (!nameSongs.equalsIgnoreCase("exit"));

		/*
		 * once the films are selected then 
		 * we will write in another 
		 * file asking the user to enter the name of their 
		 * wish list which will be the same as the name
		 */
		File archivo = new File(nameWhitList + ".txt");
		try (BufferedWriter b = new BufferedWriter(new FileWriter(archivo))) {
			for (Song song : songsWhitList) {
				b.append(song.getName().concat(Constant.SEPARATOR).concat(song.getAutor())
						.concat(Constant.SEPARATOR)
						.concat(song.getDuration())).append(Constant.LINE_BREAK);
			}

			/*
			 * close file
			 */
			b.close();
			System.out.println("creado correcatmente");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return songsWhitList;
	}
	

}
