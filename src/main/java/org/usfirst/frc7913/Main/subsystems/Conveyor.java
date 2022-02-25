package org.usfirst.frc7913.Main.subsystems;

import org.usfirst.frc7913.Main.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

public class Conveyor extends Subsystem {
    private PWMSparkMax motor;

    private double motorSpeed = 0.75;

    public Conveyor() {
        motor = new PWMSparkMax(7);
    }

    @Override
    public void periodic() {
        //               This could be a source of error, I have no clue what a GenericHID.Hand is
        setSpeed(Robot.io.xboxController.getTriggerAxis(GenericHID.Hand.kLeft) ? motorSpeed : 0);
    }

    public void setSpeed(double speed) {
        motor.set(speed);
    }

    @Override
    protected void initDefaultCommand() {
    }
}
