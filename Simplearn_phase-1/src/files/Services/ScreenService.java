package files.Services;

import Screens.*;

public class ScreenService {
	public static FirstScreen FirstScreen = new FirstScreen();
	public static FileOptionsScreen FileOptionsScreen = new FileOptionsScreen();
	
	public static Screen CurrentScreen = FirstScreen;
	
	 public static Screen getCurrentScreen() {
	        return CurrentScreen;
	    }
	 public static void setCurrentScreen(Screen currentScreen) {
	        CurrentScreen = currentScreen;
	    }

	

}
