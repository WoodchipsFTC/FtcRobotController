/*
Copyright 2018 FIRST Tech Challenge Team 10603

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
associated documentation files (the "Software"), to deal in the Software without restriction,
including without limitation the rights to use, copy, modify, merge, publish, distribute,
sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial
portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/

//Based on Test4.java
package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * This file contains an minimal example of a Linear "OpMode". An OpMode is a 'program' that runs in either
 * the autonomous or the teleop period of an FTC match. The names of OpModes appear on the menu
 * of the FTC Driver Station. When an selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.
 *
 * This particular OpMode just executes a basic Tank Drive Teleop for a PushBot
 * It includes all the skeletal structure that all linear OpModes contain.
 *
 * Remove a @Disabled the on the next line or two (if present) to add this opmode to the Driver Station OpMode list,
 * or add a @Disabled annotation to prevent this OpMode from being added to the Driver Station
 */
@TeleOp

public class FinalProg1_2021 extends LinearOpMode {

     
    //create the capstone dropping servo
    //private Servo Servo_Cap;
    //define the motors
    private DcMotor RF;
    private DcMotor RB;
    private DcMotor LF;
    private DcMotor LB;
     
    //declare a flywheel slide motor
    private DcMotor Flywheel_Motor;

    //declare an intake conveyor motor
    private DcMotor Intake_Motor;

    //Declare the arm motor
    private DcMotor Arm_Motor;

    //Declare the Grip Servo
    private Servo Grip_Servo;

    //Declare the Flywheel Speed
    private Double FlySpeed = 1.0;

    @Override
    public void runOpMode() {
        
        //map the motors
        //Servo_Cap = hardwareMap.get(Servo.class, "Servo Cap");
        //RF_motor = hardwareMap.get(DcMotor.class, "Right Front");
       
        //define the wheels
        RF = hardwareMap.get(DcMotor.class, "RF");
        RB = hardwareMap.get(DcMotor.class, "RB");
        LF = hardwareMap.get(DcMotor.class, "LF");
        LB = hardwareMap.get(DcMotor.class, "LB");
        //set the wheels to use encoders
        RF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        LF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        LB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        //Hardwaremap the servos
        Grip_Servo = hardwareMap.get(Servo.class, "Grip Servo");

        //Hardwaremap the other motors
        Flywheel_Motor = hardwareMap.get(DcMotor.class, "Flywheel Motor");
        Intake_Motor = hardwareMap.get(DcMotor.class, "Intake Motor");
        Arm_Motor = hardwareMap.get(DcMotor.class, "Arm Motor");
        //Set the motors ot use encoders
        Flywheel_Motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Intake_Motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Arm_Motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        telemetry.addData("Status", "Initialized");

        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)


        while (opModeIsActive()) {
            telemetry.addData("Status", "Running");

            if(this.gamepad2.y) {
                Intake_Motor.setPower(1);
            } else if(this.gamepad2.a) {
                Intake_Motor.setPower(-1);
            } else {
                Intake_Motor.setPower(0);
            }

            if(this.gamepad2.dpad_down) {
                Arm_Motor.setPower(1);
            } else if(this.gamepad2.dpad_up) {
                Arm_Motor.setPower(-1);
            } else {
                Arm_Motor.setPower(0);
            }

            if (FlySpeed <= 1) {
                FlySpeed += this.gamepad2.right_trigger / 100;
            }

            if (FlySpeed >= -1) {
                FlySpeed -= this.gamepad2.left_trigger / 100;
            }

            telemetry.addData("Flywheel Speed", FlySpeed);

            //Shooter power adjustment code
            Flywheel_Motor.setPower(gamepad2.right_stick_x * FlySpeed);


            //set the Servo position

            Grip_Servo.setPosition(this.gamepad2.left_stick_y * 135);
            telemetry.addData("Grip_Servo",this.gamepad2.left_stick_y * 135);

           //move the motors
            //RF_motor.setPower(this.gamepad1.right_stick_y);
           /*
            ArmLoc = Slide_motor.getCurrentPosition();
            telemetry.addData("ArmLoc", ArmLoc);
            if (ArmLoc >= ArmStart) {
            Slide_motor.setPower((Math.pow(this.gamepad2.right_stick_y, 2))* -(this.gamepad2.right_stick_y / Math.abs(this.gamepad2.right_stick_y)));
            } else {
                Slide_motor.setPower(-1);
            }
            */
            //Slide_motor.setPower((Math.pow(this.gamepad2.right_stick_y, 2))* -(this.gamepad2.right_stick_y / Math.abs(this.gamepad2.right_stick_y)));

            //ArmLoc += (Math.pow(this.gamepad2.right_stick_y, 2))* -(this.gamepad2.right_stick_y / Math.abs(this.gamepad2.right_stick_y));
            //ArmLoc += RT;

            
            //driving code goes here

            double speedModifier = (1- ((this.gamepad1.right_trigger + this.gamepad1.left_trigger)/1.5));
            double gamepad1LX = this.gamepad1.left_stick_x * speedModifier;
            double gamepad1LY = this.gamepad1.left_stick_y * speedModifier;
            double gamepad1RX = this.gamepad1.right_stick_x * speedModifier;
            
            
            LF.setPower((-(gamepad1LX + -gamepad1LY)) + -gamepad1RX);
            RF.setPower((-gamepad1LY - gamepad1LX) + -gamepad1RX);
            RB.setPower(((gamepad1LX + -gamepad1LY)) + -gamepad1RX);
            LB.setPower((-(-gamepad1LY - gamepad1LX)) + -gamepad1RX);
            
            
            
            
            telemetry.update();

        }
    }
}
