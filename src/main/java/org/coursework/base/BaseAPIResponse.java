package org.coursework.base;

public class BaseAPIResponse<T> {
    private String jsonrpc;
    private long id;
    private T result;

    public BaseAPIResponse() {
    }

    public BaseAPIResponse(String jsonrpc, long id, T result) {
        this.jsonrpc = jsonrpc;
        this.id = id;
        this.result = result;
    }

    public String getJsonrpc() {
        return jsonrpc;
    }

    public long getId() {
        return id;
    }

    public T getResult() {
        return result;
    }

    public void setJsonrpc(String jsonrpc) {
        this.jsonrpc = jsonrpc;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setResult(T result) {
        this.result = result;
    }
}