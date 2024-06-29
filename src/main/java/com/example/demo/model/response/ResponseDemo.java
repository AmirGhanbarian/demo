package com.example.demo.model.response;

public class ResponseDemo<T> {
    private String status;
    private String result;
    private ResponseErrorDemo error;
    private T data;
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }
    public T getData() {
        return data;
    }
    public ResponseErrorDemo getError() {
        return error;
    }
    public void setError(ResponseErrorDemo error) {
        this.error = error;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setData(T data) {
        this.data = data;
    }
}