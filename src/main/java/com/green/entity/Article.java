package com.green.entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;


@Entity
public class Article {
	//pk = @id
	//값을 자동으로 채움 @GeneratedValue
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String title;
	
	@Column
	private String content;

	
	
	//생성자
	public Article(Long id, String title, String content) {
		this.id = id;
		this.title = title;
		this.content = content;
	}
	
	//toString();
	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", content=" + content + "]";
	}



	
}
