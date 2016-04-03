package gameInterface;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Key implements KeyListener{

	private boolean right, left, up, down, enter, one, two, three;
	
	public Key() {
		right = false;
		left = false;
		up = false;
		down = false;
		enter = false;
		one = false;
		two = false;
		three = false;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getExtendedKeyCode() == KeyEvent.VK_W){
			up = true;
		}else if(e.getExtendedKeyCode() == KeyEvent.VK_S){
			down = true;
		}else if(e.getExtendedKeyCode() == KeyEvent.VK_A){
			left = true;
		}else if(e.getExtendedKeyCode() == KeyEvent.VK_D){
			right = true;
		}else if(e.getExtendedKeyCode() == KeyEvent.VK_ENTER){
			enter = true;
		}
		else if(e.getExtendedKeyCode() == KeyEvent.VK_1){
			one = true;
		}
		else if(e.getExtendedKeyCode() == KeyEvent.VK_2){
			two = true;
		}
		else if(e.getExtendedKeyCode() == KeyEvent.VK_3){
			three = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getExtendedKeyCode() == KeyEvent.VK_W){
			up = false;
		}else if(e.getExtendedKeyCode() == KeyEvent.VK_S){
			down = false;
		}else if(e.getExtendedKeyCode() == KeyEvent.VK_A){
			left = false;
		}else if(e.getExtendedKeyCode() == KeyEvent.VK_D){
			right = false;
		}else if(e.getExtendedKeyCode() == KeyEvent.VK_ENTER){
			enter = false;
		}
		else if(e.getExtendedKeyCode() == KeyEvent.VK_1){
			one = false;
		}
		else if(e.getExtendedKeyCode() == KeyEvent.VK_2){
			two = false;
		}
		else if(e.getExtendedKeyCode() == KeyEvent.VK_3){
			three = false;
		}
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public boolean isEnter() {
		return enter;
	}

	public void setEnter(boolean enter) {
		this.enter = enter;
	}

	public boolean is1()
	{
		return this.one;
	}
	
	public void set1(boolean one)
	{
		this.one = one;
	}
	
	public boolean is2()
	{
		return this.two;
	}
	
	public void set2(boolean two)
	{
		this.two = two;
	}
	
	public boolean is3()
	{
		return this.three;
	}
	
	public void set3(boolean three)
	{
		this.three = three;
	}
}
