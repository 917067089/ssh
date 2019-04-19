package main.com.imooc.utils.jdk18;

import java.util.Optional;

public class NullOptional {
    public static void main(String[] args){
        //使用of方法任然会报空指针
//        Optional optional = Optional.of(null);
//        System.out.println(optional.get());
       /* 抛出没有该元素的异常
        Exception in thread "main" java.util.NoSuchElementException: No value present
        at java.util.Optional.get(Optional.java:135)
        at com.javase.Java8.空指针Optional.main(空指针Optional.java:14)
        Optional optional1 = Optional.ofNullable(null);
        System.out.println(optional1.get());*/
       Optional optional1 = Optional.ofNullable(null);
        System.out.println(optional1.isPresent());
        System.out.println(optional1.orElse(0));//当值为空时给予赋值
        System.out.println(optional1.orElseGet(()->new String[]{"a"}));//使用回调函数设置默认值

       /** 即使传入Optional容器的元素为空，使用optional.isPresent()方法也不会报空指针异常
        所以通过optional.orElse这种方式就可以写出避免空指针异常的代码了
        输出Optional.empty。
        */

       Optional<String> firstName = Optional.of("Tom");
       System.out.println("First Name  is set:"+firstName.isPresent());
       System.out.println("First Name :"+firstName.orElseGet(()-> "[none]"));
       System.out.println(firstName.map(s -> "Hey" + s +"!").orElse("Hey Stranger"));




    }
}
