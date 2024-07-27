package com.example.Empregados;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmpregadoService {

    private final EmpregadoRepository empregadoRepository;

    @Autowired
    public EmpregadoService(EmpregadoRepository empregadoRepository) {
        this.empregadoRepository = empregadoRepository;
    }


    public List<Empregado> getPersons() {
        return empregadoRepository.findAll();
    }

    public void addNewEmpregado(Empregado empregado) {
        Optional<Empregado> empregadoByemail = empregadoRepository.findByEmail(empregado.getEmail());
        if (empregadoByemail.isPresent()) {
            throw  new IllegalStateException("Student already exists");
        }
        empregadoRepository.save(empregado);
    }
    public void deleteEmpregado(Long empregadoID) {
        boolean exists = empregadoRepository.existsById(empregadoID);
        System.out.println("exists: " + exists);
        if (!exists) {
            throw  new IllegalStateException("Student with id " + empregadoID + " does not exist");
        }
        empregadoRepository.deleteById(empregadoID);
    }

    @Transactional
    public void updateEmpregado(Long studentId,
                                String name,
                                String email) {
        Empregado empregado = empregadoRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "Student with id: "+ studentId + " does not exist"));
        if(name != null &&
                name.length() > 3 &&
                !Objects.equals(empregado.getNome(), name)) {
            empregado.setNome(name);
        }
        if(email != null &&
                email.length() > 5 &&
                !Objects.equals(empregado.getEmail(), email)) {
            Optional<Empregado> studentOptional = empregadoRepository.
                    findByEmail(email);
            if (studentOptional.isPresent()) {
                throw  new IllegalStateException("This email taken");
            }
            empregado.setEmail(email);
        }
    }
}
