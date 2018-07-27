package interfaces;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FilepathListTest
{

	public static void main( String[ ] args ) throws FileNotFoundException
	{
		File f = new File( "/home/richard/musikdatenbank/songtitel.txt" );
		// Liste oder Collection
		List<String> filepathList = new ArrayList<String>( );
		InputStream istream = new FileInputStream( f );
		Scanner reader = new Scanner( istream );
		while ( reader.hasNextLine( ) == true )
		{
			filepathList.add( reader.nextLine( ) );
		}
		// index 0 ist immer Leerzeile
		

		for ( int j = 0; j < filepathList.size( ); j++ )
		{
			System.out.println( filepathList.get( j ) );
		}


	}

}
