package edu.jsu.mcis.cs310.coursedb.dao;

import java.sql.*;
import com.github.cliftonlabs.json_simple.*;
import java.util.ArrayList;

public class DAOUtility {
    
    public static final int TERMID_FA24 = 1;
    
    public static String getResultSetAsJson(ResultSet rs) {
        
        JsonArray records = new JsonArray();
        
        try {
        
            if (rs != null) {

                      //RESULTSETMETADATA
                ResultSetMetaData Mdata = rs.getMetaData();
                
                while (rs.next()) {
                
                    JsonObject Data = new JsonObject();
                    
                    //for loop
                    for (int i = 1; i <= Mdata.getColumnCount(); i++){
                        
                        String colName = Mdata.getColumnName(i);
                        Object colV = rs.getObject(i).toString();
                        
                        Data.put(colName, colV );
                    }
                //adding the records
                records.add(Data);


            }
            
        }
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return Jsoner.serialize(records);
        
    }
}
    
