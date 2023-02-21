package com.fastcampus.ch3;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;
@Component class  Engine{}                          //<bean id="engine" class="com.fastcompus.ch3.Engine"/>
@Component class  SuperEngine extends Engine{}
@Component class  TurboEngine extends Engine{}
@Component class  Door{}
@Component
class  Car{         //기본생성자 꼭 쓰기
    String color;
    int oil;
    Engine engine;
    Door[] doors;

    public void setColor(String color) {
        this.color = color;
    }

    public void setOil(int oil) {
        this.oil = oil;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setDoors(Door[] doors) {
        this.doors = doors;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", oil=" + oil +
                ", engine=" + engine +
                ", doors=" + Arrays.toString(doors) +
                '}';
    }
}


public class SpringDiTest {
    public static void main(String[] args) {

        ApplicationContext ac = new GenericXmlApplicationContext("config1.xml");
        Car car = ac.getBean("car",Car.class);          //byname, bytype 을 같이 선언할수있으며 형변환(Car) 을 안해두된다

       // Engine engine = (Engine) ac.getBean("engine");  // byname
// engine = (Engine)ac.getBean(SuperEngine);
     //   Door door = (Door) ac.getBean("door");
    //     Handle handle2 = (Handle) ac.getBean(Handle.class);     //bytype

        car.setColor("orange");
        car.setOil(9899);
        car.setEngine(engine);
        car.setDoors(new Door[]{ ac.getBean("door",Door.class),ac.getBean("door",Door.class)});

        System.out.println("car = "+ car);
        System.out.println("engine = "+ SuperEngines);
    }

}
