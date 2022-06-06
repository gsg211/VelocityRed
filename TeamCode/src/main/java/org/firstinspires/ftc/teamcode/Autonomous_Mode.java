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
    DcMotor caruselMotor;
    Servo servoSlider;
    CRServo servoGlisiera;


    public void assignComponents() {
        frontRightMotor= (DcMotor) hardwareMap.get("frontRightMotor");
        frontLeftMotor= (DcMotor) hardwareMap.get("frontLeftMotor");
        backLeftMotor= (DcMotor) hardwareMap.get("backLeftMotor");
        backRightMotor= (DcMotor) hardwareMap.get("backRightMotor");
        wheelMotor=(DcMotor) hardwareMap.get("wheelMotor");
        servoSlider=(Servo) hardwareMap.get("servoSlider");
        servoGlisiera=(CRServo) hardwareMap.get("servoGlisiera");
       caruselMotor=(DcMotor) hardwareMap.get("caruselMotor");
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
                caruselMotor.setPower(-0.6);
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

    public void stop_carusel(){
        caruselMotor.setPower(0);
    }
    public void throw_cube(long milisecunde) {
        try {
            servoSlider.setPosition(-1);
            Thread.sleep(milisecunde);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public void back_cube(){
            servoSlider.setPosition(1);
    }

    public void stop_move(){
        frontRightMotor.setPower(0);
        frontLeftMotor.setPower(0);
        backRightMotor.setPower(0);
        backLeftMotor.setPower(0);
    }

    public void rotate_counter_clockwise(long milisecunde)
    {
        try {
            frontRightMotor.setPower(0.5);
            frontLeftMotor.setPower(0.5);
            backRightMotor.setPower(0.5);
            backLeftMotor.setPower(0.5);
            Thread.sleep(milisecunde);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void stop_glisiera()
    {
        servoGlisiera.setPower(0);
    }

    public void rotate_clockwise(long milisecunde)
    {
        try {
            frontRightMotor.setPower(-0.5);
            frontLeftMotor.setPower(-0.5);
            backRightMotor.setPower(-0.5);
            backLeftMotor.setPower(-0.5);
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
        move_forward(80);
        move_left(1320);
        //move_backwards(40);
        stop_move();
        move_carusel(2000);
        move_forward(300);
        rotate_counter_clockwise(530);
        stop_move();
        stop_carusel();
        move_right(200);
        stop_move();
        move_backwards(1300);
        stop_move();
        rotate_counter_clockwise(530);
        stop_move();
        move_backwards(270);
        stop_move();
        ridicare_glisiera(5500);
        stop_glisiera();
        throw_cube(800);
        back_cube();
        coborare_glisiera(600);
        move_forward(200);
        rotate_counter_clockwise(660);
        stop_move();
        //move_left(700);
        move_forward(2700);



    }
}
