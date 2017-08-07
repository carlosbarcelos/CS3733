package controller;

import javax.swing.*;

import view.Application;

public class QuitController {
	
  public boolean confirm(Application app) {
	  
	  int c = JOptionPane.showConfirmDialog (app, "Do you wish to exit Application?");
	  
	  if (c == JOptionPane.OK_OPTION) {
		  return true;
	  }
	  
	  // don't exit
	  return false;
  }  
}
