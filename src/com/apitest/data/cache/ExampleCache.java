package com.apitest.data.cache;

import com.apitest.data.model.TimelineModel;

/*
*   example implementation of cache
*   this cache does actually provide no persistence of
*   data but it represents idea that cache
*   implementation is not important for data provider
*   user(more general - to data service user)
*
*   each cache implementation is a distinct module so
*   they are placed in different files though that
*   exposes api
*   so it is important not to use caches directly as
*   they are not designed to. rather cache
*   implementation should be selected in DataService
*   class and used indirectly via abstract api
*
* */
public class ExampleCache implements DataCache {

    private TimelineModel mTimeline;

    @Override
    public void cacheTimeline(TimelineModel timeline) {
        mTimeline = timeline;
    }

    @Override
    public TimelineModel readTimeline() {
        return mTimeline;
    }

}