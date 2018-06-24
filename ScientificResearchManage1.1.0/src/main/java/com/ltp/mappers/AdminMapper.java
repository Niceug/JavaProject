package com.ltp.mappers;

import com.ltp.entities.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {
    Admin login(@Param("username") String username, @Param("password") String password);
}
