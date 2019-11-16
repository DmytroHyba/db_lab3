package ua.lviv.iot.model;

import java.sql.Date;

public class CommentsPost {
    private Integer idCommentsPost;
    private String text;
    private Date date;

    public CommentsPost() {

    }

    public CommentsPost(Integer idCommentsPost, String text, Date date) {
        this.idCommentsPost = idCommentsPost;
        this.text = text;
        this.date = date;
    }

    @Override
    public String toString() {
        return "CommentsPost{" +
                "idCommentsPost=" + idCommentsPost +
                ", text=" + text +
                ", date=" + date +
                '}';
    }

    public Integer getIdCommentsPost() {
        return idCommentsPost;
    }

    public void setIdCommentsPost(Integer idCommentsPost) {
        this.idCommentsPost = idCommentsPost;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
