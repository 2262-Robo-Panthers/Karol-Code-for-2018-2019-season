/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */

public class OI {
  public static XboxController controller = new XboxController(RobotMap.controller); 

  public double GetDriverRawAxis (int axis) {
    return controller.getRawAxis(axis);
  }

  
  //// CREATING BUTTONS
  public Joystick driveStick = new Joystick(RobotMap.leftJoystickPort);
  public static double rightTrigger = OI.controller.getTriggerAxis(Hand.kRight);
  public static double leftTrigger = OI.controller.getTriggerAxis(Hand.kLeft);
  public static int dPad = OI.controller.getPOV(0);
  // || 0 = up || 90 = right || 180 = down || 270 = left ||
  }
  //public JoystickButton button = new JoystickButton(stick, RobotMap.joystickButtonPort);
 


  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
