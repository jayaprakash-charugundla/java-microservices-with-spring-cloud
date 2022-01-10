package com.jc.ps;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class FastPassController {

    List<FastPassCustomer> customers;

    public FastPassController() {

        customers = new ArrayList<FastPassCustomer>();
        customers.add(new FastPassCustomer("800", "Omar Zidan", "555-123-4567", 19.50f));
        customers.add(new FastPassCustomer("801", "Maggie Bell", "555-321-7654", 11.25f));
        customers.add(new FastPassCustomer("802", "Tiffany Wallace", "555-987-6543", 35.05f));

    }
    
    @RequestMapping(path="/fastpass", params={"fastpassid"})
    public FastPassCustomer getFastPassById(@RequestParam String fastpassid) {
        log.info("Fast pass retrieved for: {}", fastpassid);
        return customers.stream().filter(customer -> fastpassid.equals(customer.getFastPassId())).findAny().orElse(new FastPassCustomer());
    }
}
