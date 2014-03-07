package com.apitest.data.cache;

import com.apitest.data.model.TimelineModel;

/*
*   base interface to work with any cache
*
*   we need any caching api to be abstract
*   thus we will be able to do any refactoring
*   or new caching strategy implementation
*   with no impact on production code
*
* */
public interface DataCache {

    /*
    *   cache interface should define methods to handle
    *   any caching operations we need
    *   thus minimum viable cache interface is one that
    *   define any caching operation we need
    *   however this requirement is not mandatory and
    *   we can include other methods with purpose of
    *   fine-tuning cache performance
    *
    *   as for this example we have only timeline example
    *   model, we define two methods - one to store this
    *   model in cache and second to read it
    *
    * */
    public void cacheTimeline(TimelineModel timeline);

    public TimelineModel readTimeline();

}