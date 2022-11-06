package org.example.dao;

import org.example.idao.iEmployeeDao;
import org.example.models.Department;
import org.example.models.Employee;
import org.example.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class EmployeeDao implements iEmployeeDao {


    public Employee getEmployee(int emp_no) {
        String query = "SELECT * FROM employees WHERE emp_no = ?";
        boolean check = false;
        Employee employee = null;

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, emp_no);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                employee = new Employee(2, "1964-06-02", "Pepe", "Martinez","M", "1996-02-03");
                employee.setEmp_no(rs.getInt("emp_no"));
                employee.setBirth_date(rs.getString("birth_date"));
                employee.setFirst_name(rs.getString("First_name"));
                employee.setLast_name(rs.getString("Last_name"));
                employee.setHire_date(rs.getString("Hire_date"));


            }

            rs.close();
        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
        }

        return employee;
    }

    @Override
    public Set<Employee> listaEmpleadosDepartamento(String codigoDepartamento) {
        String query
                = "select * from dept_emp d join employees e on d.emp_no=e.emp_no where d.dept_no = ?";
        PreparedStatement ps = null;
        boolean check = false;
        List<Department> list = new ArrayList<>();
        try {
            Connection con = DatabaseConnection.getConnection();
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                check = true;
                Employee employee = new Employee(2, "1964-06-02", "Pepe", "Martinez","M", "1996-02-03");
                employee.setEmp_no(rs.getInt("emp_no"));
                employee.setBirth_date(rs.getString("birth_date"));
                employee.setFirst_name(rs.getString("First_name"));
                employee.setLast_name(rs.getString("Last_name"));
                employee.setHire_date(rs.getString("Hire_date"));

                list.add(Employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (check == true) {
            return (Set<Employee>) list;
        } else
            return null;
    }


    @Override
    public Employee managerDepartamento(String codigoDepartamento) {
        String query = "SELECT * FROM employees e join dept_manager m on e.emp_no=m.emp_no WHERE dept_no = ?";
        boolean check = false;
        Employee employee = null;

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, codigoDepartamento);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                employee = new Employee(2, "1964-06-02", "Pepe", "Martinez","M", "1996-02-03");
                employee.setEmp_no(rs.getInt("emp_no"));
                employee.setBirth_date(rs.getString("birth_date"));
                employee.setFirst_name(rs.getString("First_name"));
                employee.setLast_name(rs.getString("Last_name"));
                employee.setHire_date(rs.getString("Hire_date"));


            }

            rs.close();
        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
        }

        return employee;
    }

    @Override
    public Boolean isManager(String codigoDepartamento, int codigoEmpleado) {
        String query = "SELECT * FROM employees e join dept_manager m on e.emp_no=m.emp_no WHERE dept_no = ?";
        boolean check = false;
        Employee employee = null;

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, codigoDepartamento);
            ps.setInt(2, Integer.parseInt(codigoEmpleado));
            ResultSet rs = ps.executeQuery();


            rs.close();
        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
        }

        return true;

    }

    @Override
    public Set<Employee> getEmployeesByTitle(String title) {
        String query
                = "select * from employees e join titles t on e.emp_no=t.emp_no where t.title = ?";
        PreparedStatement ps = null;
        boolean check = false;
        List<Department> list = new ArrayList<>();
        try {
            Connection con = DatabaseConnection.getConnection();
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                check = true;
                Employee employee = new Employee(2, "1964-06-02", "Pepe", "Martinez","M", "1996-02-03");
                employee.setEmp_no(rs.getInt("emp_no"));
                employee.setBirth_date(rs.getString("birth_date"));
                employee.setFirst_name(rs.getString("First_name"));
                employee.setLast_name(rs.getString("Last_name"));
                employee.setHire_date(rs.getString("Hire_date"));

                list.add(Employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (check == true) {
            return (Set<Employee>) list;
        } else
            return null;
    }


    @Override
    public Boolean nuevoEmpleado(Employee newEmployee, String noDept, Date inicio, Integer salario) {
        final String query = "INSERT INTO employees(emp_no, birth_date,first_name ,last_name, gender, hire_date) values(?, ?, ?,?, ?, ?)";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, Employee.getEmp_no());
            ps.setString(2, Employee.getBirth_date());
            ps.setString(3, Employee.getFirst_name());
            ps.setString(4, Employee.getLast_name());
            ps.setString(5, Employee.getGender());
            ps.setString(6, Employee.getHire_date());

            ps.executeUpdate();
        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
        }

        return Employee;
    }

/*
    @Override
    public Boolean eliminarEmpleado(Employee newEmployee) {
        int resultado = 0;
        final String query = "DELETE FROM doctors WHERE doctors.id = ?";

        if (getEmployee(newEmployee) != null) {
            try (Connection con = DatabaseConnection.getConnection();
                 PreparedStatement ps = con.prepareStatement(query)) {
                ps.setInt(1, newEmployee);
                resultado = ps.executeUpdate();
            } catch (SQLException sqlE) {
                sqlE.printStackTrace();
            }
        } else {
            System.out.println("No existe el doctor a eliminar");
            return false;
        }

        return resultado == 1;
    }


 */

}
