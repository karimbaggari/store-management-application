package ma.nemo.assignment.dto;

public class ReturnResponseDTO {
    private String message;

    public ReturnResponseDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
