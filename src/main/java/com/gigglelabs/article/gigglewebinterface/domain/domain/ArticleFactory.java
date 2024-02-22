package com.gigglelabs.article.gigglewebinterface.domain.domain;

import com.gigglelabs.article.gigglewebinterface.port.in.dto.ArticleDto;

public class ArticleFactory {
    public static Article create(ArticleDto articleDto) {
        return Article.builder()
                .id(articleDto.id)
                .title(articleDto.title)
                .url(articleDto.url)
                .sites(Sites.valueOf(articleDto.site))
                .likes(articleDto.likes)
                .views(articleDto.views)
                .sourceLikes(articleDto.sourceLikes)
                .sourceViews(articleDto.sourceViews)
                .sourceDate(articleDto.sourceDate)
                .thumbnailUrl(articleDto.thumbnailUrl)
                .preText(articleDto.preText)
                .build();
    }
}
