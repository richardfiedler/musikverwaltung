package interfaces;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.farng.mp3.TagException;

public class AdminMode
{
	// Attribut: Liste aller Songs
	private List<Song> songs;

	public List<Song> getSongs( )
	{
		return songs;
	}

	public void setSongs( List<Song> songs )
	{
		this.songs = songs;
	}

	
	
	/**
	 * Dateipfade werden in Textdatei eingefügt
	 * @param filePathOfSong - Dateipfad zur mp3 Datei
	 * @param filePathForPersistence - Dateipfad zur Text Datei
	 * @param notOverWrite - true: vorhandener Text in Textdatei wird nicht überschrieben
	 * @throws FileNotFoundException
	 */
	public static void addSong( String filePathOfSong, String  filePathForPersistence, boolean notOverWrite) throws FileNotFoundException
	// static: ohne bestehendes Objekt anwenden
	{

		//File f = new File( "/home/richard/musikdatenbank/songtitel.txt" ); // Dateipfad
		OutputStream ostream = new FileOutputStream( filePathForPersistence, notOverWrite );
		// true: falls die Datei bereits existiert wrd der Text an das Ende der Datei geschrieben

		Scanner input = new Scanner( System.in );
		PrintStream writer = new PrintStream( ostream );
		String eingabeInDatei = filePathOfSong, String ;
		// Text wird in ostream und in Datei geschriebenS
		writer.flush( );
		writer.print( eingabeInDatei + '\n' );
		// ostream wird geleert
		writer.flush( );

		// }
	}

	/*
	 * public static void addSong( Song song ) { String filepath = new String( ); filepath = song.getFilepath( ); try {
	 * // Dateipfad zu txt Datei addFilepathToFile( filepath ); } // bearbeiten catch ( FileNotFoundException fnfex ) {
	 * System.out.print( "Falscher Dateipfad" ); } }
	 */

	
	/**
	 * in txt Datei gespeicherte Dateipfade werden an ArrayList übergeben
	 * @param filepathForPersistence - Dateipfad zur txt Datei
	 * @return ArrayList<String> filepathList
	 * @throws FileNotFoundException
	 */
	public static ArrayList<String> generateFilepathList(String filepathForPersistence ) throws FileNotFoundException
	{
		// Dateipfad, der zu text Datei führt
		File f = new File( filepathForPersistence);//"/home/richard/musikdatenbank/songtitel.txt" );
		ArrayList<String> filepathList = new ArrayList<String>( );
		InputStream istream = new FileInputStream( f );
		Scanner reader = new Scanner( istream );
		while ( reader.hasNextLine( ) == true )
		{
			filepathList.add( reader.nextLine( ) );
		}
		// index 0 ist immer Leerzeile

		return filepathList;
	}

	
	/**
	 * Dateipfad wird Konstruktor von Song übergeben, Song wird an ArrayList songs übergeben
	 * @param filepathes - Dateipfade, aus denen Song erstellt wird
	 * @param filepathForPersistence
	 * @return  ArrayList<Song> songs
	 */
	public ArrayList<Song> generateSongsFromFilepathList( List <String> filepathes,String filepathForPersistence )
	{
		ArrayList<String> filepathList = new ArrayList<String>( );

		try
		{
			filepathList = generateFilepathList( filepathForPersistence);
		}
		// bearbeiten
		catch ( FileNotFoundException fnfex )
		{
			System.out.print( "Falscher Dateipfad" );
		}

		ArrayList<Song> songs = new ArrayList<Song>( );

		for ( int j = 0; j < filepathList.size( ); j++ ) // j=1: 0. Listenelement ist immer Leerzeile
		{
			
			String filepath = new String( );
			filepath = filepathList.get( j );
		
			//wenn Dateipfad aus leerzeile besteht, dann darf daraus kein Song erstellt werden
			if(filepath.isEmpty( )==false)
			{
			
			/*
			 * try { Song song = new Song (filepath); } catch ( IOException e ) //bearbeiten { // TODO Auto-generated
			 * catch block e.printStackTrace(); } catch ( TagException e ) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */ // warum nicht in songs.add(song)???

			try
			{
				//TEST
				//System.out.println("Ich bin hier drin"+filepath);
				songs.add( new Song( filepath ) );
			}
			catch ( IOException e )
			{
				// TODO Auto-generated catch block
				e.printStackTrace( );
			}
			catch ( TagException e )
			{
				// TODO Auto-generated catch block
				e.printStackTrace( );
			}
			}

		}

		return songs;

	}

	/**
	 * aus Liste aller Songs alle Songtitel erhalten
	 * @param songs Liste aller Objekte Song
	 * @return List<String> songtitle
	 */
	public static List<String> getSongTitles( ArrayList<Song> songs )
	{
		List <String> titleList = new ArrayList<String>( songs.size( ));
		
		for ( int j = 0; j < songs.size( ); j++ )
		{
			String title = new String( );
			title = ( songs.get( j ) ).getTitle( );
			//System.out.print( title + '\n' );
			
			titleList.add( title );

		}
		
		return titleList;
	}

	/**
	 * lösche Dateipfadd aus txt Datei, im Anschluss müssen Songs neu generiert werden
	 * @param filepathToDelete - zu löschender Dateipfad 
	 * @param filepathForPersistence - Dateipfad zur txt Datei
	 * @throws FileNotFoundException
	 */
	public static void deleteSong( String filepathToDelete, String filepathForPersistence ) throws FileNotFoundException
	{
		List <String> oldFilePathList = generateFilepathList(filepathForPersistence);
		
		//lösche filepath aus filepathes
		while (oldFilePathList.contains( filepathToDelete ))
		{
			oldFilePathList.remove( filepathToDelete );
		}
		
		
		File f = new File( filepathForPersistence );
		

		// lösche filepath aus filepathes
//		for ( int i = 0; i < oldFilePathList.size( ); i++ )
//		{
//
//			String filepath2 = oldFilePathList.get( i );
//
//			if ( filepath2.equals( filepathToDelete ) )
//			{
//				oldFilePathList.remove( i );
//			}
//		}

		// lösche gesamten Inhalt von songtitel.txt und füge alle Dateipfade aus FilepathList ein
		OutputStream ostream = new FileOutputStream( f );
		// ohne true: neuer Inhalt überschreibt alten Inhalt

		PrintStream writer = new PrintStream( ostream );

		for ( int i = 0; i < ( oldFilePathList.size( ) ); i++ )
		{
			String eingabeInDatei = oldFilePathList.get( i );
			writer.flush( );
			// Text wird in ostream und in Datei geschrieben
			writer.print( eingabeInDatei + '\n' );
			// ostream wird geleert
			writer.flush( );

		}
	}
	
	/**
	 * Sortieren
	 * @param songs
	 */
	public static void sortSongsTitle( ArrayList<Song> songs )
	{
		ArrayList<String> songTitles = new ArrayList<String>( );
		String title = new String( );
		
		for ( int j = 0; j < songs.size( ); j++ )
		{
			title = ( songs.get( j ) ).getTitle( );
			songTitles.add( title );

		}
		Collections.sort( songTitles );
	}
	
	public static void sortSongsGenre( ArrayList<Song> songs )
	{
		
	}
	
	public static void sortSongsInterpret( ArrayList<Song> songs )
	{
		
	}
	
	/**
	 * search Song
	 * @throws TagException 
	 * @throws IOException 
	 */
	public Song searchSong( ArrayList<Song> songs, String songTitle ) throws IOException, TagException
	{
		String title = new String( );
		String filepath = new String( );
		
		for ( int j = 0; j < songs.size( ); j++ )
		{
			title=songs.get( j ).getTitle( );
			
			if(title.equals( songTitle ))
			{
				filepath = songs.get(j).getFilepath( );
			}
		}
		Song searchedSong = new Song(filepath);
		return searchedSong;
	}
}
