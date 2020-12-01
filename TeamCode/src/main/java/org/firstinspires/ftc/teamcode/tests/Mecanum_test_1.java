/*
Copyright 2019 FIRST Tech Challenge Team 10603

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
package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.hardware.motors.TetrixMotor;
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

public class Mecanum_test_1 extends LinearOpMode {
    private DcMotor Right_Front;
    private DcMotor Left_Front;
    private DcMotor Right_Back;
    private DcMotor Left_Back;
    @Override
    public void runOpMode() {
        
        
        Right_Front = hardwareMap.get(DcMotor.class, "Right Front");
        Left_Front = hardwareMap.get(DcMotor.class, "Left Front");
        Right_Back = hardwareMap.get(DcMotor.class, "Right Back");
        Left_Back = hardwareMap.get(DcMotor.class, "Left Back");
        
        
        
        
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        
        
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            telemetry.addData("Status", "Running");
            
            
            
            //create variables
            
            double LF_Movement = 1;
            double RF_Movement = 1;
            double LB_Movement = 1;
            double RB_Movement = 1;
            
            double MovDir = 0;
            double MovMag = 0;
            double LS_X;
            double LS_Y;
            double RS_X;
            


            
            //calculate the Direction and Magnitude 
            LS_X = this.gamepad1.left_stick_x * 2;
            LS_Y = this.gamepad1.left_stick_y;
            RS_X = -this.gamepad1.right_stick_x;
            
            //create variables for motor movement
            
                        
            //calculate mecanum movements
            
            
            LF_Movement = (RS_X + -LS_X + LS_Y);
            LB_Movement = (RS_X - -LS_X + LS_Y);
            RF_Movement = (RS_X - -LS_X - LS_Y);
            RB_Movement = (RS_X + -LS_X - LS_Y);
            
            
            //move the motors
            Left_Front.setPower(LF_Movement);
            Left_Back.setPower(LB_Movement);
            Right_Front.setPower(RF_Movement);
            Right_Back.setPower(RB_Movement);
            
            
            telemetry.update();

        }
    }
}
