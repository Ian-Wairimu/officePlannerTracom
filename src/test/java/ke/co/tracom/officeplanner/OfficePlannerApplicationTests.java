package ke.co.tracom.officeplanner;

import ke.co.tracom.officeplanner.entity.user.Name;
import ke.co.tracom.officeplanner.entity.user.User;
import ke.co.tracom.officeplanner.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
class OfficePlannerApplicationTests {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private UserRepository repository;

    @Test
    public void testUser() {

        Name name = new Name();
        name.setFirstname("brian");
        name.setSurname("kings");
        User user = new User();
        user.setName(name);
        user.setEmail("brian@gmail.com");
        user.setPassword("12734");
        user.setGender("female");
        user.setPhone("0797281395");

        User savedUser = repository.save(user);

        User existUser = entityManager.find(User.class, savedUser.getId());

        assertThat(user.getEmail()).isEqualTo(existUser.getEmail());

    }
}
