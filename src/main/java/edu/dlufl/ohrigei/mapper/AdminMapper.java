package edu.dlufl.ohrigei.mapper;

import edu.dlufl.ohrigei.dao.AdminDao;
import edu.dlufl.ohrigei.model.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface AdminMapper {
    @Select("Select * FROM admin")
    Admin
}
