package main.com.imooc.utils;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class StringTest {
    @Test
    public void str1(){
        StringBuffer sb = new StringBuffer();
        String str="abcabc12313#$%%";
        for (int i=0;i<str.length();i++){
            sb.append(" ").append(str.charAt(i));
        }
        System.out.println(sb.toString());
        String[] str2 = sb.toString().split("\\ ");
        String[] sArray=str.split("a");
        for(String str3:str2){
            System.out.println(str3);
        }
        System.out.println(sArray.length);
    }
    @Test
    public void str2(){
        String input = "abcabc12313#$%%";
        String regex = "(.{1})";
        input = input.replaceAll (regex, "$1 ");
        List<String> lis = Arrays.asList(input.split(" "));
        for (String string : lis) {
            System.out.println(string);
        }
        System.out.println (input);
    }

    @Test
    public void str3(){
        String str="abc123";
        char s = str.charAt(str.length()-1);//最后一个位置上的值
        StringBuffer sb =  exchangeString_1(str);
        System.out.println(sb.reverse());
        System.out.println(sb.toString());
    }
    /*
     * 问题：如何反向输出字符串
     * 1，用StringBuffer
     */

    public static StringBuffer exchangeString_1(String str){
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<str.length();i++){
            sb.append(str.charAt(str.length() - (i+1)));
        }
        return sb;
    }
    /*
     * 问题：如何反向输出字符串CHINA
     * 2，用StringBuffer的reverse()方法
     */
    public static String exchangeString_2(String str){
        StringBuffer sb = new StringBuffer(str);
        StringBuffer result = sb.reverse();
        return result.toString();
    }
    @Test
    public void test2(){
//        defautTest();
//        breakTest();
        stringTest();
    }
    /*
     * default不是必须的，也可以不写
     * 输出：case two
     */
    private static void defautTest() {
        char ch = 'A';
        switch (ch) {
            case 'B':
                System.out.println("case one");
                break;
            case 'A':
                System.out.println("case two");
                break;
            case 'C':
                System.out.println("case three");
                break;
        }
    }

    /*
     * case语句中少写了break，编译不会报错
     *     但是会一直执行之后所有case条件下的语句，并不再进行判断，直到default语句
     *     下面的代码输出： case two
     *                   case three
     */
    private static void breakTest() {
        char ch = 'A';
        switch (ch) {
            case 'B':
                System.out.println("case one");

            case 'A':
                System.out.println("case two");

            case 'C':
                System.out.println("case three");
            default:
                break;
        }
    }

    /*
     * switch用于判断String类型
     *     输出：It's OK!
     */
    private static void stringTest() {
        String string = new String("hello");
        switch (string) {
            case "hello":
                System.out.println("It's OK!");
                break;

            default:
                System.out.println("ERROR!");
                break;
        }
    }
    public short getValue(byte i){
        short s = (short)(i & 0xff);
        return  s;
    }
    public byte toUnsignedByte(short i){
        return (byte)(i& 0xff);
    }
    @Test
    public void test3(){
        StringTest st= new StringTest();
        short[] shorts = new short[256];
        int ssize = shorts.length;
        for (int i = 0; i <ssize ; i++) {
            shorts[i]=(short)i;
        }
        byte [] bytes = new byte[256];
        int bsize = bytes.length;
        for (int i = 0; i < bsize; i++) {
            bytes[i]=(byte)i;
            System.out.println(st.getValue(bytes[i]));
        }

    }
}
