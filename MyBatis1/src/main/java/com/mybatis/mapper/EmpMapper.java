package com.mybatis.mapper;


import com.mybatis.domain.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {

    /**
     * 查询员工信息
     */
    //出错二：没有用List接收
    public List<Emp> findEmpByDeptId(@Param("did") int id);
}
