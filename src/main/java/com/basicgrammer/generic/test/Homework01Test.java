package com.basicgrammer.generic.test;

import com.basicgrammer.generic.DAO;
import com.basicgrammer.generic.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author Pi
 * @date 2021-04-22 15:28
 */
public class Homework01Test {

    @Test
    public void should_return_a_user_from_map_by_key_id() throws Exception {
        DAO<User> dao = new DAO();
        dao.save("1", new User(1, 22, "jacky"));
        User user = dao.get("1");
        assertEquals(user.getName(), ("jacky"));
        assertEquals(user.getAge(), (22));
    }

    @Test
    public void should_throw_exception_when_save_id_or_entity_is_null() throws Exception {
        DAO<User> userDAO = new DAO<>();
        Assertions.assertThrows(NullPointerException.class, () -> userDAO.update(null, null));
    }

    @Test
    public void should_return_new_user_info_after_update() throws Exception {
        DAO<User> userDAO = new DAO<>();
        userDAO.save("1", new User(1, 23, "Jacky"));
        User user = userDAO.get("1");
        assertEquals(user.getName(), ("Jacky"));
        userDAO.update("1", new User(1, 22, "Tom"));
        User updatedUser = userDAO.get("1");
        assertEquals(updatedUser.getName(), ("Tom"));
    }

    @Test
    public void should_throw_null_point_exception_if_update_input_null_param() throws Exception {
        DAO<User> userDAO = new DAO<>();
        Assertions.assertThrows(NullPointerException.class, () -> userDAO.update(null, null));
    }

    @Test
    public void should_return_list_in_dao_data() throws Exception {
        DAO<User> userDAO = new DAO<>();
        userDAO.save("1", new User(1, 23, "Jacky"));
        userDAO.save("2", new User(2, 22, "Tom"));
        List<User> userList = userDAO.list();
        assertEquals(userList.size(), (2));

    }

    @Test
    public void should_return_0_element_when_delete_entity() throws Exception {
        DAO<User> userDAO = new DAO<>();
        userDAO.save("1", new User(1, 23, "Jacky"));
        userDAO.delete("1");
        assertEquals(userDAO.list().size(), (0));
    }


}
