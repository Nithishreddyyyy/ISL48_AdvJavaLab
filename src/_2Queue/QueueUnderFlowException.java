package LabPrac._2Queue;

public class QueueUnderFlowException extends RuntimeException {
    public QueueUnderFlowException(String message) {
        super(message);
    }
}
