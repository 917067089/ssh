package main.com.imooc.utils.jdk18;

public class OverridableImpl implements  Defaulable {
    @Override
    public String notRequired() {
        return "Overridden implementation";
    }
}
