package com.apitest.data;

/*
*   basic interface to define data obtaining interface
*   currently we only need data we requested or error
*   code if any occurred
*
*   this interface can be scaled to handle any
*   additional information about data we requested
*
* */
public interface DataListener<T> {

    public void onDataReceived(T data);

    public void onError(int code);

}
