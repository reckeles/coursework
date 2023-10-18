package org.coursework.base;

import org.coursework.config.EnvConfig;

public class BaseAPIRequestBody<T> {
    private String jsonrpc;
    private String method;
    private long id;
    private T params;

    public BaseAPIRequestBody(String method, long id, T params) {
        this.jsonrpc = EnvConfig.JSONRPC_VERSION.value;
        this.method = method;
        this.id = id;
        this.params = params;
    }

    public String getJsonrpc() {
        return jsonrpc;
    }

    public String getMethod() {
        return method;
    }

    public long getId() {
        return id;
    }

    public T getParams() {
        return params;
    }
}
