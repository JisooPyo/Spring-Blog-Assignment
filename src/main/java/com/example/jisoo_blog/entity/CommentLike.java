package com.example.jisoo_blog.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "commentLikes")
public class CommentLike {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="userId")
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="commentId")
	private Comment comment;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="postId")
	private Post post;

	public CommentLike(User user, Comment comment, Post post){
		this.user = user;
		this.comment = comment;
		this.post = post;
	}
}
