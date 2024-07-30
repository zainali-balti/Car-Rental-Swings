package org.example.dao;

import org.example.domain.Customer;
import org.example.mapper.CustomerMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CustomerDao extends BaseDao implements ICurd<Customer>{

    private final CustomerMapper customerMapper = new CustomerMapper();
    @Override
    public void insert(Customer obj) {
        try {
            PreparedStatement ps = con.prepareStatement(SqlQueriesConstant.INSERT_ALL_ELEMENTS);
            ps.setString(1,obj.getName());
            ps.setString(2,obj.getPhone_Number());
            ps.setString(3,obj.getCnic_No());
            ps.setString(4,obj.getAddress());
            Integer rs  = ps.executeUpdate();

            if (rs>0){
                System.out.println("Yes Successfully Insert");
            }
            else {
                System.out.println("Sorry Not inserted Yet");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Customer> getAll() {
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SqlQueriesConstant.GET_ALL_ELEMENTS);
            return customerMapper.getListOfObjects(rs);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Customer getById(long id) {
        try {
            PreparedStatement ps = con.prepareStatement(SqlQueriesConstant.GET_ELEMENTS_BY_ID);
            ps.setInt(1, (int) id);
        ResultSet rs = ps.executeQuery();
        return customerMapper.getObjects(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Customer> getByName(String name) {
        try {
            PreparedStatement ps = con.prepareStatement(SqlQueriesConstant.GET_ELEMENTS_BY_NAME);
            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();
            return customerMapper.getListOfObjects(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Customer obj, long id) {
        try {
            PreparedStatement ps = con.prepareStatement(SqlQueriesConstant.UPDATE_ELEMENTS_BY_ID);
            ps.setString(1,obj.getName());
            ps.setString(2,obj.getPhone_Number());
            ps.setString(3,obj.getCnic_No());
            ps.setString(4,obj.getAddress());
            ps.setInt(5, (int) id);
            Integer rs = ps.executeUpdate();
            if (rs>0){
                System.out.println("Yes Successfully Updated");
            }
            else {
                System.out.println("Sorry Not Updated Yet");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(long id) {
        try {
            PreparedStatement ps = con.prepareStatement(SqlQueriesConstant.DELETE_ELEMENT);
            ps.setInt(1, (int) id);
            Integer rs = ps.executeUpdate();
            if (rs>0){
                System.out.println("Yes deleted");
            }
            else {
                System.out.println("Sorry not deleted yet");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
