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
public class operate {

    private int id = 0;
    private String name_of_outlet = "";
    private String name_of_service_provider = "";
    private String owns_a_smartphone = "";
    private long phone_number = 0;
    private long alternate_phone_number = 0;    
    private String location = "";
    private String opening_time = "";
    private String closing_time = "";
    private String outlet_established_in = "";
    //images blob thing
    
    public operate(int iD, String name_of_outlet, String name_of_service_provider, String owns_a_smartphone,long phone_number, long alternate_phone_number,String location,String opening_time, String closing_time, String outlet_established_in )
    {
        this.id = iD;
        this.name_of_outlet = name_of_outlet;
        this.name_of_service_provider = name_of_service_provider;
        this.owns_a_smartphone = owns_a_smartphone;
        this.phone_number = phone_number;
        this.alternate_phone_number = alternate_phone_number;
        this.location = location;
        this.opening_time = opening_time;
        this.closing_time = closing_time;
        this.outlet_established_in = outlet_established_in;
    }  

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String getname_of_outlet() {
        return name_of_outlet;
    }

    public void setname_of_outlet(String name_of_outlet) {
        this.name_of_outlet = name_of_outlet;
    }

    public String getname_of_service_provider() {
        return name_of_service_provider;
    }

    public void setname_of_service_provider(String name_of_service_provider) {
        this.name_of_service_provider = name_of_service_provider;
    }

    public String getowns_a_smartphone() {
        return owns_a_smartphone;
    }

    public void setowns_a_smartphone(String owns_a_smartphone) {
        this.owns_a_smartphone = owns_a_smartphone;
    }

    public long getphone_number() {
        return phone_number;
    }

    public void setphone_number(long phone_number) {
        this.phone_number = phone_number;
    }

    public double getalternate_phone_number() {
        return alternate_phone_number;
    }

    public void setalternate_phone_number(long alternate_phone_number) {
        this.alternate_phone_number = alternate_phone_number;
    }
    
    public String getlocation() {
        return location;
    }
    
    public void setlocation(String location) {
        this.location = location;
    }
    
    public String getopening_time() {
        return opening_time;
    }
    
    public void setopening_time(String opening_time) {
        this.opening_time = opening_time;
    }
    
    public String getclosing_time() {
        return closing_time;
    } 
    
    public void setclosing_time(String closing_time) {
        this.closing_time = closing_time;
    }    

    public String getoutlet_established_in() {
        return outlet_established_in;
    } 
    
    public void setoutlet_established_in(String outlet_established_in) {
        this.outlet_established_in = outlet_established_in;
    }
    
    
 
}
