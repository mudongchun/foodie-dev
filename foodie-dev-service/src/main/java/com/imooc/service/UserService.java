package com.imooc.service;

import com.imooc.pojo.Users;
import com.imooc.pojo.bo.UserBO;

public interface UserService {
    public boolean queryUsernameIsExist(String username);

    public Users createUser(UserBO userBO);

    /*
    * 检索用户名和密码是否匹配
    * */
    public Users queryUserForLogin(String username, String password);
}
