package ru.sberbank.edu.entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Finance {
    @NotNull(message = "is required")
    @Min(value = 50_000, message = "Минимальная сумма на момент открытия вклада 50 000 рублей")
    private Integer sum;
    @NotNull(message = "is required")
//    @Size(min = 3, message = "cannot be less 3")
    private Integer percentage;
    @NotNull(message = "is required")
//    @Min(value = 4, message = "age must be greater 4")
    private Integer years;

    public Finance(Integer sum, Integer percentage, Integer years) {
        this.sum = sum;
        this.percentage = percentage;
        this.years = years;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }
}
