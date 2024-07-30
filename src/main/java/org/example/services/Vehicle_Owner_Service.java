package org.example.services;

import org.example.dao.VehicleDao;
import org.example.dao.Vehicle_OwnerDao;
import org.example.domain.Vehicle_Owner;

import java.util.List;

public class Vehicle_Owner_Service {

    private final Vehicle_OwnerDao vehicleOwnerDao = new Vehicle_OwnerDao();
    private final VehicleDao vehicleDao = new VehicleDao();
    public String[][] getByName(String name){
        List<Vehicle_Owner> vehicleOwnerList = vehicleOwnerDao.getByName(name);
        return getAllInJTable(vehicleOwnerList,6);

    }
    public String[][] getByNameJTable(){
        List<Vehicle_Owner> vehicleOwnerList = vehicleOwnerDao.getAll();
        return getAllInJTable(vehicleOwnerList,6);
    }
    public String[][] getAllInJTable(List<Vehicle_Owner> vehicleOwnerList, Integer col){

        String[][] data = new String[vehicleOwnerList.size()][col];
        for (int i=0 ; i<vehicleOwnerList.size() ; i++){
            data[i][0] = String.valueOf(vehicleOwnerList.get(i).getId());
            data[i][1] = vehicleOwnerList.get(i).getName();
            data[i][2] = vehicleOwnerList.get(i).getPhone_No();
            data[i][3] = vehicleOwnerList.get(i).getCnic_no();
            data[i][4] = vehicleOwnerList.get(i).getAddress();
            data[i][5] = String.valueOf(vehicleOwnerList.get(i).getCommission());
        }
        return data;
    }
    public void save(String name,String phone_no,String cnic,String address,Integer commission){

        Vehicle_Owner vehicleOwner = Vehicle_Owner.builder()
                 .name(name)
                 .phone_No(phone_no)
                 .cnic_no(cnic)
                 .address(address)
                 .commission(commission)
                .build();
        vehicleOwnerDao.insert(vehicleOwner);

    }
    public void update(String name,String phone_no,String cnic,String address,Integer commission, long id){

        Vehicle_Owner vehicleOwner = Vehicle_Owner.builder()
                .name(name)
                .phone_No(phone_no)
                .cnic_no(cnic)
                .address(address)
                .commission(commission)
                .build();
        vehicleOwnerDao.update(vehicleOwner,id);

    }

    public void remove(long id){
        vehicleDao.deleteByVehicleOwnerId(id);
        vehicleOwnerDao.delete(id);
    }

}
