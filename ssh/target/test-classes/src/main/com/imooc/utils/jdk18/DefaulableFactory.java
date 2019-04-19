package main.com.imooc.utils.jdk18;

import java.util.function.Supplier;

public interface DefaulableFactory {
    static Defaulable create( Supplier< Defaulable > supplier ) {
        return supplier.get();
    }
}
