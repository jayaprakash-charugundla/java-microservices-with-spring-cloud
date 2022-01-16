package com.jc.ps;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TollStation {
    private String stationId;
    private Float mileMaker;
    private Integer stallCount;
}
