package org.example.services;

import org.example.dao.BookingDao;
import org.example.dao.VehicleDao;
import org.example.domain.Vehicle;

import java.util.List;

public class VehicleService {
    private  final VehicleDao vehicleDao = new VehicleDao();
    private final BookingDao bookingDao = new BookingDao();
    public String[][] getByName(String name){
        List<Vehicle> vehicleDaoList = vehicleDao.getByName(name);
        return getAllInJTable(vehicleDaoList,6);
    }
    public String[][] getAllInJTable(List<Vehicle> vehicleList, Integer col){

        String[][] data = new String[vehicleList.size()][col];
        for (int i=0 ; i<vehicleList.size() ; i++){
            data[i][0] = String.valueOf(vehicleList.get(i).getId());
            data[i][1] = vehicleList.get(i).getName();
            data[i][2] = String.valueOf(vehicleList.get(i).getModel());
            data[i][3] = vehicleList.get(i).getBrand();
            data[i][4] = vehicleList.get(i).getColor();
            data[i][5] = String.valueOf(vehicleList.get(i).getOid());
        }
        return data;
    }
    public String[][] getByNameJTable(){
        List<Vehicle> vehicleList = vehicleDao.getAll();
        return getAllInJTable(vehicleList,6);
    }
    public void save(String name, Integer model, String brand, String color, Integer o_id){

        Vehicle vehicle = Vehicle.builder()
                .name(name)
                .model(model)
                .brand(brand)
                .color(color)
                .oid(o_id)
                .build();
        vehicleDao.insert(vehicle);

    }
    public void deleteRow(long id){
        bookingDao.deleteByVehicleId(id);
        vehicleDao.delete(id);
    }
}
