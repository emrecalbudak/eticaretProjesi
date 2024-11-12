package com.spring.project.business.abstracts;

import com.spring.project.core.entities.User;
import com.spring.project.core.utilities.results.DataResult;
import com.spring.project.core.utilities.results.Result;

public interface UserService {
    Result add(User user);
    DataResult<User> findByEmail(String email);
}
