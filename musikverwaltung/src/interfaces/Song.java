package interfaces;

import java.io.IOException;

import org.farng.mp3.TagException;

public class Song 
{
	private String title;
	private String genre;
	private String interpret;
	private String filepath;
	
	
	public String getGenre( )
	{
		return genre;
	}
	public void setGenre( String genre )
	{
		this.genre = genre;
	}
	public String getInterpret( )
	{
		return interpret;
	}
	public void setInterpret( String interpret )
	{
		this.interpret = interpret;
	}
	public String getTitle( )
	{
		return title;
	}
	public void setTitle( String title )
	{
		this.title = title;
	}
	public String getFilepath( )
	{
		return filepath;
	}
	public void setFilepath( String filepath )
	{
		
		this.filepath = filepath;
		
	}
	
	public Song( String filepath ) throws IOException, TagException
	{
		// vorher Test, ob Datei existiert im Main checkFilepath
		// metadataTest -> Helperklasse MetaDataHelper
		MetaDataHelper mdh = new MetaDataHelper ( filepath );
		this.genre = mdh.getGenre();
		this.title = mdh.getTitle();
		this.interpret = mdh.getInterpret();
		this.filepath = filepath;
		
	}
	

	
	
	
	
	

	
}
