package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name="Autonomous Mode", group= "test")
public class Autonomous_Mode extends LinearOpMode {
    long milisecunde;
    DcMotor frontRightMotor;
    DcMotor frontLeftMotor;
    DcMotor backRightMotor;
    DcMotor backLeftMotor;
    DcMotor wheelMotor;
    Servo servoSlider;
    CRServo servoGlisiera;
    CRServo servoCarusel;

    public void assignComponents() {
        frontRightMotor= (DcMotor) hardwareMap.get("frontRightMotor");
        frontLeftMotor= (DcMotor) hardwareMap.get("frontLeftMotor");
        backLeftMotor= (DcMotor) hardwareMap.get("backLeftMotor");
        backRightMotor= (DcMotor) hardwareMap.get("backRightMotor");
        wheelMotor=(DcMotor) hardwareMap.get("wheelMotor");
        servoSlider=(Servo) hardwareMap.get("servoSlider");
        servoGlisiera=(CRServo) hardwareMap.get("servoGlisiera");
        servoCarusel=(CRServo) hardwareMap.get("servoCarusel");
    }

    public void move_forward(long milisecunde){
        try {
            frontRightMotor.setPower(0.5);
            frontLeftMotor.setPower(-0.5);
            backRightMotor.setPower(0.5);
            backLeftMotor.setPower(-0.5);
            Thread.sleep(milisecunde);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public void move_backwards(long milisecunde){
        try{
            frontRightMotor.setPower(-0.5);
            frontLeftMotor.setPower(0.5);
            backRightMotor.setPower(-0.5);
            backLeftMotor.setPower(0.5);
            Thread.sleep(milisecunde);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public void move_right(long milisecunde){
        try{
            frontRightMotor.setPower(-0.5);
            frontLeftMotor.setPower(-0.5);
            backRightMotor.setPower(0.5);
            backLeftMotor.setPower(0.5);
            Thread.sleep(milisecunde);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public void move_left(long milisecunde)
    {
        try {
            frontRightMotor.setPower(0.5);
            frontLeftMotor.setPower(0.5);
            backRightMotor.setPower(-0.5);
            backLeftMotor.setPower(-0.5);
            Thread.sleep(milisecunde);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
     public void move_carusel(long milisecunde){
            try{
                servoCarusel.setPower(-1);
                Thread.sleep(milisecunde);
            }
            catch (Exception e){
                System.out.println(e);
            }
    }

    public void ridicare_glisiera(long milisecunde) {
           try {
               servoGlisiera.setPower(-0.99);
               Thread.sleep(milisecunde);
           }
           catch (Exception e){
               System.out.println(e);
           }
        }


    public void coborare_glisiera(long milisecunde) {
        try {
            servoGlisiera.setPower(0.99);
            Thread.sleep(milisecunde);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public void throw_cube() {
            servoSlider.setPosition(0.9);
    }

    public void back_cube(){
            servoSlider.setPosition(-0.2);
    }

    public void stop_move(){
        frontRightMotor.setPower(0);
        frontLeftMotor.setPower(0);
        backRightMotor.setPower(0);
        backLeftMotor.setPower(0);
    }

    public void rotate_clockwise(long milisecunde)
    {
        try {
            frontRightMotor.setPower(1);
            frontLeftMotor.setPower(1);
            backRightMotor.setPower(1);
            backLeftMotor.setPower(1);
            Thread.sleep(milisecunde);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void runOpMode() throws InterruptedException
    {
        assignComponents();
        waitForStart();
        move_forward(50);
        move_left(1550);
        move_backwards(5);
        stop_move();
        move_carusel(8000);
        rotate_clockwise(200);
        move_left(300);
        move_forward(200);
        rotate_clockwise(500);
        move_backwards(200);
        ridicare_glisiera(400);
        throw_cube();
        back_cube();
        move_left(200);
        move_backwards(2000);



    }
}
