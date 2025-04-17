package myproject.tijada_oop.SMS_DB;

import java.sql.*;
import javax.swing.JOptionPane;
public class SMS {
    

    public void addStudent(String[] student_details, String[] student_demo, String[] student_fam, String[] combo_info, 
            int yrLvl, String dobString, String gender, int studentId, String program) {

        String queryStudentDetails = "INSERT INTO student_details (student_ID, student_name, student_sx, student_email, student_contact, student_dob) " +
                                    "VALUES (?, ?, ?, ?, ?, ?)";
        String queryStudentDemo = "INSERT INTO student_demo (student_ID, per_add, zip, census, religion, ethnicity, civ_stat_student, job_student, nat_student, prim_school, sec_school, ter_school, tech_voc) " +
                                  "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String queryStudentFam = "INSERT INTO student_fam (student_ID, mother_name, mother_address, civ_stat_mother, job_mother, father_name, father_address, civ_stat_father, job_father, guardian_name, guardian_contact, guardian_address, income_source, ann_income) " +
                                 "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String queryStudentRecords = "INSERT INTO student_records (student_ID, acad_year, sem, enrol_stat, yr_lvl, program, scholar) " +
                                     "VALUES (?, ?, ?, ?, ?, ?, ?)";

        Connection conn = null;
        try {
            conn = Connect_DB.connect();
            conn.setAutoCommit(false);

            try (PreparedStatement stmtStudentDetails = conn.prepareStatement(queryStudentDetails);
                 PreparedStatement stmtStudentDemo = conn.prepareStatement(queryStudentDemo);
                 PreparedStatement stmtStudentFam = conn.prepareStatement(queryStudentFam);
                 PreparedStatement stmtStudentRecords = conn.prepareStatement(queryStudentRecords)) {

                // Insert student details
                String student_name = student_details[2] + ", " + student_details[0] + " " + student_details[1].charAt(0) + ".";

                if (!student_details[3].isEmpty()) {
                    student_name += " " + student_details[3];  // Append extension if it's not empty
                }
                
                stmtStudentDetails.setInt(1, studentId);
                stmtStudentDetails.setString(2, student_name);
                stmtStudentDetails.setString(3, gender);
                stmtStudentDetails.setString(4, student_details[4]);
                stmtStudentDetails.setString(5, student_details[5]);
                stmtStudentDetails.setString(6, dobString);
                stmtStudentDetails.addBatch();

                // Insert student demo
                String address = student_demo[2] + ", " + student_demo[1] + ", " + student_demo[0];
                stmtStudentDemo.setInt(1, studentId);
                stmtStudentDemo.setString(2, address);
                stmtStudentDemo.setString(3, student_demo[3]); // Zip
                stmtStudentDemo.setString(4, combo_info[0]);   // Census
                stmtStudentDemo.setString(5, student_demo[4]); // Religion
                stmtStudentDemo.setString(6, student_demo[5]); // Ethnicity
                stmtStudentDemo.setString(7, combo_info[1]);   // Civil status
                stmtStudentDemo.setString(8, student_demo[6]); // Job
                stmtStudentDemo.setString(9, student_demo[7]); // Nationality
                stmtStudentDemo.setString(10, student_demo[8]); // Primary school
                stmtStudentDemo.setString(11, student_demo[9]); // Secondary school
                stmtStudentDemo.setString(12, student_demo[10]); // Tertiary school
                stmtStudentDemo.setString(13, student_demo[11]); // Technical vocation
                stmtStudentDemo.addBatch();

                // Insert family details
                stmtStudentFam.setInt(1, studentId);
                stmtStudentFam.setString(2, student_fam[0]); // Mother name
                stmtStudentFam.setString(3, student_fam[1]); // Mother address
                stmtStudentFam.setString(4, combo_info[2]); // Mother civ stat
                stmtStudentFam.setString(5, student_fam[2]); // Mother Job
                stmtStudentFam.setString(6, student_fam[3]); // Father name
                stmtStudentFam.setString(7, student_fam[4]); // Father address
                stmtStudentFam.setString(8, combo_info[3]); // Father civ stat
                stmtStudentFam.setString(9, student_fam[5]); // Father job
                stmtStudentFam.setString(10, student_fam[6]); // Guardian name
                stmtStudentFam.setString(11, student_fam[7]); // Guardian contact
                stmtStudentFam.setString(12, student_fam[8]); // Guardian address
                stmtStudentFam.setString(13, combo_info[4]); // Source of income
                stmtStudentFam.setString(14, combo_info[5]); // Annual income
                stmtStudentFam.addBatch();

                // Insert student records
                stmtStudentRecords.setInt(1, studentId);
                stmtStudentRecords.setString(2, combo_info[6]);// acad year
                stmtStudentRecords.setString(3, combo_info[7]);// sem
                stmtStudentRecords.setString(4, combo_info[8]);// enrol_stat
                stmtStudentRecords.setInt(5, yrLvl);// yrLvl
                stmtStudentRecords.setString(6, program);// program
                stmtStudentRecords.setString(7, combo_info[9]);// scholar
                stmtStudentRecords.addBatch();

                // Execute batch
                stmtStudentDetails.executeBatch();
                stmtStudentDemo.executeBatch();
                stmtStudentFam.executeBatch();
                stmtStudentRecords.executeBatch();
                JOptionPane.showMessageDialog(null, "Student added succesfully.");

                conn.commit();
            } catch (SQLException e) {
                e.printStackTrace();
                if (conn != null) {
                    conn.rollback();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } finally {
            try {
                if (conn != null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void addProf(String[] prof_details, String dobString, String gender, int profId) {
        String query = "INSERT INTO professor_details (profID, prof_name, prof_sex, prof_dob, prof_contact, prof_email, address, position, dept, spec) " +
                                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        Connection conn = null;
        try {
            conn = Connect_DB.connect();
            conn.setAutoCommit(false);

            try (PreparedStatement stmtProfDetails = conn.prepareStatement(query);){

                String prof_name = prof_details[2] + ", " + prof_details[0] + " " + prof_details[1].charAt(0) + ".";

                if (!prof_details[3].isEmpty()) {
                    prof_name += " " + prof_details[3];  // Append extension if it's not empty
                }
                
                stmtProfDetails.setInt(1, profId);
                stmtProfDetails.setString(2, prof_name);
                stmtProfDetails.setString(3, gender);
                stmtProfDetails.setString(4, dobString);
                stmtProfDetails.setString(5, prof_details[4]);// contact
                stmtProfDetails.setString(6, prof_details[5]);// email
                stmtProfDetails.setString(7, prof_details[6]);// address
                stmtProfDetails.setString(8, prof_details[7]);// position
                stmtProfDetails.setString(9, prof_details[8]);// dept
                stmtProfDetails.setString(10, prof_details[9]);// spec
                stmtProfDetails.addBatch();
     
                stmtProfDetails.executeBatch();
                JOptionPane.showMessageDialog(null, "Professor added succesfully.");

                conn.commit();
            } catch (SQLException e) {
                e.printStackTrace();
                if (conn != null) {
                    conn.rollback();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } finally {
            try {
                if (conn != null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
    }
    
    public void addCourse(String[] course_info, String type) {
        String query = "INSERT INTO course (course_code, description, course_type, spec, dept) " +
                                    "VALUES (?, ?, ?, ?, ?)";
        
        Connection conn = null;
        try {
            conn = Connect_DB.connect();
            conn.setAutoCommit(false);

            try (PreparedStatement stmtProfDetails = conn.prepareStatement(query);){

                
                stmtProfDetails.setString(1, course_info[0]);// code
                stmtProfDetails.setString(2, course_info[1]);// desc
                stmtProfDetails.setString(3, type);
                stmtProfDetails.setString(4, course_info[2]);// spec
                stmtProfDetails.setString(5, course_info[3]);// dept

                stmtProfDetails.addBatch();
     
                stmtProfDetails.executeBatch();
                JOptionPane.showMessageDialog(null, "Course added succesfully.");

                conn.commit();
            } catch (SQLException e) {
                e.printStackTrace();
                if (conn != null) {
                    conn.rollback();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } finally {
            try {
                if (conn != null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
    }
    
    public void addSubj(String[] subjData, double units, String type, String schedDay, String schedTime) {
        String query = "INSERT INTO subject (subj_code, subj_desc, units, spec, dept, sched_time, sched_day, subj_type) " +
                                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        Connection conn = null;
        try {
            conn = Connect_DB.connect();
            conn.setAutoCommit(false);

            try (PreparedStatement stmtProfDetails = conn.prepareStatement(query);){

                
                stmtProfDetails.setString(1, subjData[0]);// code
                stmtProfDetails.setString(2, subjData[1]);// desc
                stmtProfDetails.setDouble(3, units);
                stmtProfDetails.setString(4, subjData[2]);// spec
                stmtProfDetails.setString(5, subjData[3]);// dept
                stmtProfDetails.setString(6, schedTime);// time
                stmtProfDetails.setString(7, schedDay);// day
                stmtProfDetails.setString(8, type);// type

                stmtProfDetails.addBatch();
     
                stmtProfDetails.executeBatch();
                JOptionPane.showMessageDialog(null, "Subject added succesfully.");

                conn.commit();
            } catch (SQLException e) {
                e.printStackTrace();
                if (conn != null) {
                    conn.rollback();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } finally {
            try {
                if (conn != null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
    }
}
