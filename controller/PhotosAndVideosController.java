package ua.lviv.iot.controller;

import ua.lviv.iot.model.PhotosAndVideos;
import ua.lviv.iot.service.PhotosAndVideosService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class PhotosAndVideosController {

    private static Scanner input = new Scanner(System.in);

    public void findAll() throws SQLException {
        System.out.println("\nTable: PhotosAndVideos");
        PhotosAndVideosService service = new PhotosAndVideosService();
        List<PhotosAndVideos> entities = service.findAll();
        for (PhotosAndVideos entity : entities) {
            System.out.println(entity);
        }
    }

    public void create() throws SQLException {
        System.out.println("Input content for PhotosAndVideos: ");
        String content = input.nextLine();
        System.out.println("Input size for PhotosAndVideos: ");
        String size = input.nextLine();
        System.out.println("Input photo for PhotosAndVideos: ");
        Integer photo = input.nextInt();
        System.out.println("Input video for PhotosAndVideos: ");
        Integer video = input.nextInt();
        PhotosAndVideos entity = new PhotosAndVideos(0, content, size, photo, video);

        PhotosAndVideosService service = new PhotosAndVideosService();
        int count = service.create(entity);
        System.out.printf("There are created %d rows\n", count);
    }

    public void update() throws SQLException {
        System.out.println("Input id for PhotosAndVideos: ");
        Integer id = input.nextInt();
        input.nextLine();
        System.out.println("Input content for PhotosAndVideos: ");
        String content = input.nextLine();
        System.out.println("Input size for PhotosAndVideos: ");
        String size = input.nextLine();
        System.out.println("Input photo for PhotosAndVideos: ");
        Integer photo = input.nextInt();
        System.out.println("Input video for PhotosAndVideos: ");
        Integer video = input.nextInt();
        PhotosAndVideos entity = new PhotosAndVideos(id, content, size, photo, video);

        PhotosAndVideosService service = new PhotosAndVideosService();
        int count = service.update(entity);
        System.out.printf("There are created %d rows\n", count);
    }

    public void delete() throws SQLException {
        System.out.println("Input id for PhotosAndVideos: ");
        Integer id = input.nextInt();
        input.nextLine();
        PhotosAndVideosService service = new PhotosAndVideosService();
        int count = service.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    public void findByID() throws SQLException {
        System.out.println("Input id for PhotosAndVideos: ");
        Integer id = input.nextInt();
        input.nextLine();
        PhotosAndVideosService service = new PhotosAndVideosService();
        PhotosAndVideos entity = service.findById(id);
        System.out.println(entity);
    }
}