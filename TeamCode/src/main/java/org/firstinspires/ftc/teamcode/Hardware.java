package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Hardware {
    public DcMotor frontRightMotor = null;
    public DcMotor frontLeftMotor = null;
    public DcMotor backRightMotor = null;
    public DcMotor backLeftMotor = null;
    public DcMotor wheelMotor = null;
    public DcMotor caruselMotor = null;

    public Servo servoSlider = null;
    public Servo servoGlisiera = null;
    //public Servo servoCarusel = null;
    HardwareMap hardwareMap = null;

    public ElapsedTime Runtime = new ElapsedTime();
    public Hardware(HardwareMap hwMap)
    {
        initialize(hwMap);
    }
    private void initialize(HardwareMap hwMap)
    {
        hardwareMap= hwMap;
        //motors
        frontRightMotor=hardwareMap.get(DcMotor.class, "frontRightMotor");
        frontLeftMotor=hardwareMap.get(DcMotor.class, "frontLeftMotor");
        backRightMotor=hardwareMap.get(DcMotor.class, "backRightMotor");
        backLeftMotor=hardwareMap.get(DcMotor.class, "backLeftMotor");
        wheelMotor=hardwareMap.get(DcMotor.class,"wheelMotor");
        caruselMotor=hardwareMap.get(DcMotor.class,"caruselMotor");
        //servos
        servoSlider=hardwareMap.get(Servo.class,"servoSlider");
        servoGlisiera=hardwareMap.get(Servo.class,"servoglisiera");



        //setup motor direction
        frontRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        backLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        wheelMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        caruselMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        //set motor mode
        frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        wheelMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        caruselMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        frontRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        wheelMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        caruselMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        //set zero power behaviour
        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        wheelMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        caruselMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        //set motors to no power
        frontRightMotor.setPower(0);
        frontLeftMotor.setPower(0);
        backRightMotor.setPower(0);
        backLeftMotor.setPower(0);
        wheelMotor.setPower(0);
        caruselMotor.setPower(0);

    }



}
