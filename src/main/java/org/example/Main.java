package org.example;
import org.example.entity.Employee;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        List<Employee> employees = new LinkedList<>();
        employees.add(new Employee(1,"Recep","Kılıç"));
        employees.add(new Employee(2,"Ahmet","Furkan"));
        employees.add(new Employee(3,"Beyza","Nur"));
        employees.add(new Employee(3,"Beyza","Nur"));
        employees.add(new Employee(4,"Hacer","Arıcan"));
        employees.add(new Employee(5,"Mehmet","Reşit"));
        employees.add(new Employee(5,"Mehmet","Reşit"));
        employees.add(new Employee(6,"Recep","Kılıç"));

        List<Employee> duplicates = findDuplicates(employees);

        System.out.println("Tekrar eden çalışanlar:");
        for (Employee e : duplicates) {
            System.out.println(e.getId() + " - " + e.getFirstName() + " " + e.getLastName());
        }

        Map<Integer, Employee> uniqueMap = findUniques(employees);
        System.out.println("Uniques map:");

        for (Map.Entry<Integer, Employee> entry : uniqueMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        List<Employee> result = removeDuplicates(employees);
        System.out.println("Sadece bir kez geçen çalışanlar:");
        for (Employee emp : result) {
            System.out.println(emp);
        }
    }
    public static List<Employee> findDuplicates(List<Employee> list) {
        List<Employee> duplicates = new LinkedList<>();

        for (int i = 0; i < list.size(); i++) {
            Employee current = list.get(i);
            if (current == null) continue;  // null ise atla

            int count = 0;

            for (int j = 0; j < list.size(); j++) {
                Employee other = list.get(j);
                if (current.equals(other)) {
                    count++;
                }
            }

            if (count > 1 && !duplicates.contains(current)) {
                duplicates.add(current);
            }
        }

        return duplicates;
    }


        public static Map<Integer, Employee> findUniques(List<Employee> list) {
            Map<Integer, Employee> result = new HashMap<>();

            List<Employee> duplicates = findDuplicates(list);


            for (Employee emp : duplicates) {
                result.put(emp.getId(), emp);
            }


            for (Employee emp : list) {
                if (emp != null && !duplicates.contains(emp)) {
                    result.put(emp.getId(), emp);
                }
            }

            return result;
        }

    public static List<Employee> removeDuplicates(List<Employee> list) {
        List<Employee> duplicates = findDuplicates(list);
        List<Employee> result = new LinkedList<>();

        for (Employee emp : list) {
            if (emp != null && !duplicates.contains(emp) && !result.contains(emp)) {
                result.add(emp);
            }
        }

        return result;
    }
    }

