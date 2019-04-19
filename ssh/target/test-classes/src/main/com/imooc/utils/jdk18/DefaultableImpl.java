package main.com.imooc.utils.jdk18;

public class DefaultableImpl implements Defaulable {


    public static void main( String[] args ) {
        Defaulable defaulable = DefaulableFactory.create( DefaultableImpl::new );
        System.out.println( defaulable.notRequired() );

        defaulable = DefaulableFactory.create( OverridableImpl::new );
        System.out.println( defaulable.notRequired() );
    }

}
