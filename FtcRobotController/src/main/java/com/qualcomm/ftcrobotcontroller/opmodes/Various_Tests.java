package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import java.util.concurrent.TimeUnit;

/**
 * Created by nikita on 12/21/15.
 */
//this code is our basic code we will run during competitions

public class Various_Tests extends OpMode {

    //UpdatedTeleOp_Code = subclass of OpMode
    //OpMode = java class


    //naming stuff below

    DcMotor Upper_Right_Motor;
    DcMotor Lower_Right_Motor;
    DcMotor Upper_Left_Motor;
    DcMotor Lower_Left_Motor;
    DcMotor Lift_Spinner;

    Servo Left_Trigger;
    Servo Right_Trigger;
    Servo Climber_Depositor;
    //Servo Brake;
    Servo RF_CattleGuard;
    Servo LF_CattleGuard;
    Servo Shoulder_Servo;
    Servo Elbow_Servo;

    //overriding the stuff OpMode makes the robot do
    //telling robot controller which hardware bits are named what so can be used in code
    //method
    //init = do this when robot is started

    @Override
    public void init() {
        //naming which motors are which
        Upper_Right_Motor = hardwareMap.dcMotor.get("Upper Right Motor");
        Lower_Right_Motor = hardwareMap.dcMotor.get("Lower Right Motor");
        Upper_Left_Motor = hardwareMap.dcMotor.get("Upper Left Motor");
        Lower_Left_Motor = hardwareMap.dcMotor.get("Lower Left Motor");
        Lift_Spinner = hardwareMap.dcMotor.get("Lift Spinner");

        //naming which servos are which
        Left_Trigger = hardwareMap.servo.get("Left Trigger");
        Right_Trigger = hardwareMap.servo.get("Right Trigger");
        Climber_Depositor = hardwareMap.servo.get("Climber Depositor");
        //Brake = hardwareMap.servo.get("Brake");
        RF_CattleGuard = hardwareMap.servo.get("RF Cattle Guard");
        LF_CattleGuard = hardwareMap.servo.get("LF Cattle Guard");
        Shoulder_Servo = hardwareMap.servo.get("Shoulder Servo");
        Elbow_Servo = hardwareMap.servo.get("Elbow Servo");

        //reversing motor direction for 2 of the motors to allow moving joysticks to actually move the robot forward

        Upper_Left_Motor.setDirection(DcMotor.Direction.REVERSE);
        Lower_Left_Motor.setDirection(DcMotor.Direction.REVERSE);

        Climber_Depositor.setPosition(1);
        Left_Trigger.setPosition(0.2);
        Right_Trigger.setPosition(1);
        LF_CattleGuard.setPosition(0.8);
        RF_CattleGuard.setPosition(0.2);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
        Shoulder_Servo.setPosition(0.15);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
        Elbow_Servo.setPosition(0.575);



    }

    //overriding more stuff OpMode makes robot do
    //loop = keep doing this again and again
    //method

    @Override
    public void loop() {
        //setting the coordinate positions for moving (-1, 0, or 1) and making the opposite #
        //things like rightY are variables

        float leftY = -gamepad1.left_stick_y;
        float rightY = -gamepad1.right_stick_y;

        //naming buttons on gamepad - declaring variable names

        //climber depositor controls
        boolean ButtonY1 = gamepad1.y;
        boolean ButtonA1 = gamepad1.a;
        //brake controls
        //boolean ButtonB1 = gamepad1.b;
        //right trigger controls
        boolean ButtonY2 = gamepad2.y;
        boolean ButtonB2 = gamepad2.b;
        boolean ButtonA2 = gamepad2.a;
        //lift spinner controls
        boolean ButtonX2 = gamepad2.x;
        boolean DPadRight2 = gamepad2.dpad_right;
        //left trigger controls
        boolean DPadUp2 = gamepad2.dpad_up;
        boolean DPadDown2 = gamepad2.dpad_down;
        boolean DPadLeft2 = gamepad2.dpad_left;
        //elbow controls
        boolean LeftBumper2 = gamepad2.left_bumper;
        boolean RightBumper2 = gamepad2.right_bumper;
        //shoulder controls
        boolean LeftBumper1 = gamepad1.left_bumper;
        boolean RightBumper1 = gamepad1.right_bumper;
        //cattle guard controls
        boolean DPadDown1 = gamepad1.dpad_down;
        boolean DPadUp1 = gamepad1.dpad_up;

        //// TODO: deal with debris collection mechanisms
        //debris trapdoor (toggle?)
        boolean ButtonX1 = gamepad1.x;
        //debris slider
        boolean DPadLeft1 = gamepad1.dpad_left;
        boolean DPadRight1 = gamepad1.dpad_right;
        //debris depositor extenders
        //these will be on the red and blue codes due to lack of buttons
        //debris collector
        //forward/backward/0
        //these will be on the red and blue codes due to lack of buttons


        //basing power for all 4 motors off the "coordinates" of the gamepad sticks (-1, 0, or 1)

        Upper_Left_Motor.setPower(leftY);
        Lower_Left_Motor.setPower(leftY);
        Upper_Right_Motor.setPower(rightY);
        Lower_Right_Motor.setPower(rightY);

        //if [button] is pressed, [do this]

        //setting positions for Climber_Depositor

        if(ButtonY1){
            Climber_Depositor.setPosition(0);
        }

        if (ButtonA1) {
            Climber_Depositor.setPosition(1);
        }

        //setting brake position
        //if(ButtonB1){
        //Brake.setPosition(0.4);
        //}
        //else {
        //Brake.setPosition(0.8);
        //}
        //setting position for triggers

        if (ButtonY2){
            Right_Trigger.setPosition(1);
        }
        if (ButtonB2){
            Right_Trigger.setPosition(0.4);
        }
        if (ButtonA2){
            Right_Trigger.setPosition(0.3);


            //left trigger
        }
        if (DPadUp2){
            Left_Trigger.setPosition(0.2);
        }
        if(DPadLeft2){
            Left_Trigger.setPosition(0.8);
        }
        if (DPadDown2) {
            Left_Trigger.setPosition(1);
        }

        //controls for elbow servo

        //up
        if (LeftBumper2) {
            Elbow_Servo.setPosition(0.575);
        }
        //down
        if (RightBumper2) {
            Elbow_Servo.setPosition(0.7);
        }

        //shoulder servo controls

        //up
        if (LeftBumper1) {
            Shoulder_Servo.setPosition(0.15);
        }
        //down
        if (RightBumper1) {
            Shoulder_Servo.setPosition(0.35);
        }

        //cattle guard controls

        if (DPadDown1) {
            LF_CattleGuard.setPosition(0.65);
            RF_CattleGuard.setPosition(0.35);
        }
        if (DPadUp1) {
            LF_CattleGuard.setPosition(0.2);
            RF_CattleGuard.setPosition(0.8);
        }

        //Lift Spinner controllers

        //let out rope
        if (DPadRight2) {
            Lift_Spinner.setPower(1);
        }

        //pull up rope
        if (ButtonX2) {
            Lift_Spinner.setPower(-1);
        }

        if (DPadRight2 || ButtonX2) {

        }
        else
        {
            Lift_Spinner.setPower(0);
        }
    }
}



