package pl.tkosinski.accountingadmin.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.tkosinski.accountingadmin.domain.company.CompanyFacade;
import pl.tkosinski.accountingadmin.domain.company.dto.CompanyDto;

@Controller
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyFacade facade;

    @PostMapping("/save")
    public void save(@RequestParam CompanyDto dto) {
        facade.save(dto);
    }

    @GetMapping("/{id}/get")
    public CompanyDto get(@PathVariable Long id) {
        return facade.get(id);
    }

    @DeleteMapping("{/id}/delete")
    public void delete(@PathVariable Long id) {
        facade.delete(id);
    }

    @GetMapping("/generate")
    public CompanyDto generate() {
        return facade.generate();
    }
}
