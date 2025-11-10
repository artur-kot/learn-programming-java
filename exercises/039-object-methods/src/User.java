
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

    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    // TODO: Override toString() method
    // Return format: "User[name=Alice, age=25]"
    // Use @Override annotation
    // This method should return a String

    // TODO: Override equals() method
    // Accept Object parameter: public boolean equals(Object obj)
    // Use @Override annotation
    // Follow the standard pattern:
    // 1. Check if this == obj (same reference)
    // 2. Check if obj is null or different class
    // 3. Cast obj to User
    // 4. Compare name and age fields
    // Return true only if both name and age match

    // TODO: Create isAdult() method
    // Returns true if age >= 18, false otherwise
    // This is an instance method (not static)

    // TODO: Create getBirthYear() method
    // Returns estimated birth year: 2024 - age
    // Return type: int

    // TODO: Create canVote() method
    // Returns true if age >= 18, false otherwise
    // Similar to isAdult()
}
