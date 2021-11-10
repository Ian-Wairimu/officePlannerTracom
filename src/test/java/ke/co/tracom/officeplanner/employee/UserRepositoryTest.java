package ke.co.tracom.officeplanner.employee;

import ke.co.tracom.officeplanner.user.User;
import ke.co.tracom.officeplanner.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase
@Rollback(false)
public class UserRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testUser(){
        User user = new User();
        user.setFirstName("ian");
        user.setLastName("wairimu");
        user.setUserEmail("ianmoon@gmail.com");
        user.setUserPassword("wairimu");
////        build();
//        User savedUser = userRepository.save(user);
//
//        User existUser = entityManager.find(User.class, savedUser.getUserId());
//
//        assertThat(user.getUserEmail()).isEqualTo(existUser.getUserEmail());

    }
}
