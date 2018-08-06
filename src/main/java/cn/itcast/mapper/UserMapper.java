package cn.itcast.mapper;

import cn.itcast.domain.User;

import java.util.List;

public interface UserMapper {
    // 根据编号查询用户信息
    public User queryUserById(Long id);

    // 查询所有的用户信息
    public List<User> queryAll();

    // 增加用户
    public void insertUser(User user);

    // 修改用户
    public void updateUser(User user);

    // 根据编号 删除用户
    public void deleteById(Long id);
}
