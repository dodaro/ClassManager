package it.unical.classmanager.statistics.queryCart;

import it.unical.classmanager.model.data.User;
import it.unical.classmanager.statistics.cart.AbstractCart;

/**
 * @author Aloisius92
 * This is the abstract cart class type.
 */
public abstract class AbstractQueryCart {
    protected AbstractCart cart = null;
    private User user;
    
    public AbstractQueryCart(){
	cart = null;
	user = null;
    }

    public AbstractQueryCart(User user){
	cart = null;
	this.user = user;
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

    public User getUser() {
	    return user;
    }

    public void setUser( User user) {
	    this.user = user;
    }
}