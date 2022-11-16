package com.springboot.hospitalboard.controller;

import com.springboot.hospitalboard.domain.ArticleAddRequest;
import com.springboot.hospitalboard.domain.ArticleAddResponse;
import com.springboot.hospitalboard.domain.ArticleResponse;
import com.springboot.hospitalboard.domain.HospitalResponse;
import com.springboot.hospitalboard.service.ArticleService;
import com.springboot.hospitalboard.service.HospitalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/articles")
public class ArticleRestController {

    private final ArticleService articleService;


    public ArticleRestController(ArticleService articleService) {
        this.articleService = articleService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<ArticleResponse> get(@PathVariable Long id){
        ArticleResponse articleResponse = articleService.getArticle(id);

        return ResponseEntity.ok().body(articleResponse);
    }

    @PostMapping("/add")
    public ResponseEntity<ArticleAddResponse> addArticle(@RequestBody ArticleAddRequest articleAddRequest){
        ArticleAddResponse articleResponse = articleService.addArticle(articleAddRequest);
        return ResponseEntity.ok().body(articleResponse);
    }

}
