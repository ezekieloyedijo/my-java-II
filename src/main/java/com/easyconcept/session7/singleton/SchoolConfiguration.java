package com.easyconcept.session7.singleton;

/*
 * There's only one Principal In a school, show we should not make that mistake to create more
 * than one
 * Steps involved
 * Create a private static instance of the class (Which has access to its props amd method)
 * Create a private constructor to prevent a new instance from being created outside the class
 * Create a factory public static method that returns the instance or object of that class. It always returns
 * the same object
 * Singleton is a global variable, so you use it for shared data.
 * Values can be changed even in the application, but we can only have a copy of it
 * Not like when you have different student in a school
 *
 * Database connection explained
 * Your application makes use of shared connection pool to talk to your database
 * if 1000 people visit my application, I will not open 1000 connection to the database
 * rather like 5 will be open then others take a turn to use when resources are released
 * too many connections more memory usage, slow performance
 * Database connection a single pipe between application and database
 * Max connection - How many connection the database server can handle at once
 * Connection pool - A fixed set of reusable connections managed by the application
*/


import java.time.LocalDateTime;

public class SchoolConfiguration {
   private static SchoolConfiguration instance;
   private String term = "First term";
   private int yearOfEst = 2010;
   private LocalDateTime valedictoryService =LocalDateTime.of(2025, 8, 15, 10, 0);
   private String schoolName = "First Gate High School";

   // private constructor
   private SchoolConfiguration(){}

   // Factory function
   // Synchronized to prevent creating multiple instance
   // Because in a multi threaded application where task can be done in parallel, it may likely
   // create multiple instances
   public static synchronized SchoolConfiguration getInstance() {
       if(instance == null) instance = new SchoolConfiguration();
       return instance;
   }

   public void setTerm(String term){
       this.term = term;
   }

   public String getTerm() {
       return this.term;
   }

    public void setValedictoryService(LocalDateTime valedictoryService) {
        this.valedictoryService = valedictoryService;
    }

    public LocalDateTime getValedictoryService(){
       return this.valedictoryService;
    }

    public static void main(String[] args) {
        SchoolConfiguration schoolConfiguration = SchoolConfiguration.getInstance();


        schoolConfiguration.setTerm("Second Term");
        System.out.println(schoolConfiguration.getTerm());

        SchoolConfiguration schoolConfiguration2 = SchoolConfiguration.getInstance();
        System.out.println(schoolConfiguration2.getTerm());


    }
}
