package au.michalwojcik.testcontiners.mysql.infrastructure;

import au.michalwojcik.testcontiners.mysql.domain.Spell;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author michal-wojcik
 */
@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class SpellRepositoryIT {

    @Container
    static MySQLContainer<?> mySQLContainer = new MySQLContainer<>(
            DockerImageName.parse("mysql:8.0.24"))
            .withDatabaseName("test")
            .withUsername("username")
            .withPassword("password");

    @Autowired
    private SpellRepository spellRepository;

    @Test
    void name() {
        spellRepository.save(new Spell(
                UUID.randomUUID(),
                "Alohomora",
                0
        ));

        assertThat(spellRepository.findByName("Alohomora")).isPresent();
    }

    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mySQLContainer::getJdbcUrl);
        registry.add("spring.datasource.username", mySQLContainer::getUsername);
        registry.add("spring.datasource.password", mySQLContainer::getPassword);
    }
}