package br.com.faturamento.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ManipulaArquivos {	
	
	/**
	 * Filtra pastas dentro de um diretorio, retorna List<String>
	 * 
	 * Recebe dois parametros:
	 * caminhoPasta --> ex: C:/contratos
	 * nomePasta:   --> ex: pastaPesquisa (nome da pasta onde estará os arquivos)
	 * OBS1: se a pasta é encontrada retorna a lista de String com caminho completo dos arquivos encontrados dentro da pasta
	 * OBS2: O caminho por exemplo C:/contratos, deve ser mapeado no (webconfig do Spring) para que o contexto do Spring reconheça
	 * Exemplo:
	 * C:/contratos/8855/arquivo_8855-A.txt
	 * C:/contratos/8855/arquivo_8855-B.txt
	 * C:/contratos/8855/arquivo_8855-C.txt
	 *
	 * @author Balestra
	 * @param caminhoPasta
	 * @param nomePasta
	 * @return
	 * 
	 */
	public static List<String> listaArquivosPastaComFiltro(String caminhoPasta, String nomePasta){
		
	    List<String> listaArquivos = new ArrayList<>();
	
		if(nomePasta.trim().isEmpty()){
			System.out.println("Pasta não encontrada.");
			return listaArquivos;
		}
		
		
		File directory = new File(caminhoPasta);
	    //Obter todos arquivos de um diretorio
	    File[] fList = directory.listFiles();
	
	    String caminhoEncontrado = null;
	    
				
		if(!directory.exists()){
			System.out.println("diretorio não encontrado.");
			return listaArquivos;//returna lista vazia
		}
    
	    
	    for (File file : fList){
	        if (file.isDirectory()){
	        	
	        	if(file.getName().toLowerCase().contains(nomePasta.toLowerCase())){
	        		//System.out.println(file.getAbsolutePath());
	        		caminhoEncontrado = file.getAbsolutePath().replace("\\", "/") + "/";
	        	} 
	        } 
	    }
	    
	    File directory2 = new File(caminhoEncontrado);
	    File[] fList2 = directory2.listFiles();
	    for (File file2 : fList2){
	        if (file2.isFile()){
	        	//System.out.println(caminhoEncontrado + file2.getName());
	        	//listaArquivos.add(caminhoEncontrado + file2.getName()); caminho completo
	        	listaArquivos.add(file2.getName());//somente no dos arquivos
	        }
	    }
	    
	    return listaArquivos;
	    
	}    
	
	public static List<String> listaArquivosPastaComFiltro2(String caminhoPasta){
		
	    List<String> listaArquivos = new ArrayList<>();
	    
	    File directory2 = new File(caminhoPasta);
	    File[] fList2 = directory2.listFiles();
	    for (File file2 : fList2){
	        if (file2.isFile()){
	        	//System.out.println(caminhoEncontrado + file2.getName());
	        	//listaArquivos.add(caminhoEncontrado + file2.getName()); caminho completo
	        	listaArquivos.add(file2.getName());//somente no dos arquivos
	        }
	    }
	    
	    return listaArquivos;
	    
	}
	
	
	public static JSONArray listaArquivosPastaComFiltro2JSON(String caminhoPasta, String nomePasta) throws JSONException{
		
		List<String> listaArquivos = listaArquivosPastaComFiltro2(caminhoPasta);
										
		JSONObject jsonAux = null;
        JSONArray jsonArray = null;        
        	
        jsonArray = new JSONArray();        
        
        int c = 0;
        for (String arquivo : listaArquivos){        
        	
        	jsonAux = null;   	
        	jsonAux = new JSONObject();
        	
                   	
        	jsonAux.put("arquivo", arquivo);
        	jsonArray.put(c, jsonAux);
        	c++;
        	
        }
        
		return jsonArray;
 		
	}	
	
}
