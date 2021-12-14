package application;

import java.util.Scanner;

public class Hangman {
	private boolean running = true;
	private RandomWord word;
	Scanner scanner = new Scanner(System.in);
	Scanner scanner1 = new Scanner(System.in);
	private char  lastCharacter;
	private int tryiesRemaining = 5;
	
	public void play() {
		//chooseFromMenu();
		chooseCategory();
		do {
		    displayWord();
			getUserInput();
			checkUserInput();
		}while(running);
	}
		
	void chooseCategory() {
		System.out.println("Wybierz kategorię: 0-zwierzęta, 1-owoce, 2-warzywa");
		int cat = scanner.nextInt();
		this.word = new RandomWord(cat);
	}
	void displayWord() {
		System.out.printf("You have %d more tryes\n", tryiesRemaining);
		System.out.println(word.toString());
		
	}
	
	void getUserInput() {
		//Ask the user to enter a character
		//Pass the character as a string
		// Pass the character to RandomWord as the argument to the method
		System.out.println("Enter your guess: ");
		 
		String input = scanner1.nextLine();
		lastCharacter = input.charAt(0);
		 
		}
	
	void checkUserInput() {
		boolean correct = word.addGues(lastCharacter);
		if (correct) {
			if (word.isGuessed()) {
				System.out.println("You win!");
				System.out.println("The word is: "+ word);
				running = false;
			}
				
		}
		else {
		    tryiesRemaining-=1;
			if (tryiesRemaining <= 0) {
				System.out.println("this time you loosed, try once again");
				running = false;
			}
		}
		 
	}

	public void close() {
		scanner.close();
		scanner1.close();
		
	}
}
