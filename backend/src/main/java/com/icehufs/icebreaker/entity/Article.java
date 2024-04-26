package com.icehufs.icebreaker.entity;


import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import javax.persistence.Column; //최근 버전에서는 import jakarta.persistence.~
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.icehufs.icebreaker.dto.request.article.PostArticleRequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Entity(name = "article")
@Table(name = "article")
public class Article {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB가 id 자동 생성
    @Column(name = "article_num")
    private int article_num;
    // 외래키 User 테이블의 컬럼명: email, 다대일 관계 설정.
    @Column(name = "user_email")
    private String user_email;

    @Column(name = "article_title")
    private String article_title;

    @Column(name = "article_content")
    private String article_content;

    @Column(name = "like_count")
    private int like_count;

    @Column(name = "view_count")
    private int view_count;

    @Column(name = "article_date")
    private String article_date;

    @Column(name = "auth_check")
    private int auth_check;

    @Column(name = "category")
    private int category;

    public Article(PostArticleRequestDto dto, String email){
        Date now = Date.from(Instant.now());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String writeDatetime = simpleDateFormat.format(now);

        this.user_email = email;
        this.article_title = dto.getArticle_title();
        this.article_content = dto.getArticle_content();
        this.like_count = 0;
        this.view_count = 0;
        this.article_date = writeDatetime;
        this.auth_check = 0;
        this.category = dto.getCategory();
    }

    // 게시글 수정을 위한 코드
    //public void patch(Article article) {
    //    if (article.title != null)
    //        this.title = article.title;
    //    if (article.content != null)
    //        this.content = article.content;
    //}
}