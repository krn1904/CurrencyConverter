package com.example.login;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView textView;
    private EditText editTextNumber;
    private Spinner spinner;
    public double value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView3);
        editTextNumber = findViewById(R.id.editTextNumber);
        spinner = findViewById(R.id.spinner_currancy);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.currancys, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
//        Same functions but with using eventlistener.........
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                Toast.makeText(MainActivity.this, "button clicked", Toast.LENGTH_SHORT).show();
//                String s = editTextNumber.toString();
//                int a = Integer.parseInt(s);;
//                double dollar = a * 0.013;
//                textView.setText("H");
//            }
//        });
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, " selected ", Toast.LENGTH_SHORT).show();
        String lable = parent.getItemAtPosition(position).toString();
//        value = setValue(lable);
    }

    public double setValue(String lable) {
        switch (lable) {
            case "US_Dollar":
                value = 0.013;
                break;

            case "Japanese_Yan":
                value = 0.0087;
                break;

            case "Russian_Ruble":
                value = 0.010;
                break;

            case "canadian_Dollar":
                value = 0.79;
                break;

            case "Australian_Dollar":
                value = 0.74;
                break;
        }
        return value;
    }

    public void calculate(View view) {
        String s = editTextNumber.getText().toString();
        double a = Integer.parseInt(s);
        double dollar = a * 0.0087;
        textView.setText("Indian currancy is " + dollar);
    }
}