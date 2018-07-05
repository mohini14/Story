package com.topstories.story.model;

import com.topstories.story.utils.AppStrings;

import java.util.ArrayList;

import io.bloco.faker.Faker;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MainPageData {

    private String category;
    private String imageURL;
    private ArrayList<String> imageURLList;
    private ArrayList<String> descriptionList;
    private static final Faker faker = new Faker();

    public ArrayList<String> getImageURLList() {
        return imageURLList;
    }

    public ArrayList<MainPageData> getData() {
        ArrayList<MainPageData> mainPageList = new ArrayList<>();
        imageURLList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {

            MainPageData data = new MainPageData();
            data.category = faker.name.firstName();
            data.imageURLList = getImages(faker);
            data.descriptionList = getDescriptions(faker);
            mainPageList.add(data);
        }

        return mainPageList;
    }

    private ArrayList<String> getImages(Faker faker) {
        ArrayList<String> images = new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            imageURL = AppStrings.getRandomImages();
            images.add(imageURL);
        }
        return images;
    }

    private ArrayList<String> getDescriptions(Faker faker){
        ArrayList<String> descriptions = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            descriptions.add(faker.lorem.sentence(3));
        }
        return descriptions;
    }


}
