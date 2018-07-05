package com.topstories.story.model;

import com.topstories.story.utils.AppStrings;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import io.bloco.faker.Faker;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class Story {

    private static final Faker faker = new Faker();
    private String thumbNailUrl;
    private String category;
    private String title;
    private String description;
    private Integer likes;
    private Integer loved;
    private Integer dislikes;
    private Integer views;
    private List<String> tags;
    private Date createdAt;
    private String author;

    public Story(){
        thumbNailUrl = AppStrings.getRandomImageUrl();
        category = faker.book.genre();
        title = faker.book.title();
        description = faker.lorem.sentence(30);
        likes = (int) (Math.random() * 10000);
        loved = (int) (Math.random() * 10000);
        dislikes = (int) (Math.random() * 10000);
        views = (int) (Math.random() * 10000);
        tags = Arrays.asList(faker.team.name(), faker.team.name(), faker.team.name());
        createdAt = faker.date.backward();
        author = faker.name.name();
    }


}
