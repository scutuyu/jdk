package com.tuyu.java8.parallelarray;

import lombok.Data;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.ThreadLocalRandom;

/**
 * java8新特性，并行数组
 *
 * @author tuyu
 * @date 9/28/18
 * Talk is cheap, show me the code.
 */
public class ParallelArrayTest {

    /**
     * 并行设值，并行排序
     */
    @Test
    public void testParallelSort() {
        Long[] arr = new Long[20000];
        Arrays.parallelSetAll(arr, (i) -> ThreadLocalRandom.current().nextLong(10000));

        // 打印排序前
        Arrays.stream(arr)
                .limit(10)
                .forEach(System.out::println);

        // 并行排序, 逆序
        Arrays.parallelSort(arr, Collections.reverseOrder());

        // 打印排序
        Arrays.stream(arr)
                .limit(10)
                .forEach(System.out::println);
    }

    @Test
    public void testReverse() {
        Integer[] arr = {1, 2, 3, 4};
        Arrays.sort(arr, Collections.reverseOrder());
        for (int i : arr){
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    @Test
    public void testComparator() {
        User[] users = User.getUsers();
        Arrays.parallelSort(users, Comparator.comparing(User::getAge).reversed());
        Arrays.stream(users)
                .forEach(System.out::println);
    }

    @Data
    static class User implements Comparable<User> {
        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int compareTo(User user) {
            return name.compareTo(user.name);
        }

        public static User[] getUsers() {
            User[] users = new User[6];
            users[0] = new User("Ram", 25);
            users[1] = new User("Shyam", 22);
            users[2] = new User("Mohan", 21);
            users[3] = new User("Suresh", 30);
            users[4] = new User("Ramesh", 20);
            users[5] = new User("Dinesh", 27);
            return users;
        }
    }
}
