package ua.in.evos;


public interface Movable {
    public static final String STEP_FORWARD_COMMAND = "StepForward";
    public static final String STEP_BACKWARD_COMMAND = "StepBackward";
    void stepForward(int index);
    void stepBackward(int index);

}
