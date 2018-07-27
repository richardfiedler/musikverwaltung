package interfaces;

import java.util.Collection;

public class Playlist 
{
	private String title;
	private Collection<Song> playlist;
	
	public Collection<Song> getPlaylist( )
	{
		return playlist;
	}
	public void setPlaylist( Collection<Song> playlist )
	{
		this.playlist = playlist;
	}
	
	
}
