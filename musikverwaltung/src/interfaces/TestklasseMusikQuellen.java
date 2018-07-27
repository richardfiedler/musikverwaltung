package interfaces;

import java.io.IOException;

import org.farng.mp3.TagException;

public class TestklasseMusikQuellen
{

	public static void main( String[ ] args ) throws IOException, TagException
	{
		Song song = new Song ("/home/richard/musikdatenbank/song4.mp3");
		
		String genre = new String( );
		String title = new String( );
		String interpret = new String( );
		String dateipfad = new String();

		genre = song.getGenre( );
		title = song.getTitle( );
		interpret = song.getInterpret( );
		dateipfad = song.getFilepath( );

		System.out.println( "Genre: " + genre );
		System.out.println( "Titel: " + title );
		System.out.println( "Interpret: " + interpret );
		System.out.println( "Dateipfad: " + dateipfad );

	}

}
