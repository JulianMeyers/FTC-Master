package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import java.util.concurrent.TimeUnit;

/**
 * Created by Julian on 1/15/16.
 */


    public class Autonomous_Red_Mountain extends LinearOpMode {
        //Naming DcMotors and Servos

        DcMotor Upper_Right_Motor;
        DcMotor Lower_Right_Motor;
        DcMotor Upper_Left_Motor;
        DcMotor Lower_Left_Motor;
        DcMotor Lift_Spinner;
        //DcMotor Collection_Motor;
        Servo Left_Trigger;
        Servo Right_Trigger;
        Servo Climber_Depositor;
        Servo RF_CowCatcher;
        Servo LF_CowCatcher;
        Servo Shoulder_Servo;
        Servo Elbow_Servo;


        @Override
        public void runOpMode() throws InterruptedException {
            Upper_Right_Motor = hardwareMap.dcMotor.get("Upper Right Motor");
            Lower_Right_Motor = hardwareMap.dcMotor.get("Lower Right Motor");
            Upper_Left_Motor = hardwareMap.dcMotor.get("Upper Left Motor");
            Lower_Left_Motor = hardwareMap.dcMotor.get("Lower Left Motor");
            Lift_Spinner = hardwareMap.dcMotor.get("Lift Spinner");
            //Collection_Motor = hardwareMap.dcMotor.get("Collection Motor");
            Left_Trigger = hardwareMap.servo.get("Left Trigger");
            Right_Trigger = hardwareMap.servo.get("Right Trigger");
            Climber_Depositor = hardwareMap.servo.get("Climber Depositor");
            RF_CowCatcher = hardwareMap.servo.get("RF Cattle Guard");
            LF_CowCatcher = hardwareMap.servo.get("LF Cattle Guard");
            Shoulder_Servo = hardwareMap.servo.get("Shoulder Servo");
            Elbow_Servo = hardwareMap.servo.get("Elbow Servo");


            //Reversing the direction of the left motors due to positioning
            Upper_Left_Motor.setDirection(DcMotor.Direction.REVERSE);
            Lower_Left_Motor.setDirection(DcMotor.Direction.REVERSE);

            //Robot Preparing for Movement-in-game
            Left_Trigger.setPosition(0.2);
            Right_Trigger.setPosition(0.8);
            LF_CowCatcher.setPosition(0.65);
            RF_CowCatcher.setPosition(0.35);
            Shoulder_Servo.setPosition(0.15);
            sleep(1000);
            Elbow_Servo.setPosition(0.5);
            sleep(1000);
            Climber_Depositor.setPosition(1);

            waitForStart();

            for(int i=0; i<1; i++) {
                Upper_Right_Motor.setPower(1.0);
                Lower_Right_Motor.setPower(1.0);
                Upper_Left_Motor.setPower(1.0);
                Lower_Left_Motor.setPower(1.0);

                sleep(3500);
            }

            Upper_Right_Motor.setPowerFloat();
            Lower_Right_Motor.setPowerFloat();
            Upper_Left_Motor.setPowerFloat();
            Lower_Left_Motor.setPowerFloat();

        }
    }

