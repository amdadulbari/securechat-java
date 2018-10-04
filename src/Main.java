import controllers.MsgController;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MsgController msgController = new MsgController();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Secure Chat Project.. [For test: username: superman , password: superman ] \n");

        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        try {
            msgController.init(username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
