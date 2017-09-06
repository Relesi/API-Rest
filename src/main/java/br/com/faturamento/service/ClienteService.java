package br.com.faturamento.service;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.faturamento.config.SqlServerConfig;
import br.com.faturamento.domain.Cliente;
import br.com.faturamento.enums.CodigoSqlServerEnum;

public class ClienteService {

	private Connection conn;
	private PreparedStatement pstm;
	private ResultSet rs;

	public ClienteService() throws Exception {
		this.conn = SqlServerConfig.getConnection(CodigoSqlServerEnum.AZURE.getCodigo());
	}

	public List<Cliente> buscaCliente() throws Exception {

		Cliente cliente = new Cliente();

		List<Cliente> lista = new ArrayList<Cliente>();
		
		try {
			String sql = "SELECT [CUSTOMERGROUP], NULL as CLIENTE, [DIVISAO], [DISTRITO], [SETOR]\r\n" + 
					" FROM [MaquinaPadrao].[dbo].[vw_NAVISION_hierarquia_todas_empresas]";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {
				cliente = new Cliente();

				cliente.setCustomerGroup(rs.getString("CustomerGroup"));
				cliente.setCliente(rs.getString("Cliente"));
				cliente.setDivisao(rs.getString("Divisao"));
				cliente.setDistrito(rs.getString("Distrito"));
				cliente.setSetor(rs.getString("Setor"));
				lista.add(cliente);
			}

		} finally {
			SqlServerConfig.closeConnection(conn, pstm, rs);
		}

		return lista;
	}

}