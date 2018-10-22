package com.delivery.chaze.chazedelivery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import butterknife.BindView;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.phone)
    EditText userPhone;
    @BindView(R.id.password)
    EditText userPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }
}
