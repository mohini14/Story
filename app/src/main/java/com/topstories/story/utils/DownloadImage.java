package com.topstories.story.utils;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadImage extends AsyncTask<ImageView, Void, Bitmap> {

    private ImageView imageView;
    String url;

    @Override
    protected Bitmap doInBackground(ImageView... imageViews) {
        this.imageView = imageViews[0];
        return download_Image((String) imageView.getTag());
    }

    @Override
    protected void onPostExecute(Bitmap result) {
        imageView.setImageBitmap(result);
    }

    private Bitmap download_Image(String url) {

        Bitmap bmp = null;
        try {
            URL ulrn = new URL(url);
            HttpURLConnection con = (HttpURLConnection) ulrn.openConnection();
            InputStream is = con.getInputStream();
            bmp = BitmapFactory.decodeStream(is);
            if (null != bmp)
                return bmp;

        } catch (Exception e) {
            Log.d("Logging", e.getMessage());
        }
        return bmp;
    }
}