package com.jc.ps;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TollRate {
    private Integer stationId;
    private Float currentRate;
    private String timestamp;
}
