package com.example.droidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private TextView orderView;
    private Spinner spn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        orderView = findViewById(R.id.orders);
        Intent intent = getIntent();
        String orders = intent.getStringExtra(MainActivity.EXTRA_MSG);
        orderView.setText(orders);
        spn = findViewById(R.id.spinner);

        if (spn != null){
            spn.setOnItemSelectedListener(this);
        }

        ArrayAdapter<CharSequence> adptr = ArrayAdapter.
                createFromResource(this,R.array.ohh, android.R.layout.simple_spinner_item);
        adptr.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        if (spn != null){
            spn.setAdapter(adptr);
        }

    }
    public void showMsg(String str){
//        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();show
        Toast.makeText(this, str, Toast.LENGTH_LONG).show();
    }
    public void onClickRadio(View view) {
        boolean id = ((RadioButton) view).isChecked();
        switch(view.getId()){
            case R.id.one:
                Toast.makeText(getApplicationContext(), R.string.same_day, Toast.LENGTH_SHORT).show();
                break;
            case R.id.two:
                Toast.makeText(getApplicationContext(), R.string.next_day_ground_delivery, Toast.LENGTH_SHORT).show();
                break;
            case R.id.three:
                Toast.makeText(getApplicationContext(), R.string.pick_up, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String label = parent.getItemAtPosition(position).toString();
        showMsg(label);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}