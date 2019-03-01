package com.hz.mongotest.service.impl;

import com.hz.mongotest.model.User;
import com.hz.mongotest.repository.UserRepository;
import com.hz.mongotest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findByUidAndName(Integer uid, String name) {
        return userRepository.findByUidAndName(uid, name);
    }

    @Override
    public long getCount() {
        return userRepository.count();
    }

    @Override
    public List<User> findAllByPage(PageRequest pageRequest) {
        return userRepository.findAll(pageRequest).getContent();
    }

    @Override
    public List<User> findByNameLikeIgnoreCase(String name) {
        return userRepository.findByNameLikeIgnoreCase(name);
    }

    @Override
    public List<User> findByNameLikeOrderBySalaryDesc(String name, PageRequest pageRequest) {
        return userRepository.findByNameLikeOrderBySalaryDesc(name, pageRequest).getContent();
    }

    @Override
    public List<User> findByNameLike2(String name, PageRequest pageRequest) {
        return userRepository.findByNameLike2(name, pageRequest).getContent();
    }


    @Override
    public void update() {

    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }



}
