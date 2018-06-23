package com.topstories.story.model;

import com.topstories.story.utils.AppStrings;

import java.util.ArrayList;

import io.bloco.faker.Faker;

public class MainPageData {

    String category;
    String imageURL;
    ArrayList<String> imageURLList;

    public ArrayList<String> getImageURLList() {
        return imageURLList;
    }

    public void setImageURLList(ArrayList<String> imageURLList) {
        this.imageURLList = imageURLList;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public ArrayList<MainPageData> getData() {
        ArrayList<MainPageData> mainPageData = new ArrayList<>();
        Faker faker = new Faker();
        imageURLList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {

            MainPageData data = new MainPageData();
            data.category = faker.name.firstName();
            data.imageURLList = getImages(faker);
            mainPageData.add(data);
        }

        return mainPageData;
    }

    private ArrayList<String> getImages(Faker faker) {
        ArrayList<String> images = new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            imageURL = AppStrings.getRandomImages();
            images.add(imageURL);
        }
        return images;
    }


}
