package interfaces;

import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

import org.farng.mp3.MP3File;
import org.farng.mp3.TagException;

public class metadataTest
{

	public static void main( String[ ] args ) throws IOException, TagException 
	{
		File sourceFile = new File( "/home/richard/musikdatenbank/song.mp3" ); ;
	    MP3File mp3file = new MP3File(sourceFile);
	      
        
       //System.out.println( "Songtitel: " + mp3file.getID3v2Tag( ).getSongTitle( ) );
        //System.out.println( "Genre: " + mp3file.getID3v2Tag( ).getSongGenre( ) );
        //System.out.println( "Interpret: " + mp3file.getID3v2Tag( ).getAuthorComposer( ) + '\n' );
	    String stringTitle = mp3file.getID3v2Tag( ).getSongTitle( );
        stringTitle = checkMetadata(stringTitle);
        
        String stringGenre = mp3file.getID3v2Tag( ).getSongGenre( );
        stringGenre = checkMetadata(stringGenre);
        
        String stringInterpret = mp3file.getID3v2Tag( ).getAuthorComposer( );
        stringInterpret = checkMetadata(stringInterpret);
        //System.out.println( "Songtitel: " + mp3file2.getID3v2Tag( ).getSongTitle( ) );
        System.out.println( "Songtitel: " + stringTitle);
        System.out.println( "Genre: " + stringGenre );
        System.out.println( "Interpret: " + stringInterpret  + '\n' );
        
        // wenn keine Metadaten gegeben oder Sonderzeichenausgabe (überprüfe Metadaten, ob Sonderzeichen)
        // dann: auf unbekannt setzen
        
        File sourceFile2 = new File( "/home/richard/musikdatenbank/holz.mp3" ); ;
	    MP3File mp3file2 = new MP3File(sourceFile2);
	      
        String stringTitle2 = mp3file2.getID3v2Tag( ).getSongTitle( );
        stringTitle2 = checkMetadata(stringTitle2);
        
        String stringGenre2 = mp3file2.getID3v2Tag( ).getSongGenre( );
        stringGenre2 = checkMetadata(stringGenre2);
        
        String stringInterpret2 = mp3file2.getID3v2Tag( ).getAuthorComposer( );
        stringInterpret2 = checkMetadata(stringInterpret2);
        //System.out.println( "Songtitel: " + mp3file2.getID3v2Tag( ).getSongTitle( ) );
        System.out.println( "Songtitel: " + stringTitle2);
        System.out.println( "Genre: " + stringGenre2 );
        System.out.println( "Interpret: " + stringInterpret2  );
        
	}

	public static String checkMetadata(String string)
	{
		boolean truthValue;
		
		if (Pattern.matches("[A-Za-z0-9' ']*",string)==false || string=="") 
			//Modellierung RegEx grüßt: 
			//falls kein lateinischer Buchstabe oder keine Zahl oder kein Leerzeichen im String 
			//setze String auf unbekannt
		{
			string = "unbekannt";
		}
		
		return  string;
	}
	
}
