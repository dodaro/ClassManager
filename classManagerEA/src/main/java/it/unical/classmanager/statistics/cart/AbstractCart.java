package it.unical.classmanager.statistics.cart;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Aloisius92
 * This is the abstract cart class type.
 */
public abstract class AbstractCart  {
    protected static final String pathToCartFiles = "src/main/webapp/resources/statistics/cartsHtml";
    protected static final String extensionFiles = ".html";
    private String cartName;
    private List<String> dataCart;
    private StringBuilder cartScript = null;
    // Data attribues
    private Map<String, String> dataMap;    
    private static String[] properties = {
	    "#container",
	    "#titleText",
	    "#subTitleText",	
	    "#tooltipPointFormat",
	    "#tooltipValueSuffix",	
	    "#xAxisCategories",
	    "#xAxisLabelsFormat",
	    "#xAxisPlotLinesLabelText",
	    "#xAxisTitle",
	    "#xAxisMin",
	    "#xAxisMax",
	    "#yAxisLabelsFormat",
	    "#yAxisPlotLinesLabelText",
	    "#yAxisTitle",
	    "#yAxisMin",
	    "#yAxisMax",
	    "#series", 
	    "#drilldownSeries"};     
    private static String[] propertiesDefaultValue = {
	    "#container",
	    "titleText",
	    "subTitleText",	
	    "",
	    "",	
	    "",
	    "",
	    "",
	    "xAxisTitle",
	    "0",
	    "0",
	    "",
	    "",
	    "yAxisTitle",
	    "0",
	    "0",
	    "", 
	    ""}; 
    
    
    public AbstractCart(String cartName){
	setAllDefaultValue();	
	this.cartName = cartName;	
	readDataCart();
    }
    
    private void setAllDefaultValue(){
	cartName = "";
	dataCart = new ArrayList<String>();
	cartScript = null;
	dataMap = new HashMap<String, String>();
	
	for(int i=0; i<propertiesDefaultValue.length; i++){
	    setProperty(properties[i], propertiesDefaultValue[i]);
	}
    }
    
    private void readDataCart() {	
	BufferedReader reader;
	try {
	    String pathToFile = pathToCartFiles+"/"+getCartName()+extensionFiles;
	    
	    reader=new BufferedReader(new FileReader(pathToFile));
	    String line;
	    boolean exit = false;
	    while(!exit && ((line=reader.readLine())!=null)){
		dataCart.add(line+"\n");
	    } 
	    
	    reader.close();
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e){
	    e.printStackTrace();
	}	
    }
    
    private boolean replaceInData(String toReplace, String replacement){
	boolean find = false;
	for(int i=0; i<dataCart.size(); i++){
	    if(dataCart.get(i).contains(toReplace)){
		String replace = dataCart.get(i).replace(toReplace, replacement);
		dataCart.set(i, replace);
		find = true;
	    }
	}
	return find;
    }
    
    private void replaceAllPlaceholders(){	
	for(int i=0; i<properties.length; i++){
	    this.replaceInData(properties[i], getProperty(properties[i]));	
	    
	}
    }
    
    /*
     * Once all util data is setted
     * the call to this function
     * replace all placeholders 
     * with real data.
     * If no data is setted, 
     * default values will be used.
     */
    private String buildFinalCart(){
	replaceAllPlaceholders();
	
	cartScript = new StringBuilder("");
	for(int i=0; i<dataCart.size(); i++){
	    cartScript.append(dataCart.get(i));
	}
	
	return cartScript.toString();
    }
 
    /*********************/
    /*	  SET AND GET	 */
    /*********************/
    
    public StringBuilder getCartScript() {
	if(cartScript==null){
	    buildFinalCart();
	}
	return cartScript;
    }
    
    public void setCartScript(StringBuilder cartScript) {
	this.cartScript = cartScript;
    }
    
    public String getCartName() {
	return cartName;
    }
    
    public void setCartName(String cartName) {
	this.cartName = cartName;
    } 
    
    public void setProperty(String key, String value){
	dataMap.put(key, value);
    }
    
    public String getProperty(String key){
	if(dataMap.containsKey(key)){
	    return dataMap.get(key);
	}
	return null;
    }
    
}
