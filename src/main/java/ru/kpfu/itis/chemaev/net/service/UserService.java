package ru.kpfu.itis.chemaev.net.service;

import ru.kpfu.itis.chemaev.net.dto.UserDto;
import ru.kpfu.itis.chemaev.net.model.User;

import java.util.List;

public interface UserService {
    List<UserDto> getAll();

    UserDto get(int id);

    void save(User user);

    UserDto get(String login);

    void update(User user);

}
