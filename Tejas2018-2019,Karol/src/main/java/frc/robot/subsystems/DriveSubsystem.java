/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.OI;
import frc.robot.commands.DriveManuallyCommand;

/**
 * Add your docs here.
 */
public class DriveSubsystem extends Subsystem {

  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  // instatiate new motorRobot.controllers
  public WPI_TalonSRX leftMaster = new WPI_TalonSRX(RobotMap.leftMasterPort);
  public WPI_TalonSRX leftSlave = new WPI_TalonSRX(RobotMap.leftSlavePort);
  public WPI_TalonSRX rightMaster = new WPI_TalonSRX(RobotMap.rightMasterPort);
  public WPI_TalonSRX rightSlave = new WPI_TalonSRX(RobotMap.rightSlavePort);


  // Instatiate a new differential drive
  public DifferentialDrive drive = new DifferentialDrive(leftMaster, rightMaster);
  public DriveSubsystem() {
    leftSlave.follow(leftMaster);
    rightSlave.follow(rightMaster);
  }
   public void manualDrive(double move, double turn) {

      if (Math.abs(move)<0.10){ move = 0;}
      if (Math.abs(turn)<0.10){turn = 0;}

    //change max speed
    if (RobotMap.maxSpeed < 1 && OI.controller.getStartButtonPressed()) {
      RobotMap.maxSpeed = RobotMap.maxSpeed + 0.25;
    }
    if (RobotMap.maxSpeed > 0 && OI.controller.getBackButtonPressed()) {
      RobotMap.maxSpeed = RobotMap.maxSpeed - 0.25;
    }
    if (RobotMap.maxSpeed < 0) {RobotMap.maxSpeed = 0;}
    if (RobotMap.maxSpeed > 1) {RobotMap.maxSpeed = 1;}

    if (OI.controller.getStartButtonPressed() || OI.controller.getBackButtonPressed()) {
      System.out.println("Robot Speed is set to " + RobotMap.maxSpeed);
    }

    // Max Speed number
    if (move > RobotMap.maxSpeed) {move = RobotMap.maxSpeed;}
     drive.arcadeDrive(move, turn); 
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
     setDefaultCommand(new DriveManuallyCommand());
  }
}
