package me.shuza.test;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Boka on 14-Jul-17.
 */

public class MyAssistantAsyn extends AsyncTask<String, Void, Void> {

    @Override
    protected Void doInBackground(String... params) {
        String title = params[0];
        String apiUrl = params[1];
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
        return null;
    }
}