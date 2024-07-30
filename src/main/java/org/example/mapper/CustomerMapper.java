package org.example.mapper;

import org.example.domain.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerMapper implements IMapper<Customer>{
    public static final String ID = "id";
    public static final String C_NAME = "c_name";
    public static final String PHONE_NUMBER = "phone_number";
    public static final String CNIC_NO = "cnic";
    public static final String ADDRESS = "address";


    @Override
    public List<Customer> getListOfObjects(ResultSet rs) throws SQLException {
        List<Customer> customerList = new ArrayList<>();
        while (rs.next()){
            Customer customer = Customer.builder()
                    .id((long) rs.getInt(ID))
                    .name(rs.getString(C_NAME))
                    .phone_Number(rs.getString(PHONE_NUMBER))
                    .cnic_No(rs.getString(CNIC_NO))
                    .address(rs.getString(ADDRESS))
                    .build();
            customerList.add(customer);
        }
        return customerList;
    }

    @Override
    public Customer getObjects(ResultSet rs) throws SQLException {

        if(rs.next()) {
            return Customer.builder()
                    .id((long) rs.getInt(ID))
                    .name(rs.getString(C_NAME))
                    .phone_Number(rs.getString(PHONE_NUMBER))
                    .cnic_No(rs.getString(CNIC_NO))
                    .address(rs.getString(ADDRESS))
                    .build();
        }
        return null;
    }
}
