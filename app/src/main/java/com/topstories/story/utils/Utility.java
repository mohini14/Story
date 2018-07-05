package com.topstories.story.utils;

public class Utility {

    private static int getRandom(int Min, int Max){
        return Min + (int)(Math.random() * ((Max - Min) + 1));
    }
    public static  String getRandomImages() {
        return "https://picsum.photos/" + getRandom(100, 200) + "/" + getRandom(100, 200) + "/";
    }
}
