package com.c2tarun.pi4led.controller;


import com.pi4j.io.gpio.GpioPinDigitalOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LedController {

    @Autowired(required = true)
    @Qualifier("redLed")
    private GpioPinDigitalOutput redLedPin;

    @Autowired(required = true)
    @Qualifier("yellowLed")
    private GpioPinDigitalOutput yellowLedPin;

    @RequestMapping("/")
    public String greeting() {
        return "Hello world!";
    }

    @RequestMapping("/redlight")
    public String redLight() {
        redLedPin.toggle();
        if(redLedPin.isHigh()) {
            return "Red LED ON";
        } else {
            return "Red LED OFF";
        }
    }

    @RequestMapping("/yellowlight")
    public String yellowLight() {
        yellowLedPin.toggle();
        if(yellowLedPin.isHigh()) {
            return "Yellow LED ON";
        } else {
            return "Yellow LED OFF";
        }
    }

}
