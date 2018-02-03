package org.henrypawlak.Zufallsgenerator.Zentrale;

import java.util.Random;

import org.henrypawlak.Zufallsgenerator.Controller;

public class Zentrale {
		private Controller c;
		Random random = new Random();
		public Zentrale(Controller c) {
			this.c = c;
		}
		
		public int generateRandomNumber(int bound) {
			int randomInt = random.nextInt(bound);
			while(randomInt == 0) {
				randomInt = random.nextInt(bound);
			}
			return randomInt;				
		}
		public char generateRandomChar() {
			return (char)(random.nextInt(26) + 'a');
		}
		public boolean generateRandomBool() {
			return random.nextBoolean();
		}
}
