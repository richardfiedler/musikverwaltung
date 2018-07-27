package interfaces;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class AddFilepathTest
{

	public static void main( String[ ] args ) throws FileNotFoundException
	{
		/**
		 * File Objekt ausgeben zum bearbeiten 
		 * Dateipfad in txt speichern
		 */
		File f = new File( "/home/richard/musikdatenbank/songtitel.txt" ); // Dateipfad
		OutputStream ostream = new FileOutputStream( f, true );
		//falls die Datei bereits existiert wrd der Text an das Ende der Datei geschrieben
			
		  Scanner input = new Scanner( System.in ); 
		  System.out.print( "Wieviele Dateipfade in Datei schreiben? >"); 
		  //exception abfangen --> nur zahleneingabe erlaubt
		  int wortanzahl = input.nextInt( ); 
		  PrintStream writer = new PrintStream( ostream);  
		  
		  for ( int i = 0; i < (wortanzahl ); i++ ) 
		  { 
			  System.out.print( "Eingabe des Dateipfades ohne Leerzeichen >" ); 
			  String eingabeInDatei = input.next( ); 
			  //Text wird in ostream und in Datei geschrieben 
			  writer.print( eingabeInDatei + '\n' );
			  //ostream wird geleert
			  writer.flush( ); 
			  
		  }
		 
		 

	}

}
