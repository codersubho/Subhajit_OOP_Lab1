package com.Gl.lab.interfaces;

import com.Gl.lab.model.Employee;

public interface Icredentials {
     public void generateEmail(Employee emp, String department);
     public void generatePassword(Employee emp);
     public void showCredentials(Employee emp);
}
