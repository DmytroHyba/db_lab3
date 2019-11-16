package ua.lviv.iot.model;

import java.sql.Date;

public class Post {
    private Integer idPost;
    private Integer idUser;
    private Date date;
    private String description;

    public Post() {

    }

    public Post(Integer idPost, Integer idUser, Date date, String description) {
        this.idPost = idPost;
        this.idUser = idUser;
        this.date = date;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Post{" +
                "idPost=" + idPost +
                ", idUser=" + idUser +
                ", date=" + date +
                ", description=" + description +
                '}';
    }

    public Integer getIdPost() {
        return idPost;
    }

    public void setIdPost(Integer idPost) {
        this.idPost = idPost;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
