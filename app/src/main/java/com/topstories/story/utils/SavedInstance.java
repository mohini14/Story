package com.topstories.story.utils;

import com.topstories.story.model.Story;

import java.util.List;

public class SavedInstance {

    private static SavedInstance instance ;

    public Story selectedStory;
    public List<Story> selectedStories;

    private SavedInstance(){

    }

    public static SavedInstance getInstance(){
        if (instance == null){
            instance = new SavedInstance();
        }
        return instance;
    }

}
