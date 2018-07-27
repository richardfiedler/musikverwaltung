package interfaces;

import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

import org.farng.mp3.MP3File;
import org.farng.mp3.TagException;

public class MetaDataHelper
{
	private String filepath;
	private String genre;
	private String title;
	private String interpret;
	

	public MetaDataHelper( String filepath ) throws IOException, TagException 
	{
		File sourceFile = new File( filepath ); ;
	    MP3File mp3file = new MP3File(sourceFile);
	    String title = mp3file.getID3v2Tag( ).getSongTitle( );// exception bei manchen musikquellenabfangen
	    setTitle( title );
	    String interpret = mp3file.getID3v2Tag( ).getAuthorComposer( );
	    setInterpret( interpret );
	    String genre = mp3file.getID3v2Tag( ).getSongGenre( );
	    setGenre( genre );
		this.filepath = filepath; 
	}


	public String getGenre( )
	{
		genre = checkMetadata(genre);
		return genre;
	}


	public void setGenre( String genre )
	{
		this.genre = genre;
	}


	public String getTitle( )
	{
		
        title = checkMetadata(title);
		return title;
	}


	public void setTitle( String title )
	{
		
		this.title = title;
	}


	public String getInterpret()
	{
		interpret = checkMetadata(interpret);
		return interpret;
	}


	public void setInterpret( String interpret )
	{
		this.interpret = interpret;
	}
	
	public static String checkMetadata(String string)
	{
		//zu bearbeiten: Sonderzeichen,...
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
