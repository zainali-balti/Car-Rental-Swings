package org.example.mapper;

import org.example.domain.CarAvailable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarAvailableMapper implements IMapper<CarAvailable>{

    @Override
    public List<CarAvailable> getListOfObjects(ResultSet rs) throws SQLException {
        List<CarAvailable>  carAvailableList = new ArrayList<>();
        while (rs.next()){
            CarAvailable carAvailable = CarAvailable.builder()
                    .id(rs.getInt("id"))
                    .name(rs.getString("v_name"))
                    .model(rs.getString("model"))
                    .brand(rs.getString("brand"))
                    .color(rs.getString("color"))
                    .build();
            carAvailableList.add(carAvailable);
        }
        return carAvailableList;
    }

    @Override
    public CarAvailable getObjects(ResultSet rs) throws SQLException {
        return null;
    }
}
