/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import models.operate;
import models.op_types_of_vehicle_serviced;

/**
 *
 * @author Sakshi
 */
public class roado2 extends javax.swing.JFrame {


    public roado2() {
        initComponents();
        Show_Users_In_JTable();
        Show_Users_In_JTable_types_of_service();
    }

   public Connection getConnection()
   {
       Connection con;
       try {
           con = DriverManager.getConnection("jdbc:mysql://localhost/roado", "root","");
           return con;
       } catch (Exception e) {
           e.printStackTrace();
           return null;
       }
   }
    
    public ArrayList<operate> getoperateList()
   {
       ArrayList<operate> operateList = new ArrayList<operate>();
       Connection connection = getConnection();
       
       String query = "SELECT * FROM  `ser_cen` ";   //
       Statement st;
       ResultSet rs;
       try {
           st = connection.createStatement();
           rs = st.executeQuery(query);

           operate op;

           while(rs.next())
           {
op = new operate(rs.getInt("id"),rs.getString("name_of_outlet"),rs.getString("name_of_service_provider"),rs.getString("owns_a_smartphone"),rs.getLong("phone_number"),rs.getLong("alternate_phone_number"),rs.getString("location"),rs.getString("opening_time"),rs.getString("closing_time"),rs.getString("outlet_established_in"));
               operateList.add(op);
           }

       } 
      catch (Exception e) {
           e.printStackTrace();
       }
       return operateList;
     
   }
    
    public void Show_Users_In_JTable()
   {
       ArrayList<operate> list = getoperateList();
       DefaultTableModel model = (DefaultTableModel)jTable_Display_Users.getModel();
       Object[] row = new Object[10];
       for(int i = 0; i < list.size(); i++)
       {
           row[0] = list.get(i).getid();
           row[1] = list.get(i).getname_of_outlet();
           row[2] = list.get(i).getname_of_service_provider();
           row[3] = list.get(i).getowns_a_smartphone();
           row[4] = list.get(i).getphone_number();
           row[5] = list.get(i).getalternate_phone_number();
           row[6] = list.get(i).getlocation();
           row[7] = list.get(i).getopening_time();
           row[8] = list.get(i).getclosing_time();
           row[9] = list.get(i).getoutlet_established_in();
           
           
           
           model.addRow(row);
       }
    } 
    
    public ArrayList<op_types_of_vehicle_serviced> gettypes_of_vehicles_List()
   {
       ArrayList<op_types_of_vehicle_serviced> tovsList = new ArrayList<op_types_of_vehicle_serviced>();
       Connection connection = getConnection();
       
       String query = "SELECT * FROM  `type_ser1` ";   //
       Statement st;
       ResultSet rs;
       try {
           st = connection.createStatement();
           rs = st.executeQuery(query);

           op_types_of_vehicle_serviced otovs;

           while(rs.next())
           {
otovs = new op_types_of_vehicle_serviced(rs.getInt("id"),rs.getString("types_of_vehicles_serviced"));
               tovsList.add(otovs);
           }

       } 
      catch (Exception e) {
           e.printStackTrace();
       }
       return tovsList;
     
   }    
    
    public void Show_Users_In_JTable_types_of_service()
   {
       ArrayList<op_types_of_vehicle_serviced> list = gettypes_of_vehicles_List();
       DefaultTableModel model = (DefaultTableModel)j_table_tovs.getModel();
       Object[] row = new Object[2];
       for(int i = 0; i < list.size(); i++)
       {
           row[0] = list.get(i).getid();
           row[1] = list.get(i).gettypes_of_vehicles_serviced();
                
           
           model.addRow(row);
       }
    }
    public void executeSQlQuery(String query, String message)
   {
       Connection con = getConnection();
       Statement st;
       try{
           st = con.createStatement();
           if((st.executeUpdate(query)) == 1)
           {
               // refresh jtable data
               DefaultTableModel model = (DefaultTableModel)jTable_Display_Users.getModel();
               model.setRowCount(0);
               Show_Users_In_JTable();
               
            
               
               JOptionPane.showMessageDialog(null, "Data "+message+" Succefully");
           }else{
               JOptionPane.showMessageDialog(null, "Data Not "+message);
           }
       }catch(Exception ex){
           ex.printStackTrace();
       }
   }
    public void executeSQlQuery1(String query, String message)
   {
       Connection con = getConnection();
       Statement st;
       try{
           st = con.createStatement();
           if((st.executeUpdate(query)) == 1)
           {
               DefaultTableModel model1 = (DefaultTableModel)j_table_tovs.getModel();
               model1.setRowCount(0);
               Show_Users_In_JTable_types_of_service(); 
               
            
               
               JOptionPane.showMessageDialog(null, "Data "+message+" Succefully");
           }else{
               JOptionPane.showMessageDialog(null, "Data Not "+message);
           }
       }catch(Exception ex){
           ex.printStackTrace();
       }
   }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        id = new javax.swing.JLabel();
        name_of_outlet = new javax.swing.JLabel();
        name_of_service_provider = new javax.swing.JLabel();
        owns_a_smartphone = new javax.swing.JLabel();
        phone_number = new javax.swing.JLabel();
        alternate_phone_number = new javax.swing.JLabel();
        location = new javax.swing.JLabel();
        opening_time = new javax.swing.JLabel();
        closing_time = new javax.swing.JLabel();
        outlet_etablished_in = new javax.swing.JLabel();
        tf_id = new javax.swing.JTextField();
        tf_name_of_outlet = new javax.swing.JTextField();
        tf_name_of_service_provider = new javax.swing.JTextField();
        tf_owns_a_smartphone = new javax.swing.JTextField();
        tf_phone_number = new javax.swing.JTextField();
        tf_alternate_phone_number = new javax.swing.JTextField();
        tf_location = new javax.swing.JTextField();
        tf_opening_time = new javax.swing.JTextField();
        tf_closing_time = new javax.swing.JTextField();
        tf_outlet_established_in = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Display_Users = new javax.swing.JTable();
        insert = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tf_types_of_vehicles_serviced = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        j_table_tovs = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        id.setText("id");

        name_of_outlet.setText("name_of_outlet");

        name_of_service_provider.setText("name_of_service_provider");

        owns_a_smartphone.setText("owns_a_smartphone");

        phone_number.setText("phone_number");

        alternate_phone_number.setText("alternate_phone_number");

        location.setText("location");

        opening_time.setText("opening_time");

        closing_time.setText("closing_time");

        outlet_etablished_in.setText("outlet_established_in");

        tf_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_idActionPerformed(evt);
            }
        });

        tf_name_of_outlet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_name_of_outletActionPerformed(evt);
            }
        });

        tf_name_of_service_provider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_name_of_service_providerActionPerformed(evt);
            }
        });

        tf_owns_a_smartphone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_owns_a_smartphoneActionPerformed(evt);
            }
        });

        tf_alternate_phone_number.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_alternate_phone_numberActionPerformed(evt);
            }
        });

        jTable_Display_Users.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "name_of_outlet", "name_of_service_provider", "owns_a_smartphone", "phone_number", "alternate_phone_number", "location", "opening_time", "closing_time", "nulloutlet_established_in"
            }
        ));
        jTable_Display_Users.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_Display_UsersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Display_Users);

        insert.setText("insert");
        insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertActionPerformed(evt);
            }
        });

        update.setText("update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        delete.setText("delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        jLabel1.setText("types_of_vehicles_serviced");

        j_table_tovs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "types_of_vehicles_serviced"
            }
        ));
        j_table_tovs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                j_table_tovsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(j_table_tovs);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(id, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(name_of_outlet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(name_of_service_provider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(owns_a_smartphone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(phone_number, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(alternate_phone_number, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(location, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(opening_time, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(closing_time, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(outlet_etablished_in, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel1))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(insert)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(tf_name_of_outlet)
                                .addComponent(tf_name_of_service_provider)
                                .addComponent(tf_owns_a_smartphone)
                                .addComponent(tf_phone_number)
                                .addComponent(tf_alternate_phone_number)
                                .addComponent(tf_location)
                                .addComponent(tf_opening_time)
                                .addComponent(tf_id, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                            .addComponent(tf_closing_time, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(tf_types_of_vehicles_serviced, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tf_outlet_established_in, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(274, 274, 274)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 290, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(update)
                                        .addGap(18, 18, 18)
                                        .addComponent(delete)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jScrollPane1))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(id)
                            .addComponent(tf_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(name_of_outlet)
                            .addComponent(tf_name_of_outlet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(name_of_service_provider)
                            .addComponent(tf_name_of_service_provider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(owns_a_smartphone)
                            .addComponent(tf_owns_a_smartphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(phone_number)
                            .addComponent(tf_phone_number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(alternate_phone_number)
                            .addComponent(tf_alternate_phone_number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(location)
                            .addComponent(tf_location, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(opening_time)
                            .addComponent(tf_opening_time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(closing_time)
                            .addComponent(tf_closing_time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(outlet_etablished_in)
                            .addComponent(tf_outlet_established_in, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(tf_types_of_vehicles_serviced, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insert)
                    .addComponent(update)
                    .addComponent(delete))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_owns_a_smartphoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_owns_a_smartphoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_owns_a_smartphoneActionPerformed

    private void tf_alternate_phone_numberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_alternate_phone_numberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_alternate_phone_numberActionPerformed

    private void tf_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_idActionPerformed

    private void jTable_Display_UsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_Display_UsersMouseClicked
        // TODO add your handling code here:
              // Get The Index Of The Slected Row 
        int i = jTable_Display_Users.getSelectedRow();

        TableModel model = jTable_Display_Users.getModel();
        
         // Display Slected Row In JTexteFields
        tf_id.setText(model.getValueAt(i,0).toString());

        tf_name_of_outlet.setText(model.getValueAt(i,1).toString());

        tf_name_of_service_provider.setText(model.getValueAt(i,2).toString());

        tf_owns_a_smartphone.setText(model.getValueAt(i,3).toString());
        
        tf_phone_number.setText(model.getValueAt(i,4).toString());
        
        tf_alternate_phone_number.setText(model.getValueAt(i,5).toString());
        
        tf_location.setText(model.getValueAt(i,6).toString());
        
        tf_opening_time.setText(model.getValueAt(i,7).toString());
        
        tf_closing_time.setText(model.getValueAt(i,8).toString());
        
        tf_outlet_established_in.setText(model.getValueAt(i,9).toString());
        
        
    }//GEN-LAST:event_jTable_Display_UsersMouseClicked

    private void insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertActionPerformed
        String query="INSERT INTO `ser_cen`(`id`, `name_of_outlet`, `name_of_service_provider`, `owns_a_smartphone`, `phone_number`, `alternate_phone_number`, `location`, `opening_time`, `closing_time`, `outlet_established_in`) VALUES ('"+tf_id.getText()+"','"+tf_name_of_outlet.getText()+"','"+tf_name_of_service_provider.getText()+"','"+tf_owns_a_smartphone.getText()+"','"+tf_phone_number.getText()+"','"+tf_alternate_phone_number.getText()+"','"+tf_location.getText()+"','"+tf_opening_time.getText()+"','"+tf_closing_time.getText()+"','"+tf_outlet_established_in.getText()+"')";
         executeSQlQuery(query, "Inserted");
        String query1="INSERT INTO `type_ser1`(`id`, `types_of_vehicles_serviced`) VALUES ('"+tf_id.getText()+"','"+tf_types_of_vehicles_serviced.getText()+"')";
        executeSQlQuery(query1, "Inserted");
    }//GEN-LAST:event_insertActionPerformed

    private void tf_name_of_outletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_name_of_outletActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_name_of_outletActionPerformed

    private void tf_name_of_service_providerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_name_of_service_providerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_name_of_service_providerActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        String query="UPDATE `ser_cen` SET `name_of_outlet`='"+tf_name_of_outlet.getText()+"',`name_of_service_provider`='"+tf_name_of_service_provider.getText()+"',`owns_a_smartphone`='"+tf_owns_a_smartphone.getText()+"',`phone_number`='"+tf_phone_number.getText()+"',`alternate_phone_number`='"+tf_alternate_phone_number.getText()+"',`location`='"+tf_location.getText()+"',`opening_time`='"+tf_opening_time.getText()+"',`closing_time`='"+tf_closing_time.getText()+"',`outlet_established_in`='"+tf_outlet_established_in.getText()+"' WHERE `id`="+tf_id.getText();
         executeSQlQuery(query, "Updated");
        //String query1="UPDATE `type_ser1` SET `types_of_vehicles_serviced`='"+tf_types_of_vehicles_serviced.getText()+"' WHERE `id`="+tf_id.getText()+"AND types_of_vehicles_serviced= '"+tf_types_of_vehicles_serviced.getText()+"'";
        //executeSQlQuery(query1, "Updated");
    }//GEN-LAST:event_updateActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        String type_of_veh= tf_types_of_vehicles_serviced.getText();
        if(!type_of_veh.isEmpty()){
        String query1="DELETE FROM `type_ser1` WHERE id="+tf_id.getText()+" AND types_of_vehicles_serviced= '"+tf_types_of_vehicles_serviced.getText()+"'";
        executeSQlQuery(query1, "Deleted");
        }
        else{
        String query="DELETE FROM `ser_cen` WHERE id="+tf_id.getText();
        executeSQlQuery(query, "Deleted");
        }
        
        
    }//GEN-LAST:event_deleteActionPerformed

    private void j_table_tovsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_j_table_tovsMouseClicked
        // TODO add your handling code here:
        int i = j_table_tovs.getSelectedRow();

        TableModel model = j_table_tovs.getModel();
        
         // Display Slected Row In JTexteFields
        tf_id.setText(model.getValueAt(i,0).toString());

        tf_types_of_vehicles_serviced.setText(model.getValueAt(i,1).toString());
    }//GEN-LAST:event_j_table_tovsMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(roado2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(roado2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(roado2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(roado2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new roado2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alternate_phone_number;
    private javax.swing.JLabel closing_time;
    private javax.swing.JButton delete;
    private javax.swing.JLabel id;
    private javax.swing.JButton insert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_Display_Users;
    private javax.swing.JTable j_table_tovs;
    private javax.swing.JLabel location;
    private javax.swing.JLabel name_of_outlet;
    private javax.swing.JLabel name_of_service_provider;
    private javax.swing.JLabel opening_time;
    private javax.swing.JLabel outlet_etablished_in;
    private javax.swing.JLabel owns_a_smartphone;
    private javax.swing.JLabel phone_number;
    private javax.swing.JTextField tf_alternate_phone_number;
    private javax.swing.JTextField tf_closing_time;
    private javax.swing.JTextField tf_id;
    private javax.swing.JTextField tf_location;
    private javax.swing.JTextField tf_name_of_outlet;
    private javax.swing.JTextField tf_name_of_service_provider;
    private javax.swing.JTextField tf_opening_time;
    private javax.swing.JTextField tf_outlet_established_in;
    private javax.swing.JTextField tf_owns_a_smartphone;
    private javax.swing.JTextField tf_phone_number;
    private javax.swing.JTextField tf_types_of_vehicles_serviced;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
