package com.ljw.web.weixin.pojo;

import java.util.List;

/**
 * Created by Linity on 2017/3/6.
 */
public class NewsMessage extends BaseMessage {

    private int ArticleCount;
    private List<News> Articles;
    public int getArticleCount() {
        return ArticleCount;
    }

    public void setArticleCount(int articleCount) {
        this.ArticleCount = articleCount;
    }

    public List<News> getArticles() {
        return Articles;
    }

    public void setArticles(List<News> articles) {
        this.Articles = articles;
    }
}
