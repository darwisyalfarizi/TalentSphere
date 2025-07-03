package utils;

import models.User;

public class Session {
    private static User currentUser;

    public static void setCurrentUser(User user) {
        currentUser = user;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void clear() {
        currentUser = null;
    }
    
    // Tambahkan method untuk pengecekan status login
    public static boolean isLoggedIn() {
        return currentUser != null;
    }
    
    // Tambahkan method untuk mendapatkan role user yang login
    public static String getCurrentRole() {
        return isLoggedIn() ? currentUser.getRole() : null;
    }
}