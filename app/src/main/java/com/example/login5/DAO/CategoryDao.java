package com.example.login5.DAO;


import com.example.login5.DTO.CategoryDto;
import com.example.login5.Utils.Database;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {
    public CategoryDao() {
    }

    public static List<CategoryDto> SelectAll(){
        List<CategoryDto> billDetail = new ArrayList<>();
        String sql = "select * from Category";
        try {
            ResultSet rs = Database.SelectQuery(sql);
            while (rs.next()){
                billDetail.add(new CategoryDto(rs.getInt("category_id"), rs.getString("name"), rs.getString("description")));
            }
        } catch (Exception ex) {}
        return billDetail;
    }


    public static int Insert(CategoryDto billDetail){
        String sql = "insert into Category(category_id, name, description) values(" + billDetail.getCategoryId() + ", '" + billDetail.getName() + "', '" + billDetail.getDescription() + "')";
        int result = Database.ExecuteQuery(sql);
        if (result == -1)
            return result;
        return Database.GetLastestId("category","category_id");
    }

    public static boolean Update(CategoryDto billDetail){
        String sql = "Update Category set name = '" + billDetail.getName() +"', description = '"+ billDetail.getDescription() + "' where billId = " + billDetail.getCategoryId() + ")" ;
        if (Database.ExecuteQuery(sql) > 0) {
            return true;
        } else
        return false;
    }
    public static int findByName(String name){
        String sql = "select category_id from Category where name = "+name;
        int id=-1;
        try {
            ResultSet rs = Database.SelectQuery(sql);
            if (rs.next()) {
                id = rs.getInt("category_id");
            }
        } catch (Exception ex) {}
        return id;
    }
    public static boolean Delete(CategoryDto billDetail){
        String sql = "delete from Category where ID = " + billDetail.getCategoryId();
        if (Database.ExecuteQuery(sql) > 0) {
            return true;
        } else
        return false;
    }


    public static CategoryDto findById(int Id){
        CategoryDto billDetail = new CategoryDto();
        String sql = "select * from Shipper where ID = " + Id;
        try {
            ResultSet rs = Database.SelectQuery(sql);
            while (rs.next()){
                billDetail = new CategoryDto(rs.getInt("category_id"), rs.getString("name"), rs.getString("description"));
            }
        } catch (Exception ex) {}
        return billDetail;
    }

    public static List<String> SelectAllName(){
        List<String> data = new ArrayList<>();
        String sql = "select name from category";
        try {
            ResultSet rs = Database.SelectQuery(sql);
            while (rs.next()){
                String name=rs.getString("name");
                data.add(name);
            }
        } catch (Exception ex) {}

        return data;
    }
}
