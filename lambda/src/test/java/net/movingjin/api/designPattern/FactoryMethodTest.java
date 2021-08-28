package net.movingjin.api.designPattern;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

public class FactoryMethodTest {

    @Test
    @DisplayName("FactoryMethod Pattern Example")
    void main(){
        Flooring flooring = FlooringFactory.getFlooring(13, 46);
        flooring.installation();
    }
}

interface Flooring{
    public void installation();
}

class ConcreteFlooring implements Flooring {
    @Override public void installation() {
        System.out.println("The Concrete flooring is installed! ");
    }
}

class CorkFlooring implements Flooring {
    @Override public void installation() {
        System.out.println("The Cork flooring is installed! ");
    }
}

class WoodenFlooring implements Flooring {
    @Override public void installation() {
        System.out.println("The Cork flooring is installed! ");
    }
}

class FlooringFactory{
    public static Flooring getFlooring(int minTemp, int maxTemp){
        Supplier<Flooring> flooring;
        if(minTemp <= 5 && maxTemp <= 20){flooring = () ->new WoodenFlooring();}
        else if(minTemp <= 5 && maxTemp >= 45){flooring = () ->new CorkFlooring();}
        else {flooring = () ->new ConcreteFlooring();}
        return flooring.get();
    }
}