package org.example.mapper;

import org.example.domain.Booking;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingMapper implements IMapper<Booking>{
    private static final String ID = "id";
    private static final String C_ID = "c_id";
    private static final String V_ID = "v_id";
    private static final String DATE = "booking_date";
    private static final String PRICE = "price";
    private static final String STATUS = "booking_status";
    @Override
    public List<Booking> getListOfObjects(ResultSet rs) throws SQLException {
        List<Booking> bookingList = new ArrayList<>();
        while (rs.next()) {
            Booking booking = Booking.builder()
                    .id(rs.getInt(ID))
                    .c_id(rs.getInt(C_ID))
                    .v_id(rs.getInt(V_ID))
                    .date(rs.getDate(DATE).toLocalDate())
                    .price(rs.getInt(PRICE))
                    .status(rs.getString(STATUS))
                    .build();
            bookingList.add(booking);
        }
        return bookingList;
    }

    @Override
    public Booking getObjects(ResultSet rs) throws SQLException {
        if (rs.next()) {
            return Booking.builder()
                    .id(rs.getInt(ID))
                    .c_id(rs.getInt(C_ID))
                    .v_id(rs.getInt(V_ID))
                    .date(rs.getDate(DATE).toLocalDate())
                    .price(rs.getInt(PRICE))
                    .status(rs.getString(STATUS))
                    .build();
        }
        return null;
    }
}
