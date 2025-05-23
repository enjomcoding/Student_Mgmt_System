/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package myproject.tijada_oop;

import java.awt.BorderLayout;
import javax.swing.JOptionPane;
/**
 *
 * @author jomsa
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        setResizable(false);

        // Create the ImagePanel with the background image
        ImagePanel background = new ImagePanel("D:\\[BSCS]\\Projects\\Tijada_OOP\\tijada_oop\\src\\main\\java\\myproject\\tijada_oop\\images\\Menu2.jpg");

        // Set the layout for the background panel
        background.setLayout(new BorderLayout());

        // Set the content pane to the background panel
        setContentPane(background);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        filter = new javax.swing.ButtonGroup();
        searchBttn = new javax.swing.JButton();
        studentFilter = new javax.swing.JRadioButton();
        profFilter = new javax.swing.JRadioButton();
        courseFilter = new javax.swing.JRadioButton();
        subjFilter = new javax.swing.JRadioButton();
        MenBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        LogOut = new javax.swing.JMenuItem();
        Exit = new javax.swing.JMenuItem();
        mStudent = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        mProf = new javax.swing.JMenuItem();
        mCourse = new javax.swing.JMenuItem();
        mSubj = new javax.swing.JMenuItem();

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        searchBttn.setIcon(new javax.swing.ImageIcon("D:\\[BSCS]\\Projects\\Tijada_OOP\\tijada_oop\\src\\main\\java\\myproject\\tijada_oop\\images\\longSearch.png")); // NOI18N
        searchBttn.setText("jButton1");
        searchBttn.setBorder(null);
        searchBttn.setBorderPainted(false);
        searchBttn.setFocusPainted(false);
        searchBttn.setOpaque(false);
        searchBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBttnActionPerformed(evt);
            }
        });

        filter.add(studentFilter);
        studentFilter.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        studentFilter.setText("Student");
        studentFilter.setOpaque(false);

        filter.add(profFilter);
        profFilter.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        profFilter.setText("Professor");
        profFilter.setOpaque(false);

        filter.add(courseFilter);
        courseFilter.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        courseFilter.setText("Course");
        courseFilter.setOpaque(false);

        filter.add(subjFilter);
        subjFilter.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        subjFilter.setText("Subject");
        subjFilter.setOpaque(false);

        jMenu1.setText("File");

        LogOut.setText("Log Out");
        LogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutActionPerformed(evt);
            }
        });
        jMenu1.add(LogOut);

        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        jMenu1.add(Exit);

        MenBar.add(jMenu1);

        mStudent.setText("Create");
        mStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mStudentActionPerformed(evt);
            }
        });

        jMenuItem1.setText("Student");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mStudent.add(jMenuItem1);

        mProf.setText("Professor");
        mProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mProfActionPerformed(evt);
            }
        });
        mStudent.add(mProf);

        mCourse.setText("Course");
        mCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mCourseActionPerformed(evt);
            }
        });
        mStudent.add(mCourse);

        mSubj.setText("Subject");
        mSubj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mSubjActionPerformed(evt);
            }
        });
        mStudent.add(mSubj);

        MenBar.add(mStudent);

        setJMenuBar(MenBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(195, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(studentFilter)
                        .addGap(39, 39, 39)
                        .addComponent(profFilter)
                        .addGap(37, 37, 37)
                        .addComponent(courseFilter)
                        .addGap(31, 31, 31)
                        .addComponent(subjFilter))
                    .addComponent(searchBttn, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(168, 168, 168))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(searchBttn, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentFilter)
                    .addComponent(profFilter)
                    .addComponent(courseFilter)
                    .addComponent(subjFilter))
                .addContainerGap(364, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutActionPerformed
        // TODO add your handling code here:
        int choice = JOptionPane.showConfirmDialog(this, "Are you sure you want to log out?", "Log Out", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (choice == JOptionPane.YES_OPTION) {
            Log_in log_out = new Log_in(this, true);
            
            // Close the current window
            this.dispose();  // Dispose of the current window
            log_out.setVisible(true);
        }
    }//GEN-LAST:event_LogOutActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        Student student = new Student(this, true); 
        student.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void mProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mProfActionPerformed
        // TODO add your handling code here:
        Professor prof = new Professor(this, true);
        prof.setVisible(true);
    }//GEN-LAST:event_mProfActionPerformed

    private void searchBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBttnActionPerformed
        // TODO add your handling code here:
        if(studentFilter.isSelected()){
            SearchStudent search = new SearchStudent(this, true);
            search.setVisible(true);
        }
        if(profFilter.isSelected()){
            SearchProf search = new SearchProf(this, true);
            search.setVisible(true);
        }
        if(courseFilter.isSelected()){
            SearchCourse search = new SearchCourse(this, true);
            search.setVisible(true);
        }
        if(subjFilter.isSelected()){
            SearchSubj search = new SearchSubj(this, true);
            search.setVisible(true);
        }
    }//GEN-LAST:event_searchBttnActionPerformed

    private void mStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mStudentActionPerformed
        // TODO add your handling code here:
 
    }//GEN-LAST:event_mStudentActionPerformed

    private void mCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mCourseActionPerformed
        // TODO add your handling code here:
        Course course = new Course(this, true); 
        course.setVisible(true);
    }//GEN-LAST:event_mCourseActionPerformed

    private void mSubjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mSubjActionPerformed
        // TODO add your handling code here:
        Subject subj = new Subject(this, true); 
        subj.setVisible(true);
    }//GEN-LAST:event_mSubjActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        // TODO add your handling code here:
        int choice = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (choice == JOptionPane.YES_OPTION) {
            System.exit(0);  // Terminates the program
        }
    }//GEN-LAST:event_ExitActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Exit;
    private javax.swing.JMenuItem LogOut;
    private javax.swing.JMenuBar MenBar;
    private javax.swing.JRadioButton courseFilter;
    private javax.swing.ButtonGroup filter;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem mCourse;
    private javax.swing.JMenuItem mProf;
    private javax.swing.JMenu mStudent;
    private javax.swing.JMenuItem mSubj;
    private javax.swing.JRadioButton profFilter;
    private javax.swing.JButton searchBttn;
    private javax.swing.JRadioButton studentFilter;
    private javax.swing.JRadioButton subjFilter;
    // End of variables declaration//GEN-END:variables
}
