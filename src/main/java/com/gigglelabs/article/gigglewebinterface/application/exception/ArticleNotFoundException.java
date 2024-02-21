package com.gigglelabs.article.gigglewebinterface.application.exception;

public class ArticleNotFoundException extends RuntimeException {
    public ArticleNotFoundException(String id) {
        super(id);
    }
}
