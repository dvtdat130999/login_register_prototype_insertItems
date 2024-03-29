package com.example.login5.DTO;

public class DiscountDto {
   private int discountId;
   private int itemId;
   private double percentage;
   private String description;
   private String startDate;
   private String endDate;

   public DiscountDto() {}

   public DiscountDto(int discountId, int itemId, double percentage, String description, String startDate, String endDate) {
      this.discountId = discountId;
      this.itemId = itemId;
      this.percentage = percentage;
      this.description = description;
      this.startDate = startDate;
      this.endDate = endDate;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public double getPercentage() {
      return percentage;
   }

   public int getDiscountId() {
      return discountId;
   }

   public int getItemId() {
      return itemId;
   }

   public String getEndDate() {
      return endDate;
   }

   public String getStartDate() {
      return startDate;
   }

   public void setDiscountId(int discountId) {
      this.discountId = discountId;
   }

   public void setEndDate(String endDate) {
      this.endDate = endDate;
   }

   public void setItemId(int itemId) {
      this.itemId = itemId;
   }

   public void setPercentage(double percentage) {
      this.percentage = percentage;
   }

   public void setStartDate(String startDate) {
      this.startDate = startDate;
   }
}
