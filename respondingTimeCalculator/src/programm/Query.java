package programm;


public class Query {
    private Service service;
    private Question question;
    private ResponseType responseType;
    private DateRange dateRange;

    public Query(String[] arr) {
        this.service = new Service(arr[1]);
        this.question = new Question(arr[2]);
        this.responseType = new ResponseType(arr[3]);
        this.dateRange = new DateRange(arr[4]);
    }

    public boolean matchToTimeLine(TimelineInfo timelineInfo) {
        if (service.compareServices(timelineInfo.getService()) && question.compareQuestions(timelineInfo.getQuestion())
                && responseType.compareResponseTypes(timelineInfo.getResponseType()) && dateRange.checkIfDateInRange(timelineInfo.getDate())) {
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
        return "Query{" +
                "service=" + service +
                ", question=" + question +
                ", responseType=" + responseType +
                ", dateRange=" + dateRange +
                '}';
    }
}
