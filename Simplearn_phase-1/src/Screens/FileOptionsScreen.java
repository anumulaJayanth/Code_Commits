package Screens;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import files.directory.Directory;


public class FileOptionsScreen implements Screen {
	
	private ArrayList<String> options = new ArrayList<>();
	private Directory dir = new Directory();
	
public FileOptionsScreen() {
    	
    	options.add("1. Add a File");
        options.add("2. Delete A File");
        options.add("3. Search A File");
        options.add("4. Return to Menu");
        
    }

@Override
public void show() {
	// TODO Auto-generated method stub
	System.out.println("File Options Menu");
    for (String s : options) {
        System.out.println(s);
    }
	
}

@Override
public void SelectedOption(int n) {
	// TODO Auto-generated method stub
	switch(n) {

    case 1: // Add File
        this.AddFile();
        
        this.show();
        break;
    case 2: // Delete File
        this.DeleteFile(); 
        this.show();
        break;
    case 3: // Search File
        this.SearchFile();
        this.show();
        break;        	
    default:
        System.out.println("Invalid Option");
        break;
                  
}
	
}

private void SearchFile() {
	// TODO Auto-generated method stub
	Boolean found = false;
	
	System.out.println("Please Enter the Filename:");

    String fileName = this.getInputString();

    System.out.println("You are searching for a file named: " + fileName);
    
    //TODO Fix it so ArrayList obtains files
    //Finished TODO
    
    ArrayList<File> files = dir.getFiles();
    
    
    for(int i = 0; i < files.size(); i++) {
		if(files.get(i).getName().equals(fileName)) {
			System.out.println("Found " + fileName);
			found = true;
		}
    }
    if (found == false) {
    	System.out.println("File not found");
    }
	
}

private String getInputString() {
	// TODO Auto-generated method stub
	 Scanner in = new Scanner(System.in);
     return(in.nextLine());
}

private void DeleteFile() {
	// TODO Auto-generated method stub
	System.out.println("Please Enter the Filename:");

    String fileName = this.getInputString();
    Path path = FileSystems.getDefault().getPath(Directory.name + fileName).toAbsolutePath();
	File file = new File(dir.getName() + fileName);
    //File file = new File(filepath+fileName);
    boolean isFileDeleted = file.delete();
	if(isFileDeleted) {	
		System.out.println(file.getName()+ " file is deleted");	
	}else {
		System.out.println("Sorry File not found");
	}
	
}

private void AddFile() {
	// TODO Auto-generated method stub
	System.out.println("Please Enter the Filename:");

    String fileName = this.getInputString();
    Path path = FileSystems.getDefault().getPath(Directory.name + fileName).toAbsolutePath();
	File file = new File(dir.getName() + fileName);
    //File file = new File(filepath+fileName);
    try {
		boolean isFileCreated = file.createNewFile();
		if(isFileCreated) {
			System.out.println(file.getName()+ " file is created");
		}else {
			System.out.println("File already Exist");
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	
}

@Override
public void SelectedInput() {
	// TODO Auto-generated method stub
	int selectedOption;
    while ((selectedOption = this.getOption()) != 4) {
        this.SelectedOption(selectedOption);
    }
	
}

private int getOption() {
	// TODO Auto-generated method stub
	Scanner in = new Scanner(System.in);

    int returnOption = 0;
    try {
        returnOption = in.nextInt();
    }
    catch (InputMismatchException ex) {
    	System.out.println("Invalid input");
    }
    return returnOption;
    }


}
