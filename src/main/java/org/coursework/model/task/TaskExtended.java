package org.coursework.model.task;

public class TaskExtended extends Task {
    private Integer id;
    private Long date_creation;
    private Long date_completed;
    private Integer position;
    private Integer is_active;
    private Long date_modification;
    private Float time_spent;
    private Float time_estimated;
    private Long date_moved;
    private Integer recurrence_parent;
    private Integer recurrence_child;
    private String external_provider;
    private String external_uri;
    private String url;
    private TaskColor color;

    public TaskExtended() {
    }

    public TaskExtended(String title,
                        Integer project_id,
                        String color_id,
                        Integer column_id,
                        Integer owner_id,
                        Integer creator_id,
                        String date_due,
                        String description,
                        Integer category_id,
                        Integer score,
                        Integer swimlane_id,
                        Integer priority,
                        Integer recurrence_status,
                        Integer recurrence_trigger,
                        Integer recurrence_factor,
                        Integer recurrence_timeframe,
                        Integer recurrence_basedate,
                        String reference,
                        String date_started,
                        Integer id,
                        Long date_creation,
                        Long date_completed,
                        Integer position,
                        Integer is_active,
                        Long date_modification,
                        Float time_spent,
                        Float time_estimated,
                        Long date_moved,
                        Integer recurrence_parent,
                        Integer recurrence_child,
                        String external_provider,
                        String external_uri,
                        String url,
                        TaskColor color) {
        super(title, project_id, color_id, column_id, owner_id, creator_id, date_due, description, category_id, score, swimlane_id, priority, recurrence_status, recurrence_trigger, recurrence_factor, recurrence_timeframe, recurrence_basedate, reference, date_started);
        this.id = id;
        this.date_creation = date_creation;
        this.date_completed = date_completed;
        this.position = position;
        this.is_active = is_active;
        this.date_modification = date_modification;
        this.time_spent = time_spent;
        this.time_estimated = time_estimated;
        this.date_moved = date_moved;
        this.recurrence_parent = recurrence_parent;
        this.recurrence_child = recurrence_child;
        this.external_provider = external_provider;
        this.external_uri = external_uri;
        this.url = url;
        this.color = color;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(Long date_creation) {
        this.date_creation = date_creation;
    }

    public Long getDate_completed() {
        return date_completed;
    }

    public void setDate_completed(Long date_completed) {
        this.date_completed = date_completed;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getIs_active() {
        return is_active;
    }

    public void setIs_active(Integer is_active) {
        this.is_active = is_active;
    }

    public Long getDate_modification() {
        return date_modification;
    }

    public void setDate_modification(Long date_modification) {
        this.date_modification = date_modification;
    }

    public Float getTime_spent() {
        return time_spent;
    }

    public void setTime_spent(Float time_spent) {
        this.time_spent = time_spent;
    }

    public Float getTime_estimated() {
        return time_estimated;
    }

    public void setTime_estimated(Float time_estimated) {
        this.time_estimated = time_estimated;
    }

    public Long getDate_moved() {
        return date_moved;
    }

    public void setDate_moved(Long date_moved) {
        this.date_moved = date_moved;
    }

    public Integer getRecurrence_parent() {
        return recurrence_parent;
    }

    public void setRecurrence_parent(Integer recurrence_parent) {
        this.recurrence_parent = recurrence_parent;
    }

    public Integer getRecurrence_child() {
        return recurrence_child;
    }

    public void setRecurrence_child(Integer recurrence_child) {
        this.recurrence_child = recurrence_child;
    }

    public String getExternal_provider() {
        return external_provider;
    }

    public void setExternal_provider(String external_provider) {
        this.external_provider = external_provider;
    }

    public String getExternal_uri() {
        return external_uri;
    }

    public void setExternal_uri(String external_uri) {
        this.external_uri = external_uri;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public TaskColor getColor() {
        return color;
    }

    public void setColor(TaskColor color) {
        this.color = color;
    }
}
