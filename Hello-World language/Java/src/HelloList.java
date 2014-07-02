import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;

import java.util.ArrayList;
import java.util.List;

public class HelloList {
    public static void main(String[] args) {
        List<String> names = new ArrayList<String>();
        names.add("Jay");

        System.out.println("Old List Content: " + names.get(0));

        // Java7
        // List<String> names7 = new ArrayList<>();
        // names.add("Jay");

        // List<String> namesByNewArrayList = newArrayList("Jay");
        // List<String> namesByOf = of("Jay");
        Person boy13 = new Person("Jay", 13);
        Person youngMan = new Person("Adam", 27);
        Person oldMan = new Person("Andy", 80);
        List<Person> persons = new ArrayList<Person>();
        persons.add(boy13);
        persons.add(youngMan);
        persons.add(oldMan);

        transformListByOldStyle(persons);
        transformListByFunctionStyle(persons);

    }

    public static void transformListByOldStyle(List<Person> persons) {
        List<String> names = new ArrayList<String>();
        for(Person person : persons) {
            int age = person.getAge();
            if (age >= 14 && age <= 28) {
                names.add(person.getName());
            }
        }

        for(String name : names) {
            System.out.println("Young Man: " + name);
        }
    }

    public static void transformListByFunctionStyle(List<Person> persons) {
        FluentIterable<String> names = FluentIterable.from(persons)
                                            .filter(isAgeQualified()).transform(toNames());
        for(String name : names) {
            System.out.println("Young Man: " + name);
        }
    }

    private static Predicate<Person> isAgeQualified() {
        return new Predicate<Person>() {
            @Override
            public boolean apply(Person person) {
                int age = person.getAge();
                return age >= 14 && age <= 28;
            }
        };
    }

    private static Function<Person, String> toNames() {
        return new Function<Person, String>() {
            @Override
            public String apply(Person person) {
                return person.getName();
            }
        };
    }

}
