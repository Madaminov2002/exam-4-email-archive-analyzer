public class Email {
    private String time;
    private String user;
    private String receiver;
    private String massage;

    public Email(String time, String user, String receiver, String massage) {
        this.time = time;
        this.user = user;
        this.receiver = receiver;
        this.massage = massage;
    }

    public String getTime() {
        return time;
    }

    public String getUser() {
        return user;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getMassage() {
        return massage;
    }

    @Override
    public String toString() {
        return "Email{" +
                "time='" + time + '\'' +
                ", user='" + user + '\'' +
                ", receiver='" + receiver + '\'' +
                ", massage='" + massage + '\'' +
                '}';
    }
}
