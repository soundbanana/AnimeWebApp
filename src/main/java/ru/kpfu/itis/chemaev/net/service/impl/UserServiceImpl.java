package ru.kpfu.itis.chemaev.net.service.impl;

import ru.kpfu.itis.chemaev.net.dao.UserDao;
import ru.kpfu.itis.chemaev.net.dao.impl.UserDaoImpl;
import ru.kpfu.itis.chemaev.net.dto.UserDto;
import ru.kpfu.itis.chemaev.net.model.User;
import ru.kpfu.itis.chemaev.net.service.UserService;
import ru.kpfu.itis.chemaev.net.util.PasswordUtil;


import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDaoImpl();

    @Override
    public List<UserDto> getAll() {
        return userDao.getAll().stream().map(
                u -> new UserDto(u.getFirstName(), u.getLastName(), u.getLogin())
        ).collect(Collectors.toList());
    }

    @Override
    public UserDto get(int id) {
        User u = userDao.get(id);
        return new UserDto(u.getFirstName(), u.getLastName(), u.getLogin());
    }

    @Override
    public void save(User user) {
        user.setPassword(PasswordUtil.encrypt(user.getPassword()));
        userDao.save(user);
    }

    @Override
    public UserDto get(String login) {
        User u = userDao.get(login);
        return new UserDto(u.getFirstName(), u.getLastName(), u.getLogin());
    }

    @Override
    public void update(User user) {
        user.setPassword(PasswordUtil.encrypt(user.getPassword()));
        userDao.update(user);
    }
}
