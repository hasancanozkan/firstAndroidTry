package com.example.hasancan.firstandroidtry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hasancan.firstandroidtry.bluetooth_module.BTManager;
import com.example.hasancan.firstandroidtry.interfaces.IBluetooth;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.firstandroidtry.MESSAGE";

    Button btn;
    TextView tV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button2);
        tV = findViewById(R.id.textView);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setup(view);
            }
        });
    }
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    public void setup (View view) {
        IBluetooth myInterface = new BTManager(MainActivity.this);
        if (!myInterface.checkBluetooth()) {
            String result = myInterface.setupBluetooth(this);
            tV.setText(result);
        }
        else {
            myInterface.disableBluetooth();
            tV.setText("Bluetooth disabled");
        }
    }
}
