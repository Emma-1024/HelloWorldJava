package org.practice2.example;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

// Explanation ::

@FunctionalInterface
interface FunctionCombine<T, R> {
    R combine(T val1, T val2);
}

public class MethodReferenceExample {
    Data d1 = new Data("foo");
    Data d2 = new Data("bar");

    static String combine(Data first, Data second) {
        return first.content + second.content;
    }

    public Data getD1() {
        return d1;
    }

    public String callCombine(FunctionCombine<Data, String> clazz) {
        return clazz.combine(d1, d2);
    }

    public String callInstanceCombine(Function<Data, String> instance) {
        return instance.apply(d1);
    }

    static class Data {
        Data(String str) {
            content = str;
        }

        String content;

        public String combine(Data other) {
            return content + other.content;
        }

//        Same as above combine
//        public static String combine(Data THIS, Data other) {
//            return THIS.content + other.content;
//        }

        public String instanceCombine(Data other) {
            return content + other.content + "INS";
        }

    }

    public static void go() {
//         Static Method Reference
        MethodReferenceExample mr = new MethodReferenceExample();
        String staticResult = mr.callCombine(MethodReferenceExample::combine);
        System.out.println(staticResult);
        String nonStaticResult = mr.callCombine(Data::combine);
        System.out.println(nonStaticResult);

//        Instance Method Reference
        Data data = new Data("baz");
        String instanceResult = mr.callInstanceCombine(data::instanceCombine);
        System.out.println(instanceResult);

//        Constructor Reference
        List<String> strings = Arrays.asList("foo", "bar", "baz");
        List<Data> dataList = strings.stream().map(Data::new).toList();
        System.out.println(dataList);
        goNoMethodReference();
    }

    public static void goNoMethodReference() {
//         Method Reference
        MethodReferenceExample mr = new MethodReferenceExample();
        String staticResult = mr.callCombine(new FunctionCombine<Data, String>() {
            @Override
            public String combine(Data data1, Data data2) {
                return data1.content + data2.content;
            }
        });
        System.out.println(staticResult);
        String nonStaticResult = mr.callCombine(new FunctionCombine<Data, String>() {
            @Override
            public String combine(Data data1, Data data2) {
                return data1.combine(data2);
            }
        });
        System.out.println(nonStaticResult);


//        var d1 = new Data("d");
//        var d2 = new Data("2");
//        d1.combine(d2);
//        Data.combine(d1, d2);

//        Instance Method Reference
        Data data = new Data("baz");
        String instanceResult = mr.callInstanceCombine(new Function<Data, String>() {
            @Override
            public String apply(Data data1) {
                return data.instanceCombine(data1);
            }
        });
        System.out.println(instanceResult);

//        Constructor Reference
        List<String> strings = Arrays.asList("foo", "bar", "baz");
        List<Data> dataList = strings.stream().map(new Function<String, Data>() {
            @Override
            public Data apply(String str) {
                return new Data(str);
            }
        }).toList();
        System.out.println(dataList);
    }
}
