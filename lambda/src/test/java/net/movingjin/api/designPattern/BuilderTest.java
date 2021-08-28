package net.movingjin.api.designPattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class BuilderTest {

    @Test
    @DisplayName("Builder Pattern Example")
    void main(){
        MobileBuilder builder = new MobileBuilder();
        Mobile myMobile = builder.with(myBuilder->{
            myBuilder.ram = 4;
            myBuilder.battery = 5000;
            myBuilder.processor = "Cortex ARM";
        }).createMobile();

        assertThat(myMobile.getRam(), is(equalTo(4)));
        assertThat(myMobile.getBattery(), is(equalTo(5000)));
        assertThat(myMobile.getProcessor(), is(equalTo("Cortex ARM")));
    }

    @Data
    @AllArgsConstructor
    class Mobile{
        private final int ram;
        private final int storage;
        private final int battery;
        private final int camera;
        private final String processor;
        private final double screenSize;

        public Mobile(MobileBuilder builder) {
            this.ram = builder.ram;
            this.storage = builder.storage;
            this.battery = builder.battery;
            this.camera = builder.camera;
            this.processor = builder.processor;
            this.screenSize = builder.screenSize;
        }
    }
    @Data
    class MobileBuilder{
        private  int ram;
        private  int storage;
        private  int battery;
        private  int camera;
        private  String processor;
        private  double screenSize;

        public MobileBuilder with(Consumer<MobileBuilder> builderField) {
            builderField.accept(this);
            return this;
        }
        public Mobile createMobile(){
            return new Mobile(this);
        }
    }
}

