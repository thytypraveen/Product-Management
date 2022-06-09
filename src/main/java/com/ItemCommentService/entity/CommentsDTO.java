package com.ItemCommentService.entity;

public class CommentsDTO {
	 private long commentId;
		private String comments; 
		private Item item;
		private Long userId;
		public long getCommentId() {
			return commentId;
		}
		public void setCommentId(long commentId) {
			this.commentId = commentId;
		}
		public String getComments() {
			return comments;
		}
		public void setComments(String comments) {
			this.comments = comments;
		}
		public Item getItem() {
			return item;
		}
		public void setItem(Item item) {
			this.item = item;
		}
		public Long getUserId() {
			return userId;
		}
		public void setUserId(Long userId) {
			this.userId = userId;
		}
		

}
