package prom.it.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
public class VocabularyController {

    @Autowired
    private DepartmentServiceImpl departmentService;

    /**
     * Returns list of all departments
     *
     * @return List<Department>
     */
    @GetMapping
    public List<Department> getDepartments() {
        return departmentService.getAll();
    }

    /**
     * Add new department
     *
     * @param department new object
     * @return Department
     */
    @PostMapping
    public Department addDepartment(@RequestBody Department department) {
        return departmentService.addDepartment(department);
    }

    /**
     * Returns specified department
     *
     * @param id unique identifier of department
     * @return Department
     */
    @GetMapping(params = "id")
    public Department getDepartment(@RequestParam String id) {
        return departmentService.getById(Long.valueOf(id));
    }

    /**
     * Update specified department
     *
     * @param department object with edited values
     * @return
     */
    @PatchMapping
    public Department updateDepartment(@RequestBody Department department) {
        return departmentService.updateDepartment(department);
    }

    /**
     * Delete specified department
     *
     * @param id unique identifier of department
     * @return true in case of success, otherwise false
     */
    @DeleteMapping
    public Boolean deleteDepartment(@RequestParam String id) {
        return departmentService.deleteDepartment(Long.valueOf(id));
    }
}
