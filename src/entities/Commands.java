package entities;

public class Commands {
	private int it;
	private char symbol = ' ';
	private int next;
	private char value= ' ';
	private char direction= ' ';
	public int getIt() {
		return it;
	}
	public void setIt(int it) {
		this.it = it;
	}
	public char getSymbol() {
		return symbol;
	}
	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
	public int getNext() {
		return next;
	}
	public void setNext(int next) {
		this.next = next;
	}
	public char getValue() {
		return value;
	}
	public void setValue(char value) {
		this.value = value;
	}
	public char getDirection() {
		return direction;
	}
	public void setDirection(char direction) {
		this.direction = direction;
	}
}
