package org.coursework.api.model.task;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Task {
    private String title;
    private Integer project_id;
    private String color_id;
    private Integer column_id;
    private Integer owner_id;
    private Integer creator_id;
    private String date_due;
    private String description;
    private Integer category_id;
    private Integer score;
    private Integer swimlane_id;
    private Integer priority;
    private Integer recurrence_status;
    private Integer recurrence_trigger;
    private Integer recurrence_factor;
    private Integer recurrence_timeframe;
    private Integer recurrence_basedate;
    private String reference;
    private String[] tags;
    private String date_started;
    private Integer id;

    public Task() {
    }

    public Task(String title, Integer project_id) {
        this(title, project_id, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public Task(String title,
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
                String[] tags,
                String date_started) {
        this.title = title;
        this.project_id = project_id;
        this.color_id = color_id;
        this.column_id = column_id;
        this.owner_id = owner_id;
        this.creator_id = creator_id;
        this.date_due = date_due;
        this.description = description;
        this.category_id = category_id;
        this.score = score;
        this.swimlane_id = swimlane_id;
        this.priority = priority;
        this.recurrence_status = recurrence_status;
        this.recurrence_trigger = recurrence_trigger;
        this.recurrence_factor = recurrence_factor;
        this.recurrence_timeframe = recurrence_timeframe;
        this.recurrence_basedate = recurrence_basedate;
        this.reference = reference;
        this.tags = tags;
        this.date_started = date_started;
    }

    public Task(String title,
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
                String date_started) {
        this.title = title;
        this.project_id = project_id;
        this.color_id = color_id;
        this.column_id = column_id;
        this.owner_id = owner_id;
        this.creator_id = creator_id;
        this.date_due = date_due;
        this.description = description;
        this.category_id = category_id;
        this.score = score;
        this.swimlane_id = swimlane_id;
        this.priority = priority;
        this.recurrence_status = recurrence_status;
        this.recurrence_trigger = recurrence_trigger;
        this.recurrence_factor = recurrence_factor;
        this.recurrence_timeframe = recurrence_timeframe;
        this.recurrence_basedate = recurrence_basedate;
        this.reference = reference;
        this.date_started = date_started;
    }

    public String getTitle() {
        return title;
    }

    public Integer getProject_id() {
        return project_id;
    }

    public String getColor_id() {
        return color_id;
    }

    public Integer getColumn_id() {
        return column_id;
    }

    public Integer getOwner_id() {
        return owner_id;
    }

    public Integer getCreator_id() {
        return creator_id;
    }

    public String getDate_due() {
        return date_due;
    }

    public String getDescription() {
        return description;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public Integer getScore() {
        return score;
    }

    public Integer getSwimlane_id() {
        return swimlane_id;
    }

    public Integer getPriority() {
        return priority;
    }

    public Integer getRecurrence_status() {
        return recurrence_status;
    }

    public Integer getRecurrence_trigger() {
        return recurrence_trigger;
    }

    public Integer getRecurrence_factor() {
        return recurrence_factor;
    }

    public Integer getRecurrence_timeframe() {
        return recurrence_timeframe;
    }

    public Integer getRecurrence_basedate() {
        return recurrence_basedate;
    }

    public String getReference() {
        return reference;
    }

    public String[] getTags() {
        return tags;
    }

    public String getDate_started() {
        return date_started;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
