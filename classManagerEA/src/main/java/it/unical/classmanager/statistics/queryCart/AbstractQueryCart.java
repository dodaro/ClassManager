package it.unical.classmanager.statistics.queryCart;

import it.unical.classmanager.statistics.cart.AbstractCart;

/**
 * @author Aloisius92
 * This is the abstract cart class type.
 */
public abstract class AbstractQueryCart {
    protected AbstractCart cart = null;
    
    public AbstractQueryCart(){
	cart = null;
    }
   
    /**
     * This is a "Factory Method",
     * the type of cart and query that must be performed
     * depends by the subclass.
     * @return AbstractCart
     */
    protected abstract AbstractCart buildCartFromQuery();
    protected abstract AbstractCart buildCartFromQuery(AbstractCart cart);
    
    public AbstractCart getCart() {
	if(cart==null){
	    cart = buildCartFromQuery();
	}
	return cart;
    }
    
    public void setCart( AbstractCart cart) {
	this.cart = cart;
    }
}
