package ua.lviv.iot.controller;

import ua.lviv.iot.model.Post;
import ua.lviv.iot.service.PostService;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class PostController {

    private static Scanner input = new Scanner(System.in);

    public void findAll() throws SQLException {
        System.out.println("\nTable: Post");
        PostService service = new PostService();
        List<Post> entities = service.findAll();
        for (Post entity : entities) {
            System.out.println(entity);
        }
    }

    public void create() throws SQLException {
        System.out.println("Input id_user for Post: ");
        Integer idUser = input.nextInt();
        input.nextLine();
        System.out.println("Input date for Post: ");
        String dateStr = input.nextLine();
        Date date = Date.valueOf(dateStr);
        System.out.println("Input color for Post: ");
        String description = input.nextLine();
        Post entity = new Post(0, idUser, date, description);

        PostService service = new PostService();
        int count = service.create(entity);
        System.out.printf("There are created %d rows\n", count);
    }

    public void update() throws SQLException {
        System.out.println("Input id for Post: ");
        Integer id = input.nextInt();
        input.nextLine();
        System.out.println("Input id_user for Post: ");
        Integer idUser = input.nextInt();
        input.nextLine();
        System.out.println("Input date for Post: ");
        String dateStr = input.nextLine();
        Date date = Date.valueOf(dateStr);
        System.out.println("Input color for Post: ");
        String description = input.nextLine();
        Post entity = new Post(id, idUser, date, description);

        PostService service = new PostService();
        int count = service.update(entity);
        System.out.printf("There are created %d rows\n", count);
    }

    public void delete() throws SQLException {
        System.out.println("Input id for Post: ");
        Integer id = input.nextInt();
        input.nextLine();
        PostService service = new PostService();
        int count = service.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    public void findByID() throws SQLException {
        System.out.println("Input id for Post: ");
        Integer id = input.nextInt();
        input.nextLine();
        PostService service = new PostService();
        Post entity = service.findById(id);
        System.out.println(entity);
    }
}
