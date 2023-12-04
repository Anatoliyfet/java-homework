package ru.sberbank.edu;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        System.out.println( "Hello World!" );
        CustomArrayImpl<String> customArray = new CustomArrayImpl<String>();
        customArray.add("sada");
        System.out.println(customArray.toString());
    }
}
