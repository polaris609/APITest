package com.apitest;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import com.apitest.data.DataListener;
import com.apitest.data.DataService;
import com.apitest.data.DataService.DataBinder;
import com.apitest.data.model.TimelineModel;

public class MainActivity extends Activity {

    // optional, use it to define whether we are connected to data interface
    private boolean mNetworkConnected = false;

    private DataBinder mDataBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // mandatory connection to data service
        // it should be placed in onCreate or onStart callback for activities
        // and in onStart callback for fragments
        Intent intent = new Intent(this, DataService.class);
        bindService(intent, mConnection, BIND_AUTO_CREATE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // mandatory unbinding from data service
        // it should be placed in onDestroy or onStop callback for activities respectively
        // in fragments place this in onStop callback
        unbindService(mConnection);
    }

    // one of listeners implementation to handle data in desired context
    private DataListener<TimelineModel> mTimelineListener = new DataListener<TimelineModel>() {
        @Override
        public void onDataReceived(TimelineModel data) {
            // do something with data
        }

        @Override
        public void onError(int code) {
            // handle error if any
        }
    };

    // mandatory connection to obtain data provider interface
    // notice that data provider implementation is not important
    // we can work with any in fully-flat manner
    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            mNetworkConnected = true;
            mDataBinder = (DataBinder)iBinder;

            // requesting data is done via this call
            mDataBinder.getProvider().timeline(mTimelineListener);
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            mNetworkConnected = false;
        }
    };

}
