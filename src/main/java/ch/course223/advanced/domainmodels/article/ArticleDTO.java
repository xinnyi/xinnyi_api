package ch.course223.advanced.domainmodels.article;

import ch.course223.advanced.core.ExtendedDTO;
import ch.course223.advanced.domainmodels.device.Device;
import ch.course223.advanced.domainmodels.user.User;



public class ArticleDTO extends ExtendedDTO {

    private User user;

    private String url;

    private Device device;

    public ArticleDTO(){}


    public ArticleDTO(User user, String url, Device device) {
        this.user = user;
        this.url = url;
        this.device = device;
    }

    public ArticleDTO(String id, User user, String url, Device device) {
        super(id);
        this.user = user;
        this.url = url;
        this.device = device;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }
}
