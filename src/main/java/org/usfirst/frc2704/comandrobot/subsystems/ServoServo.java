/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc2704.comandrobot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.DigitalInput;
/**
 * Change the name of this file when we actually know what this is for.
 */
public class ServoServo extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private Servo mysteriousServo;
  private Double distance = 0.5;
  //private DigitalInput photoSwitch;

  public ServoServo() {
    mysteriousServo = new Servo(6);
    //photoSwitch = new DigitalInput(7);
  }

  public void moveForward() {
    mysteriousServo.set(mysteriousServo.getPosition() + distance);
  }

  public void moveBackward() {
    mysteriousServo.set(mysteriousServo.getPosition() - distance);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

//public boolean get() {
	//return photoSwitch.get();
//}
}
