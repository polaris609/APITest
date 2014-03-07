package com.apitest.data.provider;

import com.apitest.data.DataListener;
import com.apitest.data.cache.DataCache;
import com.apitest.data.model.TimelineModel;

/*
*   base class representing abstract interface to any data we need
*   to use. each implementation represents distinct data sources
*
*   class is designed for inheritance
*
*   cache usage is enforced by constructor though cache is accessed
*   via abstract api so data provider developer does not need to
*   know any cache implementation details
*
* */
public abstract class DataProvider {

    protected DataCache mDataCache;

    public DataProvider(DataCache dataCache) {
        mDataCache = dataCache;
    }

    /*
    *   example call to provider. listener is a callback to handle result
    *   (whether data obtaining were successful or not)
    *   implementation is decoupled so changing data sources or any
    *   data retrieval routines does not impact any of
    *   data provider/data service users
    *
    *   generally, purpose of data provider interface is to make
    *   all data source handler distinct and independent from
    *   themselves and from api users
    *
    * */
    public abstract void timeline(DataListener<TimelineModel> listener);

}
