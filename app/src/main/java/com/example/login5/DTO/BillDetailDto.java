package com.example.login5.DTO;

public class BillDetailDto {
   private int billId;
   private int itemId;
   private int amount;

   public BillDetailDto() {
   }

   public BillDetailDto(int billId, int itemId, int amount) {
      this.billId = billId;
      this.itemId = itemId;
      this.amount = amount;
   }

   public void setBillId(int billId) {
      this.billId = billId;
   }

   public int getBillId() {
      return billId;
   }

   public void setItemId(int itemId) {
      this.itemId = itemId;
   }

   public int getItemId() {
      return itemId;
   }

   public int getAmount() {
      return amount;
   }

   public void setAmount(int amount) {
      this.amount = amount;
   }
}
