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

    // optional
    private boolean mNetworkConnected = false;

    private DataBinder mDataBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, DataService.class);
        bindService(intent, mConnection, BIND_AUTO_CREATE);
    }

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

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            mNetworkConnected = true;
            mDataBinder = (DataBinder)iBinder;

            mDataBinder.getProvider().timeline(mTimelineListener);
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            mNetworkConnected = false;
        }
    };

}
