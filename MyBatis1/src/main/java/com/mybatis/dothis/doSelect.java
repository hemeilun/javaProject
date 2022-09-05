package com.mybatis.dothis;

import com.mybatis.domain.Dept;
import com.mybatis.mapper.DeptMapper;
import com.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

public class doSelect {

    public static void main(String[] args) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.findDeptById(1);
        System.out.println(dept);

    }
}
