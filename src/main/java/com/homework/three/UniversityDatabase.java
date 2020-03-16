package com.homework.three;

import java.sql.*;

public class UniversityDatabase {

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;

    public void createConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "natalia",
                    "natalia0211");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        } finally {
            connection.close();
        }
    }

    public UniversityDatabase() throws SQLException {
        createConnection();
    }

    public void addStudent(Student student) throws SQLException {
        if (connection != null) {
            try {

                String sql = "INSERT INTO students (student_id, name, last_name, course, age)  VALUES (?,?,?,?,?)";


                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, student.getStudentID());
                preparedStatement.setString(2, student.getName());
                preparedStatement.setString(3, student.getLastName());
                preparedStatement.setString(4, student.getCourse());
                preparedStatement.setInt(5, student.getAge());

                preparedStatement.execute();

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            }
        }
    }

    public void deleteStudent(Student student) throws SQLException { //don`t work
        if (connection != null) {
            try {
                String sql1 = "DELETE FROM students WHERE student_id = ?";
                preparedStatement = connection.prepareStatement(sql1);

                preparedStatement.setInt(1, student.getStudentID());
                preparedStatement.execute();


            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            }
        }
    }

    public void updateDataForStudent(Student student) throws SQLException {
        if (connection != null) {
            try {
                String sql2 = "UPDATE `students` SET `name` = ?, `last_name` = ?, `course` = ?," +
                        " `age` = ? WHERE `student_id` =?";
                preparedStatement = connection.prepareStatement(sql2);

                preparedStatement.setInt(1, student.getStudentID());
                preparedStatement.setString(2, student.getName());
                preparedStatement.setString(3, student.getLastName());
                preparedStatement.setString(4, student.getCourse());
                preparedStatement.setInt(5, student.getAge());
                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            }
        }
    }

    public void addMarkForStudent(Student student, Mark mark) throws SQLException {

        if (connection != null) {
            PreparedStatement st = null;
            PreparedStatement stU = null;
            try {
                connection.setAutoCommit(false);
                st = connection.prepareStatement("SELECT student_id FROM students where student_id = ?");
                st.setInt(1, student.getStudentID());
                ResultSet rs = st.executeQuery();

                if (rs.next()) {
                    System.out.println(rs.getInt("student_id"));
                    stU = connection.prepareStatement("INSERT INTO marks (subject_id, firs_module, " +
                            "second_module, third_module, exam, student_id)"
                            + " VALUES (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
                    stU.setInt(1, mark.getSubjectID());
                    stU.setInt(2, mark.getFirsM());
                    stU.setInt(3, mark.getSecondM());
                    stU.setInt(4, mark.getThirdM());
                    stU.setInt(5, mark.getExam());
                    stU.setInt(6, student.getStudentID());
                    int r = stU.executeUpdate();
                    connection.commit();
                    if (r > 0) {
                        ResultSet rs1 = stU.getGeneratedKeys();
                        rs1.next();
                        System.out.println(rs1.getInt(1));
                        System.out.println("Success");
                    } else {
                        System.out.println("Error");
                    }
                }
            } catch (SQLException e) {
                connection.rollback();
                e.printStackTrace();
            } finally {
                if (st != null) {
                    st.close();
                }
            }
        }
    }
}
