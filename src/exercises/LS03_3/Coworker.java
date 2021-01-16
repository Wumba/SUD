package exercises.LS03_3;

public class Coworker {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
