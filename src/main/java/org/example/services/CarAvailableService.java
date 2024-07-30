package org.example.services;

import org.example.dao.CarAvailableDao;
import org.example.domain.CarAvailable;

import java.util.List;

public class CarAvailableService {
    private final CarAvailableDao carAvailableDao = new CarAvailableDao();
    public String[][] getAllCarAvailable(){
        List<CarAvailable> carAvailableList = carAvailableDao.getALLAvailableCar();
        return getIntoTable(carAvailableList,5);
    }
    public String[][] getIntoTable(List<CarAvailable> carAvailableList,Integer col){
        String[][] data = new String[carAvailableList.size()][col];
        for (int i=0 ; i<carAvailableList.size() ; i++){
            data[i][0] = String.valueOf(carAvailableList.get(i).getId());
            data[i][1] = carAvailableList.get(i).getName();
            data[i][2] = carAvailableList.get(i).getModel();
            data[i][3] = carAvailableList.get(i).getBrand();
            data[i][4] = carAvailableList.get(i).getColor();
        }
        return data;
    }
}
