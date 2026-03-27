package adm;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import delivers.OrderService;

public class DB_management {

	private static final String URL =
			"jdbc:mysql://localhost:3306/Big_Seller";
	private static final String User = "root";
	private static final String Password = "123456789123456789";


	public static Connection conectar() {

		try {
			Connection conn = DriverManager.getConnection(
					URL,User,Password
				);

			//System.out.println("Conectado com sucesso!!");

			return conn;
		}catch(SQLException e) {
			throw new RuntimeException("Error on connection" , e);
		}
	}
	public static void createTable() {


	String table = """
			 CREATE TABLE IF NOT EXISTS usuario(
			 id INT AUTO_INCREMENT PRIMARY KEY,
			 name VARCHAR(100) NOT NULL,
			 email VARCHAR(100) UNIQUE NOT NULL,
			 password VARCHAR(225) NOT NULL,
			 cellphone VARCHAR(20)UNIQUE NOT NULL,
			 created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP)
			""";

	try(Connection conn = DB_management.conectar();
		PreparedStatement ps = conn.prepareStatement(table);
		){
		ps.executeUpdate();
		System.out.println("Table user created successfully!");

	}catch(SQLException e) {
		throw new RuntimeException ("Error creating table", e);
}}

public static String select(String name) {

	String sql = "SELECT name FROM usuario WHERE name = ?";

			try(

					Connection conn = DB_management.conectar();
					PreparedStatement ps = conn.prepareStatement(sql);
					){
				ps.setString(1,name);
				ResultSet rs = ps.executeQuery();

				if(rs.next()) {
					return rs.getString("name");
				}

				return null;

				}catch(SQLException e) {
					throw new RuntimeException(e);
				}
}

public static String searchfield(
		String coluna,
		Integer id

		){

	String sql = "SELECT " + coluna + " FROM usuario WHERE id = ?";

	try(
			Connection conn = DB_management.conectar();
			PreparedStatement ps = conn.prepareStatement(sql)
		){
		ps.setInt(1, id);
		try (ResultSet rs = ps.executeQuery()){

			if(rs.next()) {
				return rs.getString(coluna);
			}
		}
		return null;
	}catch(SQLException e) {
		throw new RuntimeException(e);
	}
}

public static Integer searchLastId() {

	String sql = "SELECT MAX(id) as last_id FROM usuario";

	try(

			Connection conn = DB_management.conectar();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery()

			){
		if(rs.next()) {
			return rs.getInt("last_id");
		}
		return null;
	}catch(SQLException e) {
		throw new RuntimeException(e);
	}
}


public static void saveToken(int userId, String token, Timestamp expiresAt) {
    String sql = """
        INSERT INTO login_token (user_id, token, expires_at)
        VALUES (?, ?, ?)
        """;
    try (
    		Connection conn = DB_management.conectar();
    		PreparedStatement ps = conn.prepareStatement(sql)
    				) {
        ps.setInt(1, userId);
        ps.setString(2, token);
        ps.setTimestamp(3, expiresAt);
        ps.executeUpdate();
    } catch (SQLException e) {
        throw new RuntimeException("Error saving token", e);
    }
}


public static boolean isTokenValid(String token) {
    String sql = """
        SELECT 1
        FROM login_token
        WHERE token = ?
          AND expires_at > CURRENT_TIMESTAMP
        """;

    try (	Connection conn = DB_management.conectar();
    		PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, token);
        ResultSet rs = ps.executeQuery();
        return rs.next();
    } catch (SQLException e) {
        throw new RuntimeException("Error validating token", e);
    }
}
public static Integer getUserIdByToken(String token) {
    String sql = """
        SELECT user_id
        FROM login_token
        WHERE token = ?
          AND expires_at > CURRENT_TIMESTAMP
        """;

    try (	Connection conn = DB_management.conectar();
    		PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, token);
        ResultSet rs = ps.executeQuery();
        return rs.next() ? rs.getInt("user_id") : null;
    } catch (SQLException e) {
        throw new RuntimeException(e);}
    }


    public static Integer getUserIdByEmail(String email) {
        String sql = """
            SELECT id
            FROM usuario
            WHERE email = ?
            """;

        try (	Connection conn = DB_management.conectar();
        		PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            return rs.next() ? rs.getInt("id") : null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void insertuser(String fullname,String email,String password,Integer cellphone) {


    	String sql = String.format("INSERT INTO usuario(name,email,password,cellphone) VALUES (?,?,?,?)");

    	try(Connection conn = DB_management.conectar();
    		PreparedStatement ps = conn.prepareStatement(sql)){
    		ps.setString(1, fullname);
    		ps.setString(2, email);
    		ps.setString(3, password);
    		ps.setInt(4, cellphone);
    		ps.execute();
    		System.out.println("Insert user successfully!");
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}

    }

    public static String selectname(Integer id) {

    	String sql = "SELECT name FROM usuario WHERE id = ?";
    	try(

				Connection conn = DB_management.conectar();
				PreparedStatement ps = conn.prepareStatement(sql);
				){
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				return rs.getString("name");
			}

			return null;

			}catch(SQLException e) {
				throw new RuntimeException(e);
			}
    }
    public static void ProductTable() {


    	String table = """
    			 CREATE TABLE IF NOT EXISTS usuario(
    			 id INT AUTO_INCREMENT PRIMARY KEY,
    			 name VARCHAR(100) NOT NULL,
    			 email VARCHAR(100) UNIQUE NOT NULL,
    			 password VARCHAR(225) NOT NULL,
    			 cellphone VARCHAR(20)UNIQUE NOT NULL,
    			 created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP)
    			""";

    	try(Connection conn = DB_management.conectar();
    		PreparedStatement ps = conn.prepareStatement(table);
    		){
    		ps.executeUpdate();
    		System.out.println("Table user created successfully!");

    	}catch(SQLException e) {
    		throw new RuntimeException ("Error creating table", e);
    }}
    public static void Category() {


    	String table = """
    			 CREATE TABLE IF NOT EXISTS Category(
    			 id INT AUTO_INCREMENT PRIMARY KEY,
    			 name VARCHAR(100) NOT NULL)
    			""";

    	try(Connection conn = DB_management.conectar();
    		PreparedStatement ps = conn.prepareStatement(table);
    		){
    		ps.executeUpdate();
    		System.out.println("Table user created successfully!");

    	}catch(SQLException e) {
    		throw new RuntimeException ("Error creating table", e);
    }}
 public static void InsertCategory() {
    	Scanner sc = new Scanner(System.in);

    	String table = """
    			INSERT INTO category(name) VALUES (?)
    			 """;

    	try(Connection conn = DB_management.conectar();
    		PreparedStatement ps = conn.prepareStatement(table);
    		)
    	{
    		System.out.println("Insert a new category: ");
    		String category = sc.nextLine();
    		ps.setString(1, category);
    		ps.executeUpdate();
    		System.out.println("Category Inserted Successfully");

    	}catch(SQLException e) {
    		throw new RuntimeException ("Error creating table", e);
    }}
 public static void ListCategory() {


 	String table = """
 			SELECT * FROM category
 			 """;

 	try(Connection conn = DB_management.conectar();
 		PreparedStatement ps = conn.prepareStatement(table);
 		){	ResultSet rs =ps.executeQuery(table);
 		while(rs.next()) {
 			int id = rs.getInt("Id");
 			String name = rs.getString("name");
 			System.out.println("ID: " + id + " | Name: " + name);
 		}


 		System.out.println("Category Listed successfully");

 	}catch(SQLException e) {
 		throw new RuntimeException ("Error listing category", e);
 }}

 public static void CreateTableSectiontTec() {


 	String table = """
 			 CREATE TABLE IF NOT EXISTS Technology_Products(
 			 id INT AUTO_INCREMENT PRIMARY KEY,
 			 Product_name VARCHAR(100) NOT NULL,
 			 Mark VARCHAR(100) NOT NULL,
 			 Price DECIMAL(10,2) NOT NULL,
 			 Weight DECIMAL(10,2) NOT NULL,
 			 QuantityStock SMALLINT NOT NULL,
 			 Type VARCHAR(100) NOT NULL,
 			 Description VARCHAR(300) NOT NULL,
 			 TimeStock TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
 			 Conection_type VARCHAR(100),
 			 volts INT,
 			 Category_id INT,
 			 FOREIGN KEY (Category_id) REFERENCES Category(id))
 			""";

 	try(Connection conn = DB_management.conectar();
 		PreparedStatement ps = conn.prepareStatement(table);
 		){
 		ps.executeUpdate();
 		System.out.println("Table Technology created successfully!");

 	}catch(SQLException e) {
 		throw new RuntimeException ("Error creating table", e);
 }}

 public static void InsertTec() {
	 	Scanner sc = new Scanner(System.in);

	 	String table = """
	 			 INSERT INTO technology_products(Product_name,Mark,Price,Weight,QuantityStock,Type,Description,Conection_type,volts,Category_id) VALUES (?,?,?,?,?,?,?,?,?,?)
	 			""";

	 	try(Connection conn = DB_management.conectar();
	 		PreparedStatement ps = conn.prepareStatement(table);
	 		){

	 		Locale eua = Locale.US;
	 		System.out.println("Product Name: ");
	 		String product_name = sc.nextLine();
	 		System.out.println("Product Mark: ");
	 		String mark = sc.nextLine();
	 		System.out.println("Product Price: ");
	 		BigDecimal price = sc.nextBigDecimal();
	 		System.out.println("Product Weight: ");
	 		BigDecimal weight = sc.nextBigDecimal();
	 		System.out.println("QuantityStock: ");
	 		int QuantityStock = sc.nextInt();
	 		sc.nextLine();
	 		System.out.println("Type: ");
	 		String type = sc.nextLine();
	 		System.out.println("Description: ");
	 		//sc.nextLine();
	 		String Description = sc.nextLine();
	 		//sc.nextLine();
	 		System.out.println("Conection type: ");
	 		String connectiontype = sc.nextLine();
	 		System.out.println("Volts: ");
	 		int volts = sc.nextInt();
	 		System.out.println("Category_id: ");
	 		int category = sc.nextInt();




	 		ps.setString(1, product_name);
	 		ps.setString(2, mark);
	 		ps.setBigDecimal(3, price);
	 		ps.setBigDecimal(4, weight);
	 		ps.setInt(5, QuantityStock);
	 		ps.setString(6,type);
	 		ps.setString(7,Description);
	 		ps.setString(8, connectiontype);
	 		ps.setInt(9, volts);
	 		ps.setInt(10, category);




    		ps.executeUpdate();
	 		System.out.println("Table Technology Inserted successfully!");

	 	}catch(SQLException e) {
	 		throw new RuntimeException ("Error Inserting table", e);
	 }}

 public static void CreateTableSectionTools() {


	 	String table = """
	 			 CREATE TABLE IF NOT EXISTS Tools_Products(
	 			 id INT AUTO_INCREMENT PRIMARY KEY,
	 			 Product_name VARCHAR(100) NOT NULL,
	 			 Mark VARCHAR(100) NOT NULL,
	 			 Price DECIMAL(10,2) NOT NULL,
	 			 Weight DECIMAL(10,2) NOT NULL,
	 			 QuantityStock SMALLINT NOT NULL,
	 			 Type VARCHAR(100) NOT NULL,
	 			 Description VARCHAR(300) NOT NULL,
	 			 TimeStock TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	 			 Material_type VARCHAR(100),
	 			 Eletrical BOOLEAN,
	 			 Wats INT,
	 			 Ergonomic BOOLEAN,
	 			 Category_id INT,
	 			 FOREIGN KEY (Category_id) REFERENCES Category(id))
	 			""";

	 	try(Connection conn = DB_management.conectar();
	 		PreparedStatement ps = conn.prepareStatement(table);
	 		){

	 		ps.executeUpdate();
	 		System.out.println("Table Tools Created successfully!");

	 	}catch(SQLException e) {
	 		throw new RuntimeException ("Error creating table", e);
	 }}

 public static void InsertTools() {

	    String table = """
	        INSERT INTO tools_products(
	            Product_name, Mark, Price, Weight, QuantityStock, Type,
	            Description, Material_type, Eletrical, Wats, Ergonomic, Category_id
	        ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)
	    """;

	    try (Connection conn = DB_management.conectar();
	         PreparedStatement ps = conn.prepareStatement(table)) {

	        Scanner sc = new Scanner(System.in);
	        Locale eua = Locale.US;

	        System.out.println("Product Name: ");
	        String product_name = sc.nextLine();

	        System.out.println("Product Mark: ");
	        String mark = sc.nextLine();

	        System.out.println("Product Price: ");
	        BigDecimal price = sc.nextBigDecimal();

	        System.out.println("Product Weight: ");
	        BigDecimal weight = sc.nextBigDecimal();

	        System.out.println("QuantityStock: ");
	        int QuantityStock = sc.nextInt();
	        sc.nextLine(); // limpar buffer

	        System.out.println("Type: ");
	        String type = sc.nextLine();

	        System.out.println("Description: ");
	        String Description = sc.nextLine();

	        System.out.println("Material_type: ");
	        String Material_type = sc.nextLine();

	        System.out.println("Eletrical (true/false): ");
	        boolean Eletrical = sc.nextBoolean();

	        System.out.println("Wats: ");
	        int wats = sc.nextInt();

	        System.out.println("Ergonomic (true/false): ");
	        boolean Ergonomic = sc.nextBoolean();

	        System.out.println("Category_id: ");
	        int category = sc.nextInt();

	        // Configurar PreparedStatement
	        ps.setString(1, product_name);
	        ps.setString(2, mark);
	        ps.setBigDecimal(3, price);
	        ps.setBigDecimal(4, weight);
	        ps.setInt(5, QuantityStock);
	        ps.setString(6, type);
	        ps.setString(7, Description);
	        ps.setString(8, Material_type);
	        ps.setBoolean(9, Eletrical);
	        ps.setInt(10, wats);
	        ps.setBoolean(11, Ergonomic);
	        ps.setInt(12, category);

	        ps.executeUpdate();
	        System.out.println("Table Tools Insert successfully!");

	    } catch (SQLException e) {
	        throw new RuntimeException("Error Inserting table", e);
	    }
	}










 public static void CreateTableSectionPharmacy() {


	 	String table = """
	 			 CREATE TABLE IF NOT EXISTS Pharmacy_products(
	 			 id INT AUTO_INCREMENT PRIMARY KEY,
	 			 Product_name VARCHAR(100) NOT NULL,
	 			 Mark VARCHAR(100) NOT NULL,
	 			 Price DECIMAL(10,2) NOT NULL,
	 			 Weight DECIMAL(10,2) NOT NULL,
	 			 QuantityStock SMALLINT NOT NULL,
	 			 Type VARCHAR(100) NOT NULL,
	 			 Description VARCHAR(300) NOT NULL,
	 			 TimeStock TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	 			 pills INT,
	 			 expiration_date_ DATE,
	 			 Indication VARCHAR(100),
	 			 Contraindication VARCHAR(100),
	 			 Category_id INT,
	 			 FOREIGN KEY (Category_id) REFERENCES Category(id))
	 			""";

	 	try(Connection conn = DB_management.conectar();
	 		PreparedStatement ps = conn.prepareStatement(table);
	 		){

	 		ps.executeUpdate();
	 		System.out.println("Table Pharmacy Created successfully!");

	 	}catch(SQLException e) {
	 		throw new RuntimeException ("Error creating table", e);
	 }}

 public static void InsertPharmacy() {


	 	String table = """

	 			 INSERT INTO Pharmacy_products(Product_name,Mark,Price,Weight,QuantityStock,Type,Description,pills,expiration_date_,Indication,Contraindication,Category_id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)
	 			""";

	 	try(Connection conn = DB_management.conectar();
	 		PreparedStatement ps = conn.prepareStatement(table);
	 		){

	 		Scanner sc = new Scanner(System.in);

	 		Locale eua = Locale.US;
	 		System.out.println("Product Name: ");
	 		String product_name = sc.nextLine();
	 		System.out.println("Product Mark: ");
	 		String mark = sc.nextLine();
	 		System.out.println("Product Price: ");
	 		BigDecimal price = sc.nextBigDecimal();
	 		System.out.println("Product Weight: ");
	 		BigDecimal weight = sc.nextBigDecimal();
	 		System.out.println("QuantityStock: ");
	 		int QuantityStock = sc.nextInt();
	 		sc.nextLine();
	 		System.out.println("Type: ");
	 		String type = sc.nextLine();
	 		System.out.println("Description: ");
	 		String Description = sc.nextLine();
	 		System.out.println("pills: ");
	 		int pills = sc.nextInt();
	 		sc.nextLine();
	 		System.out.println("Expiration_date_ |YYYY/MM/DD| : ");
	 		String Expiration_date = sc.nextLine().trim();
	 		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	 		LocalDate data = LocalDate.parse(Expiration_date,formatter);

	 		System.out.println("Indication: ");
	 		String Indication = sc.nextLine();
	 		System.out.println("Contraindication: ");
	 		String Contraindication = sc.nextLine();
	 		System.out.println("Category_id: ");
	 		int category = sc.nextInt();




	 		ps.setString(1, product_name);
	 		ps.setString(2, mark);
	 		ps.setBigDecimal(3, price);
	 		ps.setBigDecimal(4, weight);
	 		ps.setInt(5, QuantityStock);
	 		ps.setString(6,type);
	 		ps.setString(7,Description);
	 		ps.setInt(8, pills);
	 		ps.setObject(9,data);
	 		ps.setString(10,Indication);
	 		ps.setString(11,Contraindication);
	 		ps.setInt(12, category);

	 		ps.executeUpdate();
	 		System.out.println("Table Pharmacy Insert successfully!");

	 	}catch(SQLException e) {
	 		throw new RuntimeException ("Error Inserting table", e);
	 }}
 public static void CreateTableSectionMusic() {


	 	String table = """
	 			 CREATE TABLE IF NOT EXISTS Music_products(
	 			 id INT AUTO_INCREMENT PRIMARY KEY,
	 			 Product_name VARCHAR(100) NOT NULL,
	 			 Mark VARCHAR(100) NOT NULL,
	 			 Price DECIMAL(10,2) NOT NULL,
	 			 Weight DECIMAL(10,2) NOT NULL,
	 			 QuantityStock SMALLINT NOT NULL,
	 			 Type VARCHAR(100) NOT NULL,
	 			 Description VARCHAR(300) NOT NULL,
	 			 TimeStock TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	 			 color VARCHAR(100),
	 			 Eletrical BOOLEAN,
	 			 strings INT,
	 			 Category_id INT,
	 			 FOREIGN KEY (Category_id) REFERENCES Category(id))
	 			""";

	 	try(Connection conn = DB_management.conectar();
	 		PreparedStatement ps = conn.prepareStatement(table);
	 		){

	 		ps.executeUpdate();
	 		System.out.println("Table Music Created successfully!");

	 	}catch(SQLException e) {
	 		throw new RuntimeException ("Error creating table", e);
	 }}
 public static void InsertMusic() {


	 	String table = """

	 			 INSERT INTO Music_products(Product_name,Mark,Price,Weight,QuantityStock,Type,Description,color,Eletrical,Strings,Category_id) VALUES (?,?,?,?,?,?,?,?,?,?,?)
	 			""";

	 	try(Connection conn = DB_management.conectar();
	 		PreparedStatement ps = conn.prepareStatement(table);
	 		){

	 		Scanner sc = new Scanner(System.in);

	 		Locale eua = Locale.US;
	 		System.out.println("Product Name: ");
	 		String product_name = sc.nextLine();
	 		System.out.println("Product Mark: ");
	 		String mark = sc.nextLine();
	 		System.out.println("Product Price: ");
	 		BigDecimal price = sc.nextBigDecimal();
	 		System.out.println("Product Weight: ");
	 		BigDecimal weight = sc.nextBigDecimal();
	 		System.out.println("QuantityStock: ");
	 		int QuantityStock = sc.nextInt();
	 		sc.nextLine();
	 		System.out.println("Type: ");
	 		String type = sc.nextLine();
	 		System.out.println("Description: ");
	 		String Description = sc.nextLine();
	 		System.out.println("color: ");
	 		String color = sc.nextLine();
	 		System.out.println("Eletrical: ");
	 		boolean eletrical = sc.nextBoolean();
	 		System.out.println("Strings: ");
	 		int Strings = sc.nextInt();
	 		System.out.println("Category_id: ");
	 		int category = sc.nextInt();




	 		ps.setString(1, product_name);
	 		ps.setString(2, mark);
	 		ps.setBigDecimal(3, price);
	 		ps.setBigDecimal(4, weight);
	 		ps.setInt(5, QuantityStock);
	 		ps.setString(6,type);
	 		ps.setString(7,Description);
	 		ps.setString(8, color);
	 		ps.setBoolean(9,eletrical);
	 		ps.setInt(10,Strings);
	 		ps.setInt(11, category);

	 		ps.executeUpdate();
	 		System.out.println("Table Music Insert successfully!");

	 	}catch(SQLException e) {
	 		throw new RuntimeException ("Error Inserting table", e);
	 }}
 public static void CreateTableSectionFitness() {


	 	String table = """
	 			 CREATE TABLE IF NOT EXISTS	Fitness_products(
	 			 id INT AUTO_INCREMENT PRIMARY KEY,
	 			 Product_name VARCHAR(100) NOT NULL,
	 			 Mark VARCHAR(100) NOT NULL,
	 			 Price DECIMAL(10,2) NOT NULL,
	 			 Weight DECIMAL(10,2) NOT NULL,
	 			 QuantityStock SMALLINT NOT NULL,
	 			 Type VARCHAR(100) NOT NULL,
	 			 Description VARCHAR(300) NOT NULL,
	 			 TimeStock TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	 			 muscle_activation VARCHAR(100),
	 			 Eletrical BOOLEAN,
	 			 Category_id INT,
	 			 FOREIGN KEY (Category_id) REFERENCES Category(id))
	 			""";

	 	try(Connection conn = DB_management.conectar();
	 		PreparedStatement ps = conn.prepareStatement(table);
	 		){

	 		ps.executeUpdate();
	 		System.out.println("Table Music Created successfully!");

	 	}catch(SQLException e) {
	 		throw new RuntimeException ("Error creating table", e);
	 }}
 public static void InsertFitness() {


	 	String table = """

	 			 INSERT INTO fitness_products(Product_name,Mark,Price,Weight,QuantityStock,Type,Description,muscle_activation,Eletrical,Category_id) VALUES (?,?,?,?,?,?,?,?,?,?)
	 			""";

	 	try(Connection conn = DB_management.conectar();
	 		PreparedStatement ps = conn.prepareStatement(table);
	 		){

	 		Scanner sc = new Scanner(System.in);

	 		Locale eua = Locale.US;
	 		System.out.println("Product Name: ");
	 		String product_name = sc.nextLine();
	 		System.out.println("Product Mark: ");
	 		String mark = sc.nextLine();
	 		System.out.println("Product Price: ");
	 		BigDecimal price = sc.nextBigDecimal();
	 		System.out.println("Product Weight: ");
	 		BigDecimal weight = sc.nextBigDecimal();
	 		System.out.println("QuantityStock: ");
	 		int QuantityStock = sc.nextInt();
	 		sc.nextLine();
	 		System.out.println("Type: ");
	 		String type = sc.nextLine();
	 		System.out.println("Description: ");
	 		String Description = sc.nextLine();
	 		System.out.println("muscle_activation: ");
	 		String muscle = sc.nextLine();
	 		System.out.println("Eletrical: ");
	 		boolean eletrical = sc.nextBoolean();
	 		System.out.println("Category_id: ");
	 		int category = sc.nextInt();




	 		ps.setString(1, product_name);
	 		ps.setString(2, mark);
	 		ps.setBigDecimal(3, price);
	 		ps.setBigDecimal(4, weight);
	 		ps.setInt(5, QuantityStock);
	 		ps.setString(6,type);
	 		ps.setString(7,Description);
	 		ps.setString(8, muscle);
	 		ps.setBoolean(9,eletrical);
	 		ps.setInt(10, category);

	 		ps.executeUpdate();
	 		System.out.println("Table Fitness Insert successfully!");

	 	}catch(SQLException e) {
	 		throw new RuntimeException ("Error Inserting table", e);
	 }}
 	public static void createTableOrder() {


		String table = """
				 CREATE TABLE IF NOT EXISTS Orders(
				 id INT AUTO_INCREMENT PRIMARY KEY,
				 user_id INT NOT NULL,
				 State VARCHAR(100) NOT NULL,
				 cpf VARCHAR(100)NOT NULL,
				 created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
				 FOREIGN KEY (user_id) REFERENCES usuario(id)
				 );
				""";

		try(Connection conn = DB_management.conectar();
			PreparedStatement ps = conn.prepareStatement(table);
			){
			ps.executeUpdate();
			System.out.println("Table order created successfully!");

		}catch(SQLException e) {
			throw new RuntimeException ("Error creating table", e);
	}}

	public static void createTableOrders_to_products() {


	String table = """

			 CREATE TABLE IF NOT EXISTS Orders_to_products(
			 orders_id INT NOT NULL,
			 product_id INT NOT NULL,
			 Category_id INT NOT NULL,
			 quantity INT NOT NULL,
			 cpf VARCHAR(100),
			 State VARCHAR(100) DEFAULT 'Requested',
			 totalweight DOUBLE NOT NULL,
			 totalprice DOUBLE NOT NULL,
			 PRIMARY KEY (orders_id,product_id,Category_id),
			 FOREIGN KEY (orders_id) REFERENCES Orders(id),
			 FOREIGN KEY (Category_id) REFERENCES Category(id)
			 )
			""";

	try(Connection conn = DB_management.conectar();
		PreparedStatement ps = conn.prepareStatement(table);
		){
		ps.executeUpdate();
		System.out.println("Table orders_to_products created successfully!");

	}catch(SQLException e) {
		throw new RuntimeException ("Error creating table", e);
}}


public static void selectTotal(int pedidoId) {

    String sql = "SELECT product_id, product_type, quantity, totalprice, totalweight FROM orders_to_products WHERE orders_id = ?";

    try(Connection conn = DB_management.conectar();
        PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setInt(1, pedidoId);

        ResultSet rs = ps.executeQuery();

        double totalPrice = 0;
        double totalWeight = 0;

        while(rs.next()) {

            int productId = rs.getInt("product_id");
            int productType = rs.getInt("product_type");
            int quantity = rs.getInt("quantity");
            double price = rs.getDouble("totalprice");
            double weight = rs.getDouble("totalweight");

            totalPrice += price;
            totalWeight += weight;

            System.out.println("Produto: " + productId +
                               " Tipo: " + productType +
                               " Quantidade: " + quantity);
        }

        System.out.println("Total do pedido: " + totalPrice);
        System.out.println("Peso total do pedido: " + totalWeight);

    } catch(SQLException e) {
        throw new RuntimeException("Erro ao buscar pedido", e);
    }
}

public static String selectSectionTec() {

	String sql = "SELECT id,Product_name,Mark,Price,Type,Description,Conection_type,volts FROM Technology_products";
	StringBuilder resultado = new StringBuilder();
			try(
					Connection conn = DB_management.conectar();
					PreparedStatement ps = conn.prepareStatement(sql);
					ResultSet rs = ps.executeQuery();
					){
				while(rs.next()) {
					int id = rs.getInt("id");
					String Product_name = rs.getString("Product_name");
					String Mark = rs.getString("Mark");
					Double Price = rs.getDouble("Price");
					String Type = rs.getString("Type");
					String Description = rs.getString("Description");
					String Conection_type = rs.getString("Conection_type");
					int volts = 1;
					volts = rs.getInt("volts");
			
					String linha =("Id "+ id + "| Product_name: " + Product_name + "| Mark: " + Mark + "| Price: " + Price + "| Type: " + Type
							+ "| Description: " +  Description + "| Conection_type: " + Conection_type + "| Volts: " + volts + "\n");
					System.out.println(linha);
					resultado.append(linha);
				}
				return null;

				}catch(SQLException e) {
					throw new RuntimeException(e);
				}
}

public static void SelectTools() {
	
	String sql = "SELECT id,Product_name,Mark,Price,Type,Description,Material_Type,Eletrical,Wats,Ergonomic FROM tools_products";
	StringBuilder resultado  = new StringBuilder();
	
	try(
			Connection conn = DB_management.conectar();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			){
		while(rs.next()) {
			int id = rs.getInt("id");
			String Product_name = rs.getString("Product_name");
			String Mark = rs.getString("Mark");
			Double Price = rs.getDouble("Price");
			String Type = rs.getString("Type");
			String Description = rs.getString("Description");
			String Material_Type = rs.getString("Material_Type");
			boolean Eletrical = rs.getBoolean("Eletrical");
			int Wats = rs.getInt("Wats");
			boolean Ergonomic = rs.getBoolean("Ergonomic");
			
			String linha =("Id "+ id + "| Product_name: " + Product_name + "| Mark: " + Mark + "| Price: " + Price + "| Type: " + Type
					+ "| Description: " +  Description + "| Material_Type: " + Material_Type + "| Eletrical: " + Eletrical + "| Wats: " + Wats
					+ "| Ergonomic: " + Ergonomic + " \n");
			System.out.println(linha);
			resultado.append(linha);
			
			
		}

	}catch(SQLException e) {
		throw new RuntimeException(e);
	}
}

public static void SelectPharmacy() {
	
	String sql = "SELECT id,Product_name,Mark,Price,Type,Description,pills,Indication,Contraindication FROM pharmacy_products";
	StringBuilder resultado = new StringBuilder();
	
	try(Connection conn = DB_management.conectar();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery()){
		while(rs.next()) {
			
			int id = rs.getInt("id");
			String Product_name = rs.getString("Product_name");
			String Mark = rs.getString("Mark");
			Double Price = rs.getDouble("Price");
			String Type = rs.getString("Type");
			String Description = rs.getString("Description");
			int pills = rs.getInt("pills");
			String Indication = rs.getString("Indication");
			String Contraindication = rs.getString("Contraindication");
			
			String linha =("Id "+ id + "| Product_name: " + Product_name + "| Mark: " + Mark + "| Price: " + Price + "| Type: " + Type
					+ "| Description: " +  Description + "| pills: " + pills + "| Indication: " + Indication + "| Contraindication: " + Contraindication
					+ " \n");
			
			
			System.out.println(linha);
			resultado.append(linha);
		}
		
	}catch(SQLException e) {
		throw new RuntimeException(e);
	}

	
}
public void selectfitnessproducts() {
	
	String sql = "SELECT id,Product_name,Mark,Price,Type,Description,muscle_activation,Eletrical FROM fitness_products";
	StringBuilder resultado = new StringBuilder();
	
	try(Connection conn = DB_management.conectar();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs =ps.executeQuery();
	){
	while(rs.next()) {
		
		int id = rs.getInt("id");
		String Product_name = rs.getString("Product_name");
		String Mark = rs.getString("Mark");
		Double Price = rs.getDouble("Price");
		String Type = rs.getString("Type");
		String Description = rs.getString("Description");
		String muscle_activation = rs.getString("muscle_activation");
		boolean Eletrical = rs.getBoolean("Eletrical");
		
		String linha =("Id "+ id + "| Product_name: " + Product_name + "| Mark: " + Mark + "| Price: " + Price + "| Type: " + Type
				+ "| Description: " +  Description + "| muscle_activation: " + muscle_activation + "| Eletrical: " + Eletrical + " \n");
		System.out.println(linha);
		resultado.append(linha);
	}
	
	}catch(SQLException e) {
		throw new RuntimeException(e);
	}
	
}
	
public static void selectmusic() {
	
	String sql = "SELECT id,Product_name,Mark,Price,Type,Description,color,Eletrical,strings FROM music_products";
	StringBuilder resultado = new StringBuilder();
	
	try(Connection conn = DB_management.conectar();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs =ps.executeQuery();){
		
		while(rs.next()) {
			
			int id = rs.getInt("id");
			String Product_name = rs.getString("Product_name");
			String Mark = rs.getString("Mark");
			Double Price = rs.getDouble("Price");
			String Type = rs.getString("Type");
			String Description = rs.getString("Description");
			String color = rs.getString("color");
			boolean Eletrical = rs.getBoolean("Eletrical");
			int strings = rs.getInt("strings");
			
			String linha =("Id "+ id + "| Product_name: " + Product_name + "| Mark: " + Mark + "| Price: " + Price + "| Type: " + Type
					+ "| Description: " +  Description + "| color: " + color + "| Eletrical: " + Eletrical + " |Strings: "+ strings + " \n");
			System.out.println(linha);
			resultado.append(linha);	
		}
	}catch(SQLException e) {
		throw new RuntimeException (e);
	}
}

public static void deleteProductCart(int orders_id,int product_id,int Category_id) {
	
	

	String sql = "DELETE FROM orders_to_products WHERE orders_id = ? AND product_id = ? AND Category_id = ?";
	
	try(Connection conn = DB_management.conectar();
			PreparedStatement ps = conn.prepareStatement(sql);
			){
		ps.setInt(1, orders_id);
		ps.setInt(2, product_id);
		ps.setInt(3, Category_id);
		
		int linhasDeletedas = ps.executeUpdate();
		System.out.println(linhasDeletedas + "linhas Deletedas.");
		
		}catch (SQLException e) {
		e.printStackTrace();
	}
}

public static void SelectProductCart(int orders_id,int product_id,int Category_id) {
	
	

	String sql = "SELECT * FROM orders_to_products WHERE orders_id = ? AND product_id = ? AND Category_id = ?";
	
	try(Connection conn = DB_management.conectar();
			PreparedStatement ps = conn.prepareStatement(sql);
			){
		ps.setInt(1, orders_id);
		ps.setInt(2, product_id);
		ps.setInt(3, Category_id);
		
		int linhasDeletedas = ps.executeUpdate();
		System.out.println(linhasDeletedas + "linhas Deletedas.");
		
		}catch (SQLException e) {
		e.printStackTrace();
	}
}
public static void InsertOrder(int user_id,String State,String cpf) {
	
	
	
	OrderService os = new OrderService();
	
	if(os.cpf_validation(cpf) == true) {

	String sql = "INSERT INTO orders (user_id,State,cpf) values(?,?,?)";
	
	try(Connection conn = DB_management.conectar();
			PreparedStatement ps = conn.prepareStatement(sql);
			){
		ps.setInt(1, user_id);
		ps.setString(2, State);
		ps.setString(3, cpf);
		
		int rowsInserted = ps.executeUpdate();
		  if (rowsInserted > 0) {
              System.out.println("Order inserted successfully!");
          }
		}catch (SQLException e) {
		e.printStackTrace();
	}
	}else {
		System.out.println("Invalid CPF");
	}
}

public static void	selectAllUsers() {
	
	StringBuilder resultado = new StringBuilder();
	


	String sql = "SELECT * FROM usuario";
	
	try(Connection conn = DB_management.conectar();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs =ps.executeQuery()){
	while(rs.next()) {
			
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String email = rs.getString("email");
			String cellphone = rs.getString("cellphone");
			
			String linha =("Id "+ id + "| name: " + name + "| email: " + email + "| cellphone: " + cellphone);
			System.out.println(linha);
			resultado.append(linha);	
		}
		
		
		}catch (SQLException e) {
		e.printStackTrace();
	}
	}


public static void SelectBuyngProduct(int category_id,int product_id,int quantity) {
	String category = null;
	switch(category_id) {
	case 1:
		category = "technology_products";
		break;
	case 2:
		category = "tools_products";
		break;
	case 3:
		category = "pharmacy_products";
		break;
	case 4:
		category = "fitness_products";
		break;
	case 5:
		category = "music_products";
		break;
	} 
	if(category == null){
        System.out.println("Invalid category");
        return;
    }
	

	String sql = "SELECT product_name,Price,Price * "+quantity+" AS total_price,Weight * " + quantity + " AS total_weight FROM " + category + " WHERE id = ? ";
	
	try(Connection conn = DB_management.conectar();
			PreparedStatement ps = conn.prepareStatement(sql);
			){
		ps.setInt(1, product_id);
		
		
		try(ResultSet rs = ps.executeQuery()){
		String product_name = null;
		Double total_price = null;
		Double Price = null;
		
		while(rs.next()){
			
			product_name = rs.getString("product_name");
			total_price = rs.getDouble("total_price");
			Price = rs.getDouble("Price");
			
			System.out.println(quantity + "X");
		}
		System.out.println("Product selected: " + product_name + "\n" + "Product price: " + Price + "\n" + "total_price: " + total_price);
		
		}}catch (SQLException e) {
		e.printStackTrace();
	}
}


public static void UpdateStockQuantity(int category_id,int product_id,int quantity) {
	String category = null;
	switch(category_id) {
	case 1:
		category = "technology_products";
		break;
	case 2:
		category = "tools_products";
		break;
	case 3:
		category = "pharmacy_products";
		break;
	case 4:
		category = "fitness_products";
		break;
	case 5:
		category = "music_products";
		break;
	} if(category == null){
        System.out.println("Invalid category");
        return;
    }
	

	String sql = "UPDATE " + category + " SET QuantityStock = QuantityStock - ? WHERE id = ?";
	
	try(Connection conn = DB_management.conectar();
			PreparedStatement ps = conn.prepareStatement(sql);
			){
		
		ps.setInt(1, quantity);
		ps.setInt(2, product_id);
		
		int linhasAfetadas = ps.executeUpdate();
		
		System.out.println(linhasAfetadas + " produto(s) atualizado(s) no estoque.");
		
		}catch (SQLException e) {
		e.printStackTrace();
	}
}



public static void selectIdOrder(int user) {
	
	

	String sql = "SELECT id FROM orders WHERE user_id = ?";
	
	try(Connection conn = DB_management.conectar();
			PreparedStatement ps = conn.prepareStatement(sql);
			){
		
		ps.setInt(1, user);
		ResultSet rs = ps.executeQuery();
		int id = 0;
		while(rs.next()) {
			
			id = rs.getInt("id");

		}
		System.out.println(id);
		
		}catch (SQLException e) {
		e.printStackTrace();
	}
}

public static Double SelectTotalPrice(int category_id,int product_id,int quantity) {

    String category = null;

    switch(category_id) {
        case 1: category = "technology_products"; break;
        case 2: category = "tools_products"; break;
        case 3: category = "pharmacy_products"; break;
        case 4: category = "fitness_products"; break;
        case 5: category = "music_products"; break;
    }

    if (category == null) {
        throw new IllegalArgumentException("Invalid category_id: " + category_id);
    }

    String sql = "SELECT Price * ? AS total_price FROM " + category + " WHERE id = ?";

    try(Connection conn = DB_management.conectar();
        PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setInt(1, quantity);
        ps.setInt(2, product_id);

        try(ResultSet rs = ps.executeQuery()) {

            if(rs.next()){
                return rs.getDouble("total_price");
            }

        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return null;
}


public static Double SelectTotalWeight(int category_id,int product_id,int quantity) {
	String category = null;
	switch(category_id) {
	case 1:
		category = "technology_products";
		break;
	case 2:
		category = "tools_products";
		break;
	case 3:
		category = "pharmacy_products";
		break;
	case 4:
		category = "fitness_products";
		break;
	case 5:
		category = "music_products";
		break;
	}if (category == null) {
	    throw new IllegalArgumentException("Invalid category_id: " + category_id);
	}
	
	Double totalweight = null;
	String sql = "SELECT Weight * " + quantity + " AS total_weight FROM " + category + " WHERE id = ? ";
	
	try(Connection conn = DB_management.conectar();
			PreparedStatement ps = conn.prepareStatement(sql);
			){
		ps.setInt(1, product_id);
		
		
		try(ResultSet rs = ps.executeQuery()){
		
		
		
		while(rs.next()){
			
			totalweight = rs.getDouble("total_weight");
			
		}
		
		
		}}catch (SQLException e) {
		e.printStackTrace();
	}
	return totalweight;
}
public static void insertIntoOrdersToProducts(int orders_id,int product_id,int Category_id, int quantity,String cpf,String state,Double totalweight,Double totalprice) {
	
	

	String sql = "INSERT INTO orders_to_products (orders_id,product_id,Category_id,quantity,cpf,State,totalweight,totalprice) VALUES (?,?,?,?,?,?,?,?)";
	
	try(Connection conn = DB_management.conectar();
			PreparedStatement ps = conn.prepareStatement(sql);
			){
		
		ps.setInt(1, orders_id);
		ps.setInt(2, product_id);
		ps.setInt(3, Category_id);
		ps.setInt(4, quantity);
		ps.setString(5, cpf);
		ps.setString(6, state);
		ps.setDouble(7, totalweight);
		ps.setDouble(8, totalprice);
		
		ps.executeUpdate();
		
		
		
		
		System.out.println("Cart has been created!");
		
		}catch (SQLException e) {
		e.printStackTrace();
	}}

}















