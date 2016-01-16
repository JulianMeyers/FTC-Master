package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Julian on 11/29/2015.
 * Test
 */
public class ROB_Basic_Program extends OpMode {




    DcMotor Upper_Right_Motor;
    DcMotor Lower_Right_Motor;
    DcMotor Upper_Left_Motor;
    DcMotor Lower_Left_Motor;

    Servo Left_Trigger;
    Servo Right_Trigger;
    Servo Climber_Depositor;

    @Override
    public void init() {
        Upper_Right_Motor = hardwareMap.dcMotor.get("Upper Right Motor");
        Lower_Right_Motor = hardwareMap.dcMotor.get("Lower Right Motor");
        Upper_Left_Motor = hardwareMap.dcMotor.get("Upper Left Motor");
        Lower_Left_Motor = hardwareMap.dcMotor.get("Lower Left Motor");

        Left_Trigger = hardwareMap.servo.get("Left Trigger");
        Right_Trigger = hardwareMap.servo.get("Right Trigger");
        Climber_Depositor = hardwareMap.servo.get("Climber Depositor");

        Upper_Left_Motor.setDirection(DcMotor.Direction.REVERSE);
        Lower_Left_Motor.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void loop() {
        float leftY = -gamepad1.left_stick_y;
        float rightY = -gamepad1.right_stick_y;

        boolean ButtonY1 = gamepad1.y;
        boolean ButtonA1 = gamepad1.a;
        boolean ButtonB1 = gamepad1.b;
        boolean ButtonY2 = gamepad2.y;
        boolean ButtonB2 = gamepad2.b;
        boolean ButtonA2 = gamepad2.a;
        boolean ButtonX2 = gamepad2.x;
        boolean DPadUp2 = gamepad2.dpad_up;
        boolean DPadRight2 = gamepad2.dpad_right;
        boolean DPadDown2 = gamepad2.dpad_down;
        boolean DPadLeft2 = gamepad2.dpad_left;

        Upper_Left_Motor.setPower(leftY);
        Lower_Left_Motor.setPower(leftY);
        Upper_Right_Motor.setPower(rightY);
        Lower_Right_Motor.setPower(rightY);

        if(ButtonY1){
            Climber_Depositor.setPosition(0);
        }

        if(ButtonA1){
            Climber_Depositor.setPosition(1);
        }

        if (ButtonY2){
            Right_Trigger.setPosition(1);
        }
        if (ButtonB2){
            Right_Trigger.setPosition(0.5);
        }
        if (ButtonA2){
            Right_Trigger.setPosition(0.15);
        }
        if (DPadUp2){
            Left_Trigger.setPosition(0);
        }
        if(DPadLeft2){
            Left_Trigger.setPosition(0.5);
        }
        if (DPadDown2){
            Left_Trigger.setPosition(0.85);
        }

    }
}
