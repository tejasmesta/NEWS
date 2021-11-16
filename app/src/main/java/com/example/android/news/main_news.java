package com.example.android.news;

import java.util.ArrayList;

public class main_news {
    private String status;
    private String totalResults;
    private ArrayList<ModelClass> articles;

    public main_news(String status,String totalResults,ArrayList<ModelClass> articles)
    {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public ArrayList<ModelClass> getArticles() {
        return articles;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setArticles(ArrayList<ModelClass> articles) {
        this.articles = articles;
    }
}
