package org.example.idao;

import org.example.models.Employee;

import java.util.Date;
import java.util.Set;

public interface iEmployeeDao {
    public Employee getEmployee(int emp_no);
    public Set<Employee> listaEmpleadosDepartamento(String codigoDepartamento);
    public Employee managerDepartamento(String codigoDepartamento);
    public Boolean isManager(String codigoDepartamento, int codigoEmpleado);
    public Set<Employee> getEmployeesByTitle(String title);
    public Boolean nuevoEmpleado(Employee newEmployee, String noDept, Date inicio, Integer salario);
    public Boolean eliminarEmpleado(Employee newEmployee);
}
