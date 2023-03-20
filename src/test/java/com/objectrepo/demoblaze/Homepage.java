package com.objectrepo.demoblaze;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage {
	@FindBy(id="login2")
	private WebElement Login;

	@FindBy(id="loginusername")
	private WebElement username;

	@FindBy(id="loginpassword")
	private WebElement password;

	@FindBy(xpath="//button[text()='Log in']")
	private WebElement Loginbutton;

	@FindBy(id="logout2")
	private WebElement Logout;

	@FindBy(xpath="//a[text()='Add to cart']")
	private WebElement AddToCart;

	@FindBy(xpath="//a[text()='Cart']")
	private WebElement Cart;

	@FindBy(xpath="//button[text()='Place Order']")
	private WebElement PlaceOrder;


	@FindBy(id="name")
	private WebElement Name;

	@FindBy(id="country")
	private WebElement Country;

	@FindBy(id="city")
	private WebElement City;

	@FindBy(id="card")
	private WebElement CreditCard;

	@FindBy(id="month")
	private WebElement Month;

	@FindBy(id="year")
	private WebElement Year;

	@FindBy(xpath="//button[text()='Purchase']")
	private WebElement Purchase;

	@FindBy(xpath="//button[text()='OK']")
	private WebElement OK;

	@FindBy(xpath=("(//button[text()='Close'])[3]"))
	private WebElement Close;
	
	@FindBy(id="nameofuser")
	private WebElement VerifyUN;

	//Getters

	public WebElement getLogin() {
		return Login;
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginbutton() {
		return Loginbutton;
	}

	public WebElement getLogout() {
		return Logout;
	}
	public WebElement getAddToCart() {
		return AddToCart;
	}

	public WebElement getCart() {
		return Cart;
	}
	public WebElement getPlaceOrder() {
		return PlaceOrder;
	}

	public WebElement getName() {
		return Name;
	}

	public WebElement getCountry() {
		return Country;
	}

	public WebElement getCity() {
		return City;
	}

	public WebElement getCreditCard() {
		return CreditCard;
	}

	public WebElement getMonth() {
		return Month;
	}

	public WebElement getYear() {
		return Year;
	}

	public WebElement getPurchase() {
		return Purchase;
	}

	public WebElement getOK() {
		return OK;
	}

	public WebElement getClose() {
		return Close;
	}

	public WebElement getVerifyUN() {
		return VerifyUN;
	}


}
