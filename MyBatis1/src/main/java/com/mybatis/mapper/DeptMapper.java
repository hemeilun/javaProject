package com.mybatis.mapper;

import com.mybatis.domain.Dept;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {

    /**
     * 查询部门信息
     */
    public Dept findDeptById(@Param("did") int id);
}
