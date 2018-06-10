package Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        Class st = Class.class;
        Method[] methods = st.getMethods();
        for (Method m : methods) {
            System.out.println(m.getName());
        }
    }
}
