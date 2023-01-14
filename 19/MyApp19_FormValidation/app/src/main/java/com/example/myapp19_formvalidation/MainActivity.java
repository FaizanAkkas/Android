package com.example.myapp19_formvalidation;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
 EditText edit_fn,edit_ln,edit_email,edit_address,edit_phone;
 Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit_fn = findViewById(R.id.fn);
        edit_ln = findViewById(R.id.ln);
        edit_email = findViewById(R.id.email);
        edit_address = findViewById(R.id.add);
        edit_phone = findViewById(R.id.no);
        //------------------------------------------button
        button = findViewById(R.id.btnsubmit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkDataEntry(); //calling
            }
        });
    }
    //---------------------------------------------- general required function
    private boolean isEmpty(EditText text) //define
    {
     CharSequence charSequence =  text.getText().toString();
        return TextUtils.isEmpty(charSequence);

    }

    private void checkDataEntry()  //define
    {
        if(isEmpty(edit_fn))
        {
            edit_fn.setError("First Name is Required");

        }
        if(isEmpty(edit_ln))
        {
            edit_ln.setError("Last Name is Required");

        }

        if(isEmpty(edit_email))
        {
            edit_email.setError("Email is Required");

        }

        if(isEmpty(edit_address))
        {
            edit_address.setError("Address is Required");

        }

        if(isEmpty(edit_phone))
        {
            edit_phone.setError("Phone No. is Required");

        }

        if (!isEmpty(edit_fn) && !isEmpty(edit_ln) && !isEmpty(edit_email) && !isEmpty(edit_address) &&!isEmpty(edit_phone))
        {
            AlertDialog.Builder alBuilder = new AlertDialog.Builder(MainActivity.this);
            alBuilder.setTitle("Create Account");
            alBuilder.setMessage("Successfully created :))))))))))");
            alBuilder.setIcon(R.drawable.ic_baseline_insert_emoticon_24);
            alBuilder.show();

        }
    }
}