package br.com.projeto_listonic.page;

import static br.com.projeto_listonic.core.DriverFactory.getDriver;

import br.com.projeto_listonic.core.BasePage;
import io.appium.java_client.MobileBy;

public class MinhaListaPage extends BasePage {

	public void criarNovaLista() {
		clicarPorId("com.l:id/list_of_list_fab");
	}
	
	public void escreverNomeLista(String nomeLista) {		
	
	    getDriver().hideKeyboard();
	    escrever(MobileBy.id("com.l:id/create_list_et"),nomeLista);
	    
	}
	
	public void adicionarNovaLista() {
		clicarPorXpath("//android.widget.Button[@text='CREATE']");
	}
	
	public void clicaBotaoRetornarLista() {
		
		clicarPorId("com.l:id/shopping_list_back");
	}
	
	public void editaTituloLista(String nomeListaExistente, String novoNomeLista) {
		
		clicarPorXpath("//*[@text='"+nomeListaExistente+"']/..//*[@class='android.widget.ImageView']"); //Clicar no menu de opções da lista existente
		
		clicarPorTexto("RENAME"); //Clicando no botão de editar da lista
		
		getDriver().hideKeyboard(); //fechando teclado
		escrever(MobileBy.id("com.l:id/edit_name_et"),novoNomeLista); //escrevendo o nome nome da lista
		
		clicarPorTexto("SAVE"); //salvando edição da lista
		
	}
	
	public void deletaLista(String nomeLista) {
		
		clicarPorXpath("//*[@text='"+nomeLista+"']/..//*[@class='android.widget.ImageView']"); //Clicar no menu de opções da lista existente
		
		clicarPorTexto("DELETE"); //Clicando no botão de editar da lista
		
	}
	
	public void abreLixeira() {
		
		clicarPorId("com.l:id/toolbar_home_iv"); //clicando no menu da barra lateral
		
		clicarPorTexto("Trash"); //clicando no icone da lixeira do menu lateral
		
	}
	
	
}
