package org.register.Services;

import org.register.Models.Enum.Gender;
import org.register.Models.User;
import org.register.Repositories.UserRepository;

import java.util.List;
import java.util.regex.Pattern;

public class UserService {
    private static UserRepository userRepository;
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9]+@gmail\\.com$");
    private static final Pattern USERNAME_PATTERN = Pattern.compile("^[A-Za-z0-9._-]{3,15}$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$");
    private static final Pattern PHONENUMBER_PATTERN = Pattern.compile("^\\+998(90|91|93|94|95|97|98|99|33|88|77)\\d{7}$");

    public UserService(UserRepository userRepository) {
        UserService.userRepository = userRepository;
    }

    public static boolean addUser(String username, String email, String phone, String password, Gender gender) {
        if (isValidUsername(username) && isValidEmail(email) && isValidPhoneNumber(phone) && isValidPassword(password) && isValidGender(gender)) {
            User user = new User(username, email, phone, password, gender);
            boolean isSaved = userRepository.saveUser(user);
            if (!isSaved) {
                System.out.println("Foydalanuvchi saqlashda xatolik yuz berdi.");
            }
            return isSaved;
        }
        System.out.println("Kiritilgan ma'lumotlar noto'g'ri.");
        return false;
    }



    public static User validateUser(String email, String password) {
        List<User> users = userRepository.readUser();
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public List<User> getUsers() {
        return userRepository.readUser();
    }


    public static boolean isValidEmail(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }

    public static boolean isValidUsername(String username) {
        return USERNAME_PATTERN.matcher(username).matches();
    }

    public static boolean isValidPassword(String password) {
        return PASSWORD_PATTERN.matcher(password).matches();
    }

    public static boolean isValidPhoneNumber(String phone) {
        return PHONENUMBER_PATTERN.matcher(phone).matches();
    }

    public static boolean isValidGender(Gender gender) {
        return gender != null;
    }

}
