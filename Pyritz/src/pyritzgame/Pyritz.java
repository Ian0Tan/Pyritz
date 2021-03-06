package pyritzgame;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import hsa_new.Console;

public class Pyritz {

	public static void main(String[] args) throws IOException {
		Console c = new Console( 30,100,20,"Pyritz");
		BufferedImage allen  = ImageIO.read(new File ("allen.jpg"));
		int restart = 0;
		//start
		c.print("					Pyritz: The Game\n");
		c.setTextColor(Color.WHITE);
		c.print("				___");
		c.setTextColor(Color.BLACK);
		c.print("To start, type start below\n");
		c.setTextColor(Color.WHITE);
		c.print("\n					______");
		c.setTextColor(Color.BLACK);
		String start = c.readString();
		if (start.equalsIgnoreCase("start")) {
			restart = 1;
		}
		//intro
		while (restart == 1){
			c.clear();
			c.fillRect (0, 0, 1500, 1500);
			c.setTextBackgroundColour(Color.BLACK);
			c.setTextColour(Color.WHITE);
			c.print("You are a pyrit on a ship sailing the sea, do you want to get up in the morning?\n(Yes or No)\n");
			String input1 = c.readString();
			if (input1.equalsIgnoreCase("yes")) {
				c.clear();
				c.print("You wake up and go to the mess hall. They are about to open up a barrel of rum. Do you drink it all?\n(Yes or No)\n");
				String input2 = c.readString();
				if(input2.equalsIgnoreCase("yes")) {
					c.clear();
					c.setTextColour(Color.RED);
					c.print("You drink it all and die in a bar fight.");
					restart = 0;
				}
				else if(input2.equalsIgnoreCase("no")) {
					c.clear();
					c.print("You take a conservative sip. After breakfast you are ordered to climb the rigging. Do you?\n(Yes ar No)\n");
					String input4 = c.readString();
					if(input4.equalsIgnoreCase("yes")) {
						double rng1 = Math.round(Math.random() * 6);
						c.print(rng1);
						if (rng1 == 2.0) {
							c.clear();
							c.setTextColour(Color.RED);
							c.print("You fall from the rigging and die.\nDon't drink and climb.");
							restart = 0;
						}
						//cannon battle
						else {
							c.clear();
							c.print("You climb the rigging and see another ship.\nYou inform the crew and start getting ready.\n");
							c.print("Do you help load the cannons?\n(Yes or No)\n");
							String input5 = c.readString();
							if(input5.equalsIgnoreCase("yes")) {
								double rng2 = Math.round(Math.random() * 3);
								if (rng2 == 2.0) {
									c.clear();
									c.setTextColour(Color.RED);
									c.print("The cannon goes off while loading.\nYou die instantly, your entire bloodline is disappointed.");
									restart = 0;
								}
								else {
									c.clear();
									c.print("You load the cannons and defeat the enemy ship.\nYou win!");
									restart = 0;
								}
							}
							else if (input5.equalsIgnoreCase("no")) {
								double rng3 = Math.round(Math.random() * 2);
								if (rng3 == 2.0) {
									c.setTextColour(Color.RED);
									c.print("You weren't paying attention and got hit by an enemy cannon ball.\nYou die instantly.\nCannon ball: 1 - You: 0");
									restart = 0;
								}
								else {
									c.print("You win the fight but from doing nothing you have to swab the deck forever.\nDo you really win?");
									restart = 0;
								}
							}
						}
					}
					//fighting rival pyritz
					else if (input4.equalsIgnoreCase("no")) {
						c.clear();
						c.print("You're forced to scrub the deck as punishment.\n");
						c.print("The ship gets boarded by rival pyritz, what do you do?\n");
						c.print("Fight for your side (input \"ms\")\n");
						c.print("Fight for the other side (input \"os\")\n");
						c.print("or Hide (input \"hide\")\n");
						String input6 = c.readString();
						int fightCount = 1;
						int yourSide = 0;
						int otherSide = 0;
						int hide = 0;
						while (fightCount < 3) {
							if (fightCount > 1)
								c.print("Round " + fightCount + ", what do you do?");
							c.print("Fight for your side (input \"ms\")\n");
							c.print("Fight for the other side (input \"os\")\n");
							c.print("or Hide (input \"hide\")\n");	
							if (input6.equalsIgnoreCase("ms")) {
								c.print("You fight for your side.");
								yourSide =+ 1;
								fightCount =+1;
							}
							else if (input6.equalsIgnoreCase("os")) {
								c.print("You fight for the other side to spite Dave.\nShame on Dave.");
								otherSide =+ 1;
								fightCount =+1;
							}
							else if (input6.equalsIgnoreCase("hide")) {
								hide =+ 1;
								fightCount = 3;
							}
						}
						//your side wins
						double rng4 = Math.round(Math.random() * 2);
						if (rng4 == 1 || rng4 == 6) {
							if(hide == 1) {
								c.clear();
								c.print("You're alive, but you have to scrub the poop deck forever.\nWin?");
								restart = 0;
							}
							else if (yourSide > otherSide) {
								c.clear();
								c.print("You fight valiantly and live another day\nWin");
								restart = 0;
							}
							else {
								c.clear();
								c.print("you suruived, but your betrayal is not tolerated.\n");
								c.setTextColour(Color.RED);
								c.print("You are killed by your former friends");
								restart = 0;
							}
						}
						//other side wins
						else if (rng4 == 3 || rng4 == 4) {
							if(hide == 1) {
								c.clear();
								c.print("while hiding in the barrel, it gets thrown overboard\n");
								c.setTextColour(Color.RED);
								c.print("you die a cowards death by drowning.");
								restart = 0;
							}
							else if (yourSide > otherSide) {
								c.clear();
								c.setTextColour(Color.RED);
								c.print("you die in battle fighting alougside your friends. ");
								restart = 0;
							}
							else {
								c.clear();
								c.print("You betray your crew and live.\nBut when the other crew finds out,");
								c.setTextColour(Color.RED);
								c.print("you're killed.");
								restart = 0;
							}
						}
						else {
							//boom
							c.clear();
							c.setTextColour(Color.RED);
							c.print("The ships powder magazine explodes killing everyone");
							restart = 0;
						}
					}
				}
			}
			// the allens of doom
			else if (input1.equalsIgnoreCase("no")) {
				c.clear();
				input1 = "no";
				int scream = 0;
				int cry = 0;
				c.print("You were abducted by allens, what do you do? \n");
				while (scream < 1 || cry < 1) {
					c.print("(Scream or cry) \n");
					c.drawImage(allen, 0, 85, null);
					String input3 = c.readString();
					if (input3.equalsIgnoreCase("scream")) {
						c.clear();
						c.print("The allens appear annoyed with your screaming... \n");
						scream =+ 1;
					}
					else if (input3.equalsIgnoreCase("cry")) {
						c.clear();
						c.print("The allens watch as you continue to cry your eyes out. \n");
						cry =+ 1;
					}
				}
				c.clear();
				c.print("The allens are fed up with you being loud and decide the best option is to wipe out humanity. \n");
				c.setTextColour(Color.RED);
				c.print("All because of you. \nShame.");
				restart = 0;
			}
			//restart
			restart = 0;
			c.setTextColour(Color.WHITE);
			c.print("\nwould you like to play again?\n(Yes or No)\n ");
			String input7 = c.readString();
			if(input7.equalsIgnoreCase("yes")) {
				restart = 1;
			}
			else if (input7.equalsIgnoreCase("no")) {
				c.clear();
				c.setTextColour(Color.CYAN);
				c.print("Thank you for playing!");
			}
		}
	}
}