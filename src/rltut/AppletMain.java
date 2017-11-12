package rltut;

import java.applet.Applet;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import asciiPanel.AsciiFont;
import asciiPanel.AsciiPanel;
import rltut.screens.Screen;
import rltut.screens.StartScreen;

public class AppletMain extends Applet implements KeyListener{

	private static final long serialVersionUID = 8896372357616744415L;

	private AsciiPanel terminal;
	private Screen screen;

	public AppletMain() {
		super();
		terminal = new AsciiPanel(80,60, AsciiFont.TALRYTH_15_15);
		add(terminal);
		screen = new StartScreen();
		addKeyListener(this);
		repaint();
	}

	public void repaint() {
		terminal.clear();
		screen.displayOutput(terminal);
		super.repaint();
	}

	public void keyPressed(KeyEvent e) {
		screen = screen.respondToUserInput(e);
		repaint();
	}

	public void keyReleased(KeyEvent e) {	}
	public void keyTyped(KeyEvent e) {	}

	public static void main(String[] args) {
		ApplicationMain app = new ApplicationMain();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
	}
}
