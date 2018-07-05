package com.topstories.story.utils;

import com.topstories.story.model.Story;

public class SavedInstance {

    private static SavedInstance instance ;

    public Story selectedStory;

    private SavedInstance(){

    }

    public static SavedInstance getInstance(){
        if (instance == null){
            instance = new SavedInstance();
        }
        return instance;
    }
}
