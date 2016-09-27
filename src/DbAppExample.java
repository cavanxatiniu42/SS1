//import userlib.TextIO;
import wk3.db.DBApp;

public class DbAppExample {
  
  // application main method
  public static void main(String[] args) {
    // general tasks: preparation
    DBApp dba = null;
   dba = new DBApp(DBApp.DRIVER_POSTGRESQL);

    // connect to database
    String dbName = "postgres";
    String userName = "postgres";
    String password = "123456";
      boolean ok = dba.connect(dbName, userName, password);
//     = dba.connect("northwind");
    /** alternative: connect using specific username, password
     * (requires the updated library file)
    */

    if (!ok)
      System.exit(1);

    // application specific tasks
    try {

        TextIO.putln("Enter your query here:");
        String sql = TextIO.getlnString();
  //    String sql = "Select * from Customers";

      System.out.println("Executing query: " + sql);

      // execute SQL statement to get result
//        sql = "Insert" + getName()
      String result = dba.select(sql);

      //System.out.println(result);

      // write result to file
      String userDir = System.getProperty("user.dir");
      String fileChar = System.getProperty("file.separator");
      String file = userDir+fileChar+"sqloutput.html";
      
      // OR String file = "sqloutput.html"
      
      TextIO.writeFile(file);
      TextIO.putln("<b>Result for query:</b><br>" + sql);
      TextIO.putln("<p>");
      TextIO.putln(result);
      
      System.out.println("Written result to file " + file);
      
      TextIO.writeStandardOutput();
    } catch (Exception e) {
      e.printStackTrace();
    }

    // general tasks: close
    dba.close();
  }
}
