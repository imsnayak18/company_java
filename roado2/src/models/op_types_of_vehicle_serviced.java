/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Sakshi
 */
public class op_types_of_vehicle_serviced {
 
    private int id = 0;
    private String types_of_vehicles_serviced  = "";
    public op_types_of_vehicle_serviced(int id, String types_of_vehicles_serviced){
        
        this.id = id;
        this.types_of_vehicles_serviced = types_of_vehicles_serviced;
     
    }
    
        public int getid() {
            return id;
        }
        
        public String gettypes_of_vehicles_serviced() {
            return types_of_vehicles_serviced;
        }        
}
