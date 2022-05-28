/*************************************************************************/
/* A Simple JDBC Program using Oracle Database and class IV JDBC driver  */                                      
/*************************************************************************/

import java.sql.*; 

class EmpList { 
  public static void main (String args []) 
      throws SQLException { 

    DriverManager.registerDriver (new Oracle.jdbc.driver.OracleDriver());

    String user, pass, query;
    user = "example";
    pass = "tiger";
    query = "select lname, fname from employees order by lname, fname";
    try {
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@Worf.radford.edu:1521:itec3",
                                                       user, pass);
        Statement stmt = conn.createStatement (); 
        ResultSet rset = stmt.executeQuery (query);
        while (rset.next ()) { 
            System.out.println(rset.getString("lname") + "  " + rset.getString("fname"));
        } 
        conn.close();
     }
     catch (SQLException e){System.out.println ("Could not load the db"+e); 
    }
  } 
} 
