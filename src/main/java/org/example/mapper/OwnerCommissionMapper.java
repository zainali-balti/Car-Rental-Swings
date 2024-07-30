package org.example.mapper;

import org.example.dao.BookingDao;
import org.example.domain.Booking;
import org.example.domain.OwnerCommission;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OwnerCommissionMapper implements IMapper<OwnerCommission> {

    @Override
    public List<OwnerCommission> getListOfObjects(ResultSet rs) throws SQLException {
        List<OwnerCommission> ownerCommissionList = new ArrayList<>();
        while (rs.next()){
            OwnerCommission ownerCommission = OwnerCommission.builder()
                    .id(rs.getInt("id"))
                    .name(rs.getString("o_name"))
                    .commission(rs.getInt("commision"))
                    .bid(rs.getInt("booking.id"))
                    .build();
            ownerCommissionList.add(ownerCommission);
        }
        return ownerCommissionList;
    }

    @Override
    public OwnerCommission getObjects(ResultSet rs) throws SQLException {
        return null;
    }

}
