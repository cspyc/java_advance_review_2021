package com.basicgrammer.generic.test;

import com.basicgrammer.generic.DAO;
import com.basicgrammer.generic.User;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

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
        assertThat(user.getName(), is("jacky"));
        assertThat(user.getAge(), is(22));
    }

    @Test(expected = NullPointerException.class)
    public void should_throw_exception_when_save_id_or_entity_is_null() throws Exception {
        DAO<User> userDAO = new DAO<>();
        userDAO.save(null, null);
    }

    @Test
    public void should_return_new_user_info_after_update() throws Exception {
        DAO<User> userDAO = new DAO<>();
        userDAO.save("1", new User(1, 23, "Jacky"));
        User user = userDAO.get("1");
        assertThat(user.getName(), is("Jacky"));
        userDAO.update("1", new User(1, 22, "Tom"));
        User updatedUser = userDAO.get("1");
        assertThat(updatedUser.getName(), is("Tom"));
    }

    @Test(expected = NullPointerException.class)
    public void should_throw_null_point_exception_if_update_input_null_param() throws Exception {
        DAO<User> userDAO = new DAO<>();
        userDAO.update(null, null);
    }

    @Test
    public void should_return_list_in_dao_data() throws Exception {
        DAO<User> userDAO = new DAO<>();
        userDAO.save("1", new User(1, 23, "Jacky"));
        userDAO.save("2", new User(2, 22, "Tom"));
        List<User> userList = userDAO.list();
        assertThat(userList.size(), is(2));

    }

    @Test
    public void should_return_0_element_when_delete_entity() throws Exception{
        DAO<User> userDAO = new DAO<>();
        userDAO.save("1",new User(1,23,"Jacky"));
        userDAO.delete("1");
        assertThat(userDAO.list().size(),is(0));
    }


}
