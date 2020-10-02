package programm;

import java.util.Optional;

public class DateRange {
    private Date from;
    private Optional<Date> to;

    public DateRange(String str) {
        String[] arr = str.split("-");
        if (arr.length == 2) {
            this.from = new Date(arr[0]);
            this.to = Optional.of(new Date(arr[1]));
        } else {
            this.from = new Date(arr[0]);
            this.to = Optional.empty();
        }
    }

    public boolean checkIfDateInRange(Date current) {
        if (!to.isEmpty()) {
            if ((from.getYear() < current.getYear()) && (current.getYear() < to.get().getYear())) {
                return true;
            }
            if (from.getYear() == current.getYear() && to.get().getYear() == current.getYear()) {
                if ((from.getMonth() < current.getMonth()) && (current.getMonth() < to.get().getMonth())) {
                    return true;
                }
                if (from.getMonth() == current.getMonth() && to.get().getMonth()==current.getMonth()){
                    if(from.getDay()<=current.getDay() && current.getDay()<=to.get().getDay()){
                        return true;
                    } else {
                        return false;
                    }
                }
                if (from.getMonth() == current.getMonth() && to.get().getMonth()>current.getMonth()){
                    if(from.getDay()<=current.getDay()){
                        return true;
                    } else {
                        return false;
                    }
                }
                if (to.get().getMonth()==current.getMonth() && current.getMonth()>from.getMonth()){
                    if(to.get().getDay()>=current.getDay()){
                        return true;
                    } else {
                        return false;
                    }
                }
            }
            if (from.getYear() == current.getYear() && to.get().getYear()>current.getYear()){
                if(from.getMonth()<current.getMonth()){
                    return true;
                }
                if(from.getMonth()==current.getMonth()){
                    if(from.getDay()<=current.getDay()){
                        return true;
                    } else {
                        return false;
                    }
                }
                if(from.getMonth()>current.getMonth()){
                    return false;
                }
            }
            if(to.get().getYear()==current.getYear() && from.getYear()<current.getYear()){
                if(to.get().getMonth()>current.getMonth()){
                    return true;
                }
                if(to.get().getMonth()==current.getMonth()){
                    if(to.get().getDay()>=current.getDay()){
                        return true;
                    } else {
                        return false;
                    }
                }
                if(to.get().getMonth()<current.getMonth()){
                    return false;
                }
            }
            return false;
        } else {
            if(from.getYear()==current.getYear() && from.getMonth()==current.getMonth() && from.getDay()==current.getDay()){
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public String toString() {
        return "DateRange{" +
                "from=" + from +
                ", to=" + to +
                '}';
    }
}
