package interfaces;

import java.util.Collection;

public interface AdminmodeInterface
{
	// in Liste aller Songs aus Adminmode suchen
	public Song searchSong( Collection<Song> songs );

	// irgendeinen Sortieralg vom Karsten
	public Collection<Song> sortSongs( Collection<Song> songs );
	
	// vorher: checkFilepath
	//addSong und vorher addFilepath
	public Collection<Song> addSong( Song song );
	
	//generateFilepathList
	
	//public Collection<Song> generateSongsFromFilepathList()
	//deleteSong
	public Collection<Song> deleteSong( Song song );
	
	//printAllSongs
}
