package org.example.dao;

import java.util.Stack;

public class SqlQueriesConstant {
    public static final String  GET_ALL_ELEMENTS = "SELECT * FROM car_rental.customer";
    public static final String  GET_ELEMENTS_BY_ID = "SELECT * FROM car_rental.customer where id = ?";
    public static final String  GET_ELEMENTS_BY_NAME = "SELECT * FROM car_rental.customer where c_name like ? ";
    public static final String  UPDATE_ELEMENTS_BY_ID = "update customer " +
            "set c_name= ?, phone_number = ?, cnic = ?, address = ? " +
            "where id = ?";
    public static final String  INSERT_ALL_ELEMENTS = "insert into customer" +
            "(c_name,phone_number,cnic,address) values(?,?,?,?)";
    public static final String  DELETE_ELEMENT = "delete from customer where id  = ?";
    public static final String  USER_AUTHENTICATION = "select * from sigin where uname = ? and pass = ?";
    public static final String  INSERT_ALL_ELEMENTS_INTO_VEHICLE_OWNER = "insert into vehicle_owner" +
            "(o_name,phone_number,cnic,address,commision) values(?,?,?,?,?)";
    public static final String  GET_ALL_ELEMENTS_FROM_VEHICLE_OWNER = "SELECT * FROM car_rental.vehicle_owner";
    public static final String  GET_ALL_ELEMENTS_FROM_VEHICLE_OWNER_BY_ID =
            "SELECT * FROM car_rental.vehicle_owner where id = ?";
    public static final String  GET_ELEMENTS_FROM_VEHICLE_OWNER_WHERE_NAME =
            "SELECT * FROM car_rental.vehicle_owner where o_name like ? ";
    public static final String UPDATE_ELEMENTS_FROM_VEHICLE_OWNER_BY_ID = "UPDATE vehicle_owner " +
            "SET o_name = ?, phone_number = ?, cnic = ?, address = ?, commision = ? " +
            "WHERE id = ?";
    public static final String  DELETE_ELEMENT_FROM_VEHICLE_OWNER = "delete from vehicle_owner where id  = ?";
    public static final String INSERT_INTO_VEHICLE = "insert into vehicle(v_name,model,brand,color,o_id)\n" +
            "values(?,?,?,?,?)";
    public static final String GET_ALL_VEHICLE = "SELECT * FROM car_rental.vehicle";
    public static final String  UPDATE_VEHICLE = "update vehicle set v_name = ?,model = ?,brand = ?," +
            "color = ?,o_id = ? where id = ?";
    public static final String GET_ALL_VEHICLE_BY_ID = "SELECT * FROM car_rental.vehicle where id = ?";
    public static final String DELETE_FROM_VEHICLE = "delete from vehicle where id = ?";
    public static final String INSERT_INTO_BOOKING = "insert into booking(c_id,v_id,booking_date,price,booking_status)\n" +
            "values(?,?,?,?,?)";
    public static final String GET_ALL_FROM_BOOKING = "select * from booking";
    public static final String GET_FROM_BOOKING_WHERE_ID = "select * from booking where id = ?";
    public static final String  UPDATE_FROM_BOOKING = "update booking set c_id = ?,v_id = ?,booking_date = ?," +
            "price = ?,booking_status = ? where id = ?";
    public static final String DELETE_FROM_BOOKING = "delete from booking where id = ?";
    public static final String DELETE_FROM_VEHICLE_ONLY = "delete from booking where v_id = ?";

    public static final String DELETE_FROM_BOOKING_BY_CUSTOMER_ID = "delete from booking where c_id = ?";
    public static final String  GET_ELEMENTS_FROM_VEHICLE_WHERE_NAME =
            "SELECT * FROM car_rental.vehicle where v_name like ? ";
    public static final String  DELETE_FROM_VEHICLE_WHERE_OWNER_ID =
            "delete FROM car_rental.vehicle where o_id = ? ";
    public static final String  DELETE_WHERE_VEHICLE_ID =
            "delete FROM car_rental.booking where v_id = ? ";
    public static final String NEW_USER_INSERT = "insert into sigin(uname,pass,conpass)\n" +
            "values(?,?,?)";
    public static final String NEW_USER_GET_ALL = "select * from sigin";
    public static final String NEW_USER_GET_BY_ID = "select uname,pass from sigin where id = ?";
    public static final String NEW_USER_UPDATE = "update sigin set uname = ?,pass = ?,conpass = ? where id = ?";
    public static final String NEW_USER_DELETE = "delete from sigin where id = ?";
    public static final String NEW_USER_GET_BY_NAME = "select * from sigin where uname like ?";
    public static final String GET_ALL_AVAILABLE_CAR = "SELECT v.id,v_name,model,brand,color\n" +
            "FROM vehicle as v\n" +
            "LEFT JOIN booking as b ON v.id = b.v_id\n" +
            "WHERE b.v_id IS NULL";
    public static final String GET_OWNER_COMMISSION = "SELECT vehicle.id,\n" +
            "       o_name, commision, booking.id\n" +
            "FROM vehicle_owner\n" +
            "JOIN vehicle ON vehicle_owner.id = vehicle.id\n" +
            "JOIN booking ON vehicle.id = booking.v_id";
}
