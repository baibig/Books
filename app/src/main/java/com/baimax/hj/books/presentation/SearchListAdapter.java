package com.baimax.hj.books.presentation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.baimax.hj.books.R;
import com.baimax.hj.books.app.AppControlor;
import com.baimax.hj.books.model.Book;

import java.util.List;

/**
 * Created by HJ on 2015/6/2.
 */
public class SearchListAdapter extends ArrayAdapter {
    int resource;
    ImageLoader mImageLoader;

    public SearchListAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
        this.resource=resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        Book book= (Book) getItem(position);
        if (convertView==null){
            LayoutInflater inflater=LayoutInflater.from(getContext());
            convertView=inflater.inflate(resource,null);
            viewHolder=new ViewHolder();
            viewHolder.mImg= (NetworkImageView) convertView.findViewById(R.id.search_item_img);
            viewHolder.mTitle= (TextView) convertView.findViewById(R.id.search_item_name);
            viewHolder.mTime= (TextView) convertView.findViewById(R.id.search_item_year);
            viewHolder.mPrice= (TextView) convertView.findViewById(R.id.search_item_price);
            viewHolder.mRating= (TextView) convertView.findViewById(R.id.search_item_rating);
            viewHolder.mComments= (TextView) convertView.findViewById(R.id.search_item_comments);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        mImageLoader= AppControlor.getInstance().getImageLoader();
        viewHolder.mImg.setImageUrl(book.getImage(),mImageLoader);
        viewHolder.mTitle.setText(book.getTitle());
        viewHolder.mTime.setText(book.getPubdate());
        viewHolder.mPrice.setText(book.getPrice());
        viewHolder.mRating.setText(book.getRating().getAverage()+"分");
        viewHolder.mComments.setText("( "+book.getRating().getNumRaters()+" 人)评论");
        return convertView;
    }
    class ViewHolder{
        NetworkImageView mImg;
        TextView mTitle;
        TextView mTime;
        TextView mPrice;
        TextView mRating;
        TextView mComments;
    }
}
