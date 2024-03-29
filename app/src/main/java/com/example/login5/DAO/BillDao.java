package com.example.login5.DAO;


import com.example.login5.DTO.BillDto;
import com.example.login5.Utils.Database;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BillDao {

    public BillDao() {
    }

    public static List<BillDto> SelectAll(){
        List<BillDto> bill = new ArrayList<>();
        String sql = "select * from Bill";
        try {
            ResultSet rs = Database.SelectQuery(sql);
            while (rs.next()){
                bill.add(new BillDto(rs.getInt("bill_id"), rs.getInt("customer_id"), rs.getString("created_date"), rs.getString("description"), rs.getLong("total_price"), rs.getLong("ship_charge"), rs.getBoolean("accepted"), rs.getString("status").charAt(0), rs.getInt("shipper_id"), rs.getString("deliver_time"), rs.getBoolean("is_completed")));
            }
        } catch (Exception ex) {}
        return bill;
    }

    public static int Insert(BillDto bill){
        String sql = "insert into Bill(customer_id, created_date, description, total_price, ship_charge, accepted, status, shipper_id, deliver_time, is_completed) values(" + bill.getCustomerId() + ", '" + bill.getCreatedDate() + "', '" + bill.getDescription() + "', " + bill.getTotalPrice()+ ", " + bill.getShipCharge() + ", " + bill.isAccepted() + ", '" + bill.getStatus()+ "', " + bill.getShipperId() + ", '" + bill.getDeliverTime() + "', " + bill.isCompleted()+ ")";
        int result = Database.ExecuteQuery(sql);
        if (result == -1)
            return result;
        return Database.GetLastestId("bill","bill_id");
    }

    public static boolean Update(BillDto bill){
        String sql = "Update Bill set bill_id = " + bill.getBillId() + ", customer_id = " + bill.getCustomerId() + ", created_date = '" + bill.getCreatedDate() + "', description = '" + bill.getDescription() + "', total_price = " + bill.getTotalPrice() + ", ship_charge = " + bill.getShipCharge() + ", accepted = " + bill.isAccepted() + ", status = '" + bill.getStatus()
                + "', shipper_id = " + bill.getShipperId() + ", deliver_time = '" + bill.getDeliverTime() + "', is_completed = " + bill.isCompleted() + " where bill_id = " + bill.getBillId()+ ")" ;
        if (Database.ExecuteQuery(sql) > 0) {
            return true;
        } else
        return false;
    }

    public static boolean Delete(BillDto bill){
        String sql = "delete from Bill where bill_id = " + bill.getBillId();
        if (Database.ExecuteQuery(sql) > 0) {
            return true;
        } else
        return false;
    }


    public static BillDto findById(int Id){
        BillDto bill = new BillDto();
        String sql = "select * from Bill where ID = " + Id;
        try {
            ResultSet rs = Database.SelectQuery(sql);
            while (rs.next()){
                bill = new BillDto(rs.getInt("bill_id"), rs.getInt("customer_id"), rs.getString("created_date"), rs.getString("description"), rs.getLong("total_price"), rs.getLong("ship_charge"), rs.getBoolean("accepted"), rs.getString("status").charAt(0), rs.getInt("shipper_id"), rs.getString("deliver_time"), rs.getBoolean("is_completed"));
            }
        } catch (Exception ex) {}
        return bill;
    }
}
