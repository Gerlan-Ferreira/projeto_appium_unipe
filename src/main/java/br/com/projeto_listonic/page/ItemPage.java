package br.com.projeto_listonic.page;

import static br.com.projeto_listonic.core.DriverFactory.getDriver;

import br.com.projeto_listonic.core.BasePage;
import io.appium.java_client.MobileBy;

public class ItemPage extends BasePage {

	public boolean verificarNomeDaLista(String nomeLista) {
		
		return existeElementoPorTexto(nomeLista);
		
	}
	
	public void clicarNovoItem() {
		clicarPorId("com.l:id/shopping_list_fab");
	}
	
	public void escreverNomeItem(String nomeItem) {		
		
	    getDriver().hideKeyboard();
	    escrever(MobileBy.id("com.l:id/expandable_search_ed"),nomeItem);
	    
	}
	
	public void adicionarNovoItem() {
		clicarPorId("com.l:id/add_product_fab");
	}
	
}
