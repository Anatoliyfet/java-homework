package ru.edu.module13.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.edu.module13.entity.User;
import ru.edu.module13.exceptions.ItemNotFoundException;
import ru.edu.module13.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ItemNotFoundException("User not found, id = " + id));
    }

    public User save(User user) {
        return repository.save(user);
    }

    public User update(User user) {
        findById(user.getId());
        return repository.save(user);
    }
    public User get(String userName) {
        return repository.findUserByName(userName);
    }

    public void deleteById(Long id) {
        findById(id);
        repository.deleteById(id);
    }
}
