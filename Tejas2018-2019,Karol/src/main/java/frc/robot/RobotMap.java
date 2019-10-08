/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

// If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;

  //PWM

  //DIO

  //CAN

  public static int intakeSlidePort = 2;
  public static int intakeHoldPort1 = 1;
  public static int intakeHoldPort2 = 0;
  public static int elevatorMotorPort = 0;

  public static int leftMasterPort = 3;
  public static int leftSlavePort = 4;
  public static int rightMasterPort = 2;
  public static int rightSlavePort = 1;
  
  public static int frontPostMotorPort = 5;
  public static int backPostMotorPort = 6;
  public static int smallDriveMaster = 7;
  public static int smallDriveSlave = 8;
  public static int frontLiftBrake1 = 7;
  public static int frontLiftBrake2 = 6;
  public static int backLiftBrake1 = 4;
  public static int backLiftBrake2 = 5;
  public static int compressorPort = 0;


  //USB

  public static final int controller = 0;
  public static int leftJoystickPort = 0;
  public static int buttonA = 1;
	public static int buttonB = 2;
	public static int buttonX = 3;
	public static int buttonY = 4;
	public static int leftBumper = 5;
	public static int rightBumper = 6;
	public static int buttonBack = 7;
	public static int buttonStart = 8;
	public static int buttonLeftJoystick = 9;
  public static int buttonRightJoystick = 10;
  public static int rightTriggerPort = 9;
  

  //Other driveTrian Constants
  public static double maxSpeed = 0.5;
  public static int wheelDiameter = 6;
public static int rightJoystickPort;

}
