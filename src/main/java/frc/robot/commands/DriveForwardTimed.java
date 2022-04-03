// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Subsystems;
import frc.robot.subsystems.DriveSubsystem;

public class DriveForwardTimed extends CommandBase {

  private final DriveSubsystem DRIVE_SUBSYSTEM;
  
  double kP = 1;
  double goal_speed;
  Timer timer;
  /** Creates a new DriveForwardTimed. */
  public DriveForwardTimed(DriveSubsystem ds, double speed) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.goal_speed = speed;

    this.DRIVE_SUBSYSTEM = ds;
    addRequirements(DRIVE_SUBSYSTEM);
    timer = new Timer();
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.reset();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {  

    timer.start();
    SmartDashboard.putNumber("time:", timer.get());
    while(timer.get() < Constants.DriveForwardtime){

      //double output = goal_speed + (Subsystems.GYRO_SUBSYSTEM.getHeading()*kP);

      DRIVE_SUBSYSTEM.driveForward(goal_speed);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    DRIVE_SUBSYSTEM.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
