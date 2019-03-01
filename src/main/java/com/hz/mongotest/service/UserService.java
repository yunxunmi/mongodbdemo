package com.hz.mongotest.service;

import com.hz.mongotest.model.User;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface UserService {

    /**
     * 添加
     * @param user
     */
    void save(User user);

    /**
     * 查询所有数据
     * @return
     */
     List<User> findAll();

    /**
     * 根据编号和姓名查询
     * @param uid
     * @param name
     * @return
     */
    List<User> findByUidAndName(Integer uid, String name);

    /**
     * 查询数据总条数
     * @return
     */
    long getCount();

    /**
     * 分页查询
     * @param pageRequest
     * @return
     */
    List<User> findAllByPage(PageRequest pageRequest);

    /**
     * 根据姓名模糊查询且忽略大小写
     * @param name
     * @return
     */
    List<User> findByNameLikeIgnoreCase(String name);

    /**
     * 根据姓名模糊查询并分页,且根据薪资倒序排列
     * @param name
     * @param pageRequest
     * @return
     */
    List<User> findByNameLikeOrderBySalaryDesc(String name, PageRequest pageRequest);

    /**
     * 根据姓名模糊查询并分页，且指定返回字段
     * @param name
     * @param pageRequest
     * @return
     */
    List<User> findByNameLike2(String name, PageRequest pageRequest);


    void update();

    /**
     * 根据id删除
     * @param id
     */
    void deleteById(Long id);

}
