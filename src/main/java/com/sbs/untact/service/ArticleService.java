package com.sbs.untact.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sbs.untact.dto.Article;
import com.sbs.untact.dto.ResultData;
import com.sbs.untact.util.Util;

@Service
public class ArticleService {
	private List<Article> articles;
	private int articlesLastId;

	public ArticleService() {
		articlesLastId = 0;
		articles = new ArrayList<>();

		articles.add(new Article(++articlesLastId, "2021-02-02 12:12:12", "2021-02-02 12:12:12", "제목1", "내용1"));
		articles.add(new Article(++articlesLastId, "2021-02-02 12:12:12", "2021-02-02 12:12:12", "제목2", "내용2"));
	}

	public Article getArticle(int id) {
		for (Article article : articles) {
			if (article.getId() == id) {
				return article;
			}
		}
		return null;
	}

	public List<Article> getArticles(String searchKeywordType, String searchKeyword) {
		if (searchKeyword == null) {
			return articles;
		}

		List<Article> filtered = new ArrayList<>();

		for (Article article : articles) {
			boolean contains = false;

			if (searchKeywordType.equals("title")) {
				contains = article.getTitle().contains(searchKeyword);
			} else if (searchKeywordType.equals("body")) {
				contains = article.getBody().contains(searchKeyword);
			} else {
				contains = article.getTitle().contains(searchKeyword);

				if (contains == false) {
					contains = article.getBody().contains(searchKeyword);
				}
			}
			if (contains) {
				filtered.add(article);
			}
		}
		return filtered;
	}

	public ResultData add(String title, String body) {
		int id = ++articlesLastId;
		String regDate = Util.getNowDateStr();
		String updateDate = Util.getNowDateStr();

		articles.add(new Article(id, regDate, updateDate, title, body));

		return new ResultData("S-1", "성공", "id", id);
	}

	public ResultData delete(int id) {
		for (Article article : articles) {
			if (article.getId() == id) {
				articles.remove(article);
				return new ResultData("S-1", "글이 삭제되었습니다.", "id", id);
			}
		}
		return new ResultData("F-1", "해당 게시물은 존재하지않습니다.", "id", id);
	}

	public ResultData modify(int id, String title, String body) {
		Article article = getArticle(id);

		article.setUpdateDate(Util.getNowDateStr());
		article.setTitle(title);
		article.setBody(body);

		return new ResultData("S-1", "글이 수정되었습니다.", "id", id);

	}

}
