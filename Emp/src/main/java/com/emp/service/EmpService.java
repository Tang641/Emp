package com.emp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.emp.entry.Emp;

import java.util.List;

public interface EmpService {
    /**
     * 查询所有
     * @return
     */
    List<Emp> findAll();

    /**
     * 通过姓名模糊查询
     * @param name
     * @return
     */
    List<Emp> findByName(String name);


    /**
     * 通过id查询
     * @param name
     * @return
     */
    Emp findById(Integer id);

    /**
     * 添加
     * @param emp
     * @return
     */
    void add(Emp emp);

    /**
     * 修改
     * @param emp
     * @return
     */
    void updateById(Integer id,Emp emp);

    /**
     * 按照ID删除
     */
    void delete(Integer id);

    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    IPage<Emp> findAllPage(Integer page, Integer size);



    /**
     * 通过姓名模糊查询带分页
     * @param page
     * @param size
     * @param name
     * @return
     */

    IPage<Emp> findByNamePage(Integer page, Integer size, String name);

    /**
     * 模糊查询和列表展示合在一起
     * @param page
     * @param size
     * @param findName
     * @return
     */
    IPage<Emp> findAllPage_L_N(Integer page, Integer size, String findName);
}
