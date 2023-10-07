package org.coursework.model;

public enum KanboardMethods {
    CREATE_USER("createUser", 1423501287),
    GET_USER("getUser", 1769674781),
    DELETE_USER("removeUser", 2094191872);


    String method;
    long id;

    KanboardMethods(String method, long id){
        this.method=method;
        this.id=id;
    }

    public String getMethod(){
        return this.method;
    }

    public long getId(){
        return this.id;
    }

}
