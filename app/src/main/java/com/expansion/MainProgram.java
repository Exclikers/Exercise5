package com.expansion;


import java.io.FileNotFoundException;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.Random;


public class MainProgram {

	
	static int row = 0;	
	static int col = 0;
	
	public static void main(String[] args) {
		
		
		progStart();


	}

	static void progStart() {
				
			int fileFound = readFile();

			if (fileFound == 1) {
				createFile();
			}
	
	}

	public static void getDimension() {

			Scanner getInput = new Scanner(System.in);
	  		boolean isNumber;	
			int inrow = 0;
			int incol = 0;
			
			do {
		    		System.out.print("Enter Number of Row: ");
			    	if (getInput.hasNextInt()) {
			    		row = getInput.nextInt();
			    		inrow = row;
			    		isNumber = true;
			    	} else {
			    		System.out.println("Please Input a valid number!");
			    		isNumber = false;
			    		getInput.next();
			    	}

			    	if ((inrow > 1000) || (inrow < 1)) {
				    	System.out.println("Not allowed! Please Select from 1 - 1000 \n");
				    	isNumber = false;
			    	}
	    	} while (!(isNumber));

		    do {
			    	System.out.print("Enter Number of Column: ");
			    	if (getInput.hasNextInt()) {
			    		col = getInput.nextInt();
			    		incol = col;
			    		isNumber = true;
			    	} else {
			    		System.out.println("Please Input a valid number!");
			    		isNumber = false;
			    		getInput.next();
			    	}
			    	if ((incol > 1000) || (incol < 1)) {
				    	System.out.println("Not allowed! Please Select from 1 - 1000 \n");
				    	isNumber = false;
			   		}
		    } while (!(isNumber));
	}

	

	static int readFile() {

			int fileFound = 0;
			Scanner openFile = null;
			Scanner openData = null;

			try {
				openFile = new Scanner(new File("dimension.txt"));
				openData = new Scanner(new File("data.txt"));
				int dim = 0;

				while (openFile.hasNextLine()) {
						String line = openFile.nextLine();
										
						FileStorage.storeDimension[dim] = line;
						dim = dim + 1;
				}
				
				openFile.close();
				System.out.println("\nData Files Successfully Loaded\n");

				while (openData.hasNextLine()) {
					String key = openData.nextLine();
					String value = openData.nextLine();			
					FileStorage.cellData.put(key, value);
				}
				
				openData.close();
				MenuOptions.menuPrint();
				MenuOptions.mainMenu();

			} catch (FileNotFoundException e) {
				
				fileFound = 1;
				System.out.println("File not found");
				System.out.println("\nData will be Created, Please Enter Table Dimension");
				getDimension();
			}

			return fileFound;
	}

	static void createFile() {
			
			try {
				FileWriter saveFile = new FileWriter(new File("data.txt"));
				FileWriter saveDimension = new FileWriter(new File("dimension.txt"));

				for(int index1 = 1 ; index1 <= (row * 2) ; index1++) {
				  		for(int index2 = 1 ; index2 <= (col) ; index2++) {
							saveFile.write(FileStorage.generateASCII()+"\n");
						}
				}			
				saveDimension.write(row+"\n");
				saveDimension.write(col+"\n");
				saveDimension.close();
				saveFile.close();
				System.out.println("\n");
				System.out.println("You Successfully created a table");
				progStart();

			} catch (IOException e) {
				System.out.println("Unable to open file for writing");
			}
	}


}