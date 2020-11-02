package com.Interface;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface BaseDAO<T> {
  Optional<T> get (Integer id) throws SQLException;
  
  List<T> getAll() throws SQLException;
  
  Integer save (T t) throws SQLException;
  
  void update (T t) throws SQLException;
  
  void delete (T t) throws SQLException;
  
}
