package it.unical.classmanager.statistics.cart;

/**
 * @author Aloisius92
 * This is the abstract cart class type.
 */
public abstract class AbstractCart  {
    private String idContainer;
    private String name;
    protected StringBuilder cartScript = null;
    // Data attribues
    protected String title;
    protected String subTitle;
    protected String xAxisTitle;
    protected String yAxisTitle;
    protected int xAxisMinValue;
    protected int xAxisMaxValue;
    protected String xAxisCategories;
    protected int yAxisMinValue;
    protected int yAxisMaxValue;
    protected String yAxisCategories;
    protected StringBuilder seriesContent;
    protected String categories;
    protected StringBuilder categoriesDataContent;
    protected StringBuilder drilldownContent;
    protected String xPlotText;
    protected String yPlotText;
    protected String xPointTooltip;
    protected String yPointTooltip;
    protected String zPointTooltip;
    protected String toolTipValueSuffix;
    
    public AbstractCart(){
	idContainer = "";
	name = "Generic Cart";
	cartScript = null;
	// Data attributes initialization
	title = "";
	subTitle = "";
	xAxisTitle = "";
	yAxisTitle = "";
	xAxisMinValue = 0;
	xAxisMaxValue = 0;
	yAxisMinValue = 0;
	yAxisMaxValue = 0;
	seriesContent = new StringBuilder("");	
	categories = "";
	categoriesDataContent = new StringBuilder("");
	drilldownContent = new StringBuilder("");	
	xPlotText = "";
	yPlotText = "";
	xPointTooltip = "";
	yPointTooltip = "";
	zPointTooltip = "";
	toolTipValueSuffix = "";
    }
    
    /**
     * This is a "Factory Method",
     * the type of cart depends by the subclass.
     * @return void
     */
    protected abstract void buildCart();
    
    public StringBuilder getCartScript() {
	if(cartScript==null){
	    buildCart();
	}
	return cartScript;
    }
    
    public void setCartScript(StringBuilder cartScript) {
	this.cartScript = cartScript;
    }
    
    public String getIdContainer() {
	return idContainer;
    }
    
    public void setIdContainer(String idContainer) {
	this.idContainer = idContainer;
    }
    
    public String getName() {
	return name;
    }
    
    public void setName(String name) {
	this.name = name;
    }
    
    //	Data attributes set and get

    public String getTitle() {
        return title;
    }

    public void setTitle( String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle( String subTitle) {
        this.subTitle = subTitle;
    }

    public String getxAxisTitle() {
        return xAxisTitle;
    }

    public void setxAxisTitle( String xAxisTitle) {
        this.xAxisTitle = xAxisTitle;
    }

    public String getyAxisTitle() {
        return yAxisTitle;
    }

    public void setyAxisTitle( String yAxisTitle) {
        this.yAxisTitle = yAxisTitle;
    }

    public int getxAxisMinValue() {
        return xAxisMinValue;
    }

    public void setxAxisMinValue( int xAxisMinValue) {
        this.xAxisMinValue = xAxisMinValue;
    }

    public int getxAxisMaxValue() {
        return xAxisMaxValue;
    }

    public void setxAxisMaxValue( int xAxisMaxValue) {
        this.xAxisMaxValue = xAxisMaxValue;
    }

    public String getxAxisCategories() {
        return xAxisCategories;
    }

    public void setxAxisCategories( String xAxisCategories) {
        this.xAxisCategories = xAxisCategories;
    }

    public int getyAxisMinValue() {
        return yAxisMinValue;
    }

    public void setyAxisMinValue( int yAxisMinValue) {
        this.yAxisMinValue = yAxisMinValue;
    }

    public int getyAxisMaxValue() {
        return yAxisMaxValue;
    }

    public void setyAxisMaxValue( int yAxisMaxValue) {
        this.yAxisMaxValue = yAxisMaxValue;
    }

    public String getyAxisCategories() {
        return yAxisCategories;
    }

    public void setyAxisCategories( String yAxisCategories) {
        this.yAxisCategories = yAxisCategories;
    }

    public StringBuilder getSeriesContent() {
        return seriesContent;
    }

    public void setSeriesContent( StringBuilder seriesContent) {
        this.seriesContent = seriesContent;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories( String categories) {
        this.categories = categories;
    }

    public StringBuilder getCategoriesDataContent() {
        return categoriesDataContent;
    }

    public void setCategoriesDataContent( StringBuilder categoriesDataContent) {
        this.categoriesDataContent = categoriesDataContent;
    }

    public StringBuilder getDrilldownContent() {
        return drilldownContent;
    }

    public void setDrilldownContent( StringBuilder drilldownContent) {
        this.drilldownContent = drilldownContent;
    }

    public String getxPlotText() {
        return xPlotText;
    }

    public void setxPlotText( String xPlotText) {
        this.xPlotText = xPlotText;
    }

    public String getyPlotText() {
        return yPlotText;
    }

    public void setyPlotText( String yPlotText) {
        this.yPlotText = yPlotText;
    }

    public String getxPointTooltip() {
        return xPointTooltip;
    }

    public void setxPointTooltip( String xPointTooltip) {
        this.xPointTooltip = xPointTooltip;
    }

    public String getyPointTooltip() {
        return yPointTooltip;
    }

    public void setyPointTooltip( String yPointTooltip) {
        this.yPointTooltip = yPointTooltip;
    }

    public String getzPointTooltip() {
        return zPointTooltip;
    }

    public void setzPointTooltip( String zPointTooltip) {
        this.zPointTooltip = zPointTooltip;
    }

    public String getToolTipValueSuffix() {
	    return toolTipValueSuffix;
    }

    public void setToolTipValueSuffix( String toolTipValueSuffix) {
	    this.toolTipValueSuffix = toolTipValueSuffix;
    }
    
}
