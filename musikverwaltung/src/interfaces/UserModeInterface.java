package interfaces;

import java.util.Collection;

public interface UserModeInterface
{
	public Playlist editPlaylist( Playlist playlist1 );

	public Collection<Playlist> addPlaylist( Playlist playlist );

	public Collection<Playlist> deletePlaylist( Playlist playlist );

	public void playPlaylist( Playlist playlist );

	public void printPlaylist( Playlist playlist );
	
	public Collection<Song> addSong( Song song );

	public Collection<Song> deleteSong( Song song );

	public void playSong( Song song ); 

	public void printSong( Song song );

	public void breakSong( Song song1 );

	public void skipSong( Song song1 );
}
