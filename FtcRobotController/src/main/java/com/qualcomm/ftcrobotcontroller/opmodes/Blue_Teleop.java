package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import java.util.concurrent.TimeUnit;

/**
 * Created by Julian on 1/7/16.
 */
//this code is our basic code we will run during competitions

public class Blue_Teleop extends OpMode {



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
    public void init() {
        //Naming which motors and servos are which
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
        Climber_Depositor.setPosition(1);
        Left_Trigger.setPosition(0.2);
        Right_Trigger.setPosition(0.8);
        LF_CowCatcher.setPosition(0.65);
        RF_CowCatcher.setPosition(0.35);
        Shoulder_Servo.setPosition(0.15);
        Elbow_Servo.setPosition(0.5);



    }



    @Override
    public void loop() {

        //Which Name Correlates to Which Button
        float LeftY1 = -gamepad1.left_stick_y;
        float RightY1 = -gamepad1.right_stick_y;
        float RightTrigger1 = gamepad1.right_trigger;
        float LeftTrigger1 = -gamepad1.left_trigger;
        float RightTrigger2 = gamepad2.right_trigger;
        float LeftTrigger2 = gamepad2.left_trigger;
        boolean ButtonY1 = gamepad1.y;
        boolean ButtonA1 = gamepad1.a;
        boolean ButtonB1 = gamepad1.b;
        boolean ButtonY2 = gamepad2.y;
        boolean ButtonB2 = gamepad2.b;
        boolean ButtonA2 = gamepad2.a;
        boolean ButtonX2 = gamepad2.x;
        boolean DPadRight2 = gamepad2.dpad_right;
        boolean DPadUp2 = gamepad2.dpad_up;
        boolean DPadDown2 = gamepad2.dpad_down;
        boolean DPadLeft2 = gamepad2.dpad_left;
        boolean LeftBumper2 = gamepad2.left_bumper;
        boolean RightBumper2 = gamepad2.right_bumper;
        boolean LeftBumper1 = gamepad1.left_bumper;
        boolean RightBumper1 = gamepad1.right_bumper;
        boolean DPadDown1 = gamepad1.dpad_down;
        boolean DPadUp1 = gamepad1.dpad_up;
        boolean ButtonX1 = gamepad1.x;
        boolean DPadLeft1 = gamepad1.dpad_left;
        boolean DPadRight1 = gamepad1.dpad_right;


        //Drive Motor Controls

        Upper_Left_Motor.setPower(LeftY1);
        Lower_Left_Motor.setPower(LeftY1);
        Upper_Right_Motor.setPower(RightY1);
        Lower_Right_Motor.setPower(RightY1);


        //Trigger Controls


        if (DPadUp1){
            Left_Trigger.setPosition(0.2);
            //if dpad 1 Up is pressed Left Trigger moves to Up position
        }
        if(DPadLeft1){
            Left_Trigger.setPosition(0.8);
            //if dpad 1 Left is pressed Left Trigger moves to mid position
        }
        if (DPadDown1) {
            Left_Trigger.setPosition(1);
            //if dpad 1 down is pressed Left Trigger moves to low position
        }


        //Climber Depositor Controls

        if(RightBumper1){
            Climber_Depositor.setPosition(0);
            //moves climber depositor to Depositing position
        }

        if (LeftBumper1) {
            Climber_Depositor.setPosition(1);
            //moves climber depositor to Storage position
        }



        //Elbow Controls

        float ElbowPositionGoal = RightTrigger2;
        double ElbowPosition = (ElbowPositionGoal - 0) * (0.7-0.5) + 0.5;
        Elbow_Servo.setPosition(ElbowPosition);





        //Shoulder Controls


         float ShoulderPositionGoal = LeftTrigger2;
        double ShoulderPosition = (ShoulderPositionGoal - 0) * (0.5-0.15) + 0.15;
        Shoulder_Servo.setPosition(ShoulderPosition);




        //Cow Catcher Controls


        if (ButtonY1) {
            LF_CowCatcher.setPosition(0.2);
            RF_CowCatcher.setPosition(0.8);
            //if Y1 is pressed CowCatchers go to up position
        }
        if (ButtonA1) {
            LF_CowCatcher.setPosition(0.65);
            RF_CowCatcher.setPosition(0.35);
            //if A1 is pressed CowCatchers got to down position
        }


        //Lift Spinner Controls
        if (ButtonA2) {
            Lift_Spinner.setPower(-1);
        }

        if (ButtonY2) {
            Lift_Spinner.setPower(1);
        }

        if (ButtonA2 || ButtonY2) {

        }
        else
        {
            Lift_Spinner.setPower(0);
        }


        //Lift_Spinner.setPower(RightTrigger2); //LiftSpinner goes forward based off of how far Right Trigger 2 is pressed
        //Lift_Spinner.setPower(LeftTrigger2);  //LiftSpinner goes backward based off of how far Left Trigger 2 is pressed



        //Debris Collection Controls

        //Collection_Motor.setPower(RightTrigger1); //Collection Occurs when right trigger 1 is pressed based off of how far it is pressed
        //Collection_Motor.setPower(LeftTrigger1);  //Reversing Occurs when left trigger 1 is pressed based off of how far it is pressed






        //Debris Bucket Controls









    }
}