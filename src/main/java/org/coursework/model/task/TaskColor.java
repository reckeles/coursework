package org.coursework.model.task;

public class TaskColor {
    private String name;
    private String background;
    private String border;

    public TaskColor() {
    }

    public TaskColor(String name, String background, String border) {
        this.name = name;
        this.background = background;
        this.border = border;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getBorder() {
        return border;
    }

    public void setBorder(String border) {
        this.border = border;
    }
}
