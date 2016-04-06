/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.asu.cse564.client;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import edu.asu.cse564.gradebook.models.*;

import com.sun.jersey.api.client.ClientResponse;

import javax.ws.rs.core.Response;

import javax.swing.JFrame;

import javax.xml.bind.JAXBException;

import java.net.URI;

import java.lang.String;
import javax.swing.JOptionPane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author fcalliss
 */
public class MainClass extends JFrame {

    private static final Logger LOG = LoggerFactory.getLogger(MainClass.class);

    private JsonParser jsonBuilder;

    private Gson gson;

    private GradeBookClient gradeBookClient;

    private URI resourceURI;

    private SetWorkItem setWorkItem;

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        System.out.println("Hello world");
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainClass().setVisible(true);
            }
        });
    }

    /**
     * Creates new form Appointment_REST_UI
     */
    public MainClass() {
        LOG.info("Creating a Appointment_REST_UI object");
        initComponents();
        gradeBookClient = new GradeBookClient();
        setWorkItem = new SetWorkItem();
        jsonBuilder = new JsonParser();
        gson = new Gson();
    }

    private String convertFormToXMLString() {
        Appointment appointment = new Appointment();
        //if (!jTextField1.getText().equals("")){
        //    appointment.setId(Integer.parseInt(jTextField1.getText()));
        //}
        appointment.setTitle(jTextField2.getText());
        appointment.setPriority(Integer.parseInt(jTextField4.getText()));

        String xmlString = Converter.convertFromObjectToXml(appointment, appointment.getClass());

        return xmlString;
    }

    private void populateForm(ClientResponse clientResponse) {
        LOG.info("Populating the UI with the Appointment info");

        String entity = clientResponse.getEntity(String.class);

        LOG.debug("The Client Response entity is {}", entity);

        try {
            if ((clientResponse.getStatus() == Response.Status.OK.getStatusCode())
                    || (clientResponse.getStatus() == Response.Status.CREATED.getStatusCode())) {
                Appointment appointment = (Appointment) Converter.convertFromXmlToObject(entity, Appointment.class);
                LOG.debug("The Client Response appointment object is {}", appointment);

                // Populate Appointment info
                //jTextField1.setText(Integer.toString(appointment.getId()));
                jTextField2.setText(appointment.getTitle());
                jTextField4.setText(Integer.toString(appointment.getPriority()));
            } else {
                jTextField2.setText("");
                jTextField4.setText("");
            }

            // Populate HTTP Header Information
            jTextField3.setText(Integer.toString(clientResponse.getStatus()));
            //jTextField6.setText(clientResponse.getType().toString());

            // The Location filed is only populated when a Resource is created
            if (clientResponse.getStatus() == Response.Status.CREATED.getStatusCode()) {
                jTextField5.setText(clientResponse.getLocation().toString());
            } else {
                jTextField5.setText("");
            }

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel1.setText("Actions");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Create");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Read");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("Update");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setText("Delete");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel2.setText("Details");

        jLabel3.setText("Student Name");

        jLabel4.setText("Work Item ");

        jLabel6.setText("Grade");

        jTextField2.setName("TitleField"); // NOI18N
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField4.setToolTipText("dd/MM/yyyy HH:mm:ss");
        jTextField4.setName("PriorityField"); // NOI18N
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setText("HTTP Status Code");

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel7.setText("Response Text");

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel8.setText("HTTP Header Info");

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jLabel10.setText("Class Plan");

        jTextField7.setName("IdField"); // NOI18N
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        jTextField8.setName("IdField"); // NOI18N
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        jTextField9.setName("IdField"); // NOI18N
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });

        jLabel11.setText("Work Item Name");

        jLabel12.setText("Percentage ");

        jButton2.setText("Add WorkItem to List");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Submit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel9.setText("Feedback");

        jTextField6.setToolTipText("dd/MM/yyyy HH:mm:ss");
        jTextField6.setName("PriorityField"); // NOI18N
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jLabel13.setText("Student");

        jLabel14.setText("Student Name");

        jTextField10.setName("IdField"); // NOI18N
        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });

        jButton4.setText("Get Student Total Score");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Add Student");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel15.setText("Student Total Score");

        jTextField11.setName("IdField"); // NOI18N
        jTextField11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField11ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(jTextField5)
                                .add(layout.createSequentialGroup()
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                .add(jLabel7)
                                                .add(layout.createSequentialGroup()
                                                        .add(jLabel5)
                                                        .add(34, 34, 34)
                                                        .add(jTextField3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 86, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                        .add(56, 56, 56)
                                                        .add(jLabel8))
                                                .add(layout.createSequentialGroup()
                                                        .add(184, 184, 184)
                                                        .add(jTextField11, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 201, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                        .add(75, 75, 75)
                                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                                .add(jButton5)
                                                                .add(jButton4))))
                                        .add(0, 0, Short.MAX_VALUE))
                                .add(layout.createSequentialGroup()
                                        .add(30, 30, 30)
                                        .add(jLabel1)
                                        .add(87, 87, 87)
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                .add(layout.createSequentialGroup()
                                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                                .add(jTextField8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 201, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                                .add(jTextField9, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 201, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .add(jButton2))
                                                .add(layout.createSequentialGroup()
                                                        .add(310, 310, 310)
                                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                                .add(jLabel4)
                                                                .add(jLabel2)
                                                                .add(jLabel3)
                                                                .add(jLabel6)
                                                                .add(jLabel9))))
                                        .add(18, 18, 18)
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                .add(jButton3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 253, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                .add(jTextField7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 201, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                .add(jTextField2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 201, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                .add(jTextField6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 201, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                                        .add(jButton1)
                                                        .add(jTextField4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 201, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap())
                .add(layout.createSequentialGroup()
                        .add(31, 31, 31)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(layout.createSequentialGroup()
                                        .add(jLabel11)
                                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .add(layout.createSequentialGroup()
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                .add(jRadioButton3)
                                                .add(jRadioButton2)
                                                .add(jRadioButton1)
                                                .add(jLabel12)
                                                .add(jRadioButton4))
                                        .addContainerGap(792, Short.MAX_VALUE))
                                .add(layout.createSequentialGroup()
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                .add(jLabel15)
                                                .add(jLabel13)
                                                .add(jLabel10))
                                        .add(0, 0, Short.MAX_VALUE))
                                .add(layout.createSequentialGroup()
                                        .add(jLabel14)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .add(jTextField10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 201, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(506, 506, 506))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jLabel13)
                        .add(50, 50, 50)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(jLabel14)
                                .add(jTextField10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(jButton5))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(jLabel15)
                                .add(jTextField11, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(jButton4))
                        .add(35, 35, 35)
                        .add(jLabel10)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 50, Short.MAX_VALUE)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(layout.createSequentialGroup()
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                                .add(jLabel11)
                                                .add(jTextField8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                                .add(jLabel12)
                                                .add(jTextField9, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(jButton2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 61, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(jButton3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 61, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 19, Short.MAX_VALUE)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(jLabel2)
                                .add(jLabel1))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(jTextField7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(jLabel4)
                                .add(jRadioButton1))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(jTextField2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(jLabel3)
                                .add(jRadioButton2))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(jLabel6)
                                .add(jTextField6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(jRadioButton3))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(jLabel9)
                                .add(jTextField4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(jRadioButton4))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jButton1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel8)
                        .add(10, 10, 10)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(jLabel5)
                                .add(jTextField3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(25, 25, 25)
                        .add(jLabel7)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jTextField5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
        );

        pack();
    }// </editor-fold>              

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        LOG.info("Selecting radio button {}", jRadioButton1.getText());
        textFieldResetter();
    }

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        LOG.info("Selecting radio button {}", jRadioButton2.getText());
        textFieldResetter();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        LOG.info("Invoking REST Client based on selection");

        //String appointmentID = jTextField1.getText();
        if (jRadioButton1.isSelected()) {
            LOG.debug("Invoking {} action", jRadioButton1.getText());//Create
            Grade grade = new Grade();

            if (!jTextField6.getText().equals("") && !jTextField2.getText().equals("") && !jTextField4.getText().equals("") && !jTextField7.getText().equals("")) {
                grade.grade = Float.parseFloat(jTextField6.getText());
                grade.feedback = jTextField4.getText();
                String workItemName = jTextField7.getText();
                String studentName = jTextField2.getText();
                ClientResponse clientResponse = gradeBookClient.addGrade(grade, studentName, workItemName);
                resourceURI = clientResponse.getLocation();
                LOG.debug("Retrieved location {}", resourceURI);
                textFieldResetter();
                this.responseParser(clientResponse);
            } else {
                JOptionPane.showMessageDialog(null, "Required elements missing", "InfoBox: " + "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (jRadioButton2.isSelected()) {
            LOG.debug("Invoking {} action", jRadioButton2.getText());// Read
            String workItemName = jTextField7.getText();
            String studentName = jTextField2.getText();
            if (!workItemName.equals("") && !studentName.equals("")) {
                ClientResponse clientResponse = gradeBookClient.getGrade(studentName, workItemName);
                textFieldResetter();
                this.responseParser(clientResponse);
            } else {
                JOptionPane.showMessageDialog(null, "Required elements missing", "InfoBox: " + "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (jRadioButton3.isSelected()) {
            LOG.debug("Invoking {} action", jRadioButton3.getText());//Update
            Grade grade = new Grade();
            if (!jTextField6.getText().equals("") && !jTextField2.getText().equals("") && !jTextField4.getText().equals("") && !jTextField7.getText().equals("")) {
                grade.grade = Float.parseFloat(jTextField6.getText());
                grade.feedback = jTextField4.getText();
                String workItemName = jTextField7.getText();
                String studentName = jTextField2.getText();
                ClientResponse clientResponse = gradeBookClient.updateGrade(grade, studentName, workItemName);
                textFieldResetter();
                resourceURI = clientResponse.getLocation();
                LOG.debug("Retrieved location {}", resourceURI);

                this.responseParser(clientResponse);
            } else {
                JOptionPane.showMessageDialog(null, "Required elements missing", "InfoBox: " + "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else if (jRadioButton4.isSelected()) {
            LOG.debug("Invoking {} action", jRadioButton4.getText());//Delete

            String workItemName = jTextField7.getText();
            String studentName = jTextField2.getText();
            if (!workItemName.equals("") && !studentName.equals("")) {
                ClientResponse clientResponse = gradeBookClient.deleteGrade(studentName, workItemName);
                textFieldResetter();
                this.responseParser(clientResponse);
            } else {
                JOptionPane.showMessageDialog(null, "Required elements missing", "InfoBox: " + "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        LOG.info("Selecting radio button {}", jRadioButton3.getText());
        textFieldResetter();
    }

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        LOG.info("Selecting radio button {}", jRadioButton4.getText());
        textFieldResetter();
    }

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        if (!jTextField9.getText().equals("") && !jTextField8.getText().equals("")) {
            WorkItem workItem = new WorkItem();
            workItem.percentage = Float.parseFloat(jTextField9.getText());
            workItem.workItemName = jTextField8.getText();
            setWorkItem.workItems.add(workItem);
        } else {
            JOptionPane.showMessageDialog(null, "Required elements missing", "InfoBox: " + "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        if (setWorkItem.workItems.size() != 0) {
            ClientResponse response = gradeBookClient.addClassPlan(setWorkItem);
            setWorkItem = new SetWorkItem();
            responseParser(response);
        } else {
            JOptionPane.showMessageDialog(null, "No work item added", "InfoBox: " + "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        String student = jTextField10.getText();
        if (!student.equals("")) {
            ClientResponse response = gradeBookClient.getStudentTotalScore(student);
            if (response.getStatus() == ClientResponse.Status.OK.getStatusCode()) {
                jTextField11.setText(response.getEntity(String.class));
            } else {
                responseParser(response);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Student name is missing", "InfoBox: " + "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        String student = jTextField10.getText();
        if (!student.equals("")) {
            ClientResponse response = gradeBookClient.addStudent(student);
            responseParser(response);
        } else {
            JOptionPane.showMessageDialog(null, "Student name is missing", "InfoBox: " + "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void jTextField11ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void responseParser(ClientResponse response) {
        jTextField3.setText(Integer.toString(response.getStatus()));
        if (response.getStatus() == ClientResponse.Status.OK.getStatusCode()
                && jRadioButton2.isSelected()) {
            jTextField3.setText(Integer.toString(response.getStatus()));
            //String grade = response.getEntity(String.class);
            JsonObject jsonData = jsonBuilder.parse(response.getEntity(String.class)).getAsJsonObject();
            Grade grade = gson.fromJson(jsonData, Grade.class);
            jTextField6.setText(Float.toString(grade.grade));
            jTextField4.setText(grade.feedback);
        } else {
            jTextField5.setText(response.getEntity(String.class));
        }
    }

    private void textFieldResetter() {
        jTextField2.setText(null);
        jTextField3.setText(null);
        jTextField4.setText(null);
        jTextField5.setText(null);
        jTextField6.setText(null);
        jTextField7.setText(null);
    }

    // Variables declaration - do not modify                     
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration                   
}
