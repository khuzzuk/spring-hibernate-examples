package pl.khuzzuk.jpa;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.khuzzuk.jpa.dao.MySecondDao;

public class JpaApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("pl.khuzzuk.jpa");
        context.refresh();

        work(context);
        context.close();
    }

    private static void work(ApplicationContext applicationContext) {
        MyDao dao = applicationContext.getBean(MyDao.class);

        System.out.println("save person with main source");
        Person person = new Person();
        person.setName("Person");
        System.out.println(person);
        Person savedPerson = dao.savePerson(person);
        System.out.println(person);

        System.out.println("find person with secondary source");
        MySecondDao secondaryDao = applicationContext.getBean(MySecondDao.class);
        System.out.println(secondaryDao.find(savedPerson.getId()));
        System.out.println("save person with secondary source");
        Person secondaryDaoPerson = new Person();
        secondaryDaoPerson.setName("First");
        secondaryDao.savePersonWithoutClosing(secondaryDaoPerson);
        secondaryDaoPerson.setName("Second");
        secondaryDao.commitTransaction();
        Person savedPerson2 = secondaryDao.find(secondaryDaoPerson.getId());
        System.out.println(savedPerson2);
    }
}
