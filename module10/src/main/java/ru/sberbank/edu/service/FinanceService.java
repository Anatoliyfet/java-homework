package ru.sberbank.edu.service;

import org.springframework.stereotype.Service;
import ru.sberbank.edu.entity.Finance;

@Service
public class FinanceService {
    private Integer Count;

    public Integer getCount() {
        return this.Count;
    }

    public void setCount(Finance finance ){
        this.Count = finance.getSum() * finance.getPercentage() * finance.getYears();
    }

}
