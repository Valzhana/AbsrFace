package src.personal;

import src.personal.controllers.UserController;
import src.personal.model.*;
import src.personal.views.ViewUser;

public class Main {
    public static void main(String[] args) {
        saveFile();
        saveFile1();
    }

    private static void saveFile() {
        FileOperation fileOperation = new FileOperationImpl("users.txt");
        Repository repository = new RepositoryFile(fileOperation, new UserMapper());
        UserController controller = new UserController(repository);
        ViewUser view = new ViewUser(controller);
        view.run();
    }
    private static void saveFile1() {
        FileOperation fileOperation = new FileOperationImpl("users1.txt");
        Repository repository = new RepositoryFile(fileOperation, new NewUserMapper());
        UserController controller = new UserController(repository);
        ViewUser view = new ViewUser(controller);
        view.run();
    }
}
