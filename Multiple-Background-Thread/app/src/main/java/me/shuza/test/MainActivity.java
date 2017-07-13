package me.shuza.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private String API_URL_1 = "http://www.mocky.io/v2/5967c646110000be19b6c2ef";
    private String API_URL_2 = "http://www.mocky.io/v2/5967c689110000b319b6c2f1";
    private String API_URL_3 = "http://www.mocky.io/v2/5967c69b1100007d19b6c2f3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*new MyAssistantAsyn().execute("API-1", API_URL_1);
        new MyAssistantAsyn().execute("API-2", API_URL_2);
        new MyAssistantAsyn().execute("API-3", API_URL_3);*/

        new MyAssistantThread("API-1", API_URL_1).start();
        new MyAssistantThread("API-2", API_URL_2).start();
        new MyAssistantThread("API-3", API_URL_3).start();
    }

}
