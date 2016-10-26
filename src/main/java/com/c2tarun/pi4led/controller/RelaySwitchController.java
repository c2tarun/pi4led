package com.c2tarun.pi4led.controller;

import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
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

    @RequestMapping("/relay/{pinId}/{action}")
    public String toggleIn1(@PathVariable("pinId") int pinId, @PathVariable("action") String action) {
        switch (pinId) {
            case 1:
                performAction(in1, action);
                break;
            case 2:
                performAction(in2, action);
                break;
            case 3:
                performAction(in3, action);
                break;
            case 4:
                performAction(in4, action);
        }
        return "Action Successfull";
    }

    private void performAction(GpioPinDigitalOutput gpioPin, String action) {
        if("on".equals(action)) {
            gpioPin.setState(PinState.LOW);
        } else {
            gpioPin.setState(PinState.HIGH);
        }
    }

}
