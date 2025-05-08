package org.register.Repositories;

import org.register.Models.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    public static final String USER_FILE = "user.txt";

    public boolean saveUser(User user) {
        List<User> users = new ArrayList<User>();
        users.add(user);
        return writeUser(users);
    }

    private boolean writeUser(List<User> users) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USER_FILE))) {
            oos.writeObject(users);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public List<User> readUser() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(USER_FILE))) {
            List<User> users = (List<User>) ois.readObject();
            return users;
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
}
