package Hack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.TreeSet;

class Reference
{
	public static int currentPosition=-1;
	public static int filePosition=0;
}

interface Shortcuts {
	void addShortcut(String shortcutUrl);
	void viewShortcuts();
}


class InvalidURLException extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidURLException(String s)
	{
		super(s); 
	}
}
@SuppressWarnings("serial")
class NoHistoryFoundException extends Exception {
	public NoHistoryFoundException(String s)
	{
		super(s); 
	}
}
@SuppressWarnings("serial")
class InvalidPositionException extends Exception {
	public InvalidPositionException(String s)
	{
		super(s); 
	}
}

class Browser {
	private ArrayList<String> url = new ArrayList<>();
	private LinkedList<String> urlLinkedList=new LinkedList<String>();
	private HashSet<String> urlHashSet=new HashSet<String>(); 
	private LinkedHashSet<String> urlLinkedHashSet=new LinkedHashSet<String>();
	private TreeSet<String> urlTreeSet=new TreeSet<String>();
	
	Browser(){
		//empty constructor
	}
	
	public void display()  
	{  
		System.out.println("Browser History \n");
		for(int i=0;i<url.size();i++)
			System.out.println(url.get(i)+"\n");
	}
	
	class BrowserHistory
	{  
		Hacker hackerObject=new Hacker();
		int extensionIndex;
		String extension;
		String[] extensionsArray= {".com",".in",".org"};
		
		public void loopElements(Collection collectionName)
		{
			for(Object element:collectionName)    
			    System.out.println(element);
		}
		
		void visit(String visitUrl)
		{
			try
			{
				extensionIndex=visitUrl.lastIndexOf(".");
				extension=visitUrl.substring(extensionIndex, visitUrl.length());
				if (Arrays.asList(extensionsArray).contains(extension))
				{
					Reference.currentPosition++;
					url.add(Reference.currentPosition,visitUrl);
				}
				else
				{
					throw new InvalidURLException("Invalid url exception");
				}
			}
			catch(InvalidURLException urlException)
			{
				System.out.println(urlException.getMessage());
			}
		}
		public void sortUrls()
		{
			List<String> visitUrlSort = new ArrayList<String>(url);
			
			System.out.println("SORTED URLS:");
			visitUrlSort.sort(null);
			System.out.println("Array List");
			loopElements(visitUrlSort); 
		}
		public void deleteUrl(int indexUrl, String urlDelete)
		{
			url.remove(indexUrl);
			fetchHistory();
		}
		public void fetchHistory()
		{
			System.out.println("VISITED URLS:");
			System.out.println("Array List");
			loopElements(url); 
		}
		public void searchExtension(String extensionSeached) 
		{
			System.out.println("Seaching in List");
			for(String urlElement:url)
			{
				extensionIndex=urlElement.lastIndexOf(".");
				extension=urlElement.substring(extensionIndex, urlElement.length());
				if (extension.equals(extensionSeached))
					System.out.println(urlElement);
			}
		}
		public void sizeHistory() 
		{
			System.out.println("Browser History Size: " + url.size());	
			
		}
		public void urlModify(int indexModifyUrl, String modifiedUrl)
		{
			//String urlToBeModified;
			//urlToBeModified=url.get(indexModifyUrl);
			
			url.set(indexModifyUrl, modifiedUrl);
			fetchHistory();
		}
		
		public String back(int steps)
		{
			int currentUrlPosition=Reference.currentPosition;
			try
			{
				ListIterator<String> urlIterator = url.listIterator(currentUrlPosition);
				for(int i=0;i<steps;i++) 
				{
					if (urlIterator.hasPrevious())
					{
						urlIterator.previous();
						Reference.currentPosition--;
					}
					else
						throw new NoHistoryFoundException("No History Found");
				}
				//Reference.currentPosition++;
				//System.out.println(url.get(Reference.currentPosition));
				return (urlIterator.next());
			}
			catch(NoHistoryFoundException noHistoryFound)
			{
				Reference.currentPosition=currentUrlPosition;
				System.out.println(noHistoryFound.getMessage());
			}
			//System.out.println(url.get(Reference.currentPosition));
			return url.get(currentUrlPosition);
		}
		public String forward(int steps)
		{
			int currentUrlPosition=Reference.currentPosition;
			try
			{
				ListIterator<String> urlIterator = url.listIterator(currentUrlPosition);
				for(int i=0;i<=steps;i++) 
				{
					if (urlIterator.hasNext())
					{
						urlIterator.next();
						Reference.currentPosition++;
					}
					else
						throw new NoHistoryFoundException("No History Found");
				}
				Reference.currentPosition--;
				//System.out.println(url.get(Reference.currentPosition));
				return(urlIterator.previous());
			}
			catch(NoHistoryFoundException noHistoryFound)
			{
				Reference.currentPosition=currentUrlPosition;//return to current url
				System.out.println(noHistoryFound.getMessage());
			}
			
			//System.out.println(url.get(Reference.currentPosition));
			return url.get(currentUrlPosition);
		}
		public String getUrl(int position)
		{
			String urlInPosition=null;
			try
			{
				if (position<0)
				{
					throw new InvalidPositionException("Provide only positive values");
				}
				else
					urlInPosition=url.get((position));
			}
			catch(InvalidPositionException | ArrayIndexOutOfBoundsException invalidPosition)
			{
				System.out.println(invalidPosition.getMessage());
			}
			catch(Exception e)
			{
				System.out.println("Invalid position");
			}
			return urlInPosition;
		}
		
		public void writeToFile()
		{
			hackerObject.writeHistoryFile(url);
		}
		public void readFile()
		{
			hackerObject.readHistoryFile();
		}
		
	  }
}

