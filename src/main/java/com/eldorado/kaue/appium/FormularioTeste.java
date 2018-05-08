package com.eldorado.kaue.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
//import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import junit.framework.Assert;

public class FormularioTeste {
	
	@SuppressWarnings("deprecation")
	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "NZAA470170");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
	    desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\kaue.pereira\\eclipse-workspace\\AppiumTeste\\src\\main\\resources\\CTAppium-1-1.apk");
	    
	    AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    //Selecionar formulario
	    List<MobileElement> elementosEncontrados = driver.findElements(By.className("android.widget.TextView"));
//	    for(MobileElement elemento: elementosEncontrados) {
//	    	System.out.println(elemento.getText());
//	    }
	    elementosEncontrados.get(1).click();
	    
	    //Escrever nome
	    MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));
	    campoNome.sendKeys("Kaue");
	    
	    //checar nome escrito
	    String text = campoNome.getText();
	    Assert.assertEquals("Kaue", text);
	    
	    driver.quit();
	}
	
	@Test
	public void deveInteragirComCombo() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "NZAA470170");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
	    desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\kaue.pereira\\eclipse-workspace\\AppiumTeste\\src\\main\\resources\\CTAppium-1-1.apk");
	    
	    AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    //clicar no combo
	    driver.findElement(MobileBy.AccessibilityId("console")).click();
	    
	    //selecionar a opcao desejada
	    
	    //verificar a opcao selecionada
	    
	    driver.quit();
	}


}
