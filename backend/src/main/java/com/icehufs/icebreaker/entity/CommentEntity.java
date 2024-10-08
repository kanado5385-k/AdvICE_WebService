package com.icehufs.icebreaker.entity;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import com.icehufs.icebreaker.dto.request.article.PatchCommentRequestDto;
import com.icehufs.icebreaker.dto.request.article.PostCommentRequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="comment")
@Table(name="comment")
public class CommentEntity {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentNumber;
    private String content;
    private String writeDatetime;
    private String userEmail;
    private int articleNum;

    public void patchComment(PatchCommentRequestDto dto){
        this.content = dto.getContent();
    }

    public CommentEntity(PostCommentRequestDto dto, Integer articleNum, String email){

        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String writeDatetime = now.format(formatter);

        this.content = dto.getContent();
        this.writeDatetime = writeDatetime;
        this.userEmail = email;
        this.articleNum = articleNum;

    }
}
