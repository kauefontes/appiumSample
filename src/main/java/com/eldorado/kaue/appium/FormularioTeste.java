package com.eldorado.kaue.appium;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import com.eldorado.kaue.appium.core.DSL;
import com.eldorado.kaue.appium.core.DriverFactory;

import io.appium.java_client.MobileBy;

public class FormularioTeste {
		
	private DSL dsl = new DSL();
	
	@Before
	public void inicializarAppium() throws MalformedURLException {
				
		//Selecionar formulario
		dsl.clicarPorTexto("Formulário");
	}
	
	@After
	public void tearDown() {
		DriverFactory.killDriver();
	}
	
	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {	 
	    //Escrever nome
		dsl.escrever(MobileBy.AccessibilityId("nome"), "Kaue");
	    
	    //checar nome escrito
	    assertEquals("Kaue", dsl.obterTexto(MobileBy.AccessibilityId("nome")));
	}
	
	@Test
	public void deveInteragirComCombo() throws MalformedURLException {
		//clicar no combo
		dsl.selecionarCombo(MobileBy.AccessibilityId("console"), "PS4");
		
		//verificar a opcao selecionada
		String text = dsl.obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
		Assert.assertEquals("PS4", text);
	}
	
	@Test
	public void deveInteragirSwitchCheckBox() throws MalformedURLException {		
		//verificar status dos elementos
		Assert.assertFalse(dsl.isChecked(By.className("android.widget.CheckBox")));
		Assert.assertTrue(dsl.isChecked(MobileBy.AccessibilityId("switch")));
		
		//clicar nos elementos
		dsl.clicar(By.className("android.widget.CheckBox"));
		dsl.clicar(MobileBy.AccessibilityId("switch"));
		
		//verificar status alterados
		Assert.assertTrue(dsl.isChecked(By.className("android.widget.CheckBox")));
		Assert.assertFalse(dsl.isChecked(MobileBy.AccessibilityId("switch")));
	}
	
	@Test
	public void deveRealizarCadastro() throws MalformedURLException {
		//preencher campos
		dsl.escrever(By.className("android.widget.EditText"), "Kaue");
		dsl.clicar(By.className("android.widget.CheckBox"));
		dsl.clicar(By.className("android.widget.Switch"));
		dsl.selecionarCombo(By.className("android.widget.Spinner"), "PS4");
		
		//salvar
		dsl.clicarPorTexto("SALVAR");
		
		//verificacao
		Assert.assertEquals("Nome: Kaue", dsl.obterTexto(By.xpath("//android.widget.TextView[@text='Nome: Kaue']")));
		
		
	}


}
