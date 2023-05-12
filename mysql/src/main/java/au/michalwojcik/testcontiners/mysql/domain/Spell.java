package au.michalwojcik.testcontiners.mysql.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

/**
 * @author michal-wojcik
 */
@Entity
public class Spell {

    @Id
    private UUID id;
    private String name;
    private int level;

    public Spell() {
    }

    public Spell(UUID id, String name, int level) {
        this.id = id;
        this.name = name;
        this.level = level;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
