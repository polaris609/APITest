package com.apitest.data;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import com.apitest.data.cache.DataCache;
import com.apitest.data.cache.ExampleCache;
import com.apitest.data.provider.CacheProvider;
import com.apitest.data.provider.DataProvider;
import com.apitest.data.provider.NetworkProvider;

/*
*   this class is the core of application networking
*   and persistence layer. its purpose is to provide
*   fully flat api to handle all server-originated data
*
*   all implementations of all components are not bound
*   and everything is modular. thus those components are
*   extremely easy to refactor and free to change
*
* */
public class DataService extends Service {

    // this value represents any logic we could use to select data source
    private static final boolean USE_NETWORK = true;

    // data providers that represent different data sources
    private NetworkProvider mNetworkProvider;
    private CacheProvider mCacheProvider;

    // here we can select cache implementation we want to use now
    private DataCache mDataCache = new ExampleCache();

    @Override
    public IBinder onBind(Intent intent) {
        return new DataBinder();
    }

    public class DataBinder extends Binder {
        public DataProvider getProvider() {
            if(USE_NETWORK){
                if(mNetworkProvider == null){
                    mNetworkProvider = new NetworkProvider(mDataCache);
                }
                return mNetworkProvider;
            } else {
                if(mCacheProvider == null){
                    mCacheProvider = new CacheProvider(mDataCache);
                }
                return mCacheProvider;
            }
        }
    }

}