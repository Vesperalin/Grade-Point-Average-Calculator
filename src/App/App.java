package App;
import Model.*;
import View.*;
import Controller.*;

public class App {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(view, model);
    }
}
