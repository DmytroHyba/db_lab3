package ua.lviv.iot.view;

import ua.lviv.iot.controller.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class View {

    private Map<String, String> menu;
    private Map<String, Printable> methods;
    private static Scanner input = new Scanner(System.in);

    public View() {
        menu = new LinkedHashMap<>();
        methods = new LinkedHashMap<>();
        Controller controller = new Controller();
        BlockUserController blockUserController = new BlockUserController();
        CommentsPostController commentsPostController = new CommentsPostController();
        LikeCommentsController likeCommentsController = new LikeCommentsController();
        PhotosAndVideosController photosAndVideosController = new PhotosAndVideosController();
        PostController postController = new PostController();
        UserController userController = new UserController();

        menu.put("A", "   A - Select all table");

        menu.put("1", "   1 - Table: BlockUser");
        menu.put("11", "  11 - Create for BlockUser");
        menu.put("12", "  12 - Update BlockUser");
        menu.put("13", "  13 - Delete from BlockUser");
        menu.put("14", "  14 - Select BlockUser");
        menu.put("15", "  15 - Find BlockUser by ID");

        menu.put("2", "   2 - Table: CommentsPost");
        menu.put("21", "  21 - Create for CommentsPost");
        menu.put("22", "  22 - Update CommentsPost");
        menu.put("23", "  23 - Delete from CommentsPost");
        menu.put("24", "  24 - Select CommentsPost");
        menu.put("25", "  25 - Find CommentsPost by ID");

        menu.put("3", "   3 - Table: LikeComments");
        menu.put("31", "  31 - Create for LikeComments");
        menu.put("32", "  32 - Update LikeComments");
        menu.put("33", "  33 - Delete from LikeComments");
        menu.put("34", "  34 - Select LikeComments");
        menu.put("35", "  35 - Find LikeComments by ID");

        menu.put("4", "   4 - Table: PhotosAndVideos");
        menu.put("41", "  41 - Create for PhotosAndVideos");
        menu.put("42", "  42 - Update PhotosAndVideos");
        menu.put("43", "  43 - Delete from PhotosAndVideos");
        menu.put("44", "  44 - Select PhotosAndVideos");
        menu.put("45", "  45 - Find PhotosAndVideos by ID");

        menu.put("5", "   5 - Table: Post");
        menu.put("51", "  51 - Create for Post");
        menu.put("52", "  52 - Update Post");
        menu.put("53", "  53 - Delete from Post");
        menu.put("54", "  54 - Select Post");
        menu.put("55", "  55 - Find Post by ID");

        menu.put("6", "   6 - Table: User");
        menu.put("61", "  61 - Create for User");
        menu.put("62", "  62 - Update User");
        menu.put("63", "  63 - Delete from User");
        menu.put("64", "  64 - Select User");
        menu.put("65", "  65 - Find User by ID");

        menu.put("Q", "   Q - exit");


        methods.put("A", controller::findAll);

        methods.put("11", blockUserController::create);
        methods.put("12", blockUserController::update);
        methods.put("13", blockUserController::delete);
        methods.put("14", blockUserController::findAll);
        methods.put("15", blockUserController::findByID);

        methods.put("21", commentsPostController::create);
        methods.put("22", commentsPostController::update);
        methods.put("23", commentsPostController::delete);
        methods.put("24", commentsPostController::findAll);
        methods.put("25", commentsPostController::findByID);

        methods.put("31", likeCommentsController::create);
        methods.put("32", likeCommentsController::update);
        methods.put("33", likeCommentsController::delete);
        methods.put("34", likeCommentsController::findAll);
        methods.put("35", likeCommentsController::findByID);

        methods.put("41", photosAndVideosController::create);
        methods.put("42", photosAndVideosController::update);
        methods.put("43", photosAndVideosController::delete);
        methods.put("44", photosAndVideosController::findAll);
        methods.put("45", photosAndVideosController::findByID);

        methods.put("51", postController::create);
        methods.put("52", postController::update);
        methods.put("53", postController::delete);
        methods.put("54", postController::findAll);
        methods.put("55", postController::findByID);

        methods.put("61", userController::create);
        methods.put("62", userController::update);
        methods.put("63", userController::delete);
        methods.put("64", userController::findAll);
        methods.put("65", userController::findByID);
    }

    private void outputMenu() {
        System.out.println("\nMENU:");
        for (String key : menu.keySet())
            if (key.length() == 1) {
                System.out.println(menu.get(key));
            }
    }

    private void outputSubMenu(String fig) {

        System.out.println("\nSubMENU:");
        for (String key : menu.keySet())
            if (key.length() != 1 && key.substring(0, 1).equals(fig)) {
                System.out.println(menu.get(key));
            }
    }

    public void show() {
        String keyMenu;
        do {
            outputMenu();
            System.out.println("Please, select menu point.");
            keyMenu = input.nextLine().toUpperCase();

            if (keyMenu.matches("^\\d")) {
                outputSubMenu(keyMenu);
                System.out.println("Please, select menu point.");
                keyMenu = input.nextLine().toUpperCase();
            }

            try {
                methods.get(keyMenu).print();
            } catch (Exception e) {
            }
        } while (!keyMenu.equals("Q"));
    }
}
