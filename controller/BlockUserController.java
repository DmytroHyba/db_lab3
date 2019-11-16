package ua.lviv.iot.controller;

import ua.lviv.iot.model.BlockUser;
import ua.lviv.iot.service.BlockUserService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class BlockUserController {

    private static Scanner input = new Scanner(System.in);

    public void findAll() throws SQLException {
        System.out.println("\nTable: BlockUser");
        BlockUserService service = new BlockUserService();
        List<BlockUser> entities = service.findAll();
        for (BlockUser entity : entities) {
            System.out.println(entity);
        }
    }

    public void create() throws SQLException {
        System.out.println("Input reason_ban for BlockUser: ");
        String reasonBan = input.nextLine();
        System.out.println("Input color for BlockUser: ");
        String userName = input.nextLine();
        BlockUser entity = new BlockUser(0, reasonBan, userName);

        BlockUserService service = new BlockUserService();
        int count = service.create(entity);
        System.out.printf("There are created %d rows\n", count);
    }

    public void update() throws SQLException {
        System.out.println("Input id for BlockUser: ");
        Integer id = input.nextInt();
        input.nextLine();
        System.out.println("Input reason_ban for BlockUser: ");
        String reasonBan = input.nextLine();
        System.out.println("Input color for BlockUser: ");
        String userName = input.nextLine();
        BlockUser entity = new BlockUser(id, reasonBan, userName);

        BlockUserService service = new BlockUserService();
        int count = service.update(entity);
        System.out.printf("There are created %d rows\n", count);
    }

    public void delete() throws SQLException {
        System.out.println("Input id for BlockUser: ");
        Integer id = input.nextInt();
        input.nextLine();
        BlockUserService service = new BlockUserService();
        int count = service.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    public void findByID() throws SQLException {
        System.out.println("Input id for BlockUser: ");
        Integer id = input.nextInt();
        input.nextLine();
        BlockUserService service = new BlockUserService();
        BlockUser entity = service.findById(id);
        System.out.println(entity);
    }
}