package com.tuyu.java8.stream;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author tuyu
 * @date 9/27/18
 * Talk is cheap, show me the code.
 */
public class StreamApiTest {

    private static final Collection<Task> tasks = Arrays.asList(
            new Task(Status.OPEN, 5),
            new Task(Status.OPEN, 13),
            new Task(Status.CLOSED, 8)
    );

    /**
     * 所有状态为OPEN的任务一共有多少分数
     */
    @Test
    public void testSum() {
        int sum = tasks.stream()
                .filter(s -> s.getStatus().equals(Status.OPEN))
                .mapToInt(Task::getPoints)
                .sum();
        System.out.println("the score of tasks which status is OPEN is: " + sum);
    }

    /**
     * 计算task分数和
     */
    @Test
    public void testReduce() {
        Integer totalScore = tasks.stream()
                .parallel()
                .map(Task::getPoints)
                .reduce(0, Integer::sum);
        System.out.println("total score is: " + totalScore);
    }

    /**
     * 分组
     */
    @Test
    public void testGroupBy() {
        Map<Status, List<Task>> map = tasks.stream()
                .collect(Collectors.groupingBy(Task::getStatus));
        System.out.println(map);
    }

    /**
     * 整个集合中每个task分数（或权重）的平均值
     */
    @Test
    public void test() {

        final Double totalScore = tasks.stream()
                .mapToDouble(Task::getPoints)
                .reduce(0, Double::sum);
        tasks.stream()
                .map(Task::getPoints)
                .mapToDouble(s -> s / totalScore)
                .boxed()
                .mapToLong(s -> (long) (s * 100))
                .mapToObj(s -> s + "%")
                .forEach(System.out::println);
    }

    /**
     * I/O操作
     */
    @Test
    public void testIO() throws IOException {
        String fileName = "src/test/resources/log4j.properties";
        Path path = new File(fileName).toPath();
        try (Stream<String> lines = Files.lines(path)) {
            lines.onClose(() -> System.out.println("done!"))
                    .forEach(System.out::println);
        }
    }

}

enum Status {
    OPEN, CLOSED
}

final class Task {
    private final Status status;
    private final Integer points;

    Task(final Status status, final Integer points) {
        this.status = status;
        this.points = points;
    }

    public Integer getPoints() {
        return points;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return String.format("[%s, %d]", status, points);
    }
}
