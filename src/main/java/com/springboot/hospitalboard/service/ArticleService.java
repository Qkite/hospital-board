package com.springboot.hospitalboard.service;

import com.springboot.hospitalboard.domain.*;
import com.springboot.hospitalboard.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Optional;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }


    public ArticleResponse getArticle(Long id){

        Optional<Article> articleOptional = articleRepository.findById(id);
        Article article = articleOptional.get();
        ArticleResponse articleResponse = Article.of(article);
        return articleResponse;
    }

    public ArticleAddResponse addArticle(ArticleAddRequest articleAddRequest) {
        Article article = articleAddRequest.toEntity();
        Article savedArticle = articleRepository.save(article);

        ArticleAddResponse articleAddResponse = new ArticleAddResponse(savedArticle.getId(), savedArticle.getTitle(), savedArticle.getContent());

        return articleAddResponse;
    }
}
