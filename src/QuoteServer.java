//********************************************************************
//
//  Author:        Jeremy Aubrey
//
//  Program #:     2
//
//  File Name:     QuoteServer.java
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

public class QuoteServer
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
		// Quote of the day to be served to clients
		String[] quotes = {
				"Buy Low and Sell High",
				"Eat Your Vegetables",
				"Good Fences Make Good Neighbors",
				"Never Underestimate Your Competition",
				"A Clean Camp is a Happy Camp",
				"Write tests before writing code",
				"Do no evil"
		};
		
		// Create an object of the main class and use it to call
		// the non-static developerInfo and other non-static methods
		QuoteServer server = new QuoteServer();
		server.developerInfo();
		
		try {
			
			ServerSocket sock = new ServerSocket(4302);
			
				/* now listen for connections */
				while (true) {
				Socket client = sock.accept();
				PrintWriter pout = new
				PrintWriter(client.getOutputStream(), true);
				
				/* Get a quote randomly using helper method */
				String randQuote = quotes[server.getRandomIndex(quotes.length)];
				
				/* write the quote String to the socket */
				pout.println(randQuote);
				
				/* close the socket and resume */
				/* listening for connections */
				client.close();
				}
				
			} catch (IOException ioe) {
				
				System.err.println(ioe);
				
			}
		
	} // End of the main method
	
	public int getRandomIndex(int max) {
		
		//return a random integer between 0 and max
		return (((int)(Math.random() * 100)) % max);
		
	}
	
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