/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uap_bioskopapp;

/**
 *
 * @author USER
 */
public class Akun {
    private static final ThreadLocal<User> currentUser = new ThreadLocal<>();

    public static void login(User user) {
        currentUser.set(user);
    }

    public static void logout() {
        currentUser.remove();
    }

    public static User getCurrentUser() {
        return currentUser.get();
    }
}

