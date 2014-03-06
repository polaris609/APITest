package com.apitest.data.cache;

import com.apitest.data.model.TimelineModel;

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