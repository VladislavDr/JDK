public class main {
    public static void main(String[] args) {
        Directory dic = new Directory();
        Employee vasia = new Employee("Вася", "8920744", 5);
        Employee viktoria = new Employee("Виктория", "8920744", 1);
        Employee viktori = new Employee("Виктория", "89207", 1);

        dic.add(vasia);
        dic.add(viktoria);
        dic.add(viktori);

        System.out.println(dic);
        System.out.println(dic.getPersonalNumber(1));
        System.out.println(dic.getExperiens(2));
        System.out.println(dic.getNumberByName("Виктория"));
    }
}
