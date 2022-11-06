package org.example.idao;

import org.example.models.Department;

import java.util.Set;

public interface iDepartmentDao {
    public Department getDepartment(String codigoDepartamento);
    public Set<Department> listaDepartamentos();

}
