package com.splitio.localhost;

import io.split.client.SplitFactoryBuilder;
import io.split.client.SplitClient;
import io.split.client.SplitClientConfig;

import java.io.File;
import java.util.Scanner;

/**
 * Split localhost mode demo for Java.
 *
 */


public class App 
{
	static File file = new File(".\\src\\main\\java\\com\\splitio\\localhost\\sample.txt");
	
	static SplitClientConfig config;
	static SplitClient client;
	static String treatment;
	
    public static void main( String[] args )
    {
    	try {
    		
    		// Set up the scanner and timer
    		Scanner scan = new Scanner(file);
    		
    		System.out.println("Welcome to the Java split in localhost mode tutorial");
    		
    		 // Set up SDK
        	config = SplitClientConfig.builder().splitFile(".\\src\\main\\java\\com\\splitio\\localhost\\split.yml").build();
        	client = SplitFactoryBuilder.build("localhost", config).client();
        	
        	System.out.println("Checking treatment...");
        	
        	treatment = client.getTreatment("key", "feature_on");
        	
        	System.out.println("Treatment is set to: " + treatment);
        	System.out.println("\nPrinting...\n");
        	
        	switch(treatment) {
        	
	        	case "on":
	        		while(scan.hasNext()) {
	        			System.out.println(scan.nextLine());
	        		}	        		
	        		break;
	        	case "off":
	        	default:
	        		break;
        	}
        	
    	}catch (Exception ex) {
    		System.out.println("Error: " + ex.getClass());
    		System.out.println(ex.getMessage());
    		System.out.println("Stack trace: " + ex.getStackTrace());
    	}
    }
}
