package com.config.database;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CursorMapper {
@Select({"select * from business_variables order by id"})
List<BusinessVariables> scan();
}
