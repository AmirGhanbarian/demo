package com.example.demo.model.response;

public class ResponseBuilderDemo<T> {
    private final ResponseDemo<T> responseDemo = new ResponseDemo<>();
    private ResponseBuilderDemo<T> result(String result) {
        responseDemo.setResult(result);
        return this;
    }
    private ResponseBuilderDemo<T> status(String status) {
        responseDemo.setStatus(status);
        return this;
    }
    public ResponseBuilderDemo<T> success() {
        return new ResponseBuilderDemo<T>().result("Succeed").status("200");
    }
    public ResponseBuilderDemo<T> fail() {
        return new ResponseBuilderDemo<T>().result("Failed").status("500");
    }
    public ResponseBuilderDemo<T> error(ResponseErrorDemo error) {
        responseDemo.setError(error);
        responseDemo.setResult("Failed");
        responseDemo.setStatus("500");
        return this;
    }
    public ResponseBuilderDemo<T> addData(final T body) {
        responseDemo.setData(body);
        responseDemo.setResult("Succeeded");
        responseDemo.setStatus("200");
        return this;
    }
    public ResponseDemo<T> build() {
        return responseDemo;
    }
}