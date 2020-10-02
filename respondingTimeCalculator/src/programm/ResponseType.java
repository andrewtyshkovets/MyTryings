package programm;

public class ResponseType {
    private boolean first = false;

    public ResponseType(String str) {
        if (str.equalsIgnoreCase("P")) {
            this.first = true;
        }
    }

    public boolean isFirst() {
        return first;
    }

    public boolean compareResponseTypes(ResponseType timeLineResponseType){
        if(timeLineResponseType.isFirst()==this.first){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "ResponseType{" +
                "first=" + first +
                '}';
    }
}
