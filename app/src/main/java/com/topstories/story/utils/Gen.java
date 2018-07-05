package com.topstories.story.utils;

import android.content.Context;
import android.widget.Toast;

public class Gen {

    public static void makeShortToast (Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();

    }
}
