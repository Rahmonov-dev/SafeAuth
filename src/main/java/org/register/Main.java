package org.register;


import org.register.Repositories.UserRepository;
import org.register.Services.UserService;
import org.register.controller.UserController;

import java.util.Scanner;

import static org.register.controller.UserController.*;

public class Main {
    static Scanner SCANNERINT = new Scanner(System.in);
    static Scanner SCANNERSTR = new Scanner(System.in);
    static UserRepository userRepository = new UserRepository();
    static UserController userController = new UserController();
    static UserService userService = new UserService(userRepository);

    public static void main(String[] args) {
        while (true) {
            System.out.println("""
                    1-Login
                    2-Register
                    3-Exit
                    """);
            switch (inputInt("Enter your choice: ")) {
                case 1 -> {
                    loginUser();
                }
                case 2 -> {
                    registerUser();
                }
                default -> {
                    return;
                }
            }
        }


    }

    public static int inputInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int input = Integer.parseInt(SCANNERSTR.nextLine());
                return input;
            } catch (NumberFormatException e) {
                System.out.println("Faqat son kiriting!");
            }
        }
    }


    public static String inputStr(String prompt) {
        try {
            System.out.print(prompt);
            return SCANNERSTR.nextLine();
        } catch (Exception e) {
            SCANNERSTR = new Scanner(System.in);
            return null;
        }
    }
}
