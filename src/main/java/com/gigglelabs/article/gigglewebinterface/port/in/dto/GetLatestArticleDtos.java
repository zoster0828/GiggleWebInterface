package com.gigglelabs.article.gigglewebinterface.port.in.dto;

import java.util.ArrayList;
import java.util.List;

public class GetLatestArticleDtos {
    public List<ArticleDto> list;

    public GetLatestArticleDtos() {
        list = new ArrayList<>();
    }

    public void add(ArticleDto articleDto) {
        list.add(articleDto);
    }
}
