package com.example.meetdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        final TextView tv = findViewById(R.id.discoverable);
        //tv.setText(stringFromJNI());

        //Check with button, toggle button for discoverable
        //Code for switch - make me discoverable
        Switch makeDiscoverable = (Switch)findViewById(R.id.makeDiscoverable);
        //String statusSwitch;
        makeDiscoverable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) tv.setText(stringForMakeDiscoverable());
                else tv.setText("You're not discoverable");
            }
        });

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */

    public native String stringFromJNI();
    public native String stringForMakeDiscoverable();
}
