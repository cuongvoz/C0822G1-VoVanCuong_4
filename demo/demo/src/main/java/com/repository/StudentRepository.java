package com.repository;

import com.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository{
    private final String URL = "jdbc:mysql://localhost:3306/demo";
    private final String Username = "root";
    private final String Password = "codegym";

    private static final String SELECT_ALL = "select * from student";
    private static final String SORT = "select * from student order by point asc";
    private static final String REVERSE = "select * from student order by point desc";
    private static final String DELETE = "delete from student where id = ?";
    private static final String INSERT = "insert into student (name,age,point,gender) values (?,?,?,?)";
    private static final String UPDATE = "update student set name = ?,age = ?,point = ?,gender = ? where id = ?";
    private static final String SELECT_BY = "select * from student where name like ?";

    Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL,Username,Password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public List<Student> findAll() {
        List<Student> list = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                float point = rs.getFloat("point");
                int age = rs.getInt("age");
                boolean gender = rs.getBoolean("gender");
                Student student = new Student(id,name,gender,point,age);
                list.add(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Student> sort() {
        List<Student> list = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SORT);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                float point = rs.getFloat("point");
                int age = rs.getInt("age");
                boolean gender = rs.getBoolean("gender");
                Student student = new Student(id,name,gender,point,age);
                list.add(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Student> reverse() {
        List<Student> list = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(REVERSE);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                float point = rs.getFloat("point");
                int age = rs.getInt("age");
                boolean gender = rs.getBoolean("gender");
                Student student = new Student(id,name,gender,point,age);
                list.add(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }

    @Override
    public boolean delete(int id) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1,id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return false;
    }

    @Override
    public boolean add(Student student) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setFloat(3,student.getPoint());
            preparedStatement.setInt(2,student.getAge());
            preparedStatement.setBoolean(4,student.isGender());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean edit(Student student) {
//        name = ?,age = ?,point = ?,gender = ? where id = ?
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setInt(2,student.getAge());
            preparedStatement.setFloat(3,student.getPoint());
            preparedStatement.setBoolean(4,student.isGender());
            preparedStatement.setInt(5,student.getId());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }

    @Override
    public List<Student> search(String name) {
        List<Student> list = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SELECT_BY);
            preparedStatement.setString(1, "%" +name + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String namez = rs.getString("name");
                float point = rs.getFloat("point");
                int age = rs.getInt("age");
                boolean gender = rs.getBoolean("gender");
                Student studentz = new Student(id,namez,gender,point,age);
                list.add(studentz);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }
}
