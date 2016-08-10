package ua.in.evos;


public class RobotConfig {

    private int robotId;
    private String serverIp;
    private int serverPort;
    private int startPosition;
    private int platformLength;
    private String firstParameterName;
    private String secondParameterName;
    private String thirdParameterName;

    public String getFirstParameterName() {

        return firstParameterName;
    }

    public void setFirstParameterName(String firstParameterName) {
        this.firstParameterName = firstParameterName;
    }

    public String getSecondParameterName() {
        return secondParameterName;
    }

    public void setSecondParameterName(String secondParameterName) {
        this.secondParameterName = secondParameterName;
    }

    public String getThirdParameterName() {
        return thirdParameterName;
    }

    public void setThirdParameterName(String thirdParameterName) {
        this.thirdParameterName = thirdParameterName;
    }

    public RobotConfig(int robotId) {
        this.robotId = robotId;
    }

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    public int getServerPort() {
        return serverPort;
    }

    public void setServerPort(int serverPort) {
        this.serverPort = serverPort;
    }

    public int getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(int startPosition) {
        this.startPosition = startPosition;
    }

    public int getPlatformLength() {
        return platformLength;
    }

    public void setPlatformLength(int platformLength) {
        this.platformLength = platformLength;
    }

    public int getRobotId() {
        return robotId;
    }
}
