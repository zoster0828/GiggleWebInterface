package com.gigglelabs.article.gigglewebinterface.port.in;


import com.gigglelabs.article.gigglewebinterface.port.in.dto.ArticleDto;

import java.util.List;

public interface ArticlePersistencePort {
    int save(ArticleDto articleDto);
    List<ArticleDto> findLatests(int count);
}
