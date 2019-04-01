package ru.ttv.meteringvaluesregistrationservice;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.ttv.meteringvaluesregistrationservice.model.User;
import ru.ttv.meteringvaluesregistrationservice.repository.UserRepository;

/**
 * @author Teplykh Timofey  25.03.2019
 */
@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    @Ignore
    public void findByNameTest(){
        User user = new User();
        user.setUsername("testUsername");
        entityManager.persist(user);

        User foundedUser = userRepository.findByUsername("testUsername");
        Assert.assertTrue(foundedUser.getUsername().equals("testUsername"));
    }
}