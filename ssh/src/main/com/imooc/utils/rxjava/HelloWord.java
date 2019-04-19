package main.com.imooc.utils.rxjava;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.observables.GroupedObservable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HelloWord {
    public static void main(String[] args){
//        helloWord();
//        create();
//        just();
//        from();
//        defer();
//        interval();
//        range();
//        repeat();
//        map();
//        flatMap();
//        groupBy();
//        buffer();
//        scan();

//        testDebounce();
//        testDistinct();
//        testElementAt();
//        testFilter();
//        testFirst();
//        testIgnoreElements();
//        testLast();
//        testSample();
//        testSkip();
//        testTake();

//        testZip();
//        testMerg();
//        testStartWith();
        testCombineLatest();
    }

    /**
     * 用于将两个Observale最近发射的数据已经Func2函数的规则进展组合
     */
    private static void testCombineLatest() {
        Observable<Integer> observable1 = Observable.just(10,20,30);
        Observable<Integer> observable2 = Observable.just(4,8,12,16);
        observable1.combineLatest(observable1, observable2, new Func2<Integer, Integer, Integer>() {

            @Override
            public Integer call(Integer integer, Integer integer2) {
                System.out.println("integer:"+integer+"integer2:"+integer2);
                return integer+integer2;
            }
        }).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted()");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError()");
            }

            @Override
            public void onNext(Integer s) {
                System.out.println("onNext()"+s);
            }
        });
    }

    /**
     * 用于源Observable发射的数据前插入数据，使用startWtith(Iter)
     */
    private static void testStartWith() {
        Observable<Integer> observable1 = Observable.just(10,20,30);
        Observable<Integer> observable2 = Observable.just(4,8,12,16);
        observable1.startWith(observable2).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted()");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError()");
            }

            @Override
            public void onNext(Integer s) {
                System.out.println("onNext()"+s);
            }
        });
    }

    /**
     * 将两个Observable发射的事件序列合并成一个事件序列，就像是一个Observable发射的一样。你可以简单将Observable
     * 合并成一个Observalbe
     */
    private static void testMerg() {
        Observable<Integer> observable1 = Observable.just(10,20,30);
        Observable<Integer> observable2 = Observable.just(4,8,12,16);
        Observable.merge(observable1, observable2).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted()");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError()");
            }

            @Override
            public void onNext(Integer s) {
                System.out.println("onNext()"+s);
            }
        });
    }

    /**
     * 用来合并Observable发射的数据项，根据Func2函数生成一个新的值并发射出去。
     * 当其中一个Observable发送结束或者出现异常后，另一个Observable也将停止发射数据。
     */
    private static void testZip() {
        Observable<Integer> observable1 = Observable.just(10,20,30);
        Observable<Integer> observable2 = Observable.just(4,8,12,16);
        Observable.zip(observable1, observable2, new Func2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer integer, Integer integer2) {
                return integer+integer2;
            }
        }).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted()");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError()");
            }

            @Override
            public void onNext(Integer s) {
                System.out.println("onNext()"+s);
            }
        });
    }

    private static void testTake() {
        Observable.just(1,2,3,4,5).takeLast(2).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted()");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError()");
            }

            @Override
            public void onNext(Integer s) {
                System.out.println("onNext()"+s);
            }
        });
    }

    private static void testSkip() {
        Observable.just(1,2,3,4,5).skip(2).skipLast(2).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted()");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError()");
            }

            @Override
            public void onNext(Integer s) {
                System.out.println("onNext()"+s);
            }
        });
    }

    private static void testSample() {
        Observable.create(new Observable.OnSubscribe<Integer>() {

            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                try{
                    for (int i=0;i<10;i++){
                        Thread.sleep(1000);
                        subscriber.onNext(i);
                    }
                    subscriber.onCompleted();
                }catch (Exception e){
                    e.printStackTrace();
                    subscriber.onError(e);
                }
            }
        }).sample(4, TimeUnit.SECONDS).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted()");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError()");
            }

            @Override
            public void onNext(Integer s) {
                System.out.println("onNext()"+s);
            }
        });
    }

    private static void testLast() {
        Observable.just(1,2,3,2,3).distinct().last().subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted()");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError()");
            }

            @Override
            public void onNext(Integer s) {
                System.out.println("onNext()"+s);
            }
        });
    }

    private static void testIgnoreElements() {
        Observable.create(new Observable.OnSubscribe<Integer>() {

            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                subscriber.onNext(123);
                throw new NullPointerException();
            }
        }).ignoreElements().subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted()");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError()");
            }

            @Override
            public void onNext(Integer s) {
                System.out.println("onNext()"+s);
            }
        });
    }

    private static void testFirst() {
        Observable.just(1,2,3,2,3).distinct().first().subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted()");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError()");
            }

            @Override
            public void onNext(Integer s) {
                System.out.println("onNext()"+s);
            }
        });
    }

    private static void testFilter() {
        Observable.just(1,2,3,2,3).distinct().filter(new Func1<Integer, Boolean>() {
            @Override
            public Boolean call(Integer integer) {
                return integer>2;
            }
        }).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted()");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError()");
            }

            @Override
            public void onNext(Integer s) {
                System.out.println("onNext()"+s);
            }
        });
    }

    private static void testElementAt() {
        Observable.just(1,2,3,2,3).elementAt(3).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted()");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError()");
            }

            @Override
            public void onNext(Integer s) {
                System.out.println("onNext()"+s);
            }
        });
    }

    private static void testDistinct() {
        Observable.just(1,2,3,2,3).distinct().subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted()");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError()");
            }

            @Override
            public void onNext(Integer s) {
                System.out.println("onNext()"+s);
            }
        });
    }

    private static void testDebounce() {
        Observable.create(new Observable.OnSubscribe<Integer>() {

            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                try{
                    for (int i=0;i<10;i++){
                        Thread.sleep(1000);
                        subscriber.onNext(i);
                    }
                    subscriber.onCompleted();
                }catch (Exception e){
                    subscriber.onError(e);
                    e.printStackTrace();
                }
            }
        }).debounce(1, TimeUnit.SECONDS).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted()");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError()");
            }

            @Override
            public void onNext(Integer s) {
                System.out.println("onNext()"+s);
            }
        });
    }

    private static void scan() {
        Observable.range(1,5).scan(new Func2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer integer, Integer integer2) {
                return integer+integer2;
            }
        }).subscribe(new Observer <Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted()");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError()");
            }

            @Override
            public void onNext(Integer s) {
                System.out.println("onNext()"+s);
            }
        });
    }

    private static void buffer() {
        Observable.range(1,5).buffer(2).subscribe(new Observer<List<Integer>>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted()");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError()");
            }

            @Override
            public void onNext(List<Integer> s) {
                System.out.println("onNext()"+s);
            }
        });
    }

    private static void groupBy() {
        Observable.just(1,2,3,4,5).groupBy(new Func1<Integer, Integer>() {
            @Override
            public Integer call(Integer integer) {
                return integer % 2 ;//指定分组的规则
            }
        }).subscribe(new Observer<GroupedObservable<Integer, Integer>>() {
            @Override
            public void onCompleted() {
                System.out.println("11onCompleted()");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError()");
            }

            @Override
            public void onNext(GroupedObservable<Integer, Integer> integerIntegerGroupedObservable) {
               integerIntegerGroupedObservable.subscribe(new Subscriber<Integer>() {
                   @Override
                   public void onCompleted() {
                       System.out.println("22onCompleted()");
                   }

                   @Override
                   public void onError(Throwable throwable) {
                       System.out.println("onError()");
                   }

                   @Override
                   public void onNext(Integer data) {
                       System.out.println("group："+integerIntegerGroupedObservable.getKey()+"，data:"+data);
                   }
               });
            }
        });
    }

    private static void flatMap() {
        Observable.just(1,2,3,4,5).flatMap(new Func1<Integer, Observable<String>>() {
            @Override
            public Observable<String> call(Integer integer) {
                return Observable.just(integer+"");
            }
        }).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted()");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError()");
            }

            @Override
            public void onNext(String s) {
                System.out.println("onNext()"+s);
            }
        });
    }

    private static void map() {
        Observable.just(123).map(new Func1<Integer, String>() {
            public String call(Integer arg0){
               return arg0+"";
            }
        }).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted()");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError()");
            }

            @Override
            public void onNext(String s) {
                System.out.println("onNext()"+s);
            }
        });
    }

    private static void repeat() {
        Observable.just("Rxjava").repeat(2).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted()");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError()");
            }

            @Override
            public void onNext(String s) {
                System.out.println("onNext()"+s);
            }
        });
    }

    private static void range() {
        Observable.range(1,5).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted()");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError()");
            }

            @Override
            public void onNext(Integer s) {
                System.out.println("onNext()"+s);
            }
        });
    }

    private static void interval() {


    }

    private static String valuestr;
    private static void defer() {
        Observable observable = Observable.defer(new Func0<Observable<String>>() {
            @Override
            public Observable<String> call() {
                return Observable.just(valuestr);
            }
        });
        valuestr="慕课深入浅出Rxjava";
        observable.subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted()");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError()");
            }

            @Override
            public void onNext(String s) {
                System.out.println("onNext()"+s);
            }
        });
    }

    private static void from() {
        Integer [] integers = new Integer[]{1,2,3,4,5};
        List<Integer> items = new ArrayList<Integer>();
        items.add(1);
        items.add(2);
        items.add(3);
        items.add(4);
        items.add(5);
        Observable.from(items).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted()");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError()");
            }

            @Override
            public void onNext(Integer s) {
                System.out.println("onNext()"+s);
            }
        });
    }

    private static void just() {
        Observable.just("慕课网RxJava学习").subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted()");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError()");
            }

            @Override
            public void onNext(String s) {
                System.out.println("onNext()"+s);
            }
        });
    }

    private static void create() {
        Observable.create(new Observable.OnSubscribe<String>() {
            public void call(Subscriber<? super String> subscriber){
                subscriber.onNext("慕课网RxJava学习");
            }
        }).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted()");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError()");
            }

            @Override
            public void onNext(String s) {
                System.out.println("onNext()"+s);
            }
        });
    }

    private static void helloWord() {
        //1，创建被观察者
        Observable observable = Observable.create(new Observable.OnSubscribe<String>() {
            public void call(Subscriber<? super String> subscriber){
                subscriber.onNext("Hello World");
                subscriber.onCompleted();
//                throw new NullPointerException();
            }
        });
        //2，创建观察者
        Subscriber subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted()");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError()");
            }

            @Override
            public void onNext(String s) {
                System.out.println("onNext()"+s);
            }
        };
        //3,订阅事件
        observable.subscribe(subscriber);
    }
}
