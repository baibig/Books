package com.baimax.hj.books.view;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.baimax.hj.books.R;
import com.baimax.hj.books.app.AppControlor;

import java.lang.reflect.Field;
import java.util.Random;


public class MainActivity extends ActionBarActivity{

    ImageView mImageView;
    LinearLayout mScan;
    LinearLayout mSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(AppControlor.TAG, "huangjian");
        setContentView(R.layout.activity_main);
        mImageView= (ImageView) findViewById(R.id.imageview_home);
        Random rando=new Random();
        int r=rando.nextInt(8)+1;
        try {
            Field f=R.drawable.class.getField("img_home_"+r);
            int src=f.getInt(new R.drawable());
            mImageView.setImageResource(src);
            Log.i(AppControlor.TAG,src+"");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        mScan= (LinearLayout) findViewById(R.id.home_scan);
        mSearch= (LinearLayout) findViewById(R.id.home_search);
        mScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        mSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,ActivitySearch.class);
                startActivity(intent);
            }
        });

    }

}