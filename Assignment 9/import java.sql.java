import java.sql.*;

public class RestaurantCRUD {

    static final String URL = "jdbc:mysql://localhost:3306/RestaurantDB";
    static final String USER = "root";
    static final String PASSWORD = "your_password";

    public static void main(String[] args) {

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {

            System.out.println("Connected to database\n");

            // 1. Select Menu Items where price <= 100
            String query1 = "SELECT * FROM MenuItem WHERE Price <= 100";
            System.out.println("Menu Items with Price <= 100:");
            printResult(con, query1);

            // 2. Select Menu Items in "Cafe Java"
            String query2 = "SELECT m.* FROM MenuItem m " +
                    "JOIN Restaurant r ON m.ResId = r.Id " +
                    "WHERE r.Name = 'Cafe Java'";
            System.out.println("\nMenu Items in Cafe Java:");
            printResult(con, query2);

            // 3. Update price <= 100 to 200
            String updateQuery = "UPDATE MenuItem SET Price = 200 WHERE Price <= 100";
            int updated = con.createStatement().executeUpdate(updateQuery);
            System.out.println("\nUpdated Records Count: " + updated);

            System.out.println("\nAfter Update:");
            printResult(con, "SELECT * FROM MenuItem");

            // 4. Delete items starting with 'P'
            String deleteQuery = "DELETE FROM MenuItem WHERE Name LIKE 'P%'";
            int deleted = con.createStatement().executeUpdate(deleteQuery);
            System.out.println("\nDeleted Records Count: " + deleted);

            System.out.println("\nAfter Deletion:");
            printResult(con, "SELECT * FROM MenuItem");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to print ResultSet in tabular format
    public static void printResult(Connection con, String query) {
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            ResultSetMetaData meta = rs.getMetaData();
            int columns = meta.getColumnCount();

            // Print column names
            for (int i = 1; i <= columns; i++) {
                System.out.print(meta.getColumnName(i) + "\t\t");
            }
            System.out.println();

            // Print rows
            while (rs.next()) {
                for (int i = 1; i <= columns; i++) {
                    System.out.print(rs.getString(i) + "\t\t");
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}