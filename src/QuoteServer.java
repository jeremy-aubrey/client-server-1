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
//  Description:   A server that serves a quote of the day to clients
//                 upon a successful client connection. The server communicates 
//                 to the client by writing to the socket through the PrintWriter. 
//                 Client and server communicate via localhost:4302.
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
		// quote of the day to be served to clients
		String[] quotes = {
				"Buy Low and Sell High",
				"Eat Your Vegetables",
				"Good Fences Make Good Neighbors",
				"Never Underestimate Your Competition",
				"A Clean Camp is a Happy Camp",
				"Write tests before writing code",
				"Do no evil",
				"Never take Java online"
		};
		
		// create an object of the main class and use it to call
		// the non-static developerInfo and other non-static methods
		QuoteServer server = new QuoteServer();
		server.developerInfo();
		
		try {
			
				ServerSocket sock = new ServerSocket(4302);
				
				// listen for connections
				while (true) {
				Socket client = sock.accept();
				PrintWriter pout = new
				PrintWriter(client.getOutputStream(), true);
				
				// get a quote randomly using helper method
				String randQuote = server.getRandomQuote(quotes);
				
				// write the quote String to the socket
				pout.println(randQuote);
				
				// close the socket and resume
				// listening for connections
				client.close();
				
				}
				
			} catch (IOException ioe) {
				
				System.err.println(ioe);
				
			}
		
	}// end main method
	
    //***************************************************************
    //
    //  Method:       getRandomQuote (Non Static)
    // 
    //  Description:  Returns a random String (quote of the day) from 
	//                the array passed in.
    //
    //  Parameters:   String[]
    //
    //  Returns:      String 
    //
    //***************************************************************
	public String getRandomQuote(String[] arr) {
		
		// default return value in case empty array passed
		String result = "";
		
		if(arr.length >= 1) {
			
			// get a random int (index) between 0 and length of array
			int randomIndex = (((int)(Math.random() * 100)) % arr.length);
			
			// use index to get element randomly
			result = "Quote of the day:\n" + " ~ " + arr[randomIndex] + " ~ ";
		} 
		
		return result;
		
	}// end getRandomQuote method
	
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

    } // end developerInfo method
    
}// end QuoteServer class