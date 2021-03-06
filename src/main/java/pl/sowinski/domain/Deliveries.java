package pl.sowinski.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Deliveries {
    private int id;
    private Date date;
    private String start;
    private String end;
    private int packaging;
    private String description;
    private int userId;
    private int suppliersId;
    private LocalDateTime localDateTime;


    public Deliveries() {
    }

    public Deliveries(Date date, String start, String end, int packaging, String description, int userId, int suppliersId, LocalDateTime localDateTime) {
        this.date = date;
        this.start = start;
        this.end = end;
        this.packaging = packaging;
        this.description = description;
        this.userId = userId;
        this.suppliersId = suppliersId;
        this.localDateTime = localDateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
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

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}