package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "Mecanum Move", group = "Test")
public class MecanumMove extends OpMode {

    DcMotor frontRightMotor;
    DcMotor frontLeftMotor;
    DcMotor backRightMotor;
    DcMotor backLeftMotor;
    DcMotor wheelMotor;

    Servo servoSlider;

    double slider_speed=0.5;
    double slider_position;

    @Override
    public void init() {
        frontRightMotor= (DcMotor) hardwareMap.get("frontRightMotor");
        frontLeftMotor= (DcMotor) hardwareMap.get("frontLeftMotor");
        backLeftMotor= (DcMotor) hardwareMap.get("backLeftMotor");
        backRightMotor= (DcMotor) hardwareMap.get("backRightMotor");
        wheelMotor=(DcMotor) hardwareMap.get("wheelMotor");
        servoSlider=(Servo) hardwareMap.get("servoSlider");
    }
    public void move_forward(){
            frontRightMotor.setPower(-gamepad1.right_stick_y);
            frontLeftMotor.setPower(gamepad1.right_stick_y);
            backRightMotor.setPower(-gamepad1.right_stick_y);
            backLeftMotor.setPower(gamepad1.right_stick_y);
    }

    public void collect(){
        if(gamepad1.x) {
            wheelMotor.setPower(0.5);
        }
        else
        {
            wheelMotor.setPower(0);
        }
    }

    public void move_slider_servo(){
        if(gamepad1.dpad_up){
            servoSlider.setPosition(1);
        }
        else if(gamepad1.dpad_down) {
            servoSlider.setPosition(0);
        }
    }


    public void move_sideways(){
        frontRightMotor.setPower(-gamepad1.left_stick_x);
        frontLeftMotor.setPower(-gamepad1.left_stick_x);
        backRightMotor.setPower(gamepad1.left_stick_x);
        backLeftMotor.setPower(gamepad1.left_stick_x);
    }

    public void rotate_clockwise(){
        frontRightMotor.setPower(gamepad1.right_trigger);
        frontLeftMotor.setPower(gamepad1.right_trigger);
        backRightMotor.setPower(gamepad1.right_trigger);
        backLeftMotor.setPower(gamepad1.right_trigger);
    }
    public void rotate_counterclockwise(){

        frontRightMotor.setPower(-gamepad1.left_trigger);
        frontLeftMotor.setPower(-gamepad1.left_trigger);
        backRightMotor.setPower(-gamepad1.left_trigger);
        backLeftMotor.setPower(-gamepad1.left_trigger);
    }
    @Override
    public void loop() {
        move_forward();
        move_sideways();
        rotate_clockwise();
        rotate_counterclockwise();
        collect();
        move_slider_servo();
    }
}
