package org.example.dao;

import org.example.domain.Vehicle;
import org.example.domain.Vehicle_Owner;
import org.example.mapper.VehicleMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class VehicleDao extends BaseDao implements ICurd<Vehicle> {

    private final VehicleMapper vehicleMapper = new VehicleMapper();
    @Override
    public void insert(Vehicle obj) {
        try {
            PreparedStatement ps = con.prepareStatement(SqlQueriesConstant.INSERT_INTO_VEHICLE);
            ps.setString(1,obj.getName());
            ps.setInt(2,obj.getModel());
            ps.setString(3,obj.getBrand());
            ps.setString(4,obj.getColor());
            ps.setInt(5,obj.getOid());
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
    public List<Vehicle> getAll() {
        try {
            Statement st = con.createStatement();
            ResultSet rs  = st.executeQuery(SqlQueriesConstant.GET_ALL_VEHICLE);
            return vehicleMapper.getListOfObjects(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Vehicle getById(long id) {
        try {
            PreparedStatement ps = con.prepareStatement(SqlQueriesConstant.GET_ALL_VEHICLE_BY_ID);
            ps.setInt(1, (int) id);
            ResultSet rs = ps.executeQuery();
            return vehicleMapper.getObjects(rs);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Vehicle obj, long id) {
        try {
            PreparedStatement ps = con.prepareStatement(SqlQueriesConstant.UPDATE_VEHICLE);
            ps.setString(1,obj.getName());
            ps.setInt(2,obj.getModel());
            ps.setString(3,obj.getBrand());
            ps.setString(4,obj.getColor());
            ps.setInt(5,obj.getOid());
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
//            PreparedStatement pst = con.prepareStatement(SqlQueriesConstant.DELETE_FROM_BOOKING);
//            pst.setInt(1, (int) id);
//            pst.executeUpdate();
//            PreparedStatement del_veh_own = con.prepareStatement(SqlQueriesConstant.DELETE_ELEMENT_FROM_VEHICLE_OWNER);
//            del_veh_own.setInt(1, (int) id);
//            del_veh_own.executeUpdate();
            PreparedStatement ps = con.prepareStatement(SqlQueriesConstant.DELETE_FROM_VEHICLE);
            ps.setInt(1, (int) id);
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

    public List<Vehicle> getByName(String name){
        try {
            PreparedStatement ps = con.prepareStatement(SqlQueriesConstant.GET_ELEMENTS_FROM_VEHICLE_WHERE_NAME);
            ps.setString(1,"%" + name + "%");
            ResultSet rs = ps.executeQuery();
            return vehicleMapper.getListOfObjects(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteByVehicleOwnerId(long id) {
        try {
//            PreparedStatement pst = con.prepareStatement(SqlQueriesConstant.DELETE_FROM_BOOKING);
//            pst.setInt(1, (int) id);
//            pst.executeUpdate();
//            PreparedStatement del_veh_own = con.prepareStatement(SqlQueriesConstant.DELETE_ELEMENT_FROM_VEHICLE_OWNER);
//            del_veh_own.setInt(1, (int) id);
//            del_veh_own.executeUpdate();
            PreparedStatement ps = con.prepareStatement(SqlQueriesConstant.DELETE_FROM_VEHICLE_WHERE_OWNER_ID);
            ps.setInt(1, (int) id);
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
//    public void updateByVehicle(Vehicle_Owner obj, long id) {
//
//        try {
//            PreparedStatement ps = con.prepareStatement(SqlQueriesConstant.UPDATE_FROM_VEHICLE_WHERE_OWNER_ID);
//            ps.setString(1,obj.getName());
//            ps.setString(2,obj.getPhone_No());
//            ps.setString(3,obj.getCnic_no());
//            ps.setString(4,obj.getAddress());
//            ps.setInt(5,obj.getCommission());
//            ps.setInt(6, (int) id);
//            Integer rs = ps.executeUpdate();
//            if (rs>0){
//                System.out.println("Yes");
//            }
//            else {
//                System.out.println("No");
//            }
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//
//    }
}
