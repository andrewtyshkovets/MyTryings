package programm;

import java.util.Optional;

public class TimelineInfo {
    private Date date;
    private Service service;
    private Question question;
    private ResponseType responseType;
    private Time time;


    public TimelineInfo(String[] arr) {
        this.service = new Service(arr[1]);
        this.question = new Question(arr[2]);
        this.responseType = new ResponseType(arr[3]);
        this.date = new Date(arr[4]);
        this.time = new Time(arr[5]);
    }

    public Date getDate() {
        return date;
    }

    public Service getService() {
        return service;
    }

    public Question getQuestion() {
        return question;
    }

    public ResponseType getResponseType() {
        return responseType;
    }

    public Time getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "TimelineInfo{" +
                "date=" + date +
                ", service=" + service +
                ", question=" + question +
                ", responseType=" + responseType +
                ", time=" + time +
                '}';
    }
}
