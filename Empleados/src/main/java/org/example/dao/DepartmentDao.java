package org.example.dao;

import org.example.idao.iDepartmentDao;
import org.example.models.Department;
import org.example.utils.DatabaseConnection;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DepartmentDao implements iDepartmentDao {


    @Override
    public Department getDepartment(String dept_no) {
        String query = "SELECT * FROM departments WHERE dept_no = ?";
        boolean check = false;
        Department department = null;

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, dept_no);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                department = new Department("12a3", "Ventas");
                department.setDept_no(rs.getString("dept_no"));
                department.setDept_name(rs.getString("dept_name"));

            }

            rs.close();
        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
        }

        return department;
    }



    @Override
    public Set<Department> listaDepartamentos() {
         String query
                = "select * from departments";
        PreparedStatement ps = null;
        boolean check = false;
        List<Department> list = new ArrayList<>();
        try {
            Connection con = DatabaseConnection.getConnection();
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                check = true;
                Department department = new Department("12a3", "Ventas");
                department.setDept_no(rs.getString("dept_no"));
                department.setDept_name(rs.getString("dept_name"));
                list.add(department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (check == true) {
            return (Set<Department>) list;
        } else
            return null;
    }

}
