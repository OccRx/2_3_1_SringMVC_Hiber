package web.DAO;

import web.model.User;

import java.util.List;

public interface UserDAO {

    List<User> findAll();

    User getUserById(long id);

    void add(User user);

    void update(User newUser);

    void delete(long id);
}
