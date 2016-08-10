package ua.in.evos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class ServerConnection {

    private String result;
    private StringBuilder response;
    private RobotConfig robotConfig;

    public ServerConnection(RobotConfig robotConfig) {
        this.robotConfig = robotConfig;
    }

    public String createRequest(String command, int pawIndex) {

        int serverPort = robotConfig.getServerPort();
        int robotId = robotConfig.getRobotId();
        String serverIp = robotConfig.getServerIp();
        String firstParameterName = robotConfig.getFirstParameterName();
        String secondParameterName = robotConfig.getSecondParameterName();
        String thirdParameter = robotConfig.getThirdParameterName();

        String request = String.format("http://%s:%d/?%s=%d&%s=%s&%s=%d", serverIp, serverPort, firstParameterName,
                robotId, secondParameterName, command, thirdParameter, pawIndex);

        return request;
    }

    public String createRequest(String command) {

        String serverIp = robotConfig.getServerIp();
        int serverPort = robotConfig.getServerPort();
        String firstParameterName = robotConfig.getFirstParameterName();
        int robotId = robotConfig.getRobotId();
        String secondParameterName = robotConfig.getSecondParameterName();


        String request = String.format("http://%s:%d/?%s=%d&%s=%s", serverIp, serverPort, firstParameterName,
                robotId, secondParameterName, command);

        return request;
    }

    public void doGetRequest(String request) {
        try {
            URL url = new URL(request);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream is = connection.getInputStream();
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(is, "windows-1251"));
                response = new StringBuilder();
                while ((result = reader.readLine()) != null) {
                    response.append(result);
                }
                is.close();
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(response);
    }
}
