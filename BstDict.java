package spanishDict;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class BstDict 
{
	Scanner scan=new Scanner(System.in);
	
	int a =0, b=0;//Added by Asmita
	String wordlist[]= new String[300];//Added by Asmita
	
	String word, meaning, upword, upmean, del;
	int choice, correct=0, wrong=0;
	Boolean isleftchild;
	WordNode root, focusnode, parent;
	
	BstDict()
	{
		root=null;
	}
	void create(String word,String meaning) 
	{
		WordNode newnode= new WordNode(word, meaning);
		while(true) {
			if(root==null) {//if there are no words in dict
				root=newnode;
				focusnode=root;
				return;
			}
			else {
				parent=focusnode;
				if(parent.word.compareTo(newnode.word)>0) {
					focusnode=focusnode.left;
					if(parent.left==null) {
						parent.left=newnode;
						focusnode=parent.left;
						return;
					}
				}
				else {
					focusnode=focusnode.right;
					if(parent.right==null) {
						parent.right=newnode;
						focusnode=parent.right;
						return;
					}
				}
			}
		}
	}
	void displayWords(WordNode focusnode, String arr[]) 
	{
		if(focusnode==null)
			return;
		displayWords(focusnode.left, this.wordlist);
		this.wordlist[a] = focusnode.word; //for table like display
		a++; //for the same
		displayWords(focusnode.right, this.wordlist);
	}
	void display(WordNode focusnode) //Added by Asmita, for table like display of words
	{
		displayWords(focusnode,this.wordlist);
		int x=0;
	    while(x<a)
	    {
	        for(int i=0;i<4;i++)
	        {
	        	if(this.wordlist[x]==null)
	        		break;
	            System.out.printf("%-7s %-25s"," ",this.wordlist[x]);
	            x++;
	        }
	        System.out.println();
	    }
	}
	void displayAll(WordNode focusnode) 
	{
		if(focusnode==null)
			return;
		displayAll(focusnode.left);
		focusnode.displayMeaning();
		displayAll(focusnode.right);
	}
	void search(String searchw,WordNode focusnode) 
	{
		if(focusnode!=null) 
		{
			if(searchw.compareTo(focusnode.word)==0) 
			{
				focusnode.displayMeaning();
			}
			else 
			{
				if(focusnode.word.compareTo(searchw)>0) 
				{//left child
					focusnode=focusnode.left;
					search(searchw,focusnode);
				}
				else 
				{//right child
					focusnode=focusnode.right;
					search(searchw,focusnode);
				}
			}
		}
		else 
		{
			System.out.println("The word is not in the dictionary");
		}
	}
	void flashcards() 
	{
		String answer="";
		System.out.println();
		System.out.printf("%-40sWhat is the meaning of "+focusnode.word+ " ? "," ");
		System.out.println();
		System.out.printf("%-55s"," ");
		answer=scan.nextLine();
		if(answer.equalsIgnoreCase(focusnode.meaning)) 
		{
			correct++;
			System.out.printf("%-40sYou got that right!\n"," ");
			System.out.printf("%-40sCorrect answers: "+correct+" | Wrong answers: "+wrong, " ");
			System.out.println();
		}
		else 
		{
			wrong++;
			System.out.printf("%-40sWrong :(\n"," ");
			System.out.printf("%-40sThe meaning of the word is "+focusnode.meaning+"\n"," ");
			System.out.printf("%-40sCorrect answers: "+correct+" | Wrong answers: "+wrong," ");
			System.out.println();
		}
		System.out.printf("%-40sDo you want to continue?\n%-40s1. Yes!\n%-40s2. No :("," "," "," ");
		System.out.println();
		System.out.printf("%-40sEnter your choice : "," ");
		int contichoice=scan.nextInt();
		scan.nextLine();
		if (contichoice==1) 
		{
			focusnode=focusnode.left;//try using random for this so it will randomly go left or right
			flashcards();
		}
	}
}

class Nouns extends BstDict
{
	String line,word,meaning;
	int i;
	void NounBst() throws FileNotFoundException 
	{
		File nounfile=new File("C:\\Users\\Sandeep\\Desktop\\Java quetions\\Miniproject\\src\\nouns.txt");
		Scanner scanfile=new Scanner(nounfile,"UTF-8");//scans in nounfile 
		while(scanfile.hasNextLine()) 
		{//checks if the file has a next line
			i=0;
			word="";
			meaning="";
			line=scanfile.nextLine();
			while(line.charAt(i)!=':')
			{//get our word from the line
				word=word+line.charAt(i);
		        i++;
			}
			word=word.trim();//removes spaces from start and end of word
			i++;
			while(i<line.length()) 
			{//get our meaning which is after : from the line
				meaning=meaning+line.charAt(i);
				i++;
			}
			meaning=meaning.trim();//removes spaces from start and end of word
			focusnode=root;
			create(word, meaning);//send to create to create node
		}
		scanfile.close();
	}
}

class Verbs extends BstDict
{
	String line,word,meaning;
	int i=0;
	void VerbBst() throws FileNotFoundException 
	{
		File verbfile=new File("C:\\Users\\Sandeep\\Desktop\\Java quetions\\Miniproject\\src\\verbs.txt");
		Scanner scanfile=new Scanner(verbfile,"UTF-8");//scans in verbfile 
		while(scanfile.hasNextLine()) 
		{//checks if the file has a next line
			i=0;
			word="";
			meaning="";
			line=scanfile.nextLine();
			while(line.charAt(i)!=':')
			{//get our word from the line
				word=word+line.charAt(i);
		        i++;
			}
			word=word.trim();//removes spaces from start and end of word
			i++;
			while(i<line.length()) 
			{//get our meaning which is after : from the line
				meaning=meaning+line.charAt(i);
				i++;
			}
			meaning=meaning.trim();//removes spaces from start and end of word
			focusnode=root;
			create(word, meaning);//send to create to create node
		}
		scanfile.close();
	}
}

class Adjectives extends BstDict
{
	String line,word,meaning;
	int i=0;
	void AdjBst() throws FileNotFoundException 
	{
		File adjfile=new File("C:\\Users\\Sandeep\\Desktop\\Java quetions\\Miniproject\\src\\adjectives.txt");
		Scanner scanfile=new Scanner(adjfile,"UTF-8");//scans in adjfile 
		while(scanfile.hasNextLine()) 
		{//checks if the file has a next line
			i=0;
			word="";
			meaning="";
			line=scanfile.nextLine();
			while(line.charAt(i)!=':')
			{//get our word from the line
				word=word+line.charAt(i);
		        i++;
			}
			word=word.trim();//removes spaces from start and end of word
			i++;
			while(i<line.length()) 
			{//get our meaning which is after : from the line
				meaning=meaning+line.charAt(i);
				i++;
			}
			meaning=meaning.trim();//removes spaces from start and end of word
			focusnode=root;
			create(word, meaning);//send to create to create node
		}
		scanfile.close();
	}
}
