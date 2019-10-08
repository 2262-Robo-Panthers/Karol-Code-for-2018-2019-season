/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.subsystems.LiftSubsystem;

public class LiftCommand extends Command {
  public LiftCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    boolean frontBrakeOn = false;
    boolean backBrakeOn = false;

    if (OI.controller.getYButtonPressed()) {
      LiftSubsystem.drive(1);
    }
    if (OI.controller.getYButtonReleased()) {
      LiftSubsystem.drive(0);
    }
    if (OI.controller.getBButtonPressed()) {
      LiftSubsystem.drive(-1);
    }
    if (OI.controller.getBButtonReleased()) {
      LiftSubsystem.drive(0);
    }
    if (OI.controller.getBButtonPressed() && OI.controller.getYButtonPressed()) {
      LiftSubsystem.postMotors.set(1);
    }
    if (OI.controller.getBButtonReleased() && OI.controller.getYButtonReleased()) {
      LiftSubsystem.postMotors.set(0);
      LiftSubsystem.backPostBrake.set(Value.kForward);
      LiftSubsystem.frontPostBrake.set(Value.kForward);
      frontBrakeOn = true;
      backBrakeOn = true;
      
    }
    if (OI.controller.getAButton() && OI.controller.getXButton()) {
      if (frontBrakeOn == true) {
        LiftSubsystem.frontPostBrake.set(Value.kReverse);
        frontBrakeOn = false;
      }
      if (backBrakeOn == true) {
        LiftSubsystem.backPostBrake.set(Value.kReverse);
        backBrakeOn = false;
      }
      LiftSubsystem.postMotors.set(-1);
    }
    if (OI.controller.getAButton()) {
      LiftSubsystem.backPostMotor.set(-1);
    }
    if (OI.controller.getAButtonReleased()) {
      LiftSubsystem.backPostMotor.set(0);
    }
    if (OI.controller.getXButton()) {
      LiftSubsystem.frontPostMotor.set(-1);
    }
    if (OI.controller.getXButtonReleased()) {
      LiftSubsystem.frontPostMotor.set(0);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
