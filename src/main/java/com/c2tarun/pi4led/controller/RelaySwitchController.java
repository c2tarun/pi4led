package com.c2tarun.pi4led.controller;

import com.pi4j.io.gpio.GpioPinDigitalOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tarun on 10/24/16.
 */
@RestController
public class RelaySwitchController {

    @Autowired
    @Qualifier("IN1")
    GpioPinDigitalOutput in1;

    @Autowired
    @Qualifier("IN2")
    GpioPinDigitalOutput in2;

    @Autowired
    @Qualifier("IN3")
    GpioPinDigitalOutput in3;

    @Autowired
    @Qualifier("IN4")
    GpioPinDigitalOutput in4;

    @RequestMapping("/relay/{pinId}")
    public String toggleIn1(@PathVariable("pinId") int pinId) {
        switch (pinId) {
            case 1:
                in1.toggle();
                break;
            case 2:
                in2.toggle();
                break;
            case 3:
                in3.toggle();
                break;
            case 4:
                in4.toggle();
        }
        return pinId + " Toggled";
    }
}
