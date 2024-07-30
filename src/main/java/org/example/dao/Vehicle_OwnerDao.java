package org.example.dao;

import org.example.domain.Vehicle_Owner;
import org.example.mapper.IMapper;
import org.example.mapper.Vehicle_owner_Mapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Vehicle_OwnerDao extends BaseDao implements ICurd<Vehicle_Owner>{
    private final Vehicle_owner_Mapper vehicleOwnerMapper = new Vehicle_owner_Mapper();
    @Override
    public void insert(Vehicle_Owner obj) {

        try {
            PreparedStatement pst = con.prepareStatement(SqlQueriesConstant.INSERT_ALL_ELEMENTS_INTO_VEHICLE_OWNER);
            pst.setString(1, obj.getName());
            pst.setString(2, obj.getPhone_No());
            pst.setString(3, obj.getCnic_no());
            pst.setString(4, obj.getAddress());
            pst.setInt(5, obj.getCommission());
            Integer rs= pst.executeUpdate();
            if (rs>0){
                System.out.println("Yes Inserted Successfully");
            }
            else {
                System.out.println("Sorry");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Vehicle_Owner> getAll() {
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SqlQueriesConstant.GET_ALL_ELEMENTS_FROM_VEHICLE_OWNER);
           return vehicleOwnerMapper.getListOfObjects(rs);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Vehicle_Owner getById(long id) {
        try {
            PreparedStatement ps = con.prepareStatement(SqlQueriesConstant.GET_ALL_ELEMENTS_FROM_VEHICLE_OWNER_BY_ID);
            ps.setInt(1, (int) id);
            ResultSet rs = ps.executeQuery();
            return vehicleOwnerMapper.getObjects(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Vehicle_Owner> getByName(String name){
        try {
            PreparedStatement ps = con.prepareStatement(SqlQueriesConstant.GET_ELEMENTS_FROM_VEHICLE_OWNER_WHERE_NAME);
            ps.setString(1,"%" + name + "%");
            ResultSet rs = ps.executeQuery();
            return vehicleOwnerMapper.getListOfObjects(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void update(Vehicle_Owner obj, long id) {

        try {
            PreparedStatement ps = con.prepareStatement(SqlQueriesConstant.UPDATE_ELEMENTS_FROM_VEHICLE_OWNER_BY_ID);
            ps.setString(1,obj.getName());
            ps.setString(2,obj.getPhone_No());
            ps.setString(3,obj.getCnic_no());
            ps.setString(4,obj.getAddress());
            ps.setInt(5,obj.getCommission());
            ps.setInt(6, (int) id);
            Integer rs = ps.executeUpdate();
            if (rs>0){
                System.out.println("Yes");
            }
            else {
                System.out.println("No");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void delete(long id) {
        try {
            // Delete dependent records in the vehicle table first
            PreparedStatement deleteVehicleRecords = con.prepareStatement("DELETE FROM vehicle WHERE o_id = ?");
            deleteVehicleRecords.setInt(1, (int) id);
            deleteVehicleRecords.executeUpdate();

            // Then delete the record from the vehicle_owner table
            PreparedStatement deleteOwnerRecord = con.prepareStatement(SqlQueriesConstant.DELETE_ELEMENT_FROM_VEHICLE_OWNER);
            deleteOwnerRecord.setInt(1, (int) id);
            int rs = deleteOwnerRecord.executeUpdate();

            if (rs > 0) {
                System.out.println("Record deleted successfully");
            } else {
                System.out.println("No record found for deletion");
            }
        } catch (SQLException e) {
            // Print the SQL exception details for diagnosis
            e.printStackTrace();
            throw new RuntimeException("Failed to delete record from vehicle_owner table: " + e.getMessage());
        }

    }


}
