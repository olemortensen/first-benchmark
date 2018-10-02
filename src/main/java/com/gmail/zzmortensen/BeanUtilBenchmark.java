package com.gmail.zzmortensen;

import org.apache.commons.beanutils.BeanUtils;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

public class BeanUtilBenchmark {

    @State(Scope.Benchmark)
    public static class MyState {
        public static Bean1 origin = new Bean1();
        public static Bean2 destination = new Bean2();
    }

    @Benchmark
    public void testAssignment(MyState state, Blackhole blackhole) {
        MyState.destination.setI1(MyState.origin.getI1());
        MyState.destination.setI2(MyState.origin.getI2());
        MyState.destination.setI3(MyState.origin.getI3());
        MyState.destination.setI4(MyState.origin.getI4());
        MyState.destination.setS1(MyState.origin.getS1());
        MyState.destination.setS2(MyState.origin.getS2());
        MyState.destination.setS3(MyState.origin.getS3());
        MyState.destination.setS4(MyState.origin.getS4());
        MyState.destination.setStrings(MyState.origin.getStrings());

        blackhole.consume(MyState.destination);
    }

    @Benchmark
    public void testPropertyCopy(MyState state, Blackhole blackhole) throws InvocationTargetException, IllegalAccessException {
        BeanUtils.copyProperties(MyState.destination, MyState.origin);

        blackhole.consume(MyState.destination);
    }
}

class Bean1 {
    private Integer i1;
    private Integer i2;
    private Integer i3;
    private Integer i4;
    private String s1;
    private String s2;
    private String s3;
    private String s4;
    private List<String> strings = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n");

    public Integer getI1() {
        return i1;
    }

    public void setI1(Integer i1) {
        this.i1 = i1;
    }

    public Integer getI2() {
        return i2;
    }

    public void setI2(Integer i2) {
        this.i2 = i2;
    }

    public Integer getI3() {
        return i3;
    }

    public void setI3(Integer i3) {
        this.i3 = i3;
    }

    public Integer getI4() {
        return i4;
    }

    public void setI4(Integer i4) {
        this.i4 = i4;
    }

    public String getS1() {
        return s1;
    }

    public void setS1(String s1) {
        this.s1 = s1;
    }

    public String getS2() {
        return s2;
    }

    public void setS2(String s2) {
        this.s2 = s2;
    }

    public String getS3() {
        return s3;
    }

    public void setS3(String s3) {
        this.s3 = s3;
    }

    public String getS4() {
        return s4;
    }

    public void setS4(String s4) {
        this.s4 = s4;
    }

    public List<String> getStrings() {
        return strings;
    }

    public void setStrings(List<String> strings) {
        this.strings = strings;
    }
}


class Bean2 {
    private Integer i1;
    private Integer i2;
    private Integer i3;
    private Integer i4;
    private String s1;
    private String s2;
    private String s3;
    private String s4;
    private List<String> strings = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n");

    public Integer getI1() {
        return i1;
    }

    public void setI1(Integer i1) {
        this.i1 = i1;
    }

    public Integer getI2() {
        return i2;
    }

    public void setI2(Integer i2) {
        this.i2 = i2;
    }

    public Integer getI3() {
        return i3;
    }

    public void setI3(Integer i3) {
        this.i3 = i3;
    }

    public Integer getI4() {
        return i4;
    }

    public void setI4(Integer i4) {
        this.i4 = i4;
    }

    public String getS1() {
        return s1;
    }

    public void setS1(String s1) {
        this.s1 = s1;
    }

    public String getS2() {
        return s2;
    }

    public void setS2(String s2) {
        this.s2 = s2;
    }

    public String getS3() {
        return s3;
    }

    public void setS3(String s3) {
        this.s3 = s3;
    }

    public String getS4() {
        return s4;
    }

    public void setS4(String s4) {
        this.s4 = s4;
    }

    public List<String> getStrings() {
        return strings;
    }

    public void setStrings(List<String> strings) {
        this.strings = strings;
    }
}