// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;



import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.DriveForwardTimed;
import frc.robot.commands.DriveWithJoysticks;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Shooter;


public class RobotContainer {

  

    private final DriveWithJoysticks driveWithJoysticks;
    private final DriveTrain driveT;
    private final DriveForwardTimed driveForwardTimed;
    public static XboxController dJoystick;

    private final Shooter shooter;


    public RobotContainer(){
        driveT = new DriveTrain();
        driveWithJoysticks = new DriveWithJoysticks(driveT);
        driveWithJoysticks.addRequirements(driveT);
        driveT.setDefaultCommand(driveWithJoysticks);

        driveForwardTimed = new DriveForwardTimed(driveT);
        driveForwardTimed.addRequirements(driveT);

        dJoystick = new XboxController(Constants.port_number);

        shooter = new Shooter();
    }


    public Command getAutonmousCommand(){
        return driveForwardTimed;
    }
}


