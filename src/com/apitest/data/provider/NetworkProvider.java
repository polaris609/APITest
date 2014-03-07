package com.apitest.data.provider;

import com.apitest.data.DataListener;
import com.apitest.data.cache.DataCache;
import com.apitest.data.model.TimelineModel;

/*
*   example data provider implementation
*
*   this implementation represents obtaining data
*   from network and caching it
*
* */
public class NetworkProvider extends DataProvider {

    public NetworkProvider(DataCache dataCache) {
        super(dataCache);
    }

    @Override
    public void timeline(DataListener<TimelineModel> listener) {
        // imagine result is a model built from parsing server response
        TimelineModel result = new TimelineModel();
        mDataCache.cacheTimeline(result);
        listener.onDataReceived(result);

        // we can also push any errors
        // for example, we can handle http not found error in
        // context where we were to process requested data
        listener.onError(404);
    }

}