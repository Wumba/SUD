package exercises.LS03_3;

import java.util.UUID;

public class Coworker {
    private UUID id;
    private String name;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void generateNewUUID() {
        this.id = UUID.randomUUID();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "name: " +
                name +
                "; " +
                "id: " +
                id;
    }
}
