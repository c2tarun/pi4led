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

    @Bean
    public GpioController getGpioController() {
        System.out.println("*** Gpio Controller created ***");
        return GpioFactory.getInstance();
    }

    @Bean(name = "redLed")
    public GpioPinDigitalOutput getLEDPin(GpioController gpioController) {
        System.out.println("*** Red LED Gpio pin created ***");
        return gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_24, "myredled", PinState.LOW);
    }

    @Bean(name = "yellowLed")
    public GpioPinDigitalOutput getYellowLedPin(GpioController gpioController) {
        System.out.println("*** Yellow LED Gpio pin created ***");
        return gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_27, "myyellowled", PinState.LOW);
    }


    /**
     * Due to some reason PinState.HIGH is off in relay switch.
     * @param gpioController
     * @return
     */
    @Bean(name = "IN1")
    public GpioPinDigitalOutput getIn1Pin(GpioController gpioController) {
        System.out.println("*** Initializing IN1 ***");
        return gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_04, "IN1", PinState.HIGH);
    }

    @Bean(name = "IN2")
    public GpioPinDigitalOutput getIn2Pin(GpioController gpioController) {
        System.out.println("*** Initializing IN2 ***");
        return gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_01, "IN1", PinState.HIGH);
    }

    @Bean(name = "IN3")
    public GpioPinDigitalOutput getIn3Pin(GpioController gpioController) {
        System.out.println("*** Initializing IN3 ***");
        return gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_16, "IN1", PinState.HIGH);
    }

    @Bean(name = "IN4")
    public GpioPinDigitalOutput getIn4Pin(GpioController gpioController) {
        System.out.println("*** Initializing IN4 ***");
        return gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_15, "IN1", PinState.HIGH);
    }


}
