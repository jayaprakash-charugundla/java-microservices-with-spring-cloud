package com.jc.ps;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FastPassCustomer {
    private String fastPassId;
    private String customerFullName;
    private String customerPhone;
    private Float currentBalance;
}
