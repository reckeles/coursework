package org.coursework.api.model.project;

import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class Project {
    private String name;
    private String description;
    private Integer owner_id;
    private String identifier;
    private String start_date;
    private String end_date;
    private Integer id;

    public Project() {
    }

    public Project(String name){
        this.name = name;
        this.description = null;
        this.owner_id = null;
        this.identifier = null;
        this.start_date = null;
        this.end_date = null;
    }

    public Project(String name, Integer owner_id){
        this.name = name;
        this.description = null;
        this.owner_id = owner_id;
        this.identifier = null;
        this.start_date = null;
        this.end_date = null;
    }

    public Project(String name,
                   String description,
                   Integer owner_id,
                   String identifier,
                   String start_date,
                   String end_date) {
        this.name = name;
        this.description = description;
        this.owner_id = owner_id;
        this.identifier = identifier;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getOwner_id() {
        return owner_id;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getStart_date() {
        return start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
