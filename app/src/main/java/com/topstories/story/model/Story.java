package com.topstories.story.model;

import com.topstories.story.utils.AppStrings;
import com.topstories.story.utils.Gen;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

import java.text.MessageFormat;
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
    private String mainImageUrl;
    private String category;
    private String title;
    private String description;
    private Integer likes;
    private Integer loved;
    private Integer dislikes;
    private Integer views;
    private List<String> tags;
    private List<String> generes;
    private DateTime createdAt;
    private String author;

    public Story(){
        thumbNailUrl = AppStrings.getRandomImageUrl();
        mainImageUrl = AppStrings.getRandomImageUrl(600,800);
        category = faker.book.genre();
        title = faker.book.title();
        description = faker.lorem.sentence(100) + ".\n\n" + faker.lorem.sentence(100) + ".\n\n" + faker.lorem.sentence(100);
        likes = (int) (Math.random() * 10000);
        loved = (int) (Math.random() * 10000);
        dislikes = (int) (Math.random() * 10000);
        views = (int) (Math.random() * 10000);
        tags = Arrays.asList(faker.team.name(), faker.team.name(), faker.team.name());
        generes = Arrays.asList(faker.book.genre(), faker.book.genre(), faker.book.genre());
        createdAt = new DateTime(faker.date.backward().getTime());
        author = faker.name.name();
    }

    public String getGeneresText(){
        return StringUtils.join(generes, ", ");
    }

    public String getAuthorBioText(){
        return MessageFormat.format("By {0} in {1}", author, createdAt.getYear());
    }


    public String getDescription() {
        return description + "\n\n\n";
    }

    public String likesCountText() {
        return Gen.numberToTextFormat(Double.valueOf(likes));
    }

    public String dislikesCountText(){
        return Gen.numberToTextFormat(Double.valueOf(dislikes));
    }

    public String lovedCountText(){
        return Gen.numberToTextFormat(Double.valueOf(loved));
    }

    public String viewsCountText(){
        return Gen.numberToTextFormat(Double.valueOf(views));
    }
}
