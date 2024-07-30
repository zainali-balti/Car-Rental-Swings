package org.example.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface IMapper<T>{
    List<T> getListOfObjects(ResultSet rs) throws SQLException;
    T getObjects(ResultSet rs) throws SQLException;
}
