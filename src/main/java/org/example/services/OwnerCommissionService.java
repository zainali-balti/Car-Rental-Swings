package org.example.services;

import org.example.dao.OwnerCommissionDao;
import org.example.domain.OwnerCommission;
import org.example.mapper.OwnerCommissionMapper;

import java.util.List;

public class OwnerCommissionService {
    private final OwnerCommissionDao ownerCommissionDao = new OwnerCommissionDao();
    public String[][] getAllCarAvailable(){
        List<OwnerCommission> ownerCommission = ownerCommissionDao.getAllCommission();
        return getIntoTable(ownerCommission,4);
    }
    public String[][] getIntoTable(List<OwnerCommission> ownerCommission, Integer col){
        String[][] data = new String[ownerCommission.size()][col];
        for (int i=0 ; i<ownerCommission.size() ; i++){
            data[i][0] = String.valueOf(ownerCommission.get(i).getId());
            data[i][1] = ownerCommission.get(i).getName();
            data[i][2] = String.valueOf(ownerCommission.get(i).getCommission());
            data[i][3] = String.valueOf(ownerCommission.get(i).getBid());
        }
        return data;
    }
}
