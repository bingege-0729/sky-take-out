package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper
public interface EmployeeMapper {

    /**
     * 根据用户名查询员工
     * @ param username
     * @ return
     */
    @Select("select * from employee where username = #{username}")
    Employee getByUsername(String username);

    //插入员工数据

    /**
     * 根据用户名查询员工
     * @ parm employee
     * @ return
     */
    //有开启驼峰命名转换,application.yml中配置
    @Insert("insert into employee (name,username,password,phone,sex,id_number,status,create_time,update_time,create_user,update_user) " +
            "values"+
            "(#{name},#{username},#{password},#{phone},#{sex},#{idNumber},#{status},#{createTime},#{updateTime},#{createUser},#{updateUser})")
    //加入
    @AutoFill(value= OperationType.INSERT)
    void insert(Employee employee);

    //分页查询
    //@parm employeePageQueryDTO
    // @return

    Page<Employee> pageQuery(EmployeePageQueryDTO employeePageQueryDTO);
    //扩展方法，动态扩展属性
    @AutoFill(value= OperationType.UPDATE)
    void update(Employee employee);

    //根据id查询员工信息
    @Select("select * from employee where id =#{id}")
    Employee getById(Long id);
}
