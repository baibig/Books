package com.baimax.hj.books.utils;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.baimax.hj.books.app.AppControlor;
import com.baimax.hj.books.impl.HttpCallback;
import com.google.gson.JsonObject;

import org.apache.http.client.utils.URLEncodedUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by HJ on 2015/6/2.
 */
public class HttpUtil {
    private final static String URL_SEARCH="https://api.douban.com/v2/book/search";
    private final static String URL_REVIEWS="http://book.douban.com/subject/";
    private final static String POST_URL_REVIEWS="/reviews";
    public static void searchBook(final String q, final HttpCallback listener) {
        StringRequest request = new StringRequest(Request.Method.POST, URL_SEARCH,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        listener.onHttpResult(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<>();
                params.put("q",q);
                return params;
            }
        };
        AppControlor.getInstance().addToRequestQueue(request);
    }
    public static void getReviews(String id, final int start, final String sort,final HttpCallback listener){
        String url=URL_REVIEWS+id+POST_URL_REVIEWS;
        RequestQueue queue=AppControlor.getInstance().getRequestQueue();
        StringRequest request=new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        listener.onHttpResult(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<>();
                params.put("start",start+"");
                params.put("sort",sort);
                return params;
            }
        };
        queue.add(request);
    }
}
