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

public class FinalProg1_2020 extends LinearOpMode {

     
     //create the capstone dropping servo
     //private Servo Servo_Cap;
     //define the motors
     private DcMotor RF;
     private DcMotor RB;
     private DcMotor LF;
     private DcMotor LB;
     
     //declare a linear slide motor
     private DcMotor Slide_motor;

     //declare a shooter spinner motor
     private DcMotor Shooter_motor;

     //Declare the collector wheel motor(the M stands for motor)
     private DcMotor CollectorM;

     //Declare the Arm Servo
     private Servo Arm_Servo;

     //Declare the Gripper Servo
     private Servo Grip_Servo;

    //Declare the push servo
    private Servo Push_Servo;

    @Override
    public void runOpMode() {
        
        //map the motors
       //Servo_Cap = hardwareMap.get(Servo.class, "Servo Cap");
       //RF_motor = hardwareMap.get(DcMotor.class, "Right Front");
       Slide_motor = hardwareMap.get(DcMotor.class, "Slide Motor");
       
       //define the wheels
       RF = hardwareMap.get(DcMotor.class, "Right Front");
       RB = hardwareMap.get(DcMotor.class, "Right Back");
       LF = hardwareMap.get(DcMotor.class, "Left Front");
       LB = hardwareMap.get(DcMotor.class, "Left Back");
       //set the wheels to use encoders
       RF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
       RB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
       LF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
       LB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);



       int ArmLoc;
       int ArmStart;
       ArmStart = Slide_motor.getCurrentPosition();


        //Hardwaremap the shooter motor
        Shooter_motor = hardwareMap.get(DcMotor.class,"Shooter motor");
        //set the shooter motor to use encoders
        Shooter_motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        //Hardwaremap the servos
        Arm_Servo = hardwareMap.get(Servo.class, "Arm Servo");
        Grip_Servo = hardwareMap.get(Servo.class, "Grip Servo");
        Push_Servo = hardwareMap.get(Servo.class, "Push Servo");

        telemetry.addData("Status", "Initialized");

        //Hardwaremap CollectorM
        CollectorM = hardwareMap.get(DcMotor.class,"CollectorM");
        //set CollectorM to use encoders
        CollectorM.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        //declare a variable for the triggers
        double Shooter_Power;
        Shooter_Power = 0;

        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        

        while (opModeIsActive()) {
            telemetry.addData("Status", "Running");

            if(this.gamepad2.y) {
                CollectorM.setPower(1);
            } else if(this.gamepad2.a) {
                CollectorM.setPower(-1);
            } else {
                CollectorM.setPower(0);
            }

            //Shooter power adjustment code
            Shooter_Power += this.gamepad2.left_stick_y;

            //this code moves the shooter motor
            Shooter_motor.setPower(Shooter_Power);
            //Show the shooter power to the user
            telemetry.addData("Shooter motor power", Shooter_Power);

            //set the Servo positions
            Push_Servo.setPosition(this.gamepad1.left_stick_y * 45 + 45);
            telemetry.addData("Push_Servo",this.gamepad1.left_stick_y * 45 + 45);

            Arm_Servo.setPosition(this.gamepad1.right_stick_y * 45 + 45);
            telemetry.addData("Arm_Servo",this.gamepad1.right_stick_y * 45 + 45);

            Grip_Servo.setPosition(this.gamepad2.left_stick_y * 45 + 45);
            telemetry.addData("Grip_Servo",this.gamepad2.left_stick_y * 45 + 45);

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
            Slide_motor.setPower((Math.pow(this.gamepad2.right_stick_y, 2))* -(this.gamepad2.right_stick_y / Math.abs(this.gamepad2.right_stick_y)));

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
