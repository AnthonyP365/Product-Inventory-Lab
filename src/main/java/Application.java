import io.Console;
import io.Menu;
import services.ComicBookService;
import services.VideoGameService;

public class Application {
    //private ComicBookService comicBookService = new ComicBookService();
    //private VideoGameService videoGameService = new VideoGameService();

    public static void main(String[] args) {
        Application app = new Application();
        app.init();
    }

    public void init() {
        Console.printWelcome();
        Menu.mainMenu();
    }
}
