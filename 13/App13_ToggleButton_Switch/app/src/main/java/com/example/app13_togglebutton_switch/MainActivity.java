package com.example.app13_togglebutton_switch;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ImageView imageView;
    Button button;
    LinearLayout linearLayout;
    Switch aSwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.result);
        imageView = findViewById(R.id.image);
        button = findViewById(R.id.b1);
        aSwitch = findViewById(R.id.swt);
        linearLayout = findViewById(R.id.ll);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        linearLayout.setBackgroundColor(Color.argb(255,23,45,123));
            }
        });
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    textView.setText("Wifi On");
                    textView.setTextColor(Color.GREEN);
                }
                else {
                    textView.setText("Wifi OFF");
                    textView.setTextColor(Color.RED);
                }
            }
        });

    }
    public  void  btntog (View view)
    {
      boolean check = ((ToggleButton)view).isChecked(); //true,false
    if(check)
    {
        textView.setText("Bulb state is ON");
        imageView.setBackgroundResource(R.drawable.bulbon);

    }
    else
    {
        textView.setText("Bulb state is OFF");
        imageView.setBackgroundResource(R.drawable.bulboff);
    }


    }
}