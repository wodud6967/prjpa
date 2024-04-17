package com.green.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.green.dto.ArticleDto;
import com.green.entity.Article;
import com.green.repository.ArticleRepository;

@Controller
public class ArticleController {
	
	@Autowired
	private ArticleRepository articleRepository;
		
	@GetMapping("/articles/WriteForm")
	public String writeForm() {
		
		return "articles/write";
	}
	
	@PostMapping("/articles/Write") //405에러 : method = "post" - > @GetMapping
	public String write(ArticleDto articleDto) {
		System.out.println(articleDto);
		//db에 저장 h2 article 테이블에 저장
		//Entity : db의 테이블이다.
		//1. Dto -> Entity
		Article article = articleDto.toEntity();
		//2. 리포지터리로 엔티티을 보내서 저장
		Article saved = articleRepository.save(article)
		return "redirect:/articles/List";
	}
}
