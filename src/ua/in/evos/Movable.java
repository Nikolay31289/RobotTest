package ua.in.evos;


public interface Movable {
    String STEP_FORWARD_COMMAND = "StepForward";
    String STEP_BACKWARD_COMMAND = "StepBackward";
    void stepForward(int index);
    void stepBackward(int index);

}
