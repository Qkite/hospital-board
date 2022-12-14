package com.springboot.hospitalboard.controller;

import com.springboot.hospitalboard.domain.Article;
import com.springboot.hospitalboard.domain.dto.ArticleDto;
import com.springboot.hospitalboard.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/sample-board")
@Slf4j
public class ArticleController {

    private final ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }


    @GetMapping("")
    public String firstDisplay(){
        return "redirect:/sample-board/list";
    }


    @GetMapping("/list")
    public String list(Model model){
        List<Article> articleList = articleRepository.findAll();
        model.addAttribute("article", articleList);


        return "list";
    }

    @GetMapping("/write")
    public String write(){
        return "write";
    }

    @GetMapping("/list/{id}")
    public String findById(@PathVariable Long id, Model model){
        Optional<Article> findedContent = articleRepository.findById(id);
        if (!findedContent.isEmpty()) {
            model.addAttribute("article", findedContent.get());
            return "show";
        } else {
            return "error";
        }
    }

    @GetMapping("/list/{id}/delete")
    public String deleteById(@PathVariable Long id, ArticleDto articleDto){

        articleRepository.deleteById(id);

        return "redirect:/sample-board/list";
    }

    @GetMapping("/list/{id}/edit")
    public String edit(@PathVariable Long id, Model model){
        Optional<Article> articleOptional = articleRepository.findById(id);

        if (!articleOptional.isEmpty()) {
            model.addAttribute("article", articleOptional.get());
            // addAttribute??? ????????? ????????? ????????? view??? ????????? ??? ??????
            return "edit";
        } else {
            model.addAttribute("message", String.format("%d ??? ????????????.", id));
            return "error";
        }
    }


    @PostMapping("/write")
    public String writeContent(ArticleDto articleDto){
        // id??? null??? ?????? -> database??? ???????????? DB ???????????? id??? ???????????? -> ???????????? ??????????????? getId()??? ???????????? ?????? ????????????
        log.info("id: {}, title: {}, content: {}", String.valueOf(articleDto.getId()), articleDto.getTitle(), articleDto.getContent());
        Article savedArticle = articleDto.toEntity();
        articleRepository.save(savedArticle);
        return "list";
    }

    @PostMapping("/list/{id}/update")
    public String editContent(@PathVariable Long id, ArticleDto articleDto, Model model){
        Article article = articleRepository.save(articleDto.toEntity(id));
        model.addAttribute("article", article);
        return "redirect:/sample-board/list";
    }


}