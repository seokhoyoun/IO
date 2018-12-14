package silsub3;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Book implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4111508460663350679L;
	// Field
	private String title; // 도서명
	private String author; // 저자
	private int price; // 가격
	private Calendar dates; // 출판날짜
	private double discountRate; //할인율
	
	//Constructor
	public Book() {
		
	}

	public Book(String title, String author, int price, Calendar dates, double discountRate) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
		this.dates = dates;
		this.discountRate = discountRate;
	}
	// Getter/Setter
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Calendar getDates() {
		return dates;
	}

	public void setDates(Calendar dates) {
		this.dates = dates;
	}

	public double getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy'년' MM'월' dd'일 출간' ");
		
		return this.title+"\t"+this.author+"\t"+this.price+"\t"+sdf.format(this.dates.getTime()).toString()+"\t"+this.discountRate; 
		// Calendar를 date 형으로 바꾸는 getTime() 메소드!
	}
	
	
}
