package ua.lviv.iot.model;

public class LikeComments {
    private Integer idComments;
    private Integer idUser;
    private Integer likeComments;

    public LikeComments() {

    }

    public LikeComments(Integer idComments, Integer idUser, Integer likeComments) {
        this.idComments = idComments;
        this.idUser = idUser;
        this.likeComments = likeComments;
    }

    @Override
    public String toString() {
        return "LikeComments{" +
                "idComments=" + idComments +
                ", idUser=" + idUser +
                ", likeComments=" + likeComments +
                '}';
    }

    public Integer getIdComments() {
        return idComments;
    }

    public void setIdComments(Integer idComments) {
        this.idComments = idComments;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public int getLikeComments() {
        return likeComments;
    }

    public void setLikeComments(Integer likeComments) {
        this.likeComments = likeComments;
    }
}
