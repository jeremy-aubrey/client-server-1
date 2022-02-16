//********************************************************************
//
//  Author:        Jeremy Aubrey
//
//  Program #:     2
//
//  File Name:     QuoteClient.java
//
//  Course:        COSC-4302 Operating Systems
//
//  Due Date:      02/18/2022
//
//  Instructor:    Fred Kumi 
//
//  Chapter:       Chapter 3
//
//  Description:   
//
//********************************************************************

import java.net.*;
import java.io.*;

public class QuoteClient
{
    //***************************************************************
    //
    //  Method:       main
    // 
    //  Description:  The main method of the project
    //
    //  Parameters:   String array
    //
    //  Returns:      N/A 
    //
    //**************************************************************
	public static void main(String[] args)
	{
		// Create an object of the main class and use it to call
		// the non-static developerInfo and other non-static methods
		QuoteClient client = new QuoteClient();
		client.developerInfo();
		
		try {
			/* make connection to server socket */
			Socket sock = new Socket("127.0.0.1", 4302);
			InputStream in = sock.getInputStream();
			BufferedReader bin = new
			BufferedReader(new InputStreamReader(in));
			/* read the date from the socket */
			String line;
			while ( (line = bin.readLine()) != null)
			System.out.println(line);
			/* close the socket connection*/
			sock.close();
			}
			catch (IOException ioe) {
			System.err.println(ioe);
			}

	} // End of the main method
	
	//***************************************************************
    //
    //  Method:       developerInfo (Non Static)
    // 
    //  Description:  The developer information method of the program.
    //
    //  Parameters:   None
    //
    //  Returns:      N/A 
    //
    //**************************************************************
    public void developerInfo()
    {
       System.out.println("Name:    Jeremy Aubrey");
       System.out.println("Course:  COSC 4302 Operating Systems");
       System.out.println("Program: 2");

    } // End of the developerInfo method
}