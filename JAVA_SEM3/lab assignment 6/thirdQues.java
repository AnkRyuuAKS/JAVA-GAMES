class InvalidEntryException extends Exception {
    private String details;

    public InvalidEntryException(String details) {
        super(details);
        this.details = details;
    }

    @Override
    public String getMessage() {
        return details;
    }

    @Override
    public String toString() {
        return "InvalidEntryException: " + details;
    }
}

public class thirdQues {

    public static void main(String[] args) {
        try {
            throw new InvalidEntryException("Entry value is not valid");
        } catch (InvalidEntryException e) {
            System.out.println(e.getMessage());
            System.out.println(e);
        }
    }
}
