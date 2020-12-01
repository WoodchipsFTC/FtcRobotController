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
package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
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
@TeleOp

public class ArmLinTest2 extends LinearOpMode {
     private Servo Servo_L;
     private Servo Servo_R;
     private DcMotor RF_motor;
     
     //declare a linear slide motor
     private DcMotor Slide_motor;

    @Override
    public void runOpMode() {
        
        //map the motors
       Servo_L = hardwareMap.get(Servo.class, "Left Grabber");
       Servo_R = hardwareMap.get(Servo.class, "Right Grabber");
       //RF_motor = hardwareMap.get(DcMotor.class, "Right Front");
       Slide_motor = hardwareMap.get(DcMotor.class, "Slide Motor");
       
       
       
        telemetry.addData("Status", "Initialized");
 
        
        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        //declare a variable for the triggers
        double LT;
        double RT;
        
        //set a default
        
        LT = 0;
        RT = 0;
        
        //create a servo maximum
        double ServoMax;
        
        //create a default for this too
        ServoMax = 0.7;
        
        //create a servo side offset
        double ServoOffset;
        
        //set a default
        ServoOffset = 0;
        
        //create an arm locking variable
        Boolean ArmLocked;
        
        //set a defualt
        
        ArmLocked = false;
        
        while (opModeIsActive()) {
            telemetry.addData("Status", "Running");
            telemetry.addData("left_trigger", this.gamepad1.left_trigger);
            telemetry.addData("Servo R", Servo_R.getPosition());
            
            
            // TODO test if locked
            if (this.gamepad1.start){
                ArmLocked = true;
                
            }
            else if (this.gamepad1.left_bumper || this.gamepad1.right_bumper) {
                ArmLocked = false;
                
            }
            telemetry.addData("armLocked", ArmLocked);
            
            
            //set LT and RT to the Left and right triggers
            
            if (ArmLocked == false) {
             LT = this.gamepad1.left_trigger;
             RT = this.gamepad1.right_trigger;
            }
            else {
                RT = 1;
                LT = 1;
            }
            
            //change the servo max
            
            if (this.gamepad1.y && ArmLocked == false) {
                ServoMax = 0.6;
            }
            else if (this.gamepad1.a && ArmLocked == false) {
                ServoMax = 0.5;
            }
            else if (ArmLocked == false) {
                ServoMax = 0.7;
            }
            
            
            //change the servo side offsets
            
            
            if (ServoMax < 0.7) {
                ServoOffset = this.gamepad1.left_stick_x/5;
            }
            
            else if (ArmLocked == false) {
                ServoOffset = 0;
            }
            
            
            if (LT > ServoMax + ServoOffset) {
                
                LT = ServoMax + ServoOffset;
            }
            
            if (RT > ServoMax - ServoOffset) {
                RT = ServoMax - ServoOffset;
            }
            //overide if locked
            
            
            
            //set the servo positions
            Servo_L.setPosition(LT);
            Servo_R.setPosition(1 - RT);
            
           //move the motors
            //RF_motor.setPower(this.gamepad1.right_stick_y);
            
            Slide_motor.setPower(this.gamepad1.right_stick_y);
            
            telemetry.update();

        }
    }
}
