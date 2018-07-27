package test;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import backendapi.AdminModeApi;
import interfaces.AdminMode;
import interfaces.Song;

public class AdminModeTest
{
	/**
	 * Testet das generieren von Songs aus der Textdatei
	 * 
	 * @throws FileNotFoundException
	 */
	@Test
	public void generateSongList( ) throws FileNotFoundException
	{
		String filepathForPersistence = new String();
		filepathForPersistence = "/home/richard/musikdatenbank/penelope.txt";
		initFileList( );
		ArrayList<Song> songs = new ArrayList<Song>( );
		songs=AdminModeApi.generateSongList(filepathForPersistence );
		
		assertEquals( 3, songs.size( ) );
	
	}
	
	private void initFileList () throws FileNotFoundException 
	{
		//Datei neu anlegen
//		File songFile = new File ("/home/richard/musikdatenbank/penelope.txt");
//		songFile.createNewFile( );
		String filepathForPersistence = new String();
		filepathForPersistence = "/home/richard/musikdatenbank/penelope.txt";
		ArrayList<String> filepathes = new ArrayList<String>( );
		//filepathes.add( "/home/richard/musikdatenbank/song4.mp3" );
		filepathes.add( "/home/richard/musikdatenbank/song2.mp3" );
		filepathes.add( "/home/richard/musikdatenbank/song.mp3" );
		
		AdminMode.addSong( "/home/richard/musikdatenbank/song4.mp3", "/home/richard/musikdatenbank/penelope.txt", false );
		
		for (String songPath : filepathes)
		{
			AdminMode.addSong( songPath, "/home/richard/musikdatenbank/penelope.txt", true );
		}
		//Songs reinschreiben z.B. 5
		ArrayList<Song>  songs=AdminModeApi.generateSongList(filepathForPersistence );
		assertEquals( 3, songs.size( ) );
	}
//
//	/**
//	 * Testet die Ausgabe der in der Textdatei gespeicherten Songs
//	 * 
//	 * @throws FileNotFoundException
//	 */
//	@Test
//	public void showAllExistingSongs( ) throws FileNotFoundException
//	{
//		AdminModeApi adminModeApi = new AdminModeApi( );
//		adminModeApi.showAllExistingSongs( );
//	}

	/**
	 * Testet das Hinzufügen von Songs
	 * 
	 * @throws FileNotFoundException
	 */
	@Test
	public void addSongs( ) throws FileNotFoundException
	{
		initFileList( );
		
		String filepathForPersistence = new String();
		filepathForPersistence = "/home/richard/musikdatenbank/penelope.txt";
		ArrayList<String> filepathes = new ArrayList<String>( );
		filepathes.add( "/home/richard/musikdatenbank/song.mp3" );
		filepathes.add( "/home/richard/musikdatenbank/song2.mp3" );
		filepathes.add( "/home/richard/musikdatenbank/song.mp3" );

		
		
		AdminModeApi adminModeApi = new AdminModeApi( );
		adminModeApi.addSongs( filepathes,filepathForPersistence,true );
		
		ArrayList<Song> songs = new ArrayList<Song>( );
		songs=AdminModeApi.generateSongList(filepathForPersistence );
		assertEquals( 6, songs.size( ) );
		
		//showAllExistingSongs( );

	}

//	public void printSongList() throws FileNotFoundException
//	{
//		String filepathForPersistence = new String();
//		filepathForPersistence = "/home/richard/musikdatenbank/penelope.txt";
//		initFileList( );
//		ArrayList<Song> songs = new ArrayList<Song>( );
//		songs=AdminModeApi.generateSongList(filepathForPersistence );
//		AdminMode.printSongs(songs);
//	}
	
	@Test
	public void deleteSongsLowerThanFileEntries( ) throws FileNotFoundException
	{
		initFileList( );
		
		String filepathForPersistence = new String();
		filepathForPersistence = "/home/richard/musikdatenbank/penelope.txt";
		//lösche 2 files
		ArrayList<String> filepathesToDelete = new ArrayList<String>( );

		filepathesToDelete.add( "/home/richard/musikdatenbank/song.mp3" );
		//filepathesToDelete.add( "/home/richard/musikdatenbank/song2.mp3" );
		
		AdminModeApi adminModeApi = new AdminModeApi( );
		adminModeApi.deleteSongs( filepathForPersistence, filepathesToDelete  );

		List <String> actualEntries = AdminMode.generateFilepathList(filepathForPersistence );
		
		assertEquals( 1, actualEntries.size( ) );
	}
	
	@Test
	public void deleteSongsHigherThanFileEntries( ) throws FileNotFoundException
	{
		initFileList( );
		
		String filepathForPersistence = new String();
		filepathForPersistence = "/home/richard/musikdatenbank/penelope.txt";
		//lösche 2 files
		ArrayList<String> filepathesToDelete = new ArrayList<String>( );

		filepathesToDelete.add( "/home/richard/musikdatenbank/song.mp3" );
		filepathesToDelete.add( "/home/richard/musikdatenbank/song2.mp3" );
		filepathesToDelete.add( "/home/richard/musikdatenbank/song.mp3" );
		filepathesToDelete.add( "/home/richard/musikdatenbank/song4.mp3" );
		//filepathesToDelete.add( "/home/richard/musikdatenbank/song2.mp3" );
		
		AdminModeApi adminModeApi = new AdminModeApi( );
		adminModeApi.deleteSongs( filepathForPersistence, filepathesToDelete  );

		List <String> actualEntries = AdminMode.generateFilepathList(filepathForPersistence );
		
		assertEquals( 0, actualEntries.size( ) );
	}
	
//	private List<String> readFilePathForPersistenceEntries (String filepathForPersistence)
//	{
//		List <String> entries = new ArrayList<String>( );
//		
//		return entries;
//	}
	
//	@Test
//	public void deleteSongsEqualsThanFileEntrys( ) throws FileNotFoundException
//	{
//		initFileList( );
//		//lösche 2 files
//		ArrayList<String> filepathes = new ArrayList<String>( );
//
//		// List<String> filepathes = Arrays.asList("/home/richard/musikdatenbank/song4.mp3",
//		// "/home/richard/musikdatenbank/song2.mp3", "/home/richard/musikdatenbank/song.mp3");
//		filepathes.add( "/home/richard/musikdatenbank/song.mp3" );
//		filepathes.add( "/home/richard/musikdatenbank/song2.mp3" );
//		// checkfilepath
//		for ( int j = 0; j < filepathes.size( ); j++ )
//		{
//			String filepathToDelete = new String(); 
//			filepathToDelete = filepathes.get( j );
//			AdminMode.deleteSong( filepathToDelete, filepathes );
//		}
//		// Ausgabe der neuen Songs
//		// showAllExistingSongs( );
//	}
//	
//	@Test//( expected = IllegalArgumentException.class )
//	public void deleteSongsMoreThanFileEntrys( ) throws FileNotFoundException
//	{
//		//init
//		//lösche 2 files
//		ArrayList<String> filepathes = new ArrayList<String>( );
//
//		// List<String> filepathes = Arrays.asList("/home/richard/musikdatenbank/song4.mp3",
//		// "/home/richard/musikdatenbank/song2.mp3", "/home/richard/musikdatenbank/song.mp3");
//		filepathes.add( "/home/richard/musikdatenbank/song.mp3" );
//		filepathes.add( "/home/richard/musikdatenbank/song2.mp3" );
//		// checkfilepath
//		for ( int j = 0; j < filepathes.size( ); j++ )
//		{
//			String filepathToDelete = new String(); 
//			filepathToDelete = filepathes.get( j );
//			AdminMode.deleteSong( filepathToDelete, filepathes );
//		}
//		// Ausgabe der neuen Songs
//		// showAllExistingSongs( );
//	}
//	
//	//bearbeiten
//	public void sortSongs( ) throws FileNotFoundException
//	{
//		ArrayList<Song> songs = new ArrayList<Song>( );
//		songs = generateSongList( );
//		
//		ArrayList<String> songtitles = new ArrayList<String>( );
//		songs = generateSongList( );
//		
//		for ( int j = 0; j < songs.size( ); j++ )
//		{
//			
//		}
//	}
//	

	
}
