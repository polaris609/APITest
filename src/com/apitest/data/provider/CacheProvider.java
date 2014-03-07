package com.apitest.data.provider;

import com.apitest.data.DataListener;
import com.apitest.data.cache.DataCache;
import com.apitest.data.model.TimelineModel;

/*
*   example data provider implementation
*
*   this implementation represents obtaining data only from cache
*
* */
public class CacheProvider extends DataProvider {

    public CacheProvider(DataCache dataCache) {
        super(dataCache);
    }

    @Override
    public void timeline(DataListener<TimelineModel> listener) {
        listener.onDataReceived(mDataCache.readTimeline());
    }

}
