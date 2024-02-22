package com.gigglelabs.article.gigglewebinterface.application;


import com.gigglelabs.article.gigglewebinterface.port.in.ArticlePersistencePort;
import com.gigglelabs.article.gigglewebinterface.port.in.dto.ArticleDto;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class MysqlArticleAdapater implements ArticlePersistencePort {
    private static final String URL = "jdbc:mysql://localhost:3306/giggle";
    private static final String USER = "gigglelabs";
    private static final String PASSWORD = "1234";

    @Override
    public int save(ArticleDto articleDto) {
        String sql = "INSERT INTO Articles (id, title, url, site, likes, views, sourceLikes, sourceViews, sourceDate, thumbnailUrl, preText) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, articleDto.id);
            pstmt.setString(2, articleDto.title);
            pstmt.setString(3, articleDto.url);
            pstmt.setString(4, articleDto.site);
            pstmt.setLong(5, articleDto.likes);
            pstmt.setLong(6, articleDto.views);
            pstmt.setLong(7, articleDto.sourceLikes);
            pstmt.setLong(8, articleDto.sourceViews);
            pstmt.setLong(9,  articleDto.sourceDate);
            pstmt.setString(10, articleDto.thumbnailUrl);
            pstmt.setString(11, articleDto.preText);

            return pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<ArticleDto> findLatests(int count) {
        List<ArticleDto> articles = new ArrayList<>();

        String query = "SELECT * FROM Articles ORDER BY sourceDate DESC LIMIT "+count;

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                ArticleDto articleDto =  ArticleDto.builder()
                        .id(resultSet.getString("id"))
                        .title(resultSet.getString("title"))
                        .url(resultSet.getString("url"))
                        .site(resultSet.getString("site"))
                        .likes(resultSet.getLong("likes"))
                        .views(resultSet.getLong("views"))
                        .sourceLikes(resultSet.getLong("sourceLikes"))
                        .sourceViews(resultSet.getLong("sourceViews"))
                        .sourceDate(resultSet.getLong("sourceDate"))
                        .thumbnailUrl(resultSet.getString("thumbnailUrl"))
                        .preText(resultSet.getString("preText"))
                        .build();

                articles.add(articleDto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return articles;
    }
}
