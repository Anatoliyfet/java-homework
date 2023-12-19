package ru.sberbank.edu.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.sberbank.edu.entity.Finance;
import ru.sberbank.edu.service.FinanceService;

@Controller
public class FinanceController {
    public final FinanceService financeService;

    public FinanceController(FinanceService financeService) {
        this.financeService = financeService;
    }

    @GetMapping("/finance")
    public String finance(Model model) {
        Finance finance = new Finance(50_000,2,3);
        model.addAttribute(finance);
        return "finance/finance-edit";
    }

    @PostMapping("/finance")
    public String edit(@Valid @ModelAttribute("finance") Finance finance, BindingResult result) {
        if (result.hasErrors()) {
            return "finance/finance-edit";
        }

        financeService.setCount(finance);
        return "redirect:/finance/finance-count";
    }
    @GetMapping("finance/finance-count")
    public String getMappingFinanceCount(Model model) {
//        Finance finance = new Finance(1,2,3);
        financeService.getCount();
        model.addAttribute("count", financeService.getCount());
        return "finance/finance-count";
    }
}
