package org.example.mapper;

import org.example.domain.Vehicle;

import javax.naming.Name;
import javax.print.attribute.standard.MediaSize;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleMapper implements IMapper<Vehicle>{
    private final String ID = "id";
    private final String NAME = "v_name";
    private final String MODEL = "model";
    private final String BRAND = "brand";
    private final String COLOR = "color";
    private final String OID = "o_id";
    @Override
    public List<Vehicle> getListOfObjects(ResultSet rs) throws SQLException {
        List<Vehicle> vehicleList = new ArrayList<>();
        while (rs.next()){
            Vehicle vehicle = Vehicle.builder()
                    .id(rs.getInt(ID))
                    .name(rs.getString(NAME))
                    .model(rs.getInt(MODEL))
                    .brand(rs.getString(BRAND))
                    .color(rs.getString(COLOR))
                    .oid(rs.getInt(OID))
                    .build();
            vehicleList.add(vehicle);
        }
        return vehicleList;
    }

    @Override
    public Vehicle getObjects(ResultSet rs) throws SQLException {
        if (rs.next()){
            return Vehicle.builder()
                    .id(rs.getInt(ID))
                    .name(rs.getString(NAME))
                    .model(rs.getInt(MODEL))
                    .brand(rs.getString(BRAND))
                    .color(rs.getString(COLOR))
                    .oid(rs.getInt(OID))
                    .build();
        }
        return null;
    }
}
