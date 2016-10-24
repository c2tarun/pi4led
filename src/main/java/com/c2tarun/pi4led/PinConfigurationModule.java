package com.c2tarun.pi4led;

import com.pi4j.io.gpio.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by tarun on 10/23/16.
 */
@Configuration
@ComponentScan(basePackages = "com.c2tarun.pi4led")
public class PinConfigurationModule {

    @Bean(name = "redLed")
    public GpioPinDigitalOutput getLEDPin() {
        System.out.println("*** Red LED Gpio pin created ***");
        GpioController gpioController = GpioFactory.getInstance();
        GpioPinDigitalOutput pin = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_24, "myredled", PinState.LOW);
        return pin;
    }

    @Bean(name = "yellowLed")
    public GpioPinDigitalOutput getYellowLedPin() {
        System.out.println("*** Yellow LED Gpio pin created ***");
        GpioController gpioController = GpioFactory.getInstance();
        GpioPinDigitalOutput pin = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_27, "myyellowled", PinState.LOW);
        return pin;
    }
}
