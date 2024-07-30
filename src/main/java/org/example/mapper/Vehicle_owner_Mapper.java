package org.example.mapper;

import org.example.domain.Vehicle_Owner;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Vehicle_owner_Mapper implements IMapper<Vehicle_Owner>{
    private final static String ID = "id";
    private final static String NAME = "o_name";
    private final static String PHONE_NUMBER = "phone_number";
    private final static String CNIC_NO = "cnic";
    private final static String ADDRESS = "address";
    private final static String COMMISSION = "commision";
    @Override
    public List<Vehicle_Owner> getListOfObjects(ResultSet rs) throws SQLException {
        List<Vehicle_Owner> vehicleOwners = new ArrayList<>();
        while (rs.next()){
            Vehicle_Owner vehicleOwner = Vehicle_Owner.builder()
                    .id(rs.getInt(ID))
                    .name(rs.getString(NAME))
                    .phone_No(rs.getString(PHONE_NUMBER))
                    .cnic_no(rs.getString(CNIC_NO))
                    .address(rs.getString(ADDRESS))
                    .commission(rs.getInt(COMMISSION))
                    .build();
            vehicleOwners.add(vehicleOwner);
        }


        return vehicleOwners;
    }

    @Override
    public Vehicle_Owner getObjects(ResultSet rs) throws SQLException {

        if (rs.next()){
            return Vehicle_Owner.builder()
                    .id(rs.getInt(ID))
                    .name(rs.getString(NAME))
                    .phone_No(rs.getString(PHONE_NUMBER))
                    .cnic_no(rs.getString(CNIC_NO))
                    .address(rs.getString(ADDRESS))
                    .commission(rs.getInt(COMMISSION))
                    .build();
        }
        return null;
    }
}
