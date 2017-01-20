package com.trendinfinal.trendinfinal;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {



    Button login,reset;
    EditText eno, password, dob , batch, year;
    String eno1, password1, dob1, batch1,year1;

    String server_url="http://192.168.43.231/androidlogin/new.php";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("STUDENT LOGIN");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_student);
        login = (Button) findViewById(R.id.buttonLoginStudent);
        reset=(Button)findViewById(R.id.resetButton);
        eno = (EditText) findViewById(R.id.idStudent);
        password = (EditText) findViewById(R.id.password);
        dob = (EditText) findViewById(R.id.dobStudent);
        batch = (EditText) findViewById(R.id.batchStudent);
        year = (EditText) findViewById(R.id.yearStudent);


        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eno.setText("");
                password.setText("");
                dob.setText("");
                batch.setText("");
                year.setText("");
            }
        });

        login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                eno1 = eno.getText().toString();
                password1 = password.getText().toString();
                dob1 = dob.getText().toString();
                batch1 = batch.getText().toString();
                year1 = year.getText().toString();
                boolean x=validate();

                if (x) {

                    final ProgressDialog progressDialog=new ProgressDialog(LoginActivity.this);
                    progressDialog.setTitle("Processing");
                    progressDialog.setMessage("Fetching Result from Server");
                    progressDialog.setCancelable(false);
                    progressDialog.show();

                    StringRequest stringRequest = new StringRequest(Request.Method.POST, server_url
                            , new Response.Listener<String>() {


                        @Override
                        public void onResponse(String response) {
                         //   Log.i("Inresponse",response);

                            progressDialog.cancel();
                           // Toast.makeText(getApplicationContext(),"In onResponse:"+response+response.length(),Toast.LENGTH_LONG).show();
                            if (response.length()==8) {
                                Intent intent = new Intent(LoginActivity.this, NavDrawerActivity.class);
                                startActivity(intent);
                            } else if (response.length()>8) {
                                Toast.makeText(LoginActivity.this, "Error Invalid User", Toast.LENGTH_LONG).show();

                            }
                        }
                    }, new Response.ErrorListener() {


                        @Override
                        public void onErrorResponse(VolleyError error) {

                            progressDialog.cancel();
                            Toast.makeText(LoginActivity.this, "Error...", Toast.LENGTH_LONG).show();
                            error.printStackTrace();
                            Intent intent=new Intent(LoginActivity.this,NavDrawerActivity.class);
                            startActivity(intent);

                        }
                    }) {

                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> params = new HashMap<String, String>();
                            params.put("username", eno1);
                            params.put("pass", password1);
                            params.put("dob", dob1);
                            return params;
                        }
                    };

                    int socketTimeout = 100000;
                    RetryPolicy policy = new DefaultRetryPolicy(socketTimeout,
                            DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                            DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);

                    stringRequest.setRetryPolicy(policy);
                    MySingleton.getmInstance(LoginActivity.this).addToRequestQueue(stringRequest);

                }





            }
        });

    }


    public boolean validate() {

        String pat = "[0-9]{8}";

        if (eno1.isEmpty() || eno1.length()<8 ) {
            Toast.makeText(getApplicationContext(), "Please fill eno", Toast.LENGTH_LONG).show();
           return false;
        }

        if (password1.isEmpty() ) {
            Toast.makeText(getApplicationContext(), "Please fill password", Toast.LENGTH_LONG).show();
            return false;
        }

        if (dob1.isEmpty() ) {
            Toast.makeText(getApplicationContext(), "Please fill dob", Toast.LENGTH_LONG).show();
            return false;
        }

        Pattern pattern=Pattern.compile("(0?[1-9]|[12][0-9]|3[01])(.|-|/)(0?[1-9]|1[012])(.|-|/)((19|20)\\d\\d)");
        Matcher matcher=pattern.matcher(dob1);
        if (!matcher.matches()){
            Toast.makeText(getApplicationContext(),"Please fill a valid date",Toast.LENGTH_LONG).show();
            return false;
        }

        if (batch1.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please fill batch", Toast.LENGTH_LONG).show();
            return false;
        }

        if ( year1.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please fill year", Toast.LENGTH_LONG).show();
            return false;
        }


//        if (!(eno1.matches(pat))){
//            Toast.makeText(getApplicationContext(), "Please enter a valid enrollment number", Toast.LENGTH_LONG).show();
//            return false;
//        }
//        if (!(year1.matches(".*[1-4].*"))) {
//            Toast.makeText(getApplicationContext(), "Please enter a valid year", Toast.LENGTH_LONG).show();
//            return false;
//        }






        return true;
    }



}

