package com.springboot.hospitalboard.repository;

import com.springboot.hospitalboard.domain.Article;
import com.springboot.hospitalboard.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}
