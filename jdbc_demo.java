import java.sql.*;
public class jdbc_demo {

    
    public static void main(String[] args) throws SQLException {
       
        insertValues();
      
    }

    // To veiw the Table ----------------------------------------------------------------------------------

    public static void displayTable() throws SQLException {

        String url="jdbc:postgresql://localhost:5432/demo";
        String username="postgres";
        String password="GOWTHAM@123";

        String query="Select *from student_from";


        Connection connection=DriverManager.getConnection(url, username, password);
        Statement st=connection.createStatement(); 
        ResultSet rSet=st.executeQuery(query);

       while( rSet.next())
       {
        System.out.println("id : "+rSet.getInt(1));
        System.out.println("Name : "+rSet.getString(2));
        System.out.println("Age : "+rSet.getString(3));
        System.out.println("************************************************");
       }
        connection.close();
        
    }

    //To insert Values ------------------------------------------------------------------------------------------------

    public static void insertValues() throws SQLException {

        String url="jdbc:postgresql://localhost:5432/demo";
        String username="postgres";
        String password="GOWTHAM@123";

        int id=9;
        String name="Akash Raj";
        int age=19;

        String query="insert into student_from values(?,?,?);";


        Connection connection=DriverManager.getConnection(url, username, password);
        PreparedStatement st=connection.prepareStatement(query);
        
        st.setInt(3, age);
        st.setInt(1,id);
        st.setString(2, name);

        int  r=st.executeUpdate();

        System.out.println("Insert : "+r);
        connection.close();
    }

    // To delete Values -----------------------------------------------------------------------------------------

    public static void DeleteValues() throws SQLException {
        

        String url="jdbc:postgresql://localhost:5432/demo";
        String username="postgres";
        String password="GOWTHAM@123";

        int id=10;
        

        String query="delete from student_from where id ="+id;


        Connection connection=DriverManager.getConnection(url, username, password);
        Statement st=connection.createStatement();
    

        int  r=st.executeUpdate(query);

        System.out.println("Delete : "+r);
        connection.close();
    }

    // Stored Procedure -------------------------------------------------------------------------------

    public static void ProcedureDemo() throws SQLException {
        
        String url="jdbc:postgresql://localhost:5432/demo";
        String username="postgres";
        String password="GOWTHAM@123";
        
        String query = "call demo()";

        Connection connection=DriverManager.getConnection(url, username, password);  
        CallableStatement cs=connection.prepareCall(query);
        cs.executeUpdate();

        connection.close();
    }

    // to update -----------------------------------------------------------------------------------------------

    public static void ToUpdate() throws SQLException {
        
        String url="jdbc:postgresql://localhost:5432/demo";
        String username="postgres";
        String password="GOWTHAM@123";
        
        String query = "update table ";

        Connection connection=DriverManager.getConnection(url, username, password);  
        

        connection.close();
    }
}