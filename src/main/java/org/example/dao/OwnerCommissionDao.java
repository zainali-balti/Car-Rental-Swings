package org.example.dao;

import org.example.domain.OwnerCommission;
import org.example.mapper.OwnerCommissionMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OwnerCommissionDao extends BookingDao{
    private final OwnerCommissionMapper ownerCommissionMapper = new OwnerCommissionMapper();

    public List<OwnerCommission> getAllCommission(){
        try {
            PreparedStatement ps =
                    con.prepareStatement(SqlQueriesConstant.GET_OWNER_COMMISSION);
            ResultSet rs = ps.executeQuery();
            return ownerCommissionMapper.getListOfObjects(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
