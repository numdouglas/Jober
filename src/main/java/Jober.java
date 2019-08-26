import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;
import java.nio.charset.MalformedInputException;
import java.util.Arrays;

public class Jober {
WebClient client=new WebClient(BrowserVersion.CHROME);
HtmlPage currentPage;
String[] jobCards=new String[10];
String[] coCards=new String[10];
String[] listings=new String[10];


    public String[] searchJobs_BrighterMonday(){
        try {
            client.getOptions().setJavaScriptEnabled(false);
            currentPage = client.getPage("https://www.brightermonday.co.ke/jobs");
        }
        catch (MalformedInputException f ){f.printStackTrace();}
        catch (IOException B){B.printStackTrace();}
        for (int i=0;i<10;i++) {
            HtmlElement jobotitle = (HtmlElement) currentPage.getByXPath("//a[@class='search-result__job-title metrics-apply-now ']//h3").get(i);
            HtmlElement joboOrigin=(HtmlElement)currentPage.getByXPath("//div[@class='if-content-panel padding-lr-20 flex-direction-top-to-bottom--under-lg align--start--under-lg search-result__job-meta']//a").get(i);
            jobCards[i]=jobotitle.getTextContent();
            coCards[i]=joboOrigin.getTextContent();
            listings[i]=jobCards[i]+" ->"+coCards[i];
        }
        return listings;
    }

    public String[] searchJobs_JobsWebKenya(){
        try {
            client.getOptions().setJavaScriptEnabled(false);
            currentPage = client.getPage("https://jobwebkenya.com/");
        }
        catch (MalformedInputException f ){f.printStackTrace();}
        catch (IOException B){B.printStackTrace();}
        for (int i=0;i<10;i++) {
            HtmlElement jobo = (HtmlElement) currentPage.getByXPath("//div[@id='titlo']//strong//a").get(i);
            jobCards[i]=jobo.getTextContent().split(" at ")[0];
            coCards[i]=jobo.getTextContent().split(" at ")[1];
            listings[i]=jobCards[i]+" ->"+coCards[i];
        }
        return listings;
    }

    public static void main(String[] args){
        Jober jobbo=new Jober();
        System.out.println(Arrays.asList(jobbo.searchJobs_BrighterMonday()));
        System.out.println(Arrays.asList(jobbo.searchJobs_JobsWebKenya()));
    }
}
