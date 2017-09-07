package br.com.faturamento.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 
 * @author rpgricar
 *
 */
public class SqlServerConfig {
	
	/**
	 *  Códigos:
	 * 	1 - Navision
	 * 	2 - Lecom
	 * 	3 - Homologacao
	 * 	4 - Balestra Increase
	 * 	5 - Azure
	 */
	public static int BD_UTILIZADO = 5;	 
	
	/**
	 * Metodo realiza a conexão com o Banco de Dados
	 * 
	 * @return
	 * @throws Exception
	 */
	public static Connection getConnection(int codigoServidor) throws Exception {
		
		String driverClass = "";
	    String driverUser = "";
	    String driverPass = "";
	    String driverUrl = "";
		
		switch (codigoServidor) {
		case 1:			
			
			
			
		case 2:			
			
			
			
		case 3:			
			
			
			
		case 4:			
		
					
			
		case 5:			
			
		}
		
		Class.forName(driverClass);
        return DriverManager.getConnection(driverUrl, driverUser, driverPass);
    }

	/**
	 * 
	 * @param conn
	 * @param stmt
	 * @param rs
	 * @throws Exception
	 */
    public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) throws Exception {
        close(conn, stmt, rs);
    }

    /**
     * 
     * @param conn
     * @param stmt
     * @throws Exception
     */
    public static void closeConnection(Connection conn, Statement stmt) throws Exception {
        close(conn, stmt, null);
    }

    /**
     * 
     * @param conn
     * @throws Exception
     */
    public static void closeConnection(Connection conn) throws Exception {
        close(conn, null, null);
    }

    /**
     * 
     * @param conn
     * @param stmt
     * @param rs
     * @throws Exception
     */
    private static void close(Connection conn, Statement stmt, ResultSet rs) throws Exception {
    	if (rs != null) {
    		rs.close( );
    	}    	
        if (stmt != null) {
        	stmt.close( );
        }        
        if (conn != null) {
        	conn.close( );
        }        
    }

}
