package com;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.emp.EmpApplication;
import com.emp.dao.EmpDao;
import com.emp.entry.Emp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {EmpApplication.class})
public class EmpApplicationTest {
    @Autowired
    private EmpDao empDao;

    @Test
    public void testFindAll(){
        List<Emp> emps=empDao.selectList(null);
        System.out.println(emps);
    }

    @Test
    public void testFindALl() {
        QueryWrapper<Emp> queryWrapper = new QueryWrapper<Emp>();
        queryWrapper.lt("id",10);
//        if(name!=null){
//            queryWrapper.like("name","小");
//        }
        queryWrapper.like("name","小");
        List<Emp> empList =empDao.selectList(queryWrapper);
        System.out.println(empList);
    }
}
