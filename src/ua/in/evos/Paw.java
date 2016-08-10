package ua.in.evos;

public class Paw implements Movable {

    private int index;
    private RobotConfig robotConfig;
    private ServerConnection serverConnection;

    public Paw(int index, RobotConfig robotConfig) {
        this.index = index;
        this.robotConfig = robotConfig;
    }

    public int getIndex() {
        return index;
    }
    @Override
    public void stepForward(int pawIndex) {
            serverConnection = new ServerConnection(robotConfig);
            String request = serverConnection.createRequest(STEP_FORWARD_COMMAND, pawIndex);
            serverConnection.doGetRequest(request);
    }
    @Override
    public void stepBackward(int pawIndex) {
            serverConnection = new ServerConnection(robotConfig);
            String request = serverConnection.createRequest(STEP_BACKWARD_COMMAND, pawIndex);
            serverConnection.doGetRequest(request);
    }
}
