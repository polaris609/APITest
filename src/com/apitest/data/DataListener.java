package com.apitest.data;

public interface DataListener<T> {

    public void onDataReceived(T data);

    public void onError(int code);

}
