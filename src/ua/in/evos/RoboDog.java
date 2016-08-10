package ua.in.evos;

import java.util.ArrayList;
import java.util.List;

public class RoboDog {

    private List<Paw> paws = new ArrayList<>();
    private int positionOnPlatform;
    private RobotConfig robotConfig;
    private ServerConnection serverConnection;

    public RoboDog(RobotConfig robotConfig) {
        this.robotConfig=robotConfig;
        paws.add(new Paw(0,robotConfig));
        paws.add(new Paw(2,robotConfig));
        paws.add(new Paw(1,robotConfig));
        paws.add(new Paw(3,robotConfig));
    }

    public int getPositionOnPlatform() {
        return positionOnPlatform;
    }

    public void setPositionOnPlatform(int positionOnPlatform) {
        this.positionOnPlatform = positionOnPlatform;
    }

    public void init(String command) {
        serverConnection = new ServerConnection(robotConfig);
        String request = serverConnection.createRequest(command);
        serverConnection.doGetRequest(request);
        setPositionOnPlatform(robotConfig.getStartPosition());
    }

    public void stepOneMeterForward() {
        for (Paw paw : paws) {
            paw.stepForward(paw.getIndex());
        }
        positionOnPlatform++;
    }

    public void stepOneMeterBackward() {
        for (Paw paw : paws) {
            paw.stepBackward(paw.getIndex());
        }
        positionOnPlatform--;
    }

}
