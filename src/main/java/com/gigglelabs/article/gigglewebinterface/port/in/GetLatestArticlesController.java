package com.gigglelabs.article.gigglewebinterface.port.in;

import com.gigglelabs.article.gigglewebinterface.application.GetLatestArticlesUsecase;
import com.gigglelabs.article.gigglewebinterface.port.in.dto.ArticleDto;
import com.gigglelabs.article.gigglewebinterface.port.in.dto.ArticleView;
import com.gigglelabs.article.gigglewebinterface.port.in.dto.GetLatestArticleDtos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/articles")
public class GetLatestArticlesController {

    @Autowired
    private GetLatestArticlesUsecase getLatestArticlesUsecase;

    @GetMapping("/latest")
    public List<ArticleView> getLatestArticles(@RequestParam(defaultValue = "10") Integer count) {
        GetLatestArticleDtos getLatestArticleDtos = getLatestArticlesUsecase.execute(count);

        List<ArticleView> result = new ArrayList<>();
        for (ArticleDto articleDto : getLatestArticleDtos.list) {
            result.add(new ArticleView(articleDto));
        }

        return result;
    }
}