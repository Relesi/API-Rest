package br.com.faturamento.enums;

/**
 * 
 * @author rpgricar
 *
 */
public enum CodigoSqlServerEnum {
	
	NAVISION(1),
	LECOM(2),
	HOMOLOGACAO(3),
	PRICEINCREASE(4),
	AZURE(5);
	
	private int codigo;
	
	/**
	 * Construtor
	 * @param codigo
	 */
	CodigoSqlServerEnum(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * Metodos Sets and Gets
	 */
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

}
