package interfaces;

import java.util.Collection;

public class UserMode 
{
	// Attribut: Liste aller Playlists
		private Collection<Playlist> playlists;

		public Collection<Playlist> getPlaylists( )
		{
			return playlists;
		}

		public void setPlaylists( Collection<Playlist> playlists )
		{
			this.playlists = playlists;
		}

		

		
}	
