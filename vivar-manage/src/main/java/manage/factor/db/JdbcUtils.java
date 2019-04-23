package manage.factor.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import manage.factor.dao.Product;

public class JdbcUtils {

	private String insertQuerySimple = "INSERT INTO product(id, name, description, price, idCompany) VALUES (?,?,?,?,?)";
	private String insertQueryFull   = "INSERT INTO product(id, name, description, price, idCompany, manufactureDate,"
			+ "expirationDate, maintainDate) VALUES (?,?,?,?,?,?,?,?)";
	private String selectQueryFull   = "SELECT * FROM product";
	private String insertQuery       = "INSERT IGNORE INTO Product(id, name, description, price, idCompany) SELECT Id, Name FROM Table1";
	private String selectQueryId     = "SELECT id FROM product";

	private String deleteQueryId     = "DELETE FROM product WHERE id = ?";
	private String updateQuery       = "UPDATE product SET name=?, description=?, price=?, idCompany=?, manufactureDate=?,"
			+ " expirationDate= ?, maintainDate= ? WHERE id = ?";

	
	/* . . . */
	private Connection connect() {
		String url = "jdbc:mysql://localhost/vivar";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, "root", "U!123abc");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return conn;
	}

	public void insertSimpleProduct(Product product) {
		
		//test duplicated id
		List<String> listIdCheck = new ArrayList<String>();
		listIdCheck = listId();
		String id = product.getId();
		
		for(int i=0; i < listIdCheck.size(); i++) {
			if(id.equals(listIdCheck.get(i))) {
				System.out.println("Duplicated ID");
				return;
			}
		}
		
		try {
			PreparedStatement pstmt = connect().prepareStatement(insertQuerySimple);

			pstmt.setString(1, product.getId());
			pstmt.setString(2, product.getName());
			pstmt.setString(3, product.getDescription());
			pstmt.setDouble(4, product.getPrice());
			pstmt.setInt(5, product.getIdCompany());

			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		} 
	}

	public void insertProdcut(Product product) {
		try {
			PreparedStatement pstmt = connect().prepareStatement(insertQueryFull);

			pstmt.setString(1, product.getId());
			pstmt.setString(2, product.getName());
			pstmt.setString(3, product.getDescription());
			pstmt.setDouble(4, product.getPrice());
			pstmt.setInt(5, product.getIdCompany());
			pstmt.setDate(6, product.getManufactureDate());
			pstmt.setDate(7, product.getExpirationDate());
			pstmt.setInt(8, product.getMaintainDate());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public List<Product> getAllProduct() {
		// List Product return.
		List<Product> listProduct = new ArrayList<Product>();
		
		try {
			
			PreparedStatement pstmt = connect().prepareStatement(selectQueryFull);
						
			//List Ob return when call query
			ResultSet result = pstmt.executeQuery();
			while(result.next()) {
				//Mapping
				Product product = new Product();
				
				product.setId(result.getString("id"));
				product.setName(result.getString("name"));
				product.setDescription(result.getString("description"));
				product.setPrice(result.getFloat("price"));
				product.setIdCompany(result.getInt("idCompany"));
				product.setManufactureDate(result.getDate("manufactureDate"));
				product.setExpirationDate(result.getDate("expirationDate"));
				product.setMaintainDate(result.getInt("maintainDate"));
				
				listProduct.add(product);
				product = null;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listProduct;
	}
	
	private List<String> listId(){
		List<String> listId = new ArrayList<String>();
		
		try {
			PreparedStatement pstmt = connect().prepareStatement(selectQueryId);
			ResultSet result = pstmt.executeQuery();
			while(result.next()) {
				listId.add(result.getString("id"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listId;
	}
	
	public boolean deleteProduct(String id) {
		
		try {
			PreparedStatement pstmt = connect().prepareStatement(deleteQueryId);

			pstmt.setString(1, id);
			
			int rowDelete = pstmt.executeUpdate();
			if(rowDelete > 0) {
				System.out.println("Delete successfully");
				return true;
			}else {
				System.out.println("Delete fairly");
				return false;
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public void updateProduct(Product product) {
		try {
			PreparedStatement pstmt = connect().prepareStatement(updateQuery);

			pstmt.setString(1, product.getName());
			pstmt.setString(2, product.getDescription());
			pstmt.setDouble(3, product.getPrice());
			pstmt.setInt(4, product.getIdCompany());
			pstmt.setDate(5, product.getManufactureDate());
			pstmt.setDate(6, product.getExpirationDate());
			pstmt.setInt(7, product.getMaintainDate());
			pstmt.setString(8, product.getId());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}
}
