package com.gigglelabs.article.gigglewebinterface.application;

import com.gigglelabs.article.gigglewebinterface.domain.domain.Article;
import com.gigglelabs.article.gigglewebinterface.domain.domain.ArticleRepository;
import com.gigglelabs.article.gigglewebinterface.port.in.dto.ArticleDto;
import com.gigglelabs.article.gigglewebinterface.port.in.dto.GetLatestArticleDtos;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetLatestArticlesUsecase {

    private final ArticleRepository articleRepository;

    public GetLatestArticleDtos execute(int count) {
        List<Article> articles = articleRepository.findLatests(count);

        GetLatestArticleDtos getLatestArticleDtos = new GetLatestArticleDtos();
        for (Article article : articles) {
            ArticleDto articleDto = ArticleDtoFactory.create(article);
            getLatestArticleDtos.add(articleDto);
        }

        return getLatestArticleDtos;
    }
}
