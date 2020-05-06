package ch.course223.advanced.domainmodels.article;

import ch.course223.advanced.core.ExtendedDTO;
import ch.course223.advanced.domainmodels.device.Device;
import ch.course223.advanced.domainmodels.user.User;

import java.time.LocalDate;


public class ArticleDTO extends ExtendedDTO {

    private String userId;

    private String url;

    private Device device;

    private LocalDate timestamp;

    public ArticleDTO(){}

    public ArticleDTO(String id) {
        super(id);
    }

    public ArticleDTO(String userId, String url, Device device, LocalDate timestamp) {
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
}
