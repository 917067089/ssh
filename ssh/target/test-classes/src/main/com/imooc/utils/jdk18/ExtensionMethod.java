package main.com.imooc.utils.jdk18;

import org.junit.Test;

public class ExtensionMethod {
    class B implements A {
//        void a(){}实现类方法不能重名
    }
    interface A {
        //可以有多个默认方法
        public default void a(){
            System.out.println("a");
        }
        public default void b(){
            System.out.println("b");
        }
        //报错static和default不能同时使用
//        public static default void c(){
//            System.out.println("c");
//        }
    }
    @Test
    public void test() {
        B b = new B();
        b.a();

    }
    class D implements E,F{

        @Override
        public void hello() {
//            E.super().hello();
        }
    }
    interface E{
        public void hello();
    }
    interface F{
        public void hello();
    }
}
