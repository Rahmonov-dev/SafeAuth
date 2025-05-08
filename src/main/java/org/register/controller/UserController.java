package org.register.controller;

import org.register.Models.Enum.Gender;
import org.register.Services.UserService;

import static org.register.Main.inputStr;
import static org.register.Services.NotificationService.sendEmail;

public class UserController {
    public static void registerUser() {
        String username;
        do {
            username = inputStr("Enter your username: ");
            if (!UserService.isValidUsername(username)) {
                System.out.println("Foydalanuvchi nomi noto'g'ri formatda. Qayta urinib ko'ring.");
            }
        } while (!UserService.isValidUsername(username));

        String email;
        do {
            email = inputStr("Enter your email: ");
            if (!UserService.isValidEmail(email)) {
                System.out.println("Elektron pochta manzili noto'g'ri formatda. Qayta urinib ko'ring.");
            }
        } while (!UserService.isValidEmail(email));

        String phone;
        do {
            phone = inputStr("Enter your phone: ");
            if (!UserService.isValidPhoneNumber(phone)) {
                System.out.println("Telefon raqami noto'g'ri formatda. Qayta urinib ko'ring.");
            }
        } while (!UserService.isValidPhoneNumber(phone));

        String password;
        do {
            password = inputStr("Enter your password: ");
            if (!UserService.isValidPassword(password)) {
                System.out.println("Parol noto'g'ri formatda. Qayta urinib ko'ring.");
            }
        } while (!UserService.isValidPassword(password));

        Gender gender;
        while (true) {
            String genderInput = inputStr("Enter your gender (M/F): ").trim().toUpperCase();
            if (genderInput.equals("M")) {
                gender = Gender.MALE;
                break;
            } else if (genderInput.equals("F")) {
                gender = Gender.FEMALE;
                break;
            } else {
                System.out.println("Jins noto'g'ri kiritildi. Qayta urinib ko'ring.");
            }
        }

        if (UserService.addUser(username, email, phone, password, gender)) {
            System.out.println("Foydalanuvchi muvaffaqiyatli ro'yxatga olindi!");
            sendEmail(email);
        } else {
            System.out.println("Foydalanuvchini ro'yxatga olishda xatolik yuz berdi.");
        }
    }

    public static void loginUser() {
        String email = inputStr("Enter your email: ");
        String password = inputStr("Enter your password: ");
        var user = UserService.validateUser(email, password);
        if (user != null) {
            System.out.println("Muvaffaqiyatli tizimga kirdingiz, " + user.getUsername() + "!");
        } else {
            System.out.println("Login xato! Elektron pochta yoki parol noto'g'ri.");
        }
    }
}
