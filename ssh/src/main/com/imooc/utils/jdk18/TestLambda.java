package main.com.imooc.utils.jdk18;

import org.junit.Test;

import java.util.function.Function;
import java.util.function.Supplier;

public class TestLambda {
    public void TestLambda(){

    }
    public void TestLambda(int i){

    }
    public static void execute (Runnable runnable){
        runnable.run();
    }
    public static void main(String[] args){
        //jdk1.8之前
        execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("run");
            }
        });
        //使用Lambda表达式
        execute(() -> System.out.println("run"));
    }
    /**
     * 指向静态方法的方法引用(例如Integer的parseInt方法，写作Integer::parseInt)；
     *
     * 指向任意类型实例方法的方法引用(例如String的length方法，写作String::length)；
     *
     * 指向现有对象的实例方法的方法引用(例如假设你有一个本地变量localVariable用于存放Variable类型的对象，
     * 它支持实例方法getValue，那么可以写成localVariable::getValue)。
     */
    @Test
    public void test1(){
//        举个方法引用的简单的例子：
        Function<String,Integer> stringToInteger = s -> Integer.parseInt(s);
        //使用方法引用
        Function<String, Integer> stringToInteger2 = Integer::parseInt;
        //方法引用中还有一种特殊的形式，构造函数引用，假设一个类有一个默认的构造函数，那么使用方法引用的形式为：
        Supplier<TestLambda> c1 = TestLambda::new;
        TestLambda s1 = c1.get();
        //等价于
        Supplier<TestLambda> c2 = () -> new TestLambda();
        TestLambda s2 = c2.get();

//        如果是构造函数有一个参数的情况：
       /* Function<Integer, TestLambda> c3 = TestLambda::new;
        TestLambda s3 = c3.apply(100);*/
        //等价于

        /*Function<Integer, TestLambda> c4 = i -> new TestLambda(i);
        TestLambda s4 = c4.apply(100);*/
    }
}
