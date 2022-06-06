package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
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
    DcMotor caruselMotor;

    Servo servoSlider;
    CRServo servoGlisiera;
    //double motor_modifier=1;
    //double slider_speed=0.5;
    //double slider_position;


    @Override
    public void init() {
        frontRightMotor= (DcMotor) hardwareMap.get("frontRightMotor");
        frontLeftMotor= (DcMotor) hardwareMap.get("frontLeftMotor");
        backLeftMotor= (DcMotor) hardwareMap.get("backLeftMotor");
        backRightMotor= (DcMotor) hardwareMap.get("backRightMotor");
        wheelMotor=(DcMotor) hardwareMap.get("wheelMotor");
        servoSlider=(Servo) hardwareMap.get("servoSlider");
        servoGlisiera=(CRServo) hardwareMap.get("servoGlisiera");
        caruselMotor=(DcMotor) hardwareMap.get("caruselMotor");
    }
    public void move_forward(){
            frontRightMotor.setPower(-gamepad1.left_stick_y);
            frontLeftMotor.setPower(gamepad1.left_stick_y);
            backRightMotor.setPower(-gamepad1.left_stick_y);
            backLeftMotor.setPower(gamepad1.left_stick_y);
    }

    public void collect(){
        if(gamepad2.b) {
            wheelMotor.setPower(0.8);
        }
        else
        {
            wheelMotor.setPower(0);
        }
    }

    /*
    public void carusel_left(){
        if(gamepad1.left_bumper){
            servoCarusel.setPower(0.99);
        }
        else
        {
            servoCarusel.setPower(0);
        }
    }
    */

    public void carusel_right(){
        if(gamepad2.right_bumper){
            caruselMotor.setPower(-0.6);
        }
        else
        {
            caruselMotor.setPower(0);
        }
    }
    /*
    public void throw_cube(){
        if(gamepad2.right_stick_y>0){
            //servoSlider.setDirection(Servo.Direction.REVERSE);
            servoSlider.setPosition(0.9);

        }
    }
    */

    /*
    public void keep_cube(){
        if(gamepad2.right_stick_y==0){
            servoSlider.setPosition(0);
        }
    }
    */
    /*
    public void move_cube(){
        if(gamepad2.y){
            servoSlider.setPosition(1);
        }
        else{
            if(gamepad2.a){
                servoSlider.setPosition(0);
            }
            else{
                if(gamepad2.x){
                    servoSlider.setPosition(0.6);
                }
            }
        }
    }
    */
    public void get_cube(){
            //servoSlider.setDirection(Servo.Direction.REVERSE);
        if(gamepad2.right_stick_y<0) {
            servoSlider.setPosition(gamepad2.right_stick_y);
        }
        else{
            servoSlider.setPosition(1);
        }

    }
    public void ridicare_glisiera() {
        if (gamepad2.dpad_up){
            servoGlisiera.setPower(-0.99);
        }
        //else{
           // servoGlisiera.setPower(0);
        //}
    }

    public void coborare_glisiera(){
        if (gamepad2.dpad_down) {
            servoGlisiera.setPower(0.99);
        }
        //servoGlisiera.setPower(0);
    }

    public void stop_glisiera(){
        if(gamepad2.x)
            servoGlisiera.setPower(0);
    }

    public void move_sideways(){
        frontRightMotor.setPower(-gamepad1.right_stick_x);
        frontLeftMotor.setPower(-gamepad1.right_stick_x);
        backRightMotor.setPower(gamepad1.right_stick_x);
        backLeftMotor.setPower(gamepad1.right_stick_x);
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
        //throw_cube();
        ridicare_glisiera();
        coborare_glisiera();
        carusel_right();
        get_cube();
        //move_cube();
       // keep_cube();
        stop_glisiera();
    }
}
