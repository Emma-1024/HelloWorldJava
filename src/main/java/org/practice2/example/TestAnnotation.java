package org.practice2.example;
import org.practice2.Range;

public class TestAnnotation {
    @Range
    public static void testMethod() throws NoSuchMethodException {
        Range range = TestAnnotation.class.getMethod("testMethod").getAnnotation(Range.class);
        if (range != null){
            if(range.enabled()){
                System.out.println(1111);
            }
        }else{
            System.out.println(333);
        }
    }

}
