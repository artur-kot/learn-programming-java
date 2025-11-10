
public class User {
    private String name;
    private int age;

    public User(String name, int age) {
        if (name == null || name.isEmpty()) {
            this.name = "Unknown";
        } else {
            this.name = name;
        }

        if (age < 0) {
            this.age = 0;
        } else {
            this.age = age;
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        }
    }

    @Override
    public String toString() {
        return "User[name=" + name + ", age=" + age + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        User other = (User) obj;
        return age == other.age && name.equals(other.name);
    }

    public boolean isAdult() {
        return age >= 18;
    }

    public int getBirthYear() {
        return 2024 - age;
    }

    public boolean canVote() {
        return age >= 18;
    }
}
