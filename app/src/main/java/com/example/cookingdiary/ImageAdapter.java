package com.example.cookingdiary;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.MyApplication;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.io.InputStream;
import java.util.ArrayList;

public class ImageAdapter extends PagerAdapter {

    private Context context;
    private ArrayList<String> inputStreams;

    public ImageAdapter(Context context, ArrayList<String> inputStreams) {
        this.context = context;
        this.inputStreams = inputStreams;
    }

    @Override
    public int getCount() {
        return inputStreams.size();
    }


    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }



    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ImageView) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        ImageView imageView = new ImageView(context);
        /*Glide.with(container)
                .asBitmap()
                .centerCrop()
                .load(bitmaps.get(position))
                .into(imageView);
        /*Drawable d = new BitmapDrawable(MyApplication.getAppContext().getResources(), bitmaps.get(position));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageDrawable(d);*/
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        UniversalImageLoader universalImageLoader = new UniversalImageLoader(MyApplication.getAppContext());
        ImageLoader.getInstance().init(universalImageLoader.getConfig());
        UniversalImageLoader.setImage(inputStreams.get(position), imageView, null);
        container.addView(imageView,0);
        return imageView;

    }
}
