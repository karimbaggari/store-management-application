package ma.nemo.assignment.dto;

public class OperationResponseDTO {
    private String message;

    public OperationResponseDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

