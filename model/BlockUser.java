package ua.lviv.iot.model;

public class BlockUser {
    private Integer idUser;
    private String reasonBan;
    private String userName;

    public BlockUser() {

    }

    public BlockUser(Integer idUser, String reasonBan, String userName) {
        this.idUser = idUser;
        this.reasonBan = reasonBan;
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "BlockUserEntity{" +
                "idUser=" + idUser +
                ", reasonBan=" + reasonBan  +
                ", userName=" + userName  +
                '}';
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getReasonBan() {
        return reasonBan;
    }

    public void setReasonBan(String reasonBan) {
        this.reasonBan = reasonBan;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
