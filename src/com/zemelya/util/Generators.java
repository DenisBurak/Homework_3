package com.zemelya.util;

import com.zemelya.domain.Book;
import com.zemelya.domain.Student;
import com.zemelya.domain.User;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.*;

import static com.zemelya.util.Constants.*;

public class Generators {

    public static String generateString(int length) {

        boolean useLetters = true;
        boolean useNumbers = false;

        return RandomStringUtils.random(length, useLetters, useNumbers);
    }

    public static List<Book> generateBooks(int count) {

        List<Book> list = new LinkedList<>();

        addBookInCollection(list, count);

        return list;
    }

    public static Set<Book> generateBooks(int count, int countOfTheSameBooks) {

        int countOfDifferentBooks = count - countOfTheSameBooks;
        Set<Book> set = new HashSet<>();

        addBookInCollection(set, countOfDifferentBooks);

        addTheSameBookInCollection(set, countOfTheSameBooks);

        return set;
    }

    public static <T extends Collection> T addBookInCollection(T collection, int count) {

        for (int i = 0; i < count; i++) {

            collection.add(
                    new Book(Generators.generateString(LENGHT_OF_TITLE),
                            Generators.generateString(LENGHT_OF_AUTHOR_SURNAME),
                            Generators.generateString(LENGHT_OF_AUTHOR_NAME),
                            Generators.generateString(LENGHT_OF_AUTHOR_PATRONYMIC),
                            (int) (Math.random() * MAX_YEAR_PUBLICATION))
            );
        }

        return collection;
    }

    public static <T extends Collection> T addTheSameBookInCollection(T collection, int count) {

        String titleForTheSameBooks = Generators.generateString(LENGHT_OF_TITLE);
        String surnameForTheSameBooks = Generators.generateString(LENGHT_OF_AUTHOR_SURNAME);
        String nameForTheSameBooks = Generators.generateString(LENGHT_OF_AUTHOR_NAME);
        String patronymicForTheSameBooks = Generators.generateString(LENGHT_OF_AUTHOR_PATRONYMIC);
        int yearOfPublicationForTheSameBooks = (int) (Math.random() * MAX_YEAR_PUBLICATION);

        for (int i = 0; i < count; i++) {
            collection.add(
                    new Book(titleForTheSameBooks,
                            surnameForTheSameBooks,
                            nameForTheSameBooks,
                            patronymicForTheSameBooks,
                            yearOfPublicationForTheSameBooks)
            );
        }

        return collection;
    }

    public static Set<Student> generateStudents(int count) {

        Set<Student> set = new TreeSet<>();
        for (int i = 0; i < count; i++) {
            set.add(
                    new Student(Generators.generateString(LENGTH_FULL_STUDENT_NAME),
                            Generators.generateString(LENGHT_DEFAULT_STRING),
                            Generators.generateString(LENGHT_DEFAULT_STRING),
                            (int) (MIN_STUDENT_AGE + Math.random() * MAX_STUDENT_AGE),
                            (int) (MIN_STUDENT_COURSE + Math.random() * MAX_STUDENT_COURSE)
                    )
            );
        }
        return set;
    }

    public static List<User> generateUser(int count) {

        List<User> users = new LinkedList<>();
        // будет использоваться для установки id в объекте Users
        long id = 1l;

        // сперва будет геренация объектов типа Users с пустым списком друзей
        for (int i = 0; i < count; i++) {
            users.add(

                    new User(id,
                            Generators.generateString(LENGHT_OF_USER_NAME),
                            Generators.generateString(LENGHT_DEFAULT_STRING),
                            new LinkedList<>())
            );
            id++;
        }
        for (User user : users) {

            List<User> friends = new LinkedList<>();

            for (int j = 0; j < FRIENDS_COUNT; j++) {

                User randomFriend = users.get((int) (Math.random() * (users.size() - 1)));

                    /* если рандомный user равен самому себе, то он не может быть другом
                     и если у рандомного друга есть в друзьях user то такого мы тоже не добавляем чтобы не получить
                    зацикливания*/
                if (randomFriend.equals(user)) {
                    continue;
                } else {
                    if (!friends.contains(randomFriend)
                            && !randomFriend.getFriends().contains(friends)) {
                        friends.add(randomFriend);
                    }
                }
            }
            user.setFriends(friends);
        }
        return users;
    }

}
