package com.gigglelabs.article.gigglewebinterface.application;

import com.gigglelabs.article.gigglewebinterface.domain.domain.Article;
import com.gigglelabs.article.gigglewebinterface.domain.domain.ArticleFactory;
import com.gigglelabs.article.gigglewebinterface.domain.domain.ArticleRepository;
import com.gigglelabs.article.gigglewebinterface.port.in.ArticlePersistencePort;
import com.gigglelabs.article.gigglewebinterface.port.in.dto.ArticleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ArticleRepositoryImpl implements ArticleRepository {
    private final ArticlePersistencePort articlePersistencePort;
    @Override
    public boolean save(Article article) {
        ArticleDto articleDto = ArticleDtoFactory.create(article);
        try {
            int resultCount = articlePersistencePort.save(articleDto);
            return resultCount > 0 ;
        } catch(Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }

    @Override
    public List<Article> findLatests(int count) {
        List<ArticleDto> articleDtos = articlePersistencePort.findLatests(count);

        List<Article> articles = new ArrayList<>();
        for (ArticleDto articleDto : articleDtos) {
            Article article = ArticleFactory.create(articleDto);
            articles.add(article);
        }

        return articles;
    }
}
