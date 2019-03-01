package com.hz.mongotest.controller;

import com.hz.mongotest.model.User;
import com.hz.mongotest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    // 添加
    @RequestMapping("save")
    public String save(User user){
        userService.save(user);
        return "INSERT SUCCESS";
    }

    // 查询所有
    @RequestMapping("findAll")
    public List<User> findAll(){
        return userService.findAll();
    }

    // 条件查询【自定】
    @RequestMapping("findByUidAndName")
    public List<User> findByUidAndName(Integer uid, String name){
        return userService.findByUidAndName(uid, name);
    }

    // 查询数据总条数
    @RequestMapping("getCount")
    public long getCount(){
        return userService.getCount();
    }

    // 分页查询
    @RequestMapping("findAllByPage")
    public List<User> findAllByPage(Integer page, Integer rows){
        PageRequest pageRequest = PageRequest.of(page-1, rows);
        return userService.findAllByPage(pageRequest);
    }

    // 模糊查询且忽略大小写【自定】
    @RequestMapping("findByNameLikeIgnoreCase")
    public List<User> findByNameLikeIgnoreCase(String name){
        return userService.findByNameLikeIgnoreCase(name);
    }

    // 模糊查询并分页且根据薪资倒序【自定】
    @RequestMapping("findByNameLikeOrderBySalaryDesc")
    public List<User> findByNameLikeOrderBySalaryDesc(Integer page, Integer rows, String name){
        PageRequest pageRequest = PageRequest.of(page-1, rows);
        return userService.findByNameLikeOrderBySalaryDesc(name, pageRequest);
    }

    // 模糊查询并分页，并指定返回字段【自定原生】
    @RequestMapping("findByNameLike2")
    public List<User> findByNameLike2(Integer page, Integer rows, String name){
        PageRequest pageRequest = PageRequest.of(page-1, rows);
        List<User> list = userService.findByNameLike2(name, pageRequest);
        return list;
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @RequestMapping("deleteById")
    public String deleteById(Long id){
        userService.deleteById(id);
        return "DELETE SUCCESS";
    }



}
