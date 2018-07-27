package interfaces;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeleteFilepathTest
{
	public static void main( String[ ] args ) throws FileNotFoundException
	{
		//TEST FilepathList wird erstellt
		File f = new File( "/home/richard/musikdatenbank/songtitel.txt" );
		List<String> filepathList = new ArrayList<String>( );
		InputStream istream = new FileInputStream( f );
		Scanner reader = new Scanner( istream );
		while ( reader.hasNextLine( ) == true )
		{
			filepathList.add( reader.nextLine( ) );
		}
		
		
		
		//Zeichen wird aus FilepahtList gelöscht
		String filepathToDelete = new String( );
		System.out.print( "Welchen Dateipfad möchten sie löschen? > " );
		Scanner input = new Scanner( System.in );
		filepathToDelete = input.next( );
		
		//lösche Zeichen Filepath aus FilepathList
		for ( int i = 0; i < filepathList.size( ); i++ )
		{
			
			String filepath = filepathList.get( i );
			
			System.out.println( "Element Filepatlist: "+filepath );
			System.out.println( "         zu löschen: "+filepathToDelete );
			
			if ( filepath.equals( filepathToDelete ) )
			{
				System.out.println( "wird entfernt!");
				filepathList.remove( i );
			}
		}
		
		//lösche gesamten Inhalt von songtitel.txt und füge alle Dateipfade aus FilepathList ein
		OutputStream ostream = new FileOutputStream( f); 
		//ohne true: neuer Inhalt überschreibt alten Inhalt
	
		PrintStream writer = new PrintStream( ostream); 
		  
		  for ( int i = 0; i < (filepathList.size( ) ); i++ ) 
		  { 
			  String eingabeInDatei = filepathList.get( i ); 
			  //Text wird in ostream und in Datei geschrieben 
			  writer.print( eingabeInDatei + '\n' );
			  //ostream wird geleert
			  writer.flush( ); 
			  
		  }

		  //TEST Ausgabe der neuen Liste
		  for ( int j = 0; j < filepathList.size( ); j++ )
			{
				System.out.println( filepathList.get( j ) );
			}
		  
	}
}
