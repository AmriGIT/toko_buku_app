package co.g2maruli.userapi.service;

import co.g2maruli.userapi.entity.User;
import co.g2maruli.userapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;


    public void save(User user) {
        userRepository.save(user);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }

    public User findById(Integer id) {
        return userRepository.findById(id).get();
    }


    public List<User> findAll() {
        Iterable<User> iterableUser = userRepository.findAll();
        List<User>userList = StreamSupport.stream(iterableUser.spliterator(), false).collect(Collectors.toList());
        return userList;
    }
}
