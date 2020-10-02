package programm;

import java.util.Optional;

public class Service {
    private Optional<Integer> serviceId;
    private Optional<Integer> variationId;
    private boolean matchAll = false;

    public Service(String str) {
        if (str.equals("*")) {
            this.serviceId = Optional.empty();
            this.variationId = Optional.empty();
            this.matchAll = true;
        } else {
            String[] arr = str.split("[.]");
            if (arr.length == 2) {
                this.serviceId = Optional.of(Integer.parseInt(arr[0]));
                this.variationId = Optional.of(Integer.parseInt(arr[1]));
            } else {
                this.serviceId = Optional.of(Integer.parseInt(arr[0]));
                this.variationId = Optional.empty();
            }
        }
    }

    public Optional<Integer> getServiceId() {
        return serviceId;
    }

    public Optional<Integer> getVariationId() {
        return variationId;
    }

    public boolean isMatchAll() {
        return matchAll;
    }

    public boolean compareServices(Service timeLineService) {
        if(matchAll==true){
            return true;
        } else {
            if(timeLineService.getServiceId().equals(this.serviceId)){
                if(!this.variationId.isEmpty() && !timeLineService.getVariationId().equals(this.variationId)){
                    return false;
                }
                return true;
            }
            return false;
        }
    }

    @Override
    public String toString() {
        return "Service{" +
                "serviceId=" + serviceId +
                ", variationId=" + variationId +
                '}';
    }
}
