package com.example.login5.DTO;

public class ReviewDto {
   private int reviewId;
   private int userId;
   private String type;
   private int objectId;
   private int itemId;
   private int rating;
   private String comment;
   private String createdDate;
   private String updatedDate;

   public ReviewDto() {
   }

   public ReviewDto(int reviewId, int userId, String type, int objectId, int itemId, int rating, String comment, String createdDate, String updatedDate) {
      this.reviewId = reviewId;
      this.userId = userId;
      this.type = type;
      this.objectId = objectId;
      this.itemId = itemId;
      this.rating = rating;
      this.comment = comment;
      this.createdDate = createdDate;
      this.updatedDate = updatedDate;
   }

   public int getReviewId() {
      return reviewId;
   }

   public void setReviewId(int reviewId) {
      this.reviewId = reviewId;
   }

   public int getUserId() {
      return userId;
   }

   public void setUserId(int userId) {
      this.userId = userId;
   }

   public String getType() {
      return type;
   }

   public void setType(String type) {
      this.type = type;
   }

   public int getObjectId() {
      return objectId;
   }

   public void setObjectId(int objectId) {
      this.objectId = objectId;
   }

   public int getItemId() {
      return itemId;
   }

   public void setItemId(int itemId) {
      this.itemId = itemId;
   }

   public int getRating() {
      return rating;
   }

   public void setRating(int rating) {
      this.rating = rating;
   }

   public String getComment() {
      return comment;
   }

   public void setComment(String comment) {
      this.comment = comment;
   }

   public String getCreatedDate() {
      return createdDate;
   }

   public void setCreatedDate(String createdDate) {
      this.createdDate = createdDate;
   }

   public String getUpdatedDate() {
      return updatedDate;
   }

   public void setUpdatedDate(String updatedDate) {
      this.updatedDate = updatedDate;
   }
}
