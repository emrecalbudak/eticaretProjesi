package com.spring.project.business.concretes;

import com.spring.project.business.abstracts.UserService;
import com.spring.project.core.dataAccess.UserDao;
import com.spring.project.core.entities.User;
import com.spring.project.core.utilities.results.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {
    private UserDao userDao;
    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    public Result add(User user) {
        if(userDao.existsByEmail(user.getEmail())) {
            return new ErrorResult("Email kullanılmakta");
        }

        userDao.save(user);
        return new SuccessDataResult<>("Kullanıcı Eklendi");
    }
    @Override
    public DataResult<User> findByEmail(String email) {
        return new SuccessDataResult<User>(this.userDao.findByEmail(email),"Kullanıcı bulundu");
    }
}
