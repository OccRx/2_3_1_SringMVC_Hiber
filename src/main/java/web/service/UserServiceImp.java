package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.DAO.UserDAO;
import web.model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService{

    @Autowired
    UserDAO userDAO;

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public User getUserById(long id) {
        return userDAO.getUserById(id);
    }

    @Override
    public void add(User user) {
        userDAO.add(user);
    }

    @Override
    public void update(User newUser) {
        userDAO.update(newUser);
    }

    @Override
    public void delete(long id) {
        userDAO.delete(id);
    }


}
