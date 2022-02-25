// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import frc.robot.Constants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Shooter extends SubsystemBase {
  TalonFX m_front;
  TalonFX m_rear;

  /** Creates a new Shooter. */
  public Shooter() {
    m_front = new TalonFX(Constants.shooter_front_motor);
    m_rear= new TalonFX(Constants.shooter_rear_motor);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
