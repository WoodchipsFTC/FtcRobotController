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

public class Servo_Tests extends LinearOpMode {

     //Declare the Arm Servo
     private Servo Arm_Servo;

     //Declare the Gripper Servo
     private Servo Grip_Servo;

    //Declare the push servo
    private Servo Push_Servo;

    @Override
    public void runOpMode() {

        //Hardwaremap the servos
        Arm_Servo = hardwareMap.get(Servo.class, "Arm Servo");
        Grip_Servo = hardwareMap.get(Servo.class, "Grip Servo");
        Push_Servo = hardwareMap.get(Servo.class, "Push Servo");

        telemetry.addData("Status", "Initialized");

        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)

        while (opModeIsActive()) {
            telemetry.addData("Status", "Running");

            //set the Servo positions
            Push_Servo.setPosition(this.gamepad1.left_stick_y * 45 + 45);
            telemetry.addData("Push_Servo",this.gamepad1.left_stick_y * 45 + 45);

            Arm_Servo.setPosition(this.gamepad1.right_stick_y * 45 + 45);
            telemetry.addData("Arm_Servo",this.gamepad1.right_stick_y * 45 + 45);

            Grip_Servo.setPosition(this.gamepad2.left_stick_y * 45 + 45);
            telemetry.addData("Grip_Servo",this.gamepad2.left_stick_y * 45 + 45);

            telemetry.update();

        }
    }
}
