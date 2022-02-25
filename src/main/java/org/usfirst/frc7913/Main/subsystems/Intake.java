package org.usfirst.frc7913.Main.subsystems;

import org.usfirst.frc7913.Main.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

public class Intake extends Subsystem {
    private PWMSparkMax motor;
    
    private double runSpeed = 0.5;
    
    //This will be set as either true or false by periodic
    //It will be used to determine whether the motor should be running or not
    private boolean shouldRun = false;

    public Intake() {
        motor = new PWMSparkMax(4);
    }

    public void disableMotor() {
        setSpeed(0);
    }

    @Override
    public void periodic() {
        //Here is where we detect the button that we want to use for starting and stopping
        //See https://first.wpi.edu/FRC/roborio/release2017/docs/java/edu/wpi/first/wpilibj/XboxController.html for all get functions

        //Start button
        if (Robot.io.xboxController.getAButton()) {
            shouldRun = true;
        }
        //Stop button check, start button overrides stop because its an if else, in the event that they are both pressed
        else if (Robot.io.xboxController.getBButton()) {
            shouldRun = false;
        }

        if (shouldRun) {
            setSpeed(runSpeed);
        }
        else {
            setSpeed(0);
        }
    }

    public void setSpeed(double speed) {
        motor.set(speed);
    }

    @Override
    protected void initDefaultCommand() {
    }
}
