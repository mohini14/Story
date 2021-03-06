package com.topstories.story.utils;

public class AppStrings {

    public static final String FAKER_JAVA_URL = "https://picsum.photos/50/50";

    private static int getRandom(int Min, int Max){
        return Min + (int)(Math.random() * ((Max - Min) + 1));
    }
    public static  String getRandomImageUrl() {
        return "https://picsum.photos/" + getRandom(100, 200) + "/" + getRandom(100, 200) + "/";
    }

    public static  String getRandomImageUrl(int min, int max) {
        return "https://picsum.photos/" + getRandom(min, max) + "/" + getRandom(100, 200) + "/";
    }
}
