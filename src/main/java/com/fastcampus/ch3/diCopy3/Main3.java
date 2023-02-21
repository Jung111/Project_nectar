package com.fastcampus.ch3.diCopy3;


import com.google.common.reflect.ClassPath;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@Component class Car{}
@Component class SportsCar extends Car{}
@Component class Truck extends  Car{}
@Component class Engine{}
@Component class Handle{}

class AppContext {
    Map map;  // 객체 저장소

    AppContext() {
        map = new HashMap();
        doComponentScan();


    }

    private void doComponentScan() {
        // 1.패키지내의클래스목록을가져온다.
        // 2.반복문으로 클래스를 하나씩 읽어와서 @component 이 붙어 있는지 확인
        // 3.@component가 붙어 있으면 객체를 생성해서 map 저장
        try {
            ClassLoader classLoader = AppContext.class.getClassLoader();
            ClassPath classPath = ClassPath.from(classLoader);

            Set<ClassPath.ClassInfo> set = classPath.getTopLevelClasses("com.fastcampus.ch3.diCopy3");
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
    public class Main3 {
        public static void main(String[] args) throws Exception {
            AppContext ac = new AppContext();
            Car car = (Car) ac.getBean("car");              // byname으로 객체 검색
            Handle handle = (Handle) ac.getBean("handle");  // byname으로 객체 검색
            Engine engine = (Engine) ac.getBean("engine");  // byname으로 객체 검색

            Car car2 = (Car) ac.getBean("car");                 // bytype 로 객체 검색
            Handle handle2 = (Handle) ac.getBean("handle");     // bytype 로 객체 검색
            Engine engine2 = (Engine) ac.getBean("engine");     // bytype 로 객체 검색

            System.out.println("car = " + car);
            System.out.println("engine = " + engine);
            System.out.println("handle = " + handle);
        }


    }
