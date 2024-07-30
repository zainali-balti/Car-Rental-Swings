package org.example.dao;

import org.example.domain.CarAvailable;
import org.example.mapper.CarAvailableMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CarAvailableDao extends BaseDao{
    private final CarAvailableMapper carAvailableMapper = new CarAvailableMapper();
    public List<CarAvailable> getALLAvailableCar(){
        try {
            PreparedStatement ps =
                    con.prepareStatement(SqlQueriesConstant.GET_ALL_AVAILABLE_CAR);
            ResultSet rs = ps.executeQuery();
            return carAvailableMapper.getListOfObjects(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
