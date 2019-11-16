package ua.lviv.iot.controller;

import ua.lviv.iot.model.CommentsPost;
import ua.lviv.iot.service.CommentsPostService;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class CommentsPostController {

    private static Scanner input = new Scanner(System.in);

    public void findAll() throws SQLException {
        try {
            System.out.println("\nTable: CommentsPost");
            CommentsPostService service = new CommentsPostService();
            List<CommentsPost> entities = service.findAll();
            for (CommentsPost entity : entities) {
                System.out.println(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void create() throws SQLException {
        System.out.println("Input text for CommentsPost: ");
        String text = input.nextLine();
        System.out.println("Input date for CommentsPost: ");
        String dateStr = input.nextLine();
        Date date = Date.valueOf(dateStr);
        CommentsPost entity = new CommentsPost(0, text, date);

        CommentsPostService service = new CommentsPostService();
        int count = service.create(entity);
        System.out.printf("There are created %d rows\n", count);
    }

    public void update() throws SQLException {
        System.out.println("Input id for CommentsPost: ");
        Integer id = input.nextInt();
        input.nextLine();
        System.out.println("Input text for CommentsPost: ");
        String text = input.nextLine();
        System.out.println("Input date for CommentsPost: ");
        String dateStr = input.nextLine();
        Date date = Date.valueOf(dateStr);
        CommentsPost entity = new CommentsPost(id, text, date);

        CommentsPostService service = new CommentsPostService();
        int count = service.update(entity);
        System.out.printf("There are created %d rows\n", count);
    }

    public void delete() throws SQLException {
        System.out.println("Input id for CommentsPost: ");
        Integer id = input.nextInt();
        input.nextLine();
        CommentsPostService service = new CommentsPostService();
        int count = service.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    public void findByID() throws SQLException {
        System.out.println("Input id for CommentsPost: ");
        Integer id = input.nextInt();
        input.nextLine();
        CommentsPostService service = new CommentsPostService();
        CommentsPost entity = service.findById(id);
        System.out.println(entity);
    }
}
