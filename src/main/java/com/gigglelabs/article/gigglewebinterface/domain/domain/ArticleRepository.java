package com.gigglelabs.article.gigglewebinterface.domain.domain;

import java.util.List;

public interface ArticleRepository {
    boolean save(Article article);

    List<Article> findLatests(int count);
}
