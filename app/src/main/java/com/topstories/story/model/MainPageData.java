package com.topstories.story.model;

import com.topstories.story.utils.AppStrings;
import com.topstories.story.utils.Gen;

import org.joda.time.DateTime;

import java.text.MessageFormat;
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
        long start = DateTime.now().getMillis();
        ArrayList<MainPageData> mainPageList = new ArrayList<>();
        stories = new ArrayList<>();
        for (int i = 0; i < 10; i++) {

            MainPageData data = new MainPageData();
            data.category = faker.name.firstName();
            data.stories = createStories();
            mainPageList.add(data);
        }
        long end = DateTime.now().getMillis();

        Gen.log(MessageFormat.format("Total time to create 100 stories is {0} Millis", end-start));

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
