package ua.lviv.iot.controller;

import java.sql.SQLException;

public class Controller {

    public void findAll() throws SQLException {
        new BlockUserController().findAll();
        new CommentsPostController().findAll();
        new LikeCommentsController().findAll();
        new PhotosAndVideosController().findAll();
        new PostController().findAll();
        new UserController().findAll();
    }
}
