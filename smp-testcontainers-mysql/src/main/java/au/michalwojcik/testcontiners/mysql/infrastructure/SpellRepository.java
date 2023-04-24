package au.michalwojcik.testcontiners.mysql.infrastructure;

import au.michalwojcik.testcontiners.mysql.domain.Spell;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * @author michal-wojcik
 */
@Repository
public interface SpellRepository extends CrudRepository<Spell, UUID> {

    Optional<Spell> findByName(String name);
}
