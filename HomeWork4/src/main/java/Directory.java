import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Directory {
    private static int personalNumber;
    private static Map<Integer, Employee> employeeDic = new HashMap<>();

    public void add(Employee employee) {
        personalNumber++;
        employeeDic.put(personalNumber, employee);
    }
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (var entry :
                employeeDic.entrySet()) {
            str.append("Personal number: " + entry.getKey() + " " + entry.getValue() + "\n");
        }
        return str.toString();
    }

    public List<Employee> getExperiens(int min, int max) {
        List<Employee> lstEmpl = new ArrayList<>();
        for (var entry : employeeDic.entrySet()) {
            if (entry.getValue().getExperience() < max && entry.getValue().getExperience() > min) {
                lstEmpl.add(entry.getValue());
            }
        }
        return lstEmpl;
    }

    public List<Employee> getExperiens(int min) {
        List<Employee> lstEmpl = new ArrayList<>();
        for (var entry : employeeDic.entrySet()) {
            if (entry.getValue().getExperience() > min) {
                lstEmpl.add(entry.getValue());
            }
        }
        return lstEmpl;
    }

    public Employee getPersonalNumber(int personalNumber) {
        Employee employee = null;
        for (var entry : employeeDic.entrySet()) {
            if (entry.getKey() == personalNumber) {
                employee = entry.getValue();
            }
        }
        return employee;
    }

    public List<String> getNumberByName(String name) {
        List<String> result = new ArrayList<>();
        for (var entry : employeeDic.entrySet()) {
            if(entry.getValue().getName().equalsIgnoreCase(name)){
                result.add(entry.getValue().getNumber() + " - " + entry.getValue().getName());
            }
        }
        return result;
    }
}
