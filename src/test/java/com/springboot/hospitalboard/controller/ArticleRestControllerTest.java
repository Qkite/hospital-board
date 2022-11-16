package com.springboot.hospitalboard.controller;

import com.springboot.hospitalboard.domain.ArticleResponse;
import com.springboot.hospitalboard.domain.HospitalResponse;
import com.springboot.hospitalboard.service.ArticleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ArticleRestController.class)
class ArticleRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ArticleService articleService;

    @Test
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

}