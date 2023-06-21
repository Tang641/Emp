package com.emp.entry;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Emp {
    //id根据数据库主动生成
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String type;
    private String name;
    private String sex;
    @TableField(value = "entry_time",jdbcType = JdbcType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")//将前台时间抓换为后台需要的
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone ="GMT+8" )//将数据库中时间转换为前台需要的
//    字段更具数据库使用驼峰命名，如数据库entry_time,则实体类使用entryTime;否者查询不到值或者使用
//    @TableField(value = "entry_time",jdbcType = JdbcType.TIMESTAMP)映射，但是名字不能和映射名一致，如使用private Date entrytime;
    private Date entryTime;

    private String description;
}
