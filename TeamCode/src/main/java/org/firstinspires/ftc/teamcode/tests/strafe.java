package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "strafe (Blocks to Java)", group = "")
public class strafe extends LinearOpMode {

  private DcMotor LeftBack;
  private DcMotor LeftFront;
  private DcMotor RightBack;
  private DcMotor RightFront;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    LeftBack = hardwareMap.dcMotor.get("LeftBack");
    LeftFront = hardwareMap.dcMotor.get("LeftFront");
    RightBack = hardwareMap.dcMotor.get("RightBack");
    RightFront = hardwareMap.dcMotor.get("RightFront");

    // Put initialization blocks here.
    waitForStart();
    // Put run blocks here.
    while (opModeIsActive()) {
      // Put loop blocks here.
      telemetry.update();
      if (gamepad1.right_bumper) {
        LeftBack.setPower(1);
        LeftFront.setPower(-1);
        RightBack.setPower(-1);
        RightFront.setPower(1);
      } else if (gamepad1.left_bumper) {
        LeftBack.setPower(-1);
        LeftFront.setPower(1);
        RightBack.setPower(1);
        RightFront.setPower(-1);
      } else {
        RightBack.setPower(-gamepad1.right_stick_y);
        RightFront.setPower(-gamepad1.right_stick_y);
        LeftBack.setPower(gamepad1.left_stick_y);
        LeftFront.setPower(gamepad1.left_stick_y);
      }
    }
  }
}
