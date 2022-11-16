package com.springboot.hospitalboard.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.hospitalboard.domain.ArticleAddRequest;
import com.springboot.hospitalboard.domain.ArticleAddResponse;
import com.springboot.hospitalboard.domain.ArticleResponse;
import com.springboot.hospitalboard.domain.HospitalResponse;
import com.springboot.hospitalboard.domain.dto.ArticleDto;
import com.springboot.hospitalboard.repository.ArticleRepository;
import com.springboot.hospitalboard.service.ArticleService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ArticleRestController.class)
class ArticleRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    ArticleService articleService;

    @Test
    @DisplayName("reponse가 잘 오는지 확인")
    void test1() throws Exception {
        ArticleResponse articleResponse = ArticleResponse.builder()
                .id(1L)
                .content("첫번째게시글입니다")
                .title("1번")
                .build();

        given(articleService.getArticle((long)1)).willReturn(articleResponse);

        long articleId = 1;

        String url = String.format("/api/v1/articles/%d", articleId);
        mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.title").value("1번"))
                .andExpect(jsonPath("$.content").value("첫번째게시글입니다"))
                .andDo(print());

        verify(articleService).getArticle(articleId);

    }

    @Test
    @DisplayName("데이터를 잘 생성하는지 확인")
    void test2() throws Exception {
        ArticleAddRequest articleAddRequest = new ArticleAddRequest("제목", "내용");

        given(articleService.addArticle(articleAddRequest))
                .willReturn(new ArticleAddResponse(1L, articleAddRequest.getTitle(), articleAddRequest.getContent()));

        mockMvc.perform(post("/api/v1/articles/add").content(objectMapper.writeValueAsBytes(articleAddRequest))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.title").value("제목"))
                .andExpect(jsonPath("$.content").value("내용"))
                .andDo(print());

        verify(articleService).addArticle(articleAddRequest);







    }

}