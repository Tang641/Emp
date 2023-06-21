package com.emp.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.emp.entry.Emp;
import com.emp.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    EmpService empService;

    /**
     * 查询所有
     * @return
     */
    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public List<Emp> findAll(){
        return empService.findAll();
    }

    /**
     * 分页查询所有
     * @return
     */
    @RequestMapping(value = "/findAll/{page}/{size}",method = RequestMethod.GET)
    public IPage<Emp> findAllPage(@PathVariable Integer page, @PathVariable Integer size){
        return empService.findAllPage(page,size);
    }


    /**
     * 通过姓名模糊查询
     * @param name
     * @return
     */
    @RequestMapping(value = "/findByName/{name}",method = RequestMethod.GET)
    public List<Emp> findByName(@PathVariable String name){
        return empService.findByName(name);
    }

    /**
     * 通过姓名模糊查询带分页
     * @param page
     * @param size
     * @param name
     * @return
     */
    @RequestMapping(value = "/findByName/{page}/{size}/{name}",method = RequestMethod.GET)
    public IPage<Emp> findByName(@PathVariable Integer page, @PathVariable Integer size,@PathVariable String name){
        return empService.findByNamePage(page,size,name);
    }

    /**
     * 通过id查询
     * @param name
     * @return
     */
    @RequestMapping(value = "/findById/{id}",method = RequestMethod.GET)
    public Emp findById(@PathVariable Integer id){
        return empService.findById(id);
    }

    /**
     * 添加
     * @param emp
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public void add(@RequestBody Emp emp){
         empService.add(emp);
    }


    /**
     * 修改
     * @param emp
     * @return
     */
    @RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
    public void add(@PathVariable Integer id,@RequestBody Emp emp){
         empService.updateById(id,emp);
    }

    /**
     * 按照ID删除
     */
    @RequestMapping(value = "/deleteById/{id}",method = RequestMethod.DELETE)
    public void deleteByID(@PathVariable Integer id){
        empService.delete(id);
    }


    /**
     * 带条件和普通分页同时实现
     * @param page
     * @param size
     * @param findName
     * @return
     */
    @RequestMapping(value = "/findAll_2",method = RequestMethod.GET)
    public IPage<Emp> findAllPage_L_N(@RequestParam(value = "currentPage") Integer page, @RequestParam(value = "pageSize") Integer size,String findName){
        return empService.findAllPage_L_N(page,size,findName);
    }

}
