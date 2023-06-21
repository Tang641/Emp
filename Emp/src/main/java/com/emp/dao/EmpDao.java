package com.emp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.emp.entry.Emp;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface EmpDao extends BaseMapper<Emp> {
}
