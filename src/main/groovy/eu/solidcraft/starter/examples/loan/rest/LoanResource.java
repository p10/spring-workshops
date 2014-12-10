package eu.solidcraft.starter.examples.loan.rest;

import eu.solidcraft.starter.examples.loan.LoanService;
import eu.solidcraft.starter.examples.loan.dto.LoanResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanResource {

    private LoanService loanService;

    @Autowired
    public LoanResource(LoanService loanService) {
        this.loanService = loanService;
    }

    @ResponseBody
    @RequestMapping("/{username}")
    public List<LoanResponse> getLoans(@PathVariable String username) {
        return loanService.getLoans(username);
    }
}
