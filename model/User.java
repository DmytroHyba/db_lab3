package ua.lviv.iot.model;

public class User {
    private Integer idUser;
    private String name;
    private String login;
    private String url;

    public User() {

    }

    public User(Integer idUser, String name, String login, String url) {
        this.idUser = idUser;
        this.name = name;
        this.login = login;
        this.url = url;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", name=" + name +
                ", login=" + login +
                ", url=" + url +
                '}';
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
