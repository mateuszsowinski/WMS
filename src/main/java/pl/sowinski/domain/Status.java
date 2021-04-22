package pl.sowinski.domain;

import java.time.LocalDateTime;

public class Status {
    private int id;
    private int status;
    private LocalDateTime dateStatus;
    private int userId;
    private int deliveryId;

    public Status(int id, int status, LocalDateTime dateStatus, int userId, int deliveryId) {
        this.id = id;
        this.status = status;
        this.dateStatus = dateStatus;
        this.userId = userId;
        this.deliveryId = deliveryId;
    }

    public Status() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDateTime getDateStatus() {
        return dateStatus;
    }

    public void setDateStatus(LocalDateTime dateStatus) {
        this.dateStatus = dateStatus;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(int deliveryId) {
        this.deliveryId = deliveryId;
    }
}