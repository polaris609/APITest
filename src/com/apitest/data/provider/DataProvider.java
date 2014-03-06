package com.apitest.data.provider;

import com.apitest.data.DataListener;
import com.apitest.data.cache.DataCache;
import com.apitest.data.model.TimelineModel;

public abstract class DataProvider {

    protected DataCache mDataCache;

    public DataProvider(DataCache dataCache) {
        mDataCache = dataCache;
    }

    public abstract void timeline(DataListener<TimelineModel> listener);

}
