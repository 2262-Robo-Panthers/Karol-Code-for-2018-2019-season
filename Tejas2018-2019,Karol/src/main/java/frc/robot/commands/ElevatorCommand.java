/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.subsystems.ElevatorSubsystem;

public class ElevatorCommand extends Command {
  public ElevatorCommand() {
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
    if (OI.controller.getBumperPressed(Hand.kRight)) {
      ElevatorSubsystem.elevatorMotor.set(1);
    }
    if (OI.controller.getBumperReleased(Hand.kRight)){
      ElevatorSubsystem.elevatorMotor.set(0);
    }
    if (OI.controller.getBumperPressed(Hand.kLeft)) {
      ElevatorSubsystem.elevatorMotor.set(-1);
    }
    if (OI.controller.getBumperReleased(Hand.kLeft)){
      ElevatorSubsystem.elevatorMotor.set(0);
    }
    if (OI.dPad == 0) {
      ElevatorSubsystem.intakeSlide.set(true);
    }
    if (OI.dPad == 180) {
      ElevatorSubsystem.intakeSlide.set(false);
    }
    if (OI.dPad == 90) {
      ElevatorSubsystem.intakeHold.set(Value.kForward);
    }
    if (OI.dPad == 270) {
      ElevatorSubsystem.intakeHold.set(Value.kReverse);
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
