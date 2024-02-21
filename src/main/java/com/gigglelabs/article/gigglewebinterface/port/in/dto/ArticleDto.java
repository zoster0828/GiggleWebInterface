package com.gigglelabs.article.gigglewebinterface.port.in.dto;

import lombok.Builder;

@Builder
public class ArticleDto {
    public String id;
    public String title;
    public String url;
    public String site;
    public Long likes;
    public Long views;
    public Long sourceLikes;
    public Long sourceViews;
    public Long sourceDate;
    public String thumbnailUrl;
}
