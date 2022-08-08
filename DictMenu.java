package spanishDict;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class DictMenu 
{
	public static void main(String[] args) throws FileNotFoundException 
	{
		Scanner scan=new Scanner(System.in);
		int input,inputchoice;
		String searchw;
		boolean bloop=true;
		Nouns nounobj=new Nouns();
		nounobj.NounBst();
		Verbs verbobj=new Verbs();
		verbobj.VerbBst();
		Adjectives adjobj=new Adjectives();
		adjobj.AdjBst();
		while(bloop) 
		{
			System.out.println();
			System.out.printf("%-46s %s"," ","MAIN MENU\n");
			System.out.println();
			System.out.printf("%-40s %s %-40s %s %-40s %s %-40s %s %-40s %s %-40s %s %-39s %s"," ","What do you want to do?\n\n"," ","1. Display Words  \n"," ","2. Display all words with their meanings\n"," ","3. Search for a word\n"," ","4. Practice words with Flashcards\n"," ","5. Exit.\n"," ","Enter your choice : ");
			input=scan.nextInt();
			System.out.println();
			System.out.println("     ____________________________________________________________________________________________________________________");
			switch(input) 
			{
			case 1:
				System.out.println();
				System.out.printf("%-40s %s %-40s %s %-40s %s %-40s %s %-40s %s %-39s %s"," ","Which type of words do you want displayed?\n"," ","1. Nouns\n"," ","2. Verbs\n"," ","3. Adjectives\n"," ","4. All of the above\n"," ","Enter your choice : ");
				inputchoice=scan.nextInt();
				System.out.println();
				switch(inputchoice) 
				{
				case 1:
					System.out.printf("%-55s LIST OF NOUNS"," ");
					System.out.println();
					nounobj.focusnode=nounobj.root;
					nounobj.display(nounobj.focusnode);
					break;
				case 2:
					System.out.printf("%-55s LIST OF VERBS"," ");
					System.out.println();
					verbobj.focusnode=verbobj.root;
					verbobj.display(verbobj.focusnode);
					break;
				case 3:
					System.out.printf("%-53s LIST OF ADJECTIVES"," ");
					System.out.println();
					adjobj.focusnode=adjobj.root;
					adjobj.display(adjobj.focusnode);
					break;
				case 4:
					nounobj.focusnode=nounobj.root;
					nounobj.display(nounobj.focusnode);
					verbobj.focusnode=verbobj.root;
					verbobj.display(verbobj.focusnode);
					adjobj.focusnode=adjobj.root;
					adjobj.display(adjobj.focusnode);
					break;
				}
				break;
			case 2:
				System.out.println();
				System.out.printf("%-40s %s %-40s %s %-40s %s %-40s %s %-40s %s %-39s %s"," ","Which type of words do you want displayed?\n"," ","1. Nouns\n"," ","2. Verbs\n"," ","3. Adjectives\n"," ","4. All of the above\n"," ","Enter your choice : ");
				inputchoice=scan.nextInt();
				System.out.println();
				switch(inputchoice) 
				{
				case 1:
					nounobj.focusnode=nounobj.root;
					System.out.printf("%-33s %-25s : %s"," ","Spanish Word","Meaning in English");
					System.out.println();
					System.out.println();
					nounobj.displayAll(nounobj.focusnode);
					break;
				case 2:
					verbobj.focusnode=verbobj.root;
					System.out.printf("%-33s %-25s : %s"," ","Spanish Word","Meaning in English");
					System.out.println();
					System.out.println();
					verbobj.displayAll(verbobj.focusnode);
					break;
				case 3:
					adjobj.focusnode=adjobj.root;
					System.out.printf("%-33s %-25s : %s"," ","Spanish Word","Meaning in English");
					System.out.println();
					System.out.println();
					adjobj.displayAll(adjobj.focusnode);
					break;
				case 4:
					System.out.printf("%-33s %-25s : %s"," ","Spanish Word","Meaning in English");
					System.out.println();
					System.out.println();
					nounobj.focusnode=nounobj.root;
					nounobj.displayAll(nounobj.focusnode);
					verbobj.focusnode=verbobj.root;
					verbobj.displayAll(verbobj.focusnode);
					adjobj.focusnode=adjobj.root;
					adjobj.displayAll(adjobj.focusnode);
					break;
				}
				break;
			case 3:
				scan.nextLine();
				System.out.printf("%-40s %s %-40s %s %-40s %s %-40s %s %-39s %s"," ","Which type of word do you want to search?\n"," ","1. Noun \n"," ","2. Verb \n"," ","3. Adjective \n"," ","Enter your choice : ");
				inputchoice=scan.nextInt();
				scan.nextLine();
				switch(inputchoice) 
				{
				case 1:	
					nounobj.focusnode=nounobj.root;
					System.out.printf("%-39s %s"," ","Which word do you want to search?");
					System.out.println();
					System.out.printf("%-50s","");
					searchw=scan.nextLine();
					String firstletter = searchw.substring(0,1);
					firstletter = firstletter.toUpperCase();
					String remainingletters = searchw.substring(1,searchw.length());
					searchw = firstletter + remainingletters;
					nounobj.search(searchw,nounobj.focusnode);
					break;
				case 2:
					verbobj.focusnode=verbobj.root;
					System.out.printf("%-39s %s"," ","Which word do you want to search?");
					System.out.println();
					System.out.printf("%-50s","");					
					searchw=scan.nextLine();
					verbobj.search(searchw,verbobj.focusnode);
					break;
				case 3:
					adjobj.focusnode=adjobj.root;
					System.out.printf("%-39s %s"," ","Which word do you want to search?");
					System.out.println();
					System.out.printf("%-50s","");
					searchw=scan.nextLine();
					adjobj.search(searchw,adjobj.focusnode);
					break;
				}
				break;

			case 4:
				System.out.printf("%-40s %s %-40s %s %-40s %s %-40s %s %-39s %s"," ","Which type of word do you want to search?\n"," ","1. Noun \n"," ","2. Verb \n"," ","3. Adjective \n"," ","Enter your choice : ");//"which type do you want to study?\n1.nouns\n2.verbs\n3.adjectives\n4.numbers");
				inputchoice=scan.nextInt();
				switch(inputchoice) 
				{
				case 1:
					nounobj.focusnode=nounobj.root;
					nounobj.flashcards();
					break;
				case 2:
					verbobj.focusnode=verbobj.root;
					verbobj.flashcards();
					break;
				case 3:
					adjobj.focusnode=adjobj.root;
					adjobj.flashcards();
					break;
				}
				break;

			case 5:
				bloop=false;
				break;

			}
			System.out.println("     _____________________________________________________________________________________________________________________");
			scan.close();
		}
		System.out.println();
		System.out.printf("%-50sEXITED SUCCESSFULLY"," ");
	}
}