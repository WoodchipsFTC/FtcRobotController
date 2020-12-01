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
package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

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
@Autonomous

public class Red_Load_Reprosition extends LinearOpMode {
    private Servo Servo_L;
     private Servo Servo_R;
     //define the motors
     private DcMotor RF;
     private DcMotor RB;
     private DcMotor LF;
     private DcMotor LB;
     
     //declare a linear slide motor
     private DcMotor Slide_motor;

    @Override
    public void runOpMode() {
       Servo_L = hardwareMap.get(Servo.class, "Left Grabber");
       Servo_R = hardwareMap.get(Servo.class, "Right Grabber");
       //RF_motor = hardwareMap.get(DcMotor.class, "Right Front");
       Slide_motor = hardwareMap.get(DcMotor.class, "Slide Motor");
       
       //define the wheels
       RF = hardwareMap.get(DcMotor.class, "Right Front");
       RB = hardwareMap.get(DcMotor.class, "Right Back");
       LF = hardwareMap.get(DcMotor.class, "Left Front");
       LB = hardwareMap.get(DcMotor.class, "Left Back");

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        
        //Once the game starts
        //Open servos
        Servo_L.setPosition(0);
        Servo_R.setPosition(1);
        //Move forward for 4 seconds
        RF.setPower(0.5);
        RB.setPower(0.5);
        LF.setPower(-0.5);
        LB.setPower(-0.5);
        sleep(3000);
        //Stop motors
        RF.setPower(0);
        RB.setPower(0);
        LF.setPower(0);
        LB.setPower(0);
        //Move the servos inward
        Servo_L.setPosition(1);
        Servo_R.setPosition(0);
        //Wait 1 second
        sleep(1000);
        //Turn 135 degrees left
        RF.setPower(0.5);
        RB.setPower(0.5);
        LF.setPower(0.5);
        LB.setPower(0.5);
        sleep(2000);
        //Move forward for 3.5 seconds
        RF.setPower(0.5);
        RB.setPower(0.5);
        LF.setPower(-0.5);
        LB.setPower(-0.5);
        sleep(3500);
        //Turn right 45 degrees
        RF.setPower(-0.5);
        RB.setPower(-0.5);
        LF.setPower(-0.5);
        LB.setPower(-0.5);
        sleep(600);
        //Move forward for 3.9 seconds
        RF.setPower(0.5);
        RB.setPower(0.5);
        LF.setPower(-0.5);
        LB.setPower(-0.5);
        sleep(3900);
        //Right turn 90 degrees
        RF.setPower(-0.5);
        RB.setPower(-0.5);
        LF.setPower(-0.5);
        LB.setPower(-0.5);
        sleep(700);
        //Move arm upwards for 0.8 seconds
        Slide_motor.setPower(0.5);
        sleep(1600);
        Slide_motor.setPower(0);
        //Move forward for 2.5 seconds
        RF.setPower(0.25);
        RB.setPower(0.25);
        LF.setPower(-0.25);
        LB.setPower(-0.25);
        sleep(4000);
        //Stop motors
        RF.setPower(0);
        RB.setPower(0);
        LF.setPower(0);
        LB.setPower(0);
        //Open servos
        Servo_L.setPosition(0);
        Servo_R.setPosition(1);
        sleep(500);
        //Move backward for 0.25 seconds
        RF.setPower(0.5);
        RB.setPower(0.5);
        LF.setPower(-0.5);
        LB.setPower(-0.5);
        sleep(250);
        RF.setPower(0);
        RB.setPower(0);
        LF.setPower(0);
        LB.setPower(0);
        //Lower arm for 0.8 seconds
        Slide_motor.setPower(-1);
        sleep(800);
        Slide_motor.setPower(0);
        //Move backwards for 2.75 seconds
        RF.setPower(-0.5);
        RB.setPower(-0.5);
        LF.setPower(0.5);
        LB.setPower(0.5);
        sleep(2750);
        //Raise arm for 0.8 seconds
        Slide_motor.setPower(1);
        sleep(200);
        RF.setPower(0);
        RB.setPower(0);
        LF.setPower(0);
        LB.setPower(0);
        sleep(600);
        Slide_motor.setPower(0);
        //Strafe right for 4.8 seconds
        RF.setPower(-0.5);
        RB.setPower(0.5);
        LF.setPower(-0.5);
        LB.setPower(0.5);
        sleep(1600);
        Slide_motor.setPower(-1);
        sleep(800);
        Slide_motor.setPower(0);
        sleep(1600);
        //Stop
        RF.setPower(0);
        RB.setPower(0);
        LF.setPower(0);
        LB.setPower(0);
    }
}
