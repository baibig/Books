package com.baimax.hj.books.app;

import android.app.Application;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Created by HJ on 2015/6/2.
 */
public class AppControlor extends Application {
    public static final String TAG=AppControlor.class.getSimpleName();

    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;

    private static AppControlor mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance=this;
    }

    public static synchronized AppControlor getInstance(){
        return mInstance;
    }

    public RequestQueue getRequestQueue(){
        if (mRequestQueue==null){
            mRequestQueue= Volley.newRequestQueue(this);
        }
        return this.mRequestQueue;
    }

    public ImageLoader getImageLoader(){
        getRequestQueue();
        if (mImageLoader==null){
            mImageLoader=new ImageLoader(this.mRequestQueue,
                    new LruBitmapCache());
        }
        return this.mImageLoader;
    }

    public <T> void addToRequestQueue(Request<T> req){
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequest(Object tag){
        if (mRequestQueue!=null){
            mRequestQueue.cancelAll(tag);
        }
    }
}
