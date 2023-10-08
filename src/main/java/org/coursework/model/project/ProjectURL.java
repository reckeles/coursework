package org.coursework.model.project;

public class ProjectURL {
    private String board;
    private String list;

    public ProjectURL() {
    }

    public ProjectURL(String board, String list) {
        this.board = board;
        this.list = list;
    }

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }
}
