package ru.kpfu.itis.chemaev.net.dao;

import ru.kpfu.itis.chemaev.net.model.User;

public interface UserDao extends Dao<User> {
    User get(String value);
}
