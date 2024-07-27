package com.example.Empregados;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/empregados")
public class EmpregadoController {

    private final EmpregadoService empregadoService;

    @Autowired
    public EmpregadoController(EmpregadoService empregadoService) {
        this.empregadoService = empregadoService;
    }

    @GetMapping
    public List<Empregado> getEmpregados() {
        return empregadoService.getPersons();
    }
    @PostMapping
    public void addEmpregado(@RequestBody Empregado empregado) {
        empregadoService.addNewEmpregado(empregado);
    }
    @DeleteMapping(path = "{empregadoId}")
    public void deleteStudent(@PathVariable("empregadoId") Long studentID) {
        empregadoService.deleteEmpregado(studentID);
    }

    @PutMapping(path = "{empregadoId}")
    public void updateStudent(
            @PathVariable("empregadoId") Long studentId,
            @RequestBody (required = false) String name,
            @RequestParam (required = false) String email){
        empregadoService.updateEmpregado(studentId,name,email);
    }
}
