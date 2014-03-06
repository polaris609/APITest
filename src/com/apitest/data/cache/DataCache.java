package com.apitest.data.cache;

import com.apitest.data.model.TimelineModel;

public interface DataCache {

    public void cacheTimeline(TimelineModel timeline);

    public TimelineModel readTimeline();

}