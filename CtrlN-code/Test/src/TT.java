import java.util.ArrayList;

class  tt{

        public static Person cl(Person o) {
            return  o =  new Person(1, "i" ," i");
        }
    public static void main(String[] args) {
        ArrayList<Person> personArrayList = new ArrayList<>(5);
        Person p = new Person(1,"a", "b");

        for (int i = 0; i < 5; i++) {
            personArrayList.add(cl(p));
        }
        System.out.println(personArrayList);

       personArrayList.set(0,p).setAge(1);
       personArrayList.set(1,p).setAge(9);
       personArrayList.set(2,p).setAge(8);
        System.out.println(personArrayList.get(0).toString());
    }
}