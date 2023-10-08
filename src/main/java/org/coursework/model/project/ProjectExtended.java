package org.coursework.model.project;

public class ProjectExtended extends Project{
    private Integer id;
    private Integer is_active;
    private String token;
    private Long last_modified;
    private Integer is_public;
    private Integer is_private;
    private Integer priority_default;
    private Integer priority_start;
    private Integer priority_end;
    private String email;
    private String predefined_email_subjects;
    private Integer per_swimlane_task_limits;
    private Integer task_limit;
    private Integer enable_global_tags;
    private ProjectURL url;

    public ProjectExtended() {
    }

    public ProjectExtended(String name,
                           String description,
                           Integer owner_id,
                           String identifier,
                           String start_date,
                           String end_date) {
        super(name, description, owner_id, identifier, start_date, end_date);
    }

    public ProjectExtended(String name,
                           String description,
                           Integer owner_id,
                           String identifier,
                           String start_date,
                           String end_date,
                           Integer id,
                           Integer is_active,
                           String token,
                           Long last_modified,
                           Integer is_public,
                           Integer is_private,
                           Integer priority_default,
                           Integer priority_start,
                           Integer priority_end,
                           String email,
                           String predefined_email_subjects,
                           Integer per_swimlane_task_limits,
                           Integer task_limit,
                           Integer enable_global_tags,
                           ProjectURL url) {
        super(name, description, owner_id, identifier, start_date, end_date);
        this.id = id;
        this.is_active = is_active;
        this.token = token;
        this.last_modified = last_modified;
        this.is_public = is_public;
        this.is_private = is_private;
        this.priority_default = priority_default;
        this.priority_start = priority_start;
        this.priority_end = priority_end;
        this.email = email;
        this.predefined_email_subjects = predefined_email_subjects;
        this.per_swimlane_task_limits = per_swimlane_task_limits;
        this.task_limit = task_limit;
        this.enable_global_tags = enable_global_tags;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIs_active() {
        return is_active;
    }

    public void setIs_active(Integer is_active) {
        this.is_active = is_active;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getLast_modified() {
        return last_modified;
    }

    public void setLast_modified(Long last_modified) {
        this.last_modified = last_modified;
    }

    public Integer getIs_public() {
        return is_public;
    }

    public void setIs_public(Integer is_public) {
        this.is_public = is_public;
    }

    public Integer getIs_private() {
        return is_private;
    }

    public void setIs_private(Integer is_private) {
        this.is_private = is_private;
    }

    public Integer getPriority_default() {
        return priority_default;
    }

    public void setPriority_default(Integer priority_default) {
        this.priority_default = priority_default;
    }

    public Integer getPriority_start() {
        return priority_start;
    }

    public void setPriority_start(Integer priority_start) {
        this.priority_start = priority_start;
    }

    public Integer getPriority_end() {
        return priority_end;
    }

    public void setPriority_end(Integer priority_end) {
        this.priority_end = priority_end;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPredefined_email_subjects() {
        return predefined_email_subjects;
    }

    public void setPredefined_email_subjects(String predefined_email_subjects) {
        this.predefined_email_subjects = predefined_email_subjects;
    }

    public Integer getPer_swimlane_task_limits() {
        return per_swimlane_task_limits;
    }

    public void setPer_swimlane_task_limits(Integer per_swimlane_task_limits) {
        this.per_swimlane_task_limits = per_swimlane_task_limits;
    }

    public Integer getTask_limit() {
        return task_limit;
    }

    public void setTask_limit(Integer task_limit) {
        this.task_limit = task_limit;
    }

    public Integer getEnable_global_tags() {
        return enable_global_tags;
    }

    public void setEnable_global_tags(Integer enable_global_tags) {
        this.enable_global_tags = enable_global_tags;
    }

    public ProjectURL getUrl() {
        return url;
    }

    public void setUrl(ProjectURL url) {
        this.url = url;
    }
}
