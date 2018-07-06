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
    private List<String> languages;

    public Story(){
        thumbNailUrl = AppStrings.getRandomImageUrl();
        mainImageUrl = AppStrings.getRandomImageUrl(600,800);
        category = faker.book.genre();
        title = "दिल्ली के लड़के की यह अजीब कहानी";
        description = "मैं उस बिजली संयंत्र में काम करता था। किसी भी अन्य कार्यकर्ता की तरह, हर दिन मैं अपने शरीर के साथ राख में आ गया घर लौट आया। अधिकारी फर्नेस में कभी नहीं आएंगे; उनके पास उनके सेबिन बहुत दूर थे। मैं बहुत बार बीमार पड़ता हूं और श्वसन समस्याओं को शुरू करता हूं। यही वह वक्त था जब मैंने उस नौकरी को छोड़ने का फैसला किया, और एक कूरियर डिलीवरी व्यक्ति के रूप में काम करना शुरू कर दिया। लेकिन फिर, हमारी कॉलोनी बिजली संयंत्र के बगल में भी है। यदि आप मेरी छत पर आएंगे, तो आप उस पर जमा राख की एक परत देखेंगे। हम हवा में राख भी गंध कर सकते हैं। हम या तो बाहर नहीं जा सकते हैं। मेरा बड़ा भाई अभी भी संयंत्र में काम कर रहा है। वे कहते हैं कि वे इसे जल्द से जल्द बंद करने जा रहे हैं। जब ऐसा होता है तो हम शायद गांव वापस आ जाएंगे, लेकिन निश्चित रूप से यहां नहीं रहेंगे।";
//        description = faker.lorem.sentence(100) + ".\n\n" + faker.lorem.sentence(100) + ".\n\n" + faker.lorem.sentence(100);
        likes = (int) (Math.random() * 10000);
        loved = (int) (Math.random() * 10000);
        dislikes = (int) (Math.random() * 10000);
        views = (int) (Math.random() * 10000);
        tags = Arrays.asList(faker.team.name(), faker.team.name(), faker.team.name());
        generes = Arrays.asList(faker.book.genre(), faker.book.genre(), faker.book.genre());
        createdAt = new DateTime(faker.date.backward().getTime());
        author = faker.name.name();
        languages = Arrays.asList("Hindi", "English", "Tamil", "Malyalam");
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
