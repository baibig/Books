package com.baimax.hj.books.view;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.baimax.hj.books.R;
import com.baimax.hj.books.app.AppControlor;
import com.baimax.hj.books.app.LruBitmapCache;
import com.baimax.hj.books.model.Book;
import com.baimax.hj.books.model.Tag;

public class ActivityBook extends ActionBarActivity {

    Book book;
    NetworkImageView mNetworkImageView;
    TextView mTitle;
    TextView mAuthor;
    TextView mTime;
    TextView mPages;
    TextView mPress;
    TextView mISBN;
    TextView mPrice;
    TextView mRating;
    TextView mTag;
    TextView mSummary;
    TextView mCatalog;
    Button mButtonSee;
    FloatingActionButton mFABShare;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_book);
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        book= (Book) bundle.getSerializable("book");

        mNetworkImageView= (NetworkImageView) findViewById(R.id.cardview_bookinfo_pic);
        mTitle= (TextView) findViewById(R.id.cardview_bookinfo_tv_title);
        mAuthor= (TextView) findViewById(R.id.cardview_bookinfo_tv_author);
        mTime= (TextView) findViewById(R.id.cardview_bookinfo_tv_time);
        mPages= (TextView) findViewById(R.id.cardview_bookinfo_tv_papers);
        mPress= (TextView) findViewById(R.id.cardview_bookinfo_tv_press);
        mPrice= (TextView) findViewById(R.id.cardview_bookinfo_tv_price);
        mISBN= (TextView) findViewById(R.id.cardview_bookinfo_tv_isbn);
        mRating= (TextView) findViewById(R.id.cardview_bookinfo_tv_rating);
        mTag= (TextView) findViewById(R.id.cardview_bookinfo_tv_tag);


        mSummary= (TextView) findViewById(R.id.cardview_summary_tv_summary);

        mCatalog= (TextView) findViewById(R.id.cardview_bookcatalog_tv_catalog);

        mButtonSee= (Button) findViewById(R.id.cardview_bookinfo_btn_see);
        mFABShare= (FloatingActionButton) findViewById(R.id.activity_btn_share);

        ImageLoader imageLoader=new ImageLoader(AppControlor.getInstance().getRequestQueue(),new LruBitmapCache());
        mNetworkImageView.setImageUrl(book.getImages().getLarge(),imageLoader);

        mTitle.setText(book.getTitle());

        StringBuilder author=new StringBuilder();
        for (String s:book.getAuthor()){
            author.append(s).append("/");
        }
        author.deleteCharAt(author.length()-1);
        mAuthor.setText(author);
        mTime.setText(book.getPubdate());
        mPages.setText(book.getPages()+"页");
        mPress.setText(book.getPublisher());
        mISBN.setText(book.getIsbn10()+"/"+book.getIsbn13());
        mPrice.setText(book.getPrice());
        mRating.setText(book.getRating().getAverage()+"");
        StringBuilder tag=new StringBuilder();
        for (Tag s:book.getTags()){
            tag.append(s.getName()).append("/");
        }
        tag.deleteCharAt(tag.length()-1);
        mTag.setText(tag);

        mSummary.setText(book.getSummary());
        mCatalog.setText(book.getCatalog());

        mButtonSee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_book, menu);
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
}
