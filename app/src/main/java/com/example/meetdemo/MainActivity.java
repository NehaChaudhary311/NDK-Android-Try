package com.example.meetdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
        TextView tv = findViewById(R.id.discoverable);


        //Code for switch - make me discoverable
        Switch makeDiscoverable = (Switch)findViewById(R.id.makeDiscoverable);
        Boolean switchState = makeDiscoverable.isChecked();
        if(switchState == true) {
            //Toast.makeText(getApplicationContext(),stringForMakeDiscoverable(),Toast.LENGTH_SHORT).show();
            tv.setText(stringForMakeDiscoverable());
        }
        else{
            Toast.makeText(getApplicationContext(),"You're not discoverable now",Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */

    public native String stringFromJNI();
    public native String stringForMakeDiscoverable();
}
