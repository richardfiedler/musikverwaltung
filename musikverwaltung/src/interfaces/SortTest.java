package interfaces;

import java.util.ArrayList;
import java.util.Collections;

public class SortTest
{

	public static void main( String[ ] args )
	{
		ArrayList<String> filepathesToDelete = new ArrayList<String>( );

		filepathesToDelete.add( "a" );
		filepathesToDelete.add( "b" );
		filepathesToDelete.add( "e" );
		filepathesToDelete.add( "d" );
		filepathesToDelete.add( "g" );
		filepathesToDelete.add( "c" );
		
		Collections.sort(filepathesToDelete  );
		for ( int i = 0; i < ( filepathesToDelete.size( ) ); i++ )
		{
		System.out.println(filepathesToDelete.get( i ));
		}
	}

}
