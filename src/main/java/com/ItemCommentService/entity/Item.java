package com.ItemCommentService.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name ="Item")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long itemId;
	private  String title;
	private String Description;
	@OneToMany(mappedBy="item",cascade = CascadeType.ALL)
	private Set<Comments> comments;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id", nullable = false) 
	private User user;
	public User getUser() {
		return user;
	}
	
	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Set<Comments> getComments() {
		return comments;
	}

	public void setComments(Set<Comments> comments) {
		this.comments = comments;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

	public Item() {
		super();
	}

	public Item(long itemId, String title, String description, Set<Comments> comments, User user) {
		super();
		this.itemId = itemId;
		this.title = title;
		Description = description;
		this.comments = comments;
		this.user = user;
	}
	
	
	
	
}
