package Screens;

import files.Services.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.Stream;

import files.directory.Directory;

public class FirstScreen implements Screen{
	private String WelcomeText = "Welcome to File Details  !";
	private String Developer = "Developer : Jayanth";
	private ArrayList<String> options= new ArrayList<String>();
	private Directory dir = new Directory();
	
	public  FirstScreen() {
		options.add("1. Show Files");
		options.add("2. Show File option Menu");
	    options.add("3. Quit");
	}
	
	public void intro() {
		System.out.println(this.WelcomeText);
		System.out.println(this.Developer);
		show();
	}



	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.println("Main Menu");
		for(String s : options) {	
			System.out.println(s);
		}		
	}

	@Override
	public void SelectedOption(int n) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				switch(n) {
				case 1 : // Show Files in Directory
					this.showFiles();
					this.show();
					break;
					
				case 2 : // Show File Options menu
					
					ScreenService.setCurrentScreen(ScreenService.FileOptionsScreen);
		            ScreenService.getCurrentScreen().show();
		            ScreenService.getCurrentScreen().SelectedInput();			
		            this.show();
					break;
					
				 default:
		             System.out.println("Invalid Option");
		             break;
					
				}
		
	}

	private void showFiles() {
		// TODO Auto-generated method stub
		System.out.println("List of Files: ");
		 Path path = Paths.get(dir.name);
        try {
			Stream<Path> subPath=Files.walk(path,1);
			subPath.filter(Files::isRegularFile).forEach(a->System.out.println(a.getFileName()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void SelectedInput() {
		// TODO Auto-generated method stub
		int selectedOption  = 0;
        while ((selectedOption = this.getOption()) != 3) {
            this.SelectedOption(selectedOption);
        }	
	}

	private int getOption() {
		// TODO Auto-generated method stub
		Scanner i= new Scanner(System.in);

        int returnOption = 0;
        try {
            returnOption = i.nextInt();
        }
        catch (InputMismatchException ex) {

        }
        return returnOption;
	}
}
