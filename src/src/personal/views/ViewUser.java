package src.personal.views;

import src.personal.controllers.UserController;
import src.personal.model.User;

import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class ViewUser {

    private UserController userController;

    public ViewUser(UserController userController) {
        this.userController = userController;
    }

    public void run() {
        Commands com = Commands.NONE;

        while (true) {
            try {
            String command = prompt("Введите команду: ");
            com = Commands.valueOf(command.toUpperCase());
            if (com == Commands.EXIT) return;
            switch (com) {
                case CREATE:
                    caseCreate();
                    break;
                case READ:
                    caseRead();
                    break;
                case LIST:

                    caseList();
                    break;
                case DELETE:
                    caseDeleted();
                    break;
                case UPDATE:
                    caseUpdate();
                    break;
            }
            }
            catch  (Exception ee){
                System.out.printf("Error: %s\n ", ee.getMessage());
            }
        }
    }

    private void caseDeleted() {
        String id = prompt("Идентификатор пользователя: ");
        userController.deleteUser(id);
        System.out.println("Данные удалены");
    }

    private void caseCreate() throws Exception {
        String firstName = prompt("Имя: ");
        String lastName = prompt("Фамилия: ");
        String phone = prompt("Номер телефона: ");
        userController.saveUser(new User(firstName, lastName, phone));
    }

    private void caseRead() {
        String id = prompt("Идентификатор пользователя: ");
        try {
            User user = userController.readUser(id);
            System.out.println(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void caseList() {
        List<User> usersList = userController.readUsers();
        for (User user : usersList) {
            System.out.println(user);
        }
    }
    public void caseUpdate() {
        String id = prompt("Идентификатор пользователя: ");
        String number = String.valueOf(parseInt(prompt("""
                1 - изменить имя
                2 - изменить фамилию
                3 - изменить номер телефона
                """)));
        switch (number) {
            case "1" -> {
                userController.updateUserName(id);
            }
            case "2" -> {
                userController.updateLastName(id);
            }
            case "3" -> {
                userController.updatePhoneNumber(id);
            }
        }
        System.out.println("Данные сохранены");
    }
    public String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}
