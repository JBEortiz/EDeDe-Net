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
	public List<Song> createWhitList() {
		return null;
	}

	@Override
	public List<Song> orderByPuntuation() throws IOException {
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

}
