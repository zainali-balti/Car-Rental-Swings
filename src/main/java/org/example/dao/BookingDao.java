package org.example.dao;

import org.example.domain.Booking;
import org.example.mapper.BookingMapper;

import java.sql.*;
import java.util.List;

public class BookingDao extends BaseDao implements ICurd<Booking>{
    private static final BookingMapper bookingMapper = new BookingMapper();
    @Override
    public void insert(Booking obj) {
        try {
            PreparedStatement ps = con.prepareStatement(SqlQueriesConstant.INSERT_INTO_BOOKING);
            ps.setInt(1,obj.getC_id());
            ps.setInt(2,obj.getV_id());
            ps.setDate(3, Date.valueOf(obj.getDate()));
            ps.setInt(4,obj.getPrice());
            ps.setString(5,obj.getStatus());
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
    public List<Booking> getAll() {
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SqlQueriesConstant.GET_ALL_FROM_BOOKING);
            return bookingMapper.getListOfObjects(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Booking getById(long id) {
        try {
            PreparedStatement ps = con.prepareStatement(SqlQueriesConstant.GET_FROM_BOOKING_WHERE_ID);
            ps.setInt(1, (int) id);
            ResultSet rs = ps.executeQuery();
           return bookingMapper.getObjects(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Booking obj, long id) {
        try {
            PreparedStatement ps = con.prepareStatement(SqlQueriesConstant.UPDATE_FROM_BOOKING);
            ps.setInt(1,obj.getC_id());
            ps.setInt(2,obj.getV_id());
            ps.setDate(3, Date.valueOf(obj.getDate()));
            ps.setInt(4,obj.getPrice());
            ps.setString(5,obj.getStatus());
            ps.setInt(6, (int) id);
            Integer rs = ps.executeUpdate();
            if (rs>0){
                System.out.println("Yes");
            }
            else {
                System.out.println("no");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(long id) {

        try {
//
            PreparedStatement pst = con.prepareStatement(SqlQueriesConstant.DELETE_FROM_VEHICLE_ONLY);
            pst.setInt(1, (int) id);
            pst.executeUpdate();
            PreparedStatement ps = con.prepareStatement(SqlQueriesConstant.DELETE_FROM_BOOKING);
            ps.setInt(1, (int) id);
            Integer rs = ps.executeUpdate();
            if (rs>0){
                System.out.println("Yes");
            }
            else {
                System.out.println("no");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteByCustomerId(long id) {
        try {
            PreparedStatement pst = con.prepareStatement(SqlQueriesConstant.DELETE_FROM_BOOKING_BY_CUSTOMER_ID);
            pst.setInt(1, (int) id);
            Integer rs = pst.executeUpdate();
            if (rs>0){
                System.out.println("Yes");
            }
            else {
                System.out.println("no");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteByVehicleId(long id) {
        try {
            PreparedStatement pst = con.prepareStatement(SqlQueriesConstant.DELETE_WHERE_VEHICLE_ID);
            pst.setInt(1, (int) id);
            Integer rs = pst.executeUpdate();
            if (rs>0){
                System.out.println("Yes");
            }
            else {
                System.out.println("no");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
