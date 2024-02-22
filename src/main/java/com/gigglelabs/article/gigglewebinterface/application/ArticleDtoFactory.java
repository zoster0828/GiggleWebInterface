package com.gigglelabs.article.gigglewebinterface.application;


import com.gigglelabs.article.gigglewebinterface.domain.domain.Article;
import com.gigglelabs.article.gigglewebinterface.port.in.dto.ArticleDto;

public class ArticleDtoFactory {
    public static ArticleDto create(Article article) {
        return ArticleDto.builder()
                .id(article.getId())
                .title(article.getTitle())
                .url(article.getUrl())
                .site(article.getSites().name())
                .likes(article.getLikes())
                .views(article.getViews())
                .sourceLikes(article.getSourceLikes())
                .sourceViews(article.getSourceViews())
                .sourceDate(article.getSourceDate())
                .thumbnailUrl(article.getThumbnailUrl())
                .preText(article.getPreText())
                .build();
    }
}
