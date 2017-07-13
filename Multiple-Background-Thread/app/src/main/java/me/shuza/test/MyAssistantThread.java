package me.shuza.test;

import android.util.Log;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Boka on 14-Jul-17.
 */

public class MyAssistantThread extends Thread {
    private String title;
    private String apiUrl;

    public MyAssistantThread(String title, String apiUrl) {
        this.title = title;
        this.apiUrl = apiUrl;
    }

    @Override
    public void run() {
        Log.d("shuza.me", title + "    ==/    start");
        Request request = new Request.Builder()
                .url(apiUrl)
                .build();
        try {
            Response response = new OkHttpClient().newCall(request).execute();
            Log.d("shuza.me", "response  ==/  " + response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            Log.d("shuza.me", title + "   ==/   finish");
        }
    }
}
