import io.Console;
import io.Menu;
import services.ComicBookService;
import services.VideoGameService;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        Application app = new Application();
        app.init();
    }

    public void init() throws IOException {
        Console.printWelcome();
        Menu.mainMenu();
    }
}
