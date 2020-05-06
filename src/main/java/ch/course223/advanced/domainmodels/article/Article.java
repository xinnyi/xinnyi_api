package ch.course223.advanced.domainmodels.article;

import ch.course223.advanced.core.ExtendedEntity;
import ch.course223.advanced.domainmodels.device.Device;
import ch.course223.advanced.domainmodels.user.User;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "article")
public class Article extends ExtendedEntity {

    @Column(name = "user_id")
    private String userId;

    @Column(name = "url")
    private String url;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Device device;

    @Column (name = "timestamp")
    private LocalDate timestamp;

    public Article(){}

    public Article(String userId, String url, Device device, LocalDate timestamp) {
        this.userId = userId;
        this.url = url;
        this.device = device;
        this.timestamp = timestamp;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }
}
