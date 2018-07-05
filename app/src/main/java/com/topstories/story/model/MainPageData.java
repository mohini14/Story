package com.topstories.story.model;

import com.topstories.story.utils.AppStrings;

import java.util.ArrayList;
import java.util.List;

import io.bloco.faker.Faker;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MainPageData {

    private String category;
//    private String imageURL;
    private List<Story> stories;
    private static final Faker faker = new Faker();


    public ArrayList<MainPageData> getData() {
        ArrayList<MainPageData> mainPageList = new ArrayList<>();
        stories = new ArrayList<>();
        for (int i = 0; i < 10; i++) {

            MainPageData data = new MainPageData();
            data.category = faker.name.firstName();
            data.stories = createStories();
            mainPageList.add(data);
        }

        return mainPageList;
    }

    public List<Story> createStories(){

        List<Story> stories = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            stories.add(new Story());
        }
        return stories;
    }


    public String getCategory() {
        return category;
    }
}
