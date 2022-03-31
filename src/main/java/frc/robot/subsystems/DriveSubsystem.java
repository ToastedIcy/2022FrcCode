// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.*;
import edu.wpi.first.wpilibj.motorcontrol.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


public class DriveSubsystem extends SubsystemBase {
 
  CANSparkMax m_L1;
  CANSparkMax m_L2;
  CANSparkMax m_R1;
  CANSparkMax m_R2;
  
  RelativeEncoder e_L1;
  RelativeEncoder e_L2;
  RelativeEncoder e_R1;
  RelativeEncoder e_R2;


  MotorControllerGroup m_Lcontroller;
  MotorControllerGroup m_Rcontroller;

  DifferentialDrive drive;

  /** Creates a new DriveTrain. */
  public DriveSubsystem() {

    m_L1 = new CANSparkMax(left_front_motor, MotorType.kBrushless);
    m_L2 = new CANSparkMax(left_rear_motor, MotorType.kBrushless);
    m_R1 = new CANSparkMax(right_front_motor, MotorType.kBrushless);
    m_R2 = new CANSparkMax(right_rear_motor, MotorType.kBrushless);

    e_L1 = m_L1.getEncoder();
    e_L2 = m_L2.getEncoder();
    e_R1 = m_R1.getEncoder();
    e_R2 = m_R2.getEncoder();


    m_Lcontroller = new MotorControllerGroup(m_L1, m_L2);
    m_Rcontroller = new MotorControllerGroup(m_R1, m_R2);

    drive = new DifferentialDrive(m_Lcontroller, m_Rcontroller); 

    m_L1.setInverted(true);
    m_L2.setInverted(true);
    m_R1.setInverted(false);
    m_R2.setInverted(false);
   
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Left 1 Encoder: ", e_L1.getPosition());
    SmartDashboard.putNumber("Left 2 Encoder: ", e_L2.getPosition());
    SmartDashboard.putNumber("Right 1 Encoder: ", e_R1.getPosition());
    SmartDashboard.putNumber("Right 2 Encoder: ", e_R2.getPosition());
  }

  public void driveJoysticks(XboxController dJoystick, double speed){
    
    //drive.arcadeDrive(dJoystick.getRawAxis((int) (Constants.controller_y_axis*speed)), dJoystick.getRawAxis((int) (Constants.controller_x_axis*speed)));
    drive.arcadeDrive(dJoystick.getLeftY() * -1, dJoystick.getLeftX()*0.8);
  }

  public void driveForward(double speed){
    drive.tankDrive(speed, speed);

  }

  public double getLeftEncoder() {
    return e_L1.getPosition();
  }

  public double getRightEncoder() {
    return e_R1.getPosition();
  }

  public void resetEncoders() {
    e_L1.setPosition(0);
    e_L2.setPosition(0);
    e_R1.setPosition(0);
    e_R2.setPosition(0);
  }
  
  public void setLeft(double speed) {
    m_Lcontroller.set(speed);
  }

  public void setRight(double speed) {
    m_Rcontroller.set(speed);
  }

  public void stop(){
    drive.stopMotor();
  }
}