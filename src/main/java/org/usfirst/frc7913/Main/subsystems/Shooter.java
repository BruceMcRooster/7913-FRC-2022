package org.usfirst.frc7913.Main.subsystems;

import org.usfirst.frc7913.Main.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

public class Shooter extends Subsystem {
    private PWMSparkMax bottomMotor;
    private PWMSparkMax topMotor;

    private boolean shouldRun = false;
    private double motorRunSpeed = 1;

    public Shooter() {
        bottomMotor = new PWMSparkMax(5);
        topMotor = new PWMSparkMax(6);
    }

    public void disableMotor() {
        setSpeed(0);
    }

    @Override
    public void periodic() {
        //Turn on toggle
        if (Robot.io.xboxController.getYButton()) {
            shouldRun = true;
        }
        //Turn off toggle
        else if (Robot.io.xboxController.getXButton()) {
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
        topMotor.set(speed * -1);
        bottomMotor.set(speed);
    }

    @Override
    protected void initDefaultCommand() {
    }
}
