package com.bookstore;

import com.bookstore.service.BookstoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

    @Autowired
    private BookstoreService bookstoreService;

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            
            System.out.println("\nAdd author with books  ...");
            bookstoreService.addAuthorWithBooks();

            System.out.println("\nRemove a book of an author...");
            bookstoreService.removeBookOfAuthor();
            
            System.out.println("\nRemove all book of an author...");
            bookstoreService.removeAllBooksOfAuthor();
        };
    }
}

/*
*How To Migrate PostgreSQL Database Using Flyway - Use The Default Database postgres And Schema public

Note: For production, don't rely on hibernate.ddl-auto (or counterparts) to export schema DDL to the database. Simply remove (disable) hibernate.ddl-auto or set it to validate. Rely on Flyway or Liquibase.

Description: This application is an example of migrating a PostgreSQL database via Flyway for the default database postgres and schema public.

Key points:

for Maven, in pom.xml, add the Flyway dependency
remove (disable) spring.jpa.hibernate.ddl-auto or set it to validate
in application.properties, set the JDBC URL as follows: jdbc:postgresql://localhost:5432/postgres
each SQL file containing the schema update add it in classpath:db/migration
each SQL file name it as V1.1__Description.sql, V1.2__Description.sql, ...
*/