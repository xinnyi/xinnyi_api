package ch.course223.advanced.domainmodels.article;

import ch.course223.advanced.core.ExtendedEntity;
import ch.course223.advanced.domainmodels.device.Device;
import ch.course223.advanced.domainmodels.user.User;

import javax.persistence.*;

@Entity
@Table(name = "article")
public class Article extends ExtendedEntity {

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private User user;

    @Column(name = "url")
    private String url;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Device device;

    public Article(){}

    public Article(User user, String url, Device device) {
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
