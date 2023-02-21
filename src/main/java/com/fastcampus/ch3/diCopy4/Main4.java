package com.fastcampus.ch3.diCopy4;


import com.google.common.reflect.ClassPath;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component class Car {
     Engine engine;
    Door door;

    @Override
    public String toString() {
        return "Car{" +
                "engine=" + engine +
                ", door=" + door +
                '}';
    }
}
@Component class SportsCar extends Car{}
@Component class Truck extends Car{}
@Component class Engine{}
@Component class Handle{}
@Component class Door{}

class AppContext {
    Map map;  // 객체 저장소

    AppContext() {
        map = new HashMap();
        doComponentScan();
        doAutowired();
        doResource();

    }

    private void doResource() {
        try {
            for (Object bean : map.values()){
                for (Field fld :bean.getClass().getDeclaredFields()){
                    if (fld.getAnnotations()!=null)
                        fld.set(bean,getBean(fld.getName()));  //car.engine = obj
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private void doAutowired() {
        //map에 저장되는 객체의 iv 중에 오토와이어드 가 붙어있으면 map 에서 iv의 타입에 맞는 객체를 찾아서 연결(객체주소를 iv에 저장)

        try {
            for (Object bean : map.values()){
                for (Field fld :bean.getClass().getDeclaredFields()){
                    if (fld.getAnnotations()!=null)
                        fld.set(bean,getBean(fld.getType()));  //car.engine = obj
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private void doComponentScan() {
        // 1.패키지내의클래스목록을가져온다.
        // 2.반복문으로 클래스를 하나씩 읽어와서 @component 이 붙어 있는지 확인
        // 3.@component가 붙어 있으면 객체를 생성해서 map 저장
        try {
            ClassLoader classLoader = AppContext.class.getClassLoader();
            ClassPath classPath = ClassPath.from(classLoader);

            Set<ClassPath.ClassInfo> set = classPath.getTopLevelClasses("com.fastcampus.ch3.diCopy4");
            for (ClassPath.ClassInfo classInfo : set) {
                Class clazz = classInfo.load();
                Comparator comparator = (Comparator) clazz.getAnnotation(Comparator.class);
                if (comparator != null) {
                    String id = StringUtils.uncapitalize(classInfo.getSimpleName());
                    map.put(id, clazz.newInstance());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }
        Object getBean (String key){
            return map.get(key);  // byname
        }
        Object getBean(Class clazz){   // bytype
        for (Object obj : map.values()){
            if (clazz.isInstance(obj))

                return obj;

        }

        return null;

    }

}
    public class Main4 {
        public static void main(String[] args) throws Exception {
           AppContext ac = new AppContext();
           Car car = (Car) ac.getBean("car");              // byname으로 객체 검색
           Engine engine = (Engine) ac.getBean("engine");  // byname으로 객체 검색
           Door door = (Door) ac.getBean(Door.class);       // bytype 로 객체 검색


//            //수동으로 객체를 연결해준다
//            car.engine = engine;
//            car.door = door;

            System.out.println("car = " + car);
            System.out.println("engine = " + engine);
            System.out.println("door = " + door);
        }


    }
