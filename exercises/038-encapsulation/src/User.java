
public class User {
    // TODO: Make these fields PRIVATE instead of public
    public String name;
    public int age;

    // TODO: Add validation to the constructor:
    // - If name is null or empty, set it to "Unknown"
    // - If age is less than 0, set it to 0
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // TODO: Create a setName() method with validation
    // Only set the name if it's not null and not empty
    // If invalid, do nothing (keep the current name)

    // TODO: Create a setAge() method with validation
    // Only set the age if it's >= 0
    // If invalid, do nothing (keep the current age)

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}
