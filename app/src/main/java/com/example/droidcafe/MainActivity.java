package com.example.droidcafe;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static String PKGNAME;
    protected static final String EXTRA_MSG = "com.example.droidcafe.extra.MSG";
    private String orders;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        PKGNAME = getPackageName();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Taking you to Order page", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                intent.putExtra(EXTRA_MSG, orders);
                startActivity(intent);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        switch (id) {
            case R.id.action_settings:
                showMsg(getString(R.string.select_order));
                return true;
            case R.id.action_contact:
                showMsg(getString(R.string.select_contact)); return true;
            case R.id.action_favv:
                showMsg("You selectd favorite mute. "); return true;
            case R.id.action_status:
                showMsg("You select status menu."); return true;
            default:

        }

        return super.onOptionsItemSelected(item);
    }

    public void showMsg(String str) {
//        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();show
        Toast.makeText(this, str, Toast.LENGTH_LONG).show();
        orders = str;
    }

    public void showDonut(View view) {
        showMsg(getString(R.string.donut_order_message));
    }

    public void showFroyo(View view) {
        showMsg(getString(R.string.froyo_order_message));
    }

    public void showIce(View view) {
        showMsg(getString(R.string.ice_cream_order_message));
    }
}