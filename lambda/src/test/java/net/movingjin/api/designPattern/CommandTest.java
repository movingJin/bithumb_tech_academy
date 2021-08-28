package net.movingjin.api.designPattern;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CommandTest {

    @Test
    @DisplayName("Command Pattern Example")
    void main(){
        Aircon aircon = new Aircon();
        AirconRemote airconRemote = new AirconRemote();
        airconRemote.setCommand(()->aircon.turnOn());
        airconRemote.buttonPressed();
        airconRemote.setCommand(()->aircon.incTemp());
        airconRemote.buttonPressed();
        airconRemote.setCommand(()->aircon.turnOff());
        airconRemote.buttonPressed();
    }

    class Aircon{
        public void turnOn() {
            System.out.println("turning on AC");
        }
        public void turnOff() {
            System.out.println("turning off AC");
        }
        public void incTemp() {
            System.out.println("Increasing temperature");
        }
        public void decTemp() {
            System.out.println("Decreasing temperature");
        }
    }
    interface Command{
        void execute();
    }

    class AirconRemote{
        Command command;
        public void setCommand(Command command){
            this.command = command;
        }
        public void buttonPressed(){
            command.execute();
        }
    }
}
