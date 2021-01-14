package po;

public class CartItem {
	private Integer id;
	private Integer uid;
	private double price;
	private String bookName;
	private double sum;
	private int quantity;

	public CartItem() {
	}

	public CartItem(Integer id, Integer uid, double price, String bookName, double sum, int quantity) {
		this.id = id;
		this.uid = uid;
		this.price = price;
		this.bookName = bookName;
		this.sum = sum;
		this.quantity = quantity;
	}

	public String getBookName() {
		return bookName;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getSum() {
		return sum;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}

	@Override
	public String toString() {
		return "CartItem{" +
				"id=" + id +
				", uid=" + uid +
				", bookName='" + bookName + '\'' +
				", price=" + price +
				", quantity=" + quantity +
				", sum=" + sum +
				'}';
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}
}
