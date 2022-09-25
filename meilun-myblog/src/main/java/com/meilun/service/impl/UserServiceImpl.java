package com.meilun.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.meilun.entiey.User;
import com.meilun.service.UserService;
import com.meilun.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




