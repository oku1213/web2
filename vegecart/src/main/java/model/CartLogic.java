package model;

public class CartLogic {
	public void execute(Cart cart, Vegetable vege) {
	cart.getList().add(vege);
	cart.setTotal(cart.getTotal()+vege.getPrice());
	}
}
