package cn.dsyang.dubbodemo.service.impl;

import cn.dsyang.dubbodemo.service.UserService;
import com.alibaba.dubbo.config.annotation.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public String getName() {
        return "hello word";
    }
}
