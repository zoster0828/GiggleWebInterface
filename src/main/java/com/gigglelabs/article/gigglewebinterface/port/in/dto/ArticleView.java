package com.gigglelabs.article.gigglewebinterface.port.in.dto;

public class ArticleView {
    public String id;
    public String title;
    public String url;
    public String site;
    public Long likes;
    public Long views;
    public Long date;
    public String thumbnailUrl;
    public String preText;
    public ArticleView(ArticleDto articleDto) {
        this.id = articleDto.id;
        this.title = articleDto.title;
        this.url = articleDto.url;
        this.site = articleDto.site;
        this.likes = articleDto.sourceLikes;
        this.views = articleDto.sourceViews;
        this.date = articleDto.sourceDate;
        this.thumbnailUrl = articleDto.thumbnailUrl;
        this.preText = articleDto.preText;
    }
}
