package com.baimax.hj.books.view;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.baimax.hj.books.R;
import com.baimax.hj.books.app.AppControlor;
import com.baimax.hj.books.impl.HttpCallback;
import com.baimax.hj.books.model.Book;
import com.baimax.hj.books.model.SearchResult;
import com.baimax.hj.books.presentation.SearchListAdapter;
import com.baimax.hj.books.utils.HttpUtil;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ActivitySearch extends ActionBarActivity implements
        SearchView.OnQueryTextListener,
        HttpCallback,
        AdapterView.OnItemClickListener{
    Toolbar mToolBar;
    SearchView mSearchView;
    ListView mListView;
    List<Book> list=new ArrayList<>();
    SearchListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        mToolBar= (Toolbar) findViewById(R.id.search_toolbar);
        setSupportActionBar(mToolBar);
        mListView= (ListView) findViewById(R.id.activity_search_lv);
        mAdapter=new SearchListAdapter(this,R.layout.search_lv_item,list);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_menu, menu);
        MenuItem searchItem=menu.findItem(R.id.search_menu_action_search);
       mSearchView= (SearchView) searchItem.getActionView();
        mSearchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        Log.i(AppControlor.TAG,"search submit");
        HttpUtil.searchBook(query,this);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    @Override
    public void onHttpResult(Object object) {
        Gson gson=new Gson();
        SearchResult result=gson.fromJson(object.toString(),SearchResult.class);
        list.clear();
        list.addAll(result.getBooks());
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Book book= (Book) adapterView.getItemAtPosition(i);

        Intent intent=new Intent(ActivitySearch.this,ActivityBook.class);
        Bundle bundle=new Bundle();
        bundle.putSerializable("book",book);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
