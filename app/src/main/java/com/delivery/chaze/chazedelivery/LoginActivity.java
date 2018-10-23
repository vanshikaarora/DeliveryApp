package com.delivery.chaze.chazedelivery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.delivery.chaze.chazedelivery.Retrofit.APIService;
import com.delivery.chaze.chazedelivery.Retrofit.ApiUtils;
import com.delivery.chaze.chazedelivery.models.User;

import java.util.HashMap;
import java.util.Timer;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class LoginActivity extends AppCompatActivity {

    private APIService mAPIService;
    @BindView(R.id.phone)
    EditText userPhone;
    @BindView(R.id.password)
    EditText userPassword;
    @BindView(R.id.phone_sign_in_button)
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAPIService = ApiUtils.getAPIService();
        userPhone=findViewById(R.id.phone);
        userPassword=findViewById(R.id.password);
        findViewById(R.id.phone_sign_in_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkInputs(userPhone.getText().toString(),userPassword.getText().toString())){
                    VerifyUser(userPhone.getText().toString(),userPassword.getText().toString());
                }
            }
        });

    }

    private boolean checkInputs(String s, String s1) {
        if(s.isEmpty()){
            Toast.makeText(LoginActivity.this,"Please enter mobile number",Toast.LENGTH_SHORT).show();
            return false;
        }
        if (s1.isEmpty()){
            Toast.makeText(this, "Please enter your password", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private boolean VerifyUser(String s, String s1) {

mAPIService.verify_user(s,s1).enqueue(new Callback<Void>() {
    @Override
    public void onResponse(Call<Void> call, Response<Void> response) {
        Log.d("loginactiv57",call.toString()+" "+response.message());
        //Toast.makeText(LoginActivity.this, "request code" +response.code(), Toast.LENGTH_SHORT).show();
        if (response.code()==404){
            Toast.makeText(LoginActivity.this, "Phone no. incorrect", Toast.LENGTH_SHORT).show();
        }
        else if (response.code()==200){
            Toast.makeText(LoginActivity.this, "Password Incorrect", Toast.LENGTH_SHORT).show();
        }
        else if (response.code()==201){
            Intent intent=new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
            Toast.makeText(LoginActivity.this, "Authenticated", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(Call<Void> call, Throwable t) {
        Log.d("LoginActivity64",call.toString()+" "+t.getMessage()+" "+t.toString());
        Toast.makeText(LoginActivity.this, "onfailure", Toast.LENGTH_SHORT).show();

    }
});


        return true;
    }
}
