package com.apitest.data.provider;

import com.apitest.data.DataListener;
import com.apitest.data.cache.DataCache;
import com.apitest.data.model.TimelineModel;

public class NetworkProvider extends DataProvider {

    public NetworkProvider(DataCache dataCache) {
        super(dataCache);
    }

    @Override
    public void timeline(DataListener<TimelineModel> listener) {
        TimelineModel result = new TimelineModel();
        mDataCache.cacheTimeline(result);
        listener.onDataReceived(result);

        listener.onError(404);
    }

}