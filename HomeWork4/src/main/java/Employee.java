public class Employee {
    private String name;
    private String number;
    private int experience;


    public Employee(String name, String number, int experience) {
        this.name = name;
        this.number = number;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public int getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return "Name: " + name + '\'' +
                ", phone number: " + number + '\'' +
                ", experience: " + experience;
    }
}
