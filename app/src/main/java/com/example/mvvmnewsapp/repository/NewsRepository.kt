package com.example.mvvmnewsapp.repository

import com.example.mvvmnewsapp.database.ArticleDataBase
import com.example.mvvmnewsapp.model.Article
import com.example.mvvmnewsapp.network.RetrofitInstance

class NewsRepository (val db : ArticleDataBase){

    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber )

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    fun getSavedNews() = db .getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)
}