package com.example.facadetoagentmode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.facadetoagentmode.facade.FacadeNetWork;
import com.example.facadetoagentmode.proxy.HttpProxy;
import com.example.facadetoagentmode.proxy.ICallBack;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private String URL = "http://c.3g.163.com/photo/api/set/0001%2F2250173.json";

    RequestQueue mQueue;

    private Button mBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtn = findViewById(R.id.http_request);
        mBtn.setOnClickListener(this);

        mQueue = Volley.newRequestQueue(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.http_request) {

            /**
             *  使用代理模式的调用
             */
            HttpProxy.obtain().get(URL, new ICallBack() {
                @Override
                public void onSuccess(Object respone) {
                    Toast.makeText(MainActivity.this, respone.toString(), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailed(String failed) {

                }
            });



            /**
             *  使用门面模式的调用
             */
//            FacadeNetWork facadeNetWork = FacadeNetWork.getInstance(this);
//            facadeNetWork.get(URL, new FacadeNetWork.Callback() {
//                @Override
//                public void onSuccess(Object respone) {
//                    Toast.makeText(MainActivity.this, respone.toString(), Toast.LENGTH_SHORT).show();
//                }
//
//                @Override
//                public void onFailed(String failed) {
//
//                }
//            });

            /**
             * 最原始的沒有任何封裝的网络调用
             */
//            StringRequest stringRequest = new StringRequest(Request.Method.GET,
//                    URL, new Response.Listener<String>() {
//                @Override
//                public void onResponse(String response) {
//                    try {
//                        JSONObject obj = new JSONObject(response);
//                        String source = obj.getString("source");
//                        Toast.makeText(MainActivity.this, source, Toast.LENGTH_SHORT).show();
//
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }, new Response.ErrorListener() {
//                @Override
//                public void onErrorResponse(VolleyError error) {
//
//                }
//            });
//
//            mQueue.add(stringRequest);
        }
    }
}
