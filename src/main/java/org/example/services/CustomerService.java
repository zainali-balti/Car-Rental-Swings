package org.example.services;

import org.example.dao.BookingDao;
import org.example.dao.CustomerDao;
import org.example.domain.Customer;

import java.util.List;

public class CustomerService {

    private final CustomerDao customer = new CustomerDao();
    private final BookingDao bookingDao = new BookingDao();
    public String[][] searchByName(String name){
        List<Customer> customerList = customer.getByName(name);
        return getByNameJTable(customerList,5);
    }
    public String[][] getAllCustomerInJTable(){
        List<Customer> customerList = customer.getAll();
        return getByNameJTable(customerList,5);

    }
    private String[][] getByNameJTable(List<Customer> customerList,int col){
        String[][] data = new String[customerList.size()][col];
        for (int i=0 ; i<customerList.size() ; i++){

            data[i][0] = String.valueOf(customerList.get(i).getId());
            data[i][1] = customerList.get(i).getName();
            data[i][2] = customerList.get(i).getPhone_Number();
            data[i][3] = customerList.get(i).getCnic_No();
            data[i][4] = customerList.get(i).getAddress();
        }
        return data;
    }
    public void save(String name,String phone_no,String cnic,String address){
        Customer customer1 = Customer.builder()
                .name(name)
                .phone_Number(phone_no)
                .cnic_No(cnic)
                .address(address)
                .build();
        customer.insert(customer1);
    }
    public void update(String name, String phone, String cnic, String address, long id){
        Customer customer1 = Customer.builder()
                .name(name)
                .phone_Number(phone)
                .cnic_No(cnic)
                .address(address)
                .build();
        customer.update(customer1,id);
    }
    public void remove(long id){
        bookingDao.deleteByCustomerId(id);
        customer.delete(id);
    }
}
