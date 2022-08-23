import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    static class A {
        void f1() {
            System.out.println("fa");
        }
    }

    static class B extends A{
        void f1() {
            System.out.println("fb");
        }

        void f1(int a) {
            System.out.println(a);
        }
    }


    static void findCountOfEntrance() {
        String str = "ONE, TWO, THRE, SIX, FIVE, SIX, ONEEE";
        String words = "ONE, SIX, ONE";

        // streams
        String[] arrStr = str.split(",");
        String[] arrWords = words.split(",");

        // count words
//        Map<String,Long> collect = wordsList.stream()
//                .collect( Collectors.groupingBy( Function.identity(), Collectors.counting() ));

        Map<String, Long> map = Arrays.stream(arrStr)
                //.sorted(Comparator.reverseOrder())
                .collect(Collectors.groupingBy( //Function.identity()
                        el -> {
                            if (Arrays.stream(arrWords).filter(e -> e.equals(el)).findAny().isPresent())
                                return el;
                            return "";
                        }
                        , Collectors.counting()
                ));

        Map<String, Long> map2 = map.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder())) //(c1, c2) -> c1.getValue().compareTo(c2.getValue())
               //.sorted(Map.Entry.comparingByValue().reversed()) //(c1, c2) -> c1.getValue().compareTo(c2.getValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue
                        , (e1, e2) -> e1// + e2
                        , LinkedHashMap::new
                ));

        int a = 1;

        //ONE - 1
        //SIX - 2
    }


    //0 1 2 3 4 5 6
    //1 1 2 3 5 8 13
    static int fib_r(int n) {
        if (n == 0) {
            System.out.println(1);
            return 1;
        }
        if(n == 1) {
            System.out.println(1);
            return 1;
        }

        int a = fib_r(n-1);
        System.out.println("a = " + a);
        int b = fib_r(n-2);
        System.out.println("b = " + b);
        int c = a + b;
        System.out.println("c = " + c + " (" + a + "+" + b + ")");
        return c;
    }


    static int fib(int n) {
        if (n == 0)
            return 1;
        if(n == 1)
            return 1;

        int a = 1;
        int b = 1;
        int res = 0;
        for(int i=2; i<n; i++) {
            res = a + b;
            b = a;
            a = res;
        }

        return res;
    }


    public static void main(String[] args) {

        findCountOfEntrance();

//        int res = fib(3);
//        System.out.println(res);

//  A x = new A();
//  x.f1();    //fa
//  x.f1(5);   // comp error

//  A x = new B();
//  x.f1();   //fb
  //x.f1(5);  // comp error

//  B x = (B)new A(); // runtime error (A)
//  x.f1(); // comp error // fb
//  x.f1(5);  // comp error

//  B x = new B();
//  x.f1(); //fb
//  x.f1(5); // 5

        int a = 1;
    }

}


