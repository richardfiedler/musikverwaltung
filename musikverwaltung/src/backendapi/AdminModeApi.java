package backendapi;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import interfaces.AdminMode;
import interfaces.Song;

/**
 * Schnittstillenklasse zum Backend
 * @author richard
 *
 */
public class AdminModeApi
{	
	/**
	 * wenn keine Textadatei: neu erstellen
	 * @param filepathForPersistence - Dateipfad zur Textdatei
	 * @return ArrayList<Song> songs
	 * @throws FileNotFoundException
	 */
	public static final ArrayList<Song> generateSongList(String filepathForPersistence ) throws FileNotFoundException
	{
	
		ArrayList<String> filepathes = new ArrayList<String>( );
		filepathes = AdminMode.generateFilepathList(filepathForPersistence );
		AdminMode am = new AdminMode( );
		ArrayList<Song> songs = new ArrayList<Song>( );
		songs = am.generateSongsFromFilepathList( filepathes,filepathForPersistence );

		return songs;
	}
	

	/**
	 * @param filepathForPersistence
	 * @return List <String> songTitles 
	 * @throws FileNotFoundException
	 */
	public List<String> showAllExistingSongs(String filepathForPersistence ) throws FileNotFoundException
	{
		ArrayList<Song> songs = new ArrayList<Song>( );
		
		songs = generateSongList( filepathForPersistence);
		List <String> songTitles = AdminMode.getSongTitles( songs );
		
		return songTitles;
	}
	
	/**
	 * Fügt Songs der Liste hinzu
	 * @param songlist - Liste der Songs
	 * @throws FileNotFoundException Tritt auf, wenn die Datei nicht gefunden wird
	 */
	public void addSongs( List <String> filepathes, String filePathForPersistence, boolean notOverWrite) throws FileNotFoundException
	{

		for ( int j = 0; j < filepathes.size( ); j++ )
		{
			String filepath = new String(); 
			filepath = filepathes.get( j );
			AdminMode.addSong( filepath, filePathForPersistence, notOverWrite );
		}

	}
	
	/**
	 * löscht übergebene Songs in txt Datei
	 * @param filePathForPersistence - Dateipfad zur txt Datei
	 * @param filepathesToDelete - zu löschende Dateipfade
	 * @throws FileNotFoundException
	 */
	public void deleteSongs( String filePathForPersistence, List <String> filepathesToDelete ) throws FileNotFoundException
	{
		for ( int j = 0; j < filepathesToDelete.size( ); j++ )
		{
			String filepathToDelete = new String(); 
			filepathToDelete = filepathesToDelete.get( j );
			AdminMode.deleteSong( filepathToDelete, filePathForPersistence );
		}
	}
	
	//sortSongs
	
	//searchSong
	
	
	
	

}
