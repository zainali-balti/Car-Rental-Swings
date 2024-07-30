package org.example.services;

import org.example.dao.BookingDao;
import org.example.dao.CustomerDao;
import org.example.dao.VehicleDao;
import org.example.domain.Booking;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class BookingService {

    private final BookingDao bookingDao = new BookingDao();
    public String[][] getAllBookingInJTable(){
        List<Booking> bookingList = bookingDao.getAll();
        return getByJTable(bookingList,7);
    }
    public String[][] getByJTable(List<Booking> bookingList,Integer col){
        String[][] data = new String[bookingList.size()][col];
        for (int i =0 ; i<data.length ; i++){
            data[i][0] = String.valueOf(bookingList.get(i).getId());
            data[i][1] = String.valueOf(bookingList.get(i).getC_id());
            data[i][2] = String.valueOf(bookingList.get(i).getV_id());
            data[i][3] = String.valueOf(bookingList.get(i).getDate());
            data[i][4] = String.valueOf(bookingList.get(i).getPrice());
            data[i][5] = bookingList.get(i).getStatus();
        }
        return data;
    }

    public void save(String cid, String vid, LocalDate date, Integer price,String status){
        Booking booking = Booking.builder()
                .c_id(Integer.valueOf(cid))
                .v_id(Integer.valueOf(vid))
                .date(date)
                .price(price)
                .status(status)
                .build();
        bookingDao.insert(booking);
    }

    public void edit(Integer id,Integer cid,Integer vid,LocalDate date,Integer price,String status){
        Booking booking = Booking.builder()
                .c_id(cid)
                .v_id(vid)
                .date(date)
                .price(price)
                .status(status)
                .build();
        bookingDao.update(booking,id);
    }
    public void remove(long id){
        bookingDao.delete(id);
    }
}
