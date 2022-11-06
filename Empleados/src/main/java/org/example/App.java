package org.example;

import org.example.dao.DepartmentDao;
import org.example.dao.EmployeeDao;
import org.example.models.Department;
import org.example.models.Employee;
import org.example.models.Salary;

import java.util.List;


public class App 
{
    public static void main( String[] args )
    {


        //Probamos el metodo getDepartment tomando la id de un departamento
        Department dep = new DepartmentDao().getDepartment("1a");
        System.out.println(dep);

        //Probamos el metodo ListaDepartamentos mete todos los valores en una lista y los imprime.
        List<Department> depRespuesta = (List<Department>) new DepartmentDao().listaDepartamentos();
        depRespuesta.forEach(System.out::println);


        Employee emp = new EmployeeDao().getEmployee(1);
        System.out.println(emp);

        List<Employee> empRespuesta = (List<Employee>) new EmployeeDao().listaEmpleadosDepartamento("d005");
        empRespuesta.forEach(System.out::println);

        Employee emp1 = new EmployeeDao().managerDepartamento("1a");
        System.out.println(emp1);

        Boolean emp2 = new EmployeeDao().isManager("1a",2);
        System.out.println(emp2);

        Employee emp3 = (Employee) new EmployeeDao().getEmployeesByTitle("Staff");
        System.out.println(emp3);

        Employee emp4 = new Employee(2, "1996-08-03", "Pepe", "Hernan", "M", "2015-05-20");

        Salary salary = new Salary().getSalary(2);
        System.out.println(salary);

        Salary salario2 = new Salary(2, 1500, "2010-05-20", "2015-05-20");

    }
}
