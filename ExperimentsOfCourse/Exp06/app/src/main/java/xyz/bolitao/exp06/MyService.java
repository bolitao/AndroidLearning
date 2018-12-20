package xyz.bolitao.exp06;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;

public class MyService extends Service {
    private static final String TAG = "MyService";
    private Thread thread;
    int i = 0;
    private Message message;

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind: ");
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    while (!Thread.interrupted()) {
                        message = new Message();
                        message.what = 0x001;
                        Bundle bundle = new Bundle();
                        bundle.putInt("value", i);
                        message.setData(bundle);
                        MainActivity.myHander.sendMessage(message);
                        i++;
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread = new Thread(runnable);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//        return super.onStartCommand(intent, flags, startId);
        if (!thread.isAlive()) {
            thread.start();
        }
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        thread.interrupt();
    }
}
