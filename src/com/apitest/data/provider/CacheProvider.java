package com.apitest.data.provider;

import com.apitest.data.DataListener;
import com.apitest.data.cache.DataCache;
import com.apitest.data.model.TimelineModel;

public class CacheProvider extends DataProvider {

    public CacheProvider(DataCache dataCache) {
        super(dataCache);
    }

    @Override
    public void timeline(DataListener<TimelineModel> listener) {
        TimelineModel model = mDataCache.readTimeline();
        listener.onDataReceived(model);
    }

}
