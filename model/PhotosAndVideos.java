package ua.lviv.iot.model;

public class PhotosAndVideos {
    private Integer id;
    private String content;
    private String size;
    private Integer photo;
    private Integer video;

    public PhotosAndVideos() {

    }

    public PhotosAndVideos(Integer id, String content, String size, Integer photo, Integer video) {
        this.id = id;
        this.content = content;
        this.size = size;
        this.photo = photo;
        this.video = video;
    }

    @Override
    public String toString() {
        return "PhotosAndVideos{" +
                "id=" + id +
                ", content=" + content +
                ", size=" + size +
                ", photo=" + photo +
                ", video=" + video +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getPhoto() {
        return photo;
    }

    public void setPhoto(Integer photo) {
        this.photo = photo;
    }

    public Integer getVideo() {
        return video;
    }

    public void setVideo(Integer video) {
        this.video = video;
    }
}
