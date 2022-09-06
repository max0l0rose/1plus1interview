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


     public static void main(String[] args) {
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


