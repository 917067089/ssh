package main.com.imooc.utils.jdk18;

public interface Defaulable {
    default String notRequired(){
        return "Default implementation";
    }

}
