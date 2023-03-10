package br.com.projeto_listonic.tests;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.projeto_listonic.core.BaseTest;
import br.com.projeto_listonic.page.ItemPage;
import br.com.projeto_listonic.page.MinhaListaPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ListaComprasTeste extends BaseTest {

	private static final String NOME_LISTA = "Curso-Appium";
	private MinhaListaPage minhaListaPage = new MinhaListaPage();
	private ItemPage itemPage = new ItemPage();
	
	
	//Test Case 1 - Criar lista, adicionar itens e verificar se itens existem
	@Test
	public void test_01_deveCadastrarItensNaListaCompra() {

		adicionaUmaNovaLista();
		Assert.assertTrue(minhaListaPage.existeElementoPorTexto(NOME_LISTA));

		adicionarItemNaLista("farofa");
		Assert.assertTrue(itemPage.existeElementoPorTexto("farofa"));

		adicionarItemNaLista("carne");
		Assert.assertTrue(itemPage.existeElementoPorTexto("carne"));
		
		minhaListaPage.clicaBotaoRetornarLista();
		
		Assert.assertTrue(itemPage.existeElementoPorTexto("Curso-Appium"));
	}
	
	//Test Case 2 - Editar titulo de uma lista e verificar se foi alterado.
	@Test
	public void test_02_deveEditarTituloLista() {

		minhaListaPage.editaTituloLista("Curso-Appium","Curso-Appium-Edit");
		Assert.assertTrue(itemPage.existeElementoPorTexto("Curso-Appium-Edit"));
		
	}
	
	//Test Case 3 - Deletar lista de compras e verificar se ela foi removida
	@Test
	public void test_03_deveDeletarLista() {

		minhaListaPage.deletaLista("Curso-Appium-Edit");
		Assert.assertFalse(itemPage.existeElementoPorTexto("Curso-Appium-Edit"));
		
	}
	
	//Test Case 4 - Verifica se a lista que foi removida foi para a lixeira
	@Test
	public void test_04_deveVerificarNaLixeiraListaRemovida() {

		minhaListaPage.abreLixeira();
		Assert.assertTrue(itemPage.existeElementoPorTexto("Trash")); //verificando se ele realmente ta dentro da lixeira
		Assert.assertTrue(itemPage.existeElementoPorTexto("Curso-Appium-Edit")); //verificando se a lista que removemos anteriormente está na lixeira
		
	}

	private void adicionaUmaNovaLista() {
		minhaListaPage.criarNovaLista();
		minhaListaPage.escreverNomeLista(NOME_LISTA);
		minhaListaPage.adicionarNovaLista();
	}

	private void adicionarItemNaLista(String item) {
		itemPage.clicarNovoItem();
		itemPage.escreverNomeItem(item);
		itemPage.adicionarNovoItem();

	}

}
