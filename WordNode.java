package spanishDict;

public class WordNode
{
	WordNode left;
	WordNode right;
	String word;
	String meaning;
	
	WordNode(String word, String meaning)
	{
		left=right=null;
		this.word=word;
		this.meaning=meaning;
	}
	void displayMeaning() 
	{
		System.out.printf("%-35s %-25s : %s"," ",word,meaning);
		System.out.println();
	}
}
