package cc.httpsdesignstudio.aparna.Feed;

/**
 * Created by Saumia Singhal on 3/6/2018.
 */

public class Post {

    String title, description, image;

    public Post() {
    }

    public Post(String title, String description, String image) {
        this.title = title;
        this.description = description;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public String getImage() {
        return image;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void  setImage(String image) {
        this.image = image;
    }

}