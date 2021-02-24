package com.nit.optionsandprofiling;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class IEOptionsExample {

    //There is no notifictaions
    //no profiling
    //we can manage proxy, certificates

    @Test
    public void ie(){

        System.setProperty("webdriver.ie.driver", "D:\\MyDevelopment\\drivers\\IEDriverServer.exe");
        System.setProperty(InternetExplorerDriverService.IE_DRIVER_LOGFILE_PROPERTY, "INFO");
        System.setProperty(InternetExplorerDriverService.IE_DRIVER_LOGFILE_PROPERTY, "logs\\ie.log");
        //If i give true no logs will write
        System.setProperty(InternetExplorerDriverService.IE_DRIVER_SILENT_PROPERTY, "true");
        InternetExplorerOptions options = new InternetExplorerOptions();
        //options.setPageLoadStrategy(strategy);

        //manage proxy with help of DesiredCapabilities in IE.
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        //proxy settings..
        String proxyServer = "82.288.287.22:8080";
        Proxy proxy = new Proxy();
        proxy.setAutodetect(false);
        proxy.setProxyType(Proxy.ProxyType.MANUAL);
        proxy.setSocksProxy(proxyServer);

        desiredCapabilities.setCapability(CapabilityType.PROXY, proxy);
        options.merge(desiredCapabilities);

        InternetExplorerDriver internetExplorerDriver = new InternetExplorerDriver(options);
        internetExplorerDriver.get("https://expired.badssl.com/");
        internetExplorerDriver.get("javascript:document.getElementById('overridelink').click();");
    }
}
