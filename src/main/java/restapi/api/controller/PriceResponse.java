package restapi.api.controller;

import lombok.Getter;
import lombok.Setter;

public class PriceResponse {

    @Getter
    @Setter
    private double distance;

    @Getter
    @Setter
    private double price;

    @Getter
    @Setter
    private String type;

}
