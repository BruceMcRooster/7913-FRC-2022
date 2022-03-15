package org.usfirst.frc7913.Main.subsystems;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import org.usfirst.frc7913.Main.Robot;
import java.lang.Math;

public class Shooter extends Subsystem {
    private PWMSparkMax bottomMotor;
    private PWMSparkMax topMotor;

    public boolean isRunning = false;
    //This is the amount that the speed offsets should change on click
    private final double speedChange = 0.05;
    //Base speed for a motor with no offset
    private final double baseSpeed = 0.75;
    //Negative means the bottom spins faster, positive means the top spins faster
    public double motorSpeedOffset = 0;

    public Shooter() {
        bottomMotor = new PWMSparkMax(5);
        topMotor = new PWMSparkMax(6);
    }

    public void disableMotor() {
        setSpeed(0);
    }

    @Override
    public void periodic() {
        XboxController controller = Robot.io.getXboxController();

        //Start button toggles shooter on and off
        if (controller.getStartButtonPressed() && !isRunning) {
            isRunning = true;
        }
        else if (controller.getStartButtonPressed() && isRunning) {
            isRunning = false;
        }

        //Decrease motorSpeedOffset, making the bottom spin faster or the top spin slower
        if (controller.getLeftBumperPressed()) {
            //The math makes sure you can't go under to a point where the bottom motor would spin faster than 1
            motorSpeedOffset = Math.max(motorSpeedOffset - speedChange,-(1 - baseSpeed));
        }
        
        if (controller.getRightBumperPressed()) {
            //The math makes sure you can't go over to a point where the top motor would spin faster than 1
            motorSpeedOffset = Math.min(motorSpeedOffset + speedChange, (1 - baseSpeed));
        }


        if (isRunning)
            setSpeed(Math.max(baseSpeed,baseSpeed + motorSpeedOffset), Math.abs(Math.max(-baseSpeed, -baseSpeed - motorSpeedOffset)));
        else
            setSpeed(0);
    }

    public void setSpeed(double speed) {
        topMotor.set(speed * -1);
        bottomMotor.set(speed);
    }

    public void setSpeed(double tspeed,double bspeed) {
        topMotor.set(tspeed * -1);
        bottomMotor.set(bspeed);
    }

    /*public Command start(){
        setSpeed(1);
        return null;
    }*/

    public Command stop(){
        setSpeed(0);
        return null;
    }

    @Override
    protected void initDefaultCommand() {
    }
}
