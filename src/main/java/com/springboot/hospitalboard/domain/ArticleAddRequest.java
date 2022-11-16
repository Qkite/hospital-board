package com.springboot.hospitalboard.domain;

import lombok.Getter;

@Getter
public class ArticleAddRequest {

    private String title;
    private String content;

    public ArticleAddRequest(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Article toEntity(){
        Article article = Article.builder()
                .title(this.title)
                .content(this.content)
                .build();

        return article;
    }
}
