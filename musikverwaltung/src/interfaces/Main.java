//package interfaces;
///**
// * struktur und methoden adminmode klasse
// * warum leerzeile beim einfügen nach neustart
// * bei welchen songs gibt es probleme und warum
// * reguläre ausdrücke
// * textdatei erstellen über programm
// */
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.io.PrintStream;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//import org.farng.mp3.TagException;
//
//public class Main
//{
//
//	public static void main( String[ ] args ) throws IOException, TagException
//	{
//		/**
//		 * 1.) Adminmode
//		 */
//		// 1.1. Ausgabe aller Songs
//		ArrayList<String> filepathes = new ArrayList<String>();
//		filepathes = AdminMode.generateFilepathList( );
//		AdminMode am = new AdminMode();
//		ArrayList<Song> songs = new ArrayList<Song>();
//		songs = am.generateSongsFromFilepathList( filepathes ); 
//		am.printSongs( songs );
//		
//		// 1.2. Song hinzufügen
//		Scanner input = new Scanner( System.in );
//		System.out.println( "Wieviele Songs hinzufügen?" );
//		//exception abfangen
//		int number = input.nextInt( );
//		
//		for ( int j = 0; j < number; j++ )
//		{
//		System.out.println( "Fügen sie einen Dateipfad hinzu, aus welchem ein Song erstellt wird (ohne Leerzeichen) >" );
//		//checkfilepath
//		String filepath = input.next( );
//		AdminMode.addSong(filepath, "/home/richard/musikdatenbank/songtitel.txt", true);
//		}
//		// neu laden der Dateipfade, neu laden der Songs und ausgeben
//		filepathes = AdminMode.generateFilepathList( );
//		songs = am.generateSongsFromFilepathList( filepathes ); 
//		am.printSongs( songs );
//		
//		// 1.3. Song löschen
//		System.out.println( "Wieviele Songs löschen?" );
//		//exception abfangen
//		int number2 = input.nextInt( );
//		for ( int j = 0; j < number2; j++ )
//		{
//		System.out.println( "Fügen sie einen Dateipfad hinzu, um einen Song zu löschen" );
//		// Admin kennt Dateipfad nicht mehr: über Titel an Dateipfad
//		//checkfilepath
//		String filepathToDelete = input.next( );
//		AdminMode.deleteSong( filepathToDelete, filepathes );
//		
//		// neu generieren und ausgeben
//		filepathes = AdminMode.generateFilepathList( );
//		songs = am.generateSongsFromFilepathList( filepathes ); 
//		am.printSongs( songs );
//		}
//		
//		// 1.4. Songs sortieren
//		
//		
//		// 1.5. Auswählen eines Songs
//		
//		/*Song song = new Song (filepath);
//		
//		String genre = new String( );
//		String title = new String( );
//		String interpret = new String( );
//		String dateipfad = new String();
//
//		genre = song.getGenre( );
//		title = song.getTitle( );
//		interpret = song.getInterpret( );
//		dateipfad = song.getFilepath( );
//
//		System.out.println( "Genre: " + genre );
//		System.out.println( "Titel: " + title );
//		System.out.println( "Interpret: " + interpret );
//		System.out.println( "Dateipfad: " + dateipfad );*/
//		
//		
//		
//	
//		//Song song2 = new Song( "/home/richard/musikdatenbank/song.mp3" );
//		
//		//
//		// Moduswahl
//
//		// 2
//		// switch case 1 oder 2 --> Benutzermodus oder Verwaltungsmodus
//		// 1: AdminMode adminmode = new AdminMode ();
//		// adminmode.setSongs(); // wie?: Titel, Genre, Interpret in Datei speichern, auslesen und an Liste übergeben?
//		// printTitle(adminmode);
//		// 2: UserMode usermode = new UserMode ();
//		// usermode.setplaylists();
//		// printTitle(usermode);
//
//		// 3
//		// Aktionswahl im Modus mit switch case
//
//		// Adminmode Aktionen
//		// 1.) Song suchen
//		// Song searchedSong = new Song();
//		// Collection songlist = adminmode.getSongs();
//		// searchedSong = adminmode.searchSong(songlist);
//		// SOngs sortieren, einfügen (String in Datei schreiben), löschen,...
//
//		// Usermode AKtionen
//		// Playlist bearbeiten; abspielen
//
//		// Playlist abspielen
//
//		// Playlist playlist = new Playlist("Name der Playlist");
//		// playlist.playTitles();
//
//		// playTitles
//		// Collection playlist = laden
//		// for ()
//		// song.playTitle()
//
//		
//		/**
//		 * Setzen eines Schreibers mit Zeichencodierung
//		 */
//		
//		//File f = new File( "/home/richard/musikdatenbank/songtitel.txt" );
//		// Liste oder Collection
//		//List<String> filepathList = new ArrayList<String>( );
//		/*
//		 * Auslesen
//		 */
//
//		/*InputStream istream = new FileInputStream( f );
//		Scanner reader = new Scanner( istream );
//		while ( reader.hasNextLine( ) == true )
//		{
//			filepathList.add( reader.nextLine( ) );
//		}
//		
//		for(int j = 0; j<filepathList.size( );j++)
//		{
//			System.out.println( filepathList.get( j ));
//		}*/
//		
//		// Zeichen aus Datei löschen
//		/*String filepathToDelete = new String( );
//
//		OutputStream ostream = new FileOutputStream( f );
//
//		Scanner input = new Scanner( System.in );
//
//		System.out.print( "Welchen Buchstaben möchten sie löschen > " );
//		filepathToDelete = input.next( );
//
//		for ( int i = 0; i < filepathList.size( ); i++ )
//		{
//			if ( filepathList.get( i ) == filepathToDelete )
//			{
//				filepathList.remove( i );
//			}
//		}
//
//		PrintStream writer = new PrintStream( ostream );*/
//		
//		/**
//		 * neu reinschreiben
//		 */
//		//writer.printf(  + '\n' );
//		/*
//		 * Nochmal Auslesen
//		 */
//
//		//InputStream istream = new FileInputStream( f );
//		//Scanner reader = new Scanner( istream );
//		/*while ( reader.hasNextLine( ) == true )
//		{
//			filepathList.add( reader.nextLine( ) );
//		}*/
//		
//		/*for(int k = 0; k<filepathes.size( );k++)
//		{
//			System.out.println( filepathes.get( k )+"ende");
//		}*/
//	}
//
//}
