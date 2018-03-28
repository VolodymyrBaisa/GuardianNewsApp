package com.volodymyrbaisa.guardiannewsapp.data.source;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.annotation.DrawableRes;
import android.widget.ImageView;

import com.volodymyrbaisa.guardiannewsapp.util.ImageUtils;

import java.net.URL;

import javax.inject.Inject;

/**
 * Created by Volodymyr on 3/15/2018.
 */

public class DownloadImageTask {
    private int mRes;


    @Inject
    public DownloadImageTask() {
    }

    public void downloadImage(ImageView imageView, URL url) {
        ImageTask imageTask = new ImageTask();
        imageTask.setImageView(imageView);
        imageTask.execute(url);
    }

    public void setPlaceholder(@DrawableRes int res) {
        mRes = res;
    }

    private class ImageTask extends AsyncTask<URL, Void, Bitmap> {
        private ImageView mImageView;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            if (mRes != 0) {
                mImageView.setImageDrawable(null);
                mImageView.setImageDrawable(mImageView.getResources().getDrawable(mRes));
            }
        }

        @Override
        protected Bitmap doInBackground(URL... url) {
            return ImageUtils.getBitmap(url[0]);
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            mImageView.setImageBitmap(bitmap);
        }

        private void setImageView(ImageView imageView){
            mImageView = imageView;
        }
    }
}
