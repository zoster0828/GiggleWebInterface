package com.gigglelabs.article.gigglewebinterface.domain;

import com.gigglelabs.article.gigglewebinterface.application.ArticleRepositoryImpl;
import com.gigglelabs.article.gigglewebinterface.application.MysqlArticleAdapater;
import com.gigglelabs.article.gigglewebinterface.domain.domain.Article;
import com.gigglelabs.article.gigglewebinterface.domain.domain.ArticleRepository;
import com.gigglelabs.article.gigglewebinterface.mother.ArticleMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ArticleRepositoryTest {

    ArticleRepository sut;

    @BeforeEach
    void init() {
        sut = new ArticleRepositoryImpl(new MysqlArticleAdapater());
    }


    @Test
    @DisplayName("save에 성공하면 true를 반환한다")
    void test1() {
        boolean save = sut.save(ArticleMother.generate());

        assertTrue(save);
    }

    @Test
    @DisplayName("정해진 아이템 만큼 잘 가지고 온다.")
    void test2() {
        for (int i = 0; i < 10; i++) {
            sut.save(ArticleMother.generate());
        }

        List<Article> latests = sut.findLatests(5);

        assertThat(latests.size()).isEqualTo(5);
    }
}