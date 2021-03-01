package controller;

import production.Production;
import view.CarView;
import javax.swing.*;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:




    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    //


    // The frame that represents this instance View of the MVC pattern

    CarView view;
    Production production;
    int gasAmount = 0;

    public CarController(CarView view, Production production){
        this.view = view;
        this.production = production;
        addButtonFunctionality();
    }

    private void addButtonFunctionality(){
        view.gasSpinner.addChangeListener(e -> gasAmount = (int) ((JSpinner)e.getSource()).getValue());

        view.gasButton.addActionListener(e -> production.gas(gasAmount));

        view.turboOnButton.addActionListener(e -> production.turboOn());

        view.liftBedButton.addActionListener(e -> production.liftBed());

        view.brakeButton.addActionListener(e -> production.brake(gasAmount));

        view.turboOffButton.addActionListener(e -> production.turboOff());

        view.lowerBedButton.addActionListener(e -> production.lowerBed());

        view.startButton.addActionListener(e -> production.startAll());

        view.stopButton.addActionListener(e -> production.stopAll());
    }

}
