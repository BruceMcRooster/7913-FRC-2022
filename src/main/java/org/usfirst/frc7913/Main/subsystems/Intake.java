package org.usfirst.frc7913.Main.subsystems;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

public class Intake extends Subsystem {
    private PWMSparkMax motor;

    public Intake() {
        motor = new PWMSparkMax(4);
    }

    public void disableMotor() {
        setSpeed(0);
    }

    public void setSpeed(double speed) {
        motor.set(speed);
    }

    public Command start(){
        setSpeed(0.75);
        return null;
    }

    public Command stop(){
        setSpeed(0);
        return null;
    }

    @Override
    protected void initDefaultCommand() {
    }
}
