package com.trendinfinal.trendinfinal;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Vishesh on 30-11-2016.
 */

public class MySingleton {
    private static MySingleton mInstance;
    private RequestQueue requestQueue;
    private static Context mContext;

    private MySingleton(Context context){
        mContext=context;
        requestQueue=getRequestQueue();
    }
    public static synchronized MySingleton getmInstance(Context context){
        if (mInstance==null){
            mInstance=new MySingleton(context);
        }

        return mInstance;
    }

    public RequestQueue getRequestQueue(){
        if (requestQueue==null){
            requestQueue= Volley.newRequestQueue(mContext.getApplicationContext());
        }
        return requestQueue;
    }

    public <T>void addToRequestQueue(Request<T> request){
        requestQueue.add(request);
    }
}
