package org.example.dao;

import org.example.idao.iSalaryDao;
import org.example.models.Employee;
import org.example.models.Salary;
import org.example.utils.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class SalaryDao implements iSalaryDao {




    @Override
    public Salary getSalario(int codigoEmpleado, Date fecha) {
        String query = "SELECT * FROM salaries WHERE emp_no = ? and to_date=?";
        boolean check = false;
        Salary salary = null;

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, codigoEmpleado);
            ps.setDate(2, (java.sql.Date) fecha);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                salary.setSalary(rs.getInt("salary"));

            }

            rs.close();
        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
        }


        return salary;

    }

    @Override
    public Boolean nuevoSalario(Employee newEmployee, Integer salario) {
        final String query = "INSERT INTO salaries(emp_no,salary,from_date ,to_date) values(?, ?, ?,?)";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, Salary.getEmp_no());
            ps.setString(2, Salary.getSalary());
            ps.setString(3, Salary.getFrom_date());
            ps.setString(4, Salary.getTo_date());

            ps.executeUpdate();
        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
        }

        return true;
    }
}
