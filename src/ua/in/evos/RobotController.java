package ua.in.evos;


public class RobotController {

    public static void main(String[] args) {

        RobotConfig robotConfig = new RobotConfig();
        robotConfig.setRobotId(150);
        robotConfig.setServerIp("62.80.183.154");
        robotConfig.setServerPort(7880);
        robotConfig.setStartPosition(0);
        robotConfig.setPlatformLength(5);
        robotConfig.setFirstParameterName("RobotID");
        robotConfig.setSecondParameterName("Command");
        robotConfig.setThirdParameterName("PawIndex");

        RoboDog roboDog = new RoboDog(robotConfig);

        roboDog.init("Init");

        while ( roboDog.getPositionOnPlatform()<robotConfig.getPlatformLength()) {
           roboDog.stepOneMeterForward();
        }
        System.out.println("\n\r"+"I am on the end of the platform"+"\n\r"+"I am going back"+"\n\r");

        while (roboDog.getPositionOnPlatform()>robotConfig.getStartPosition()){
            roboDog.stepOneMeterBackward();
        }
        System.out.println("\n\r"+"I am back on start position");
    }
}
