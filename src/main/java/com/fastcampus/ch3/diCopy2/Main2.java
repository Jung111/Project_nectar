package com.fastcampus.ch3.diCopy2;


import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

class Car{}
class SportsCar extends Car{}
class Truck extends  Car{}
class Engine{}
class Handle{}

class AppContext{
    Map map;  // 객체 저장소

    AppContext () {

        try {
            Properties p = new Properties();
            p.load(new FileReader("config.txt"));
            map = new HashMap(p);// Properties 에 저장된 내용을 map에 저장

            // 반복문으로 클래스 이름을 가져와서 객체를 생성하고 map 저장
            for (Object key : map.keySet()) {
                Class clazz = Class.forName((String) map.get(key));
                map.put(key, clazz.newInstance());
            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
        Object getBean(String key){
        return map.get(key);
    }
}
public class Main2 {
    public static void main(String[] args)throws Exception {
        AppContext ac = new AppContext();
        Handle handle =(Handle) ac.getBean("handle");
        Engine engine = (Engine)ac.getBean("engine");
        Car car = (Car) ac.getBean("car");
        System.out.println("car = " + car);
        System.out.println("engine = " + engine);
        System.out.println("handle = " + handle);
    }


}
