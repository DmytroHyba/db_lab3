package ua.lviv.iot.service;

import ua.lviv.iot.model.LikeComments;
import ua.lviv.iot.service.LikeCommentsService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class LikeCommentsController {

    private static Scanner input = new Scanner(System.in);

    public void findAll() throws SQLException {
        System.out.println("\nTable: LikeComments");
        LikeCommentsService service = new LikeCommentsService();
        List<LikeComments> entities = service.findAll();
        for (LikeComments entity : entities) {
            System.out.println(entity);
        }
    }

    public void create() throws SQLException {
        System.out.println("Input id_user for LikeComments: ");
        Integer idUser = input.nextInt();
        System.out.println("Input like_comments for LikeComments: ");
        Integer likes = input.nextInt();
        LikeComments entity = new LikeComments(0, idUser, likes);

        LikeCommentsService service = new LikeCommentsService();
        int count = service.create(entity);
        System.out.printf("There are created %d rows\n", count);
    }

    public void update() throws SQLException {
        System.out.println("Input id for LikeComments: ");
        Integer id = input.nextInt();
        input.nextLine();
        System.out.println("Input id_user for LikeComments: ");
        Integer idUser = input.nextInt();
        System.out.println("Input like_comments for LikeComments: ");
        Integer likes = input.nextInt();
        LikeComments entity = new LikeComments(id, idUser, likes);

        LikeCommentsService service = new LikeCommentsService();
        int count = service.update(entity);
        System.out.printf("There are created %d rows\n", count);
    }

    public void delete() throws SQLException {
        System.out.println("Input id for LikeComments: ");
        Integer id = input.nextInt();
        input.nextLine();
        LikeCommentsService service = new LikeCommentsService();
        int count = service.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    public void findByID() throws SQLException {
        System.out.println("Input id for LikeComments: ");
        Integer id = input.nextInt();
        input.nextLine();
        LikeCommentsService service = new LikeCommentsService();
        LikeComments entity = service.findById(id);
        System.out.println(entity);
    }
}