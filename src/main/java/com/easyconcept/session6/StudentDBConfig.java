package com.easyconcept.session6;

public class StudentDBConfig {
    // singleton class
    private static StudentDBConfig instance;
    private static String url;
    private static String username;
    private static String password;

    private StudentDBConfig(){
        StudentDBConfig.url = System.getenv("DB_URL");
        StudentDBConfig.username = System.getenv(("DB_USERNAME"));
        StudentDBConfig.password = System.getenv("DB_PASSWORD");
    }

    // Public accessor to the one instance
    public static StudentDBConfig getInstance() {
        if(instance == null) instance = new StudentDBConfig();
        return instance;
    }

    // Getters
    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
