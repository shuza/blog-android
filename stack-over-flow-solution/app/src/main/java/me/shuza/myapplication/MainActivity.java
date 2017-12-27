package me.shuza.myapplication;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resources resi = getResources();

        final String[] ausreden = resi.getStringArray(R.array.ausreden);
        Button b = findViewById(R.id.btnClick);
        b.setOnClickListener((v) -> {
            TextView aus = findViewById(R.id.res);
            aus.setText("aaaa");
            String g = getRandom(ausreden);
            aus.setText(g);
        });

    }

    private String getRandom(String[] ausreden) {
        Random random = new Random();
        int index = random.nextInt(ausreden.length);
        return ausreden[index];
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.share_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_item_share) {
            startActivity(doShare());
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public Intent doShare() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        TextView textView = findViewById(R.id.res);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, textView.getText().toString());
        return intent;
    }
}
