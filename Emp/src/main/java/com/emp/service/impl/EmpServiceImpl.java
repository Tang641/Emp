package com.emp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.emp.dao.EmpDao;
import com.emp.entry.Emp;
import com.emp.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpDao empDao;

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<Emp> findAll() {
        return empDao.selectList(null);
    }

    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public  IPage<Emp>findAllPage(Integer page, Integer size) {
        IPage<Emp> pageInfo=new Page<>(page,size);
        return  empDao.selectPage(pageInfo, null);
    }

    /**
     * 通过姓名模糊查询
     *
     * @param name
     * @return
     */
    @Override
    public List<Emp> findByName(String name) {
        QueryWrapper<Emp> queryWrapper=new QueryWrapper<>();
        queryWrapper.like("name",name);
        return empDao.selectList(queryWrapper);
    }

    /**
     * 通过姓名模糊查询带分页
     *
     * @param page
     * @param size
     * @param name
     * @return
     */
    @Override
    public IPage<Emp> findByNamePage(Integer page, Integer size, String name) {
        QueryWrapper<Emp> queryWrapper=new QueryWrapper<>();
        queryWrapper.like("name",name);
        IPage<Emp> pageInfo=new Page<>(page,size);
        return empDao.selectPage(pageInfo,queryWrapper);
    }


    /**
     * 模糊查询和列表展示合在一起
     *
     * @param page
     * @param size
     * @param findName
     * @return
     */
    @Override
    public IPage<Emp> findAllPage_L_N(Integer page, Integer size, String findName) {
        QueryWrapper<Emp> queryWrapper=new QueryWrapper<>();
        if(findName!=null){
            queryWrapper.like("name",findName);
        }
        IPage<Emp> pageInfo=new Page<>(page,size);
        return empDao.selectPage(pageInfo,queryWrapper);
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    @Override
    public Emp findById(Integer id) {
        return empDao.selectById(id);
    }

    /**
     * 添加
     *
     * @param emp
     * @return
     */
    @Override
    public void add(Emp emp) {
        empDao.insert(emp);
    }

    /**
     * 修改
     *
     * @param id
     * @return
     */
    @Override
    public void updateById(Integer id,Emp emp) {
        QueryWrapper<Emp> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("id",id);
//        queryWrapper.lambda().eq(Emp::getId,id);
        empDao.update(emp,queryWrapper);

    }

    /**
     * 按照ID删除
     *
     * @param id
     */
    @Override
    public void delete(Integer id) {

        empDao.deleteById(id);
    }
}
