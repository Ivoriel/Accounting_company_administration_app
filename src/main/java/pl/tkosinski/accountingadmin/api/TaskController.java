package pl.tkosinski.accountingadmin.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.tkosinski.accountingadmin.common.dto.IdRequest;
import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.domain.task.TaskFacade;
import pl.tkosinski.accountingadmin.domain.task.dto.TaskAssignmentDto;
import pl.tkosinski.accountingadmin.domain.task.dto.TaskDto;
import pl.tkosinski.accountingadmin.domain.user.dto.UserIdDto;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
class TaskController extends BaseController{

    private final TaskFacade facade;

    @PostMapping("/save")
    public void save(@RequestBody TaskDto dto) {
        facade.save(dto);
    }

    @GetMapping("/{id}/get")
    public TaskDto get(@PathVariable Id id) {
        return facade.get(id);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody IdRequest request) {
        validateAdminOrEmployee(request.getUserId());

        facade.delete(request.getId());
    }

    @GetMapping("/generate")
    public TaskDto generate(@RequestBody UserIdDto request) {
        validateAdminOrEmployee(request);

        return facade.generate();
    }

    @GetMapping("/generate-and-save")
    public TaskDto generateAndSave() {
        return facade.generateAndSave();
    }

    @PostMapping("/assign")
    public void assign(@RequestBody TaskAssignmentDto dto) {
        validateAdminOrEmployee(dto.userDto());

        facade.assignTask(dto);
    }

    @PostMapping("/begin")
    public void begin(@RequestBody IdRequest request) {
        validateEmployee(request.getUserId());

        facade.beginTask(request.getId());
    }

    @PostMapping("/finish")
    public void finish(@RequestBody IdRequest request) {
        validateAdminOrEmployee(request.getUserId());

        facade.finishTask(request.getId());
    }
}
