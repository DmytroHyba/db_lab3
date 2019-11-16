package ua.lviv.iot.controller;

import ua.lviv.iot.model.User;
import ua.lviv.iot.service.UserService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class UserController {

    private static Scanner input = new Scanner(System.in);

    public void findAll() throws SQLException {
        System.out.println("\nTable: User");
        UserService service = new UserService();
        List<User> entities = service.findAll();
        for (User entity : entities) {
            System.out.println(entity);
        }
    }

    public void create() throws SQLException {
        System.out.println("Input name for User: ");
        String name = input.nextLine();
        System.out.println("Input login for User: ");
        String login = input.nextLine();
        System.out.println("Input url for User: ");
        String url = input.nextLine();
        User entity = new User(0, name, login, url);

        UserService service = new UserService();
        int count = service.create(entity);
        System.out.printf("There are created %d rows\n", count);
    }

    public void update() throws SQLException {
        System.out.println("Input id for User: ");
        Integer id = input.nextInt();
        input.nextLine();
        System.out.println("Input name for User: ");
        String name = input.nextLine();
        System.out.println("Input login for User: ");
        String login = input.nextLine();
        System.out.println("Input url for User: ");
        String url = input.nextLine();
        User entity = new User(id, name, login, url);

        UserService service = new UserService();
        int count = service.update(entity);
        System.out.printf("There are created %d rows\n", count);
    }

    public void delete() throws SQLException {
        System.out.println("Input id for User: ");
        Integer id = input.nextInt();
        input.nextLine();
        UserService service = new UserService();
        int count = service.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    public void findByID() throws SQLException {
        System.out.println("Input id for User: ");
        Integer id = input.nextInt();
        input.nextLine();
        UserService service = new UserService();
        User entity = service.findById(id);
        System.out.println(entity);
    }
}