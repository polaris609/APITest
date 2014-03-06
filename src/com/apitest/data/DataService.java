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

public class DataService extends Service {

    private static final boolean USE_NETWORK = true;

    private NetworkProvider mNetworkProvider;
    private CacheProvider mCacheProvider;

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