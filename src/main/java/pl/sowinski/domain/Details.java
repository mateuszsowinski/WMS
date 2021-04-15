package pl.sowinski.domain;

import java.time.LocalDateTime;
import java.util.Date;

public class Details {

    private Date date;
    private String start;
    private String end;
    private int packaging;
    private String description;
    private LocalDateTime localDateTime;
    private String name;
    private String username;

    public Details(Date date, String start, String end, int packaging, String description, LocalDateTime localDateTime, String name, String username) {
        this.date = date;
        this.start = start;
        this.end = end;
        this.packaging = packaging;
        this.description = description;
        this.localDateTime = localDateTime;
        this.name = name;
        this.username = username;
    }

    public Details() {
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

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

