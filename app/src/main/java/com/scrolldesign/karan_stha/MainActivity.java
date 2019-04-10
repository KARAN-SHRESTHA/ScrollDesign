package com.scrolldesign.karan_stha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {


    private EditText etMake, etColor, etYear, etPrice, etSize;
    private Button btnCreate;
    private TextView tvOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etMake = findViewById(R.id.etMake);
        etColor = findViewById(R.id.etColor);
        etYear = findViewById(R.id.etYear);
        etPrice = findViewById(R.id.etPrice);
        etSize = findViewById(R.id.etSize);
        btnCreate = findViewById(R.id.btnCreate);
        tvOut = findViewById(R.id.tvOut);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(validate())
                {



                }

            }
        });


    }

    //Validation
    private boolean validate() {
        boolean flag = true;
        Pattern p = Pattern.compile("[-+]?[0-9]");
        Pattern p1 = Pattern.compile("[-+]?[0-9]*\\.?[0-9]+");
        Matcher m1 = p.matcher(etYear.getText().toString());
        Matcher m2 = p.matcher(etPrice.getText().toString());
        Matcher m3 = p1.matcher(etSize.getText().toString());

        //Validating for Empty Text
        if (TextUtils.isEmpty(etMake.getText().toString())) {
            etMake.setError("Enter Make");
            etMake.requestFocus();
            flag = false;
        }
        else if (TextUtils.isEmpty(etColor.getText().toString())) {
            etColor.setError("Enter Color");
            etColor.requestFocus();
            flag = false;
        }
        else if (TextUtils.isEmpty(etYear.getText().toString())) {
            etYear.setError("Enter Year");
            etYear.requestFocus();
            flag = false;
        }
        else if (TextUtils.isEmpty(etPrice.getText().toString())) {
            etPrice.setError("Enter Price");
            etPrice.requestFocus();
            flag = false;
        }
        else if (TextUtils.isEmpty(etSize.getText().toString())) {
            etSize.setError("Enter Size");
            etSize.requestFocus();
            flag = false;
        }
        else if (!m1.find())    //validating for number only
        {
            etYear.setError("Enter Valid Number");
            etYear.requestFocus();
            flag = false;
        }
        else if (!m2.find())    //validating for number only
        {
            etPrice.setError("Enter Valid Number");
            etPrice.requestFocus();
            flag = false;
        }
        else if (!m3.find())    //validating for float number only
        {
            etSize.setError("Enter Valid Number");
            etSize.requestFocus();
            flag = false;
        }

        return flag;
    }

}
