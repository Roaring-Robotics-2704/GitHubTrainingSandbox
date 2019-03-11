// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.



package org.usfirst.frc2704.comandrobot.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2704.comandrobot.Robot;

/**
 *
 */
public class DriveWithJoystick extends Command {
    // increasing this value causes turn speed to be more higher per degree turned on the joystick.
    private double leftValue = 0.0; //The speed of the left side of the robot
    private double rightValue = 0.0; //The speed of the right side of the robot
    private double deadZone = 0.5;
    private double moveSpeedModifier = 0.9; //Changing this changes forward/back movement sensitivity.
    private double turnSpeedModifier = 0.5; //Changeing this changes turning sensitivity.
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public DriveWithJoystick() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.drivetrain);

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        leftValue = 0.0; //Resets the speed of the left side of the robot after each loop.
        rightValue = 0.0; //Resets the speed of the right side of the robot after each loop.
        if (Robot.oi.joystick1.getY() >= deadZone || Robot.oi.joystick1.getY() <= -deadZone) { 
            //Don't move foward/back if the joystick's raw Y value is between -deadZone and deadZone. This prevents the joystick from being oversensitive.
            leftValue -= Robot.oi.joystick1.getY() * moveSpeedModifier;
            rightValue -= Robot.oi.joystick1.getY() * moveSpeedModifier;
        }
        if (Robot.oi.joystick1.getZ() >= deadZone || Robot.oi.joystick1.getZ() <= -deadZone) { 
            //Don't turn if the joystick's raw Z value is between -deadZone and deadZone. This prevents the joysick from being oversensitive.
            leftValue -= Robot.oi.joystick1.getZ() * turnSpeedModifier;
            rightValue += Robot.oi.joystick1.getZ() * turnSpeedModifier;
        }
        Robot.drivetrain.tankDrive(rightValue, leftValue);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        Robot.drivetrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        end();
    }
}
