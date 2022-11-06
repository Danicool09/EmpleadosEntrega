package org.example.idao;

import org.example.models.Employee;
import org.example.models.Salary;

import java.util.Date;

public interface iSalaryDao {
    public Salary getSalario(int codigoEmpleado, Date fecha);
    public Boolean nuevoSalario(Employee newEmployee, Integer salario);
}
