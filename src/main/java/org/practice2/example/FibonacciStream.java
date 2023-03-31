package org.practice2.example;
import java.util.function.LongSupplier;
import java.util.stream.LongStream;

public class FibonacciStream {
    public static void main() {
        LongStream fib = LongStream.generate(new FibSupplier());
        fib.limit(20).forEach(System.out::println);
    }
}
class FibSupplier implements LongSupplier {
    long j = 1, i = 0;
    public long getAsLong() {
        long k = j + i;
        j = i;
        i = k;
        return k;
    }
}