package pl.sowinski.domain;

import java.time.LocalDateTime;

public class Deliveries {
    private int id;
    private LocalDateTime localDateTime;
    private LocalDateTime start;
    private LocalDateTime end;
    private int packaging;
    private String description;
    private int userId;
    private int suppliersId;


    public Deliveries() {
    }

    public Deliveries(LocalDateTime localDateTime, LocalDateTime start, LocalDateTime end, int packaging, String description, int userId, int suppliersId) {
        this.localDateTime = localDateTime;
        this.start = start;
        this.end = end;
        this.packaging = packaging;
        this.description = description;
        this.userId = userId;
        this.suppliersId = suppliersId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public int getPackaging() {
        return packaging;
    }

    public void setPackaging(int packaging) {
        this.packaging = packaging;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSuppliersId() {
        return suppliersId;
    }

    public void setSuppliersId(int suppliersId) {
        this.suppliersId = suppliersId;
    }
}
