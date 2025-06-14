package pl.tkosinski.accountingadmin.domain.task;

import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.common.model.Text;
import pl.tkosinski.accountingadmin.domain.company.CompanyFacade;
import pl.tkosinski.accountingadmin.domain.task.dto.TaskDto;
import pl.tkosinski.accountingadmin.domain.user.UserFacade;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

public class TaskGenerator {

    public TaskDto generate(UserFacade userFacade, CompanyFacade companyFacade) {
        return generate(userFacade.generate().id(), companyFacade.generate().id());
    }

    public TaskDto generate(UserFacade userFacade, CompanyFacade companyFacade, int min, int max) {
        return generate(userFacade.generate().id(), companyFacade.generate().id(), min, max);
    }

    public TaskDto generate(Id performerId, Id companyId) {
        return generate(performerId, companyId, 60, 240);
    }

    public TaskDto generate(Id performerId, Id companyId, int min, int max) {
        var start = generateRandomInt(min, max);

        return new TaskDto(
                Id.generate(),
                performerId,
                companyId,
                LocalDateTime.now().minusMinutes(start),
                LocalDateTime.now().minusMinutes(start+60L),
                Text.ofValue("Lorem ipsum dolor sit amet"),
                Text.ofValue("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed at."));
    }

    private int generateRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max +1);
    }
}