package ru.ftc.android.shifttemple.features.tasks.domain.model;

public final class Task {
    private String id;
    private String user_id;
    private String title;
    private String description;
    private String date;
    private String status;
    private long id_selected_bid;

    public Task(String user_id, String title, String description) {
        this.user_id = user_id;
        this.title = title;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUserId() {
        return user_id;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public long getIdSelectedBid() {
        return id_selected_bid;
    }
}
