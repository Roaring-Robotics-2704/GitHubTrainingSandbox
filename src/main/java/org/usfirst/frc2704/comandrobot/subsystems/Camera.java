package org.usfirst.frc2704.comandrobot.subsystems;



// Made a camera change.
public class Camera extends Subsystem {
    private CameraServer server;
    private UsbCamera camera;

    public void initDefaultCommand() {}

    public Camera() {
            
            server = CameraServer.getInstance();
            enableStreaming();
    }
    public void enableStreaming() {
        camera = server.startAutomaticCapture();
        camera.setResolution(640, 480);
    }

}
