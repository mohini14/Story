package com.topstories.story.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;

import com.topstories.story.MyApplication;
import com.topstories.story.R;
import com.topstories.story.model.Story;

public class Gen {



    public static void showLoader(Activity activity) {
        ViewGroup view = (ViewGroup) activity.getWindow().getDecorView().getRootView();

        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View loader = activity.findViewById(R.id.loading_indicator);
        if (loader == null) {
            assert inflater != null;
            inflater.inflate(R.layout.loading_indicator, view, true);
            loader = activity.findViewById(R.id.loading_indicator);
        }
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        loader.setVisibility(View.VISIBLE);
    }

    public static void makeShortToast (Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static void hideLoader(Activity activity) {
        View loader = activity.findViewById(R.id.loading_indicator);
        if (loader != null) {
            loader.setVisibility(View.GONE);
        }
        activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
    }

    public static void startActivity(Intent intent, boolean clearStack) {
        if (clearStack) {
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        } else {
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        MyApplication.getAppContext().startActivity(intent);
    }

    public static void startActivity(Activity source, boolean clearStack, Class<?> destination) {
        Gen.hideLoader(source);
        Intent intent = new Intent(MyApplication.getAppContext(), destination);
        startActivity(intent, clearStack);
    }

    public static void startActivity(Activity source, boolean clearStack, Class<?> destination, String key, String value) {
        Gen.hideLoader(source);
        Intent intent = new Intent(MyApplication.getAppContext(), destination);
        Bundle bundle = new Bundle();
        bundle.putString(key, value);
        intent.putExtras(bundle);
        startActivity(intent, clearStack);
    }

    public static String numberToTextFormat(Double likes) {
        if (likes < 1000)
            return likes.toString();
        if (likes > 1000 && likes < 1000000)
            return String.format("%.2fK", likes/1000) ;
        else
            return String.format("%.2fM", likes/1000000) ;

    }
}
