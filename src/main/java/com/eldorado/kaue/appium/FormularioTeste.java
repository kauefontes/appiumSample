package com.eldorado.kaue.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.eldorado.kaue.appium.core.DriverFactory;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class FormularioTeste {
	
	private AndroidDriver<MobileElement> driver;
	
	@Before
	public void inicializarAppium() throws MalformedURLException {
		driver = DriverFactory.getDriver();
				
		//Selecionar formulario
		driver.findElement(By.xpath("//*[@text='Formulário']")).click();
	}
	
	@After
	public void tearDown() {
		DriverFactory.killDriver();
	}
	
	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {	 
	    //Escrever nome
	    MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));
	    campoNome.sendKeys("Kaue");
	    
	    //checar nome escrito
	    String text = campoNome.getText();
	    Assert.assertEquals("Kaue", text);
	}
	
	@Test
	public void deveInteragirComCombo() throws MalformedURLException {
		//clicar no combo
		driver.findElement(MobileBy.AccessibilityId("console")).click();
		
		//selecionar a opcao desejada
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='PS4']")).click();
		
		//verificar a opcao selecionada
		String text = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();
		Assert.assertEquals("PS4", text);
	}
	
	@Test
	public void deveInteragirSwitchCheckBox() throws MalformedURLException {		
		//verificar status dos elementos
		MobileElement check = driver.findElement(By.className("android.widget.CheckBox"));
		MobileElement switc = driver.findElement(MobileBy.AccessibilityId("switch"));
		Assert.assertTrue(check.getAttribute("checked").equals("false"));
		Assert.assertTrue(switc.getAttribute("checked").equals("true"));
		
		//clicar nos elementos
		check.click();
		switc.click();
		
		//verificar status alterados
		Assert.assertFalse(check.getAttribute("checked").equals("false"));
		Assert.assertFalse(switc.getAttribute("checked").equals("true"));
	}
	
	@Test
	public void interactionsAndFill() throws MalformedURLException {
		String name = "kaue";
		//interactions
		driver.findElement(By.className("android.widget.EditText")).sendKeys(name);
		driver.findElement(By.className("android.widget.CheckBox")).click();
		driver.findElement(MobileBy.AccessibilityId("switch")).click();
		
		List<MobileElement> botoesEncontrados = driver.findElements(By.className("android.widget.Button"));
		botoesEncontrados.get(0).click();		
		
	}


}
