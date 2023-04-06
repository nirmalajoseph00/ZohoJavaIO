package Hack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class BrowserMainMenu{
	
	public static Scanner in = new Scanner(System.in); //globally declared scanner is static since non-static variable i/p cannot be referenced from static content
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
		char c='Y' ;
		int choice;
		int steps;
		
		Browser newTab=new Browser();
		Browser.BrowserHistory browserHistoryObject=newTab.new BrowserHistory();
		
		do
		{
			System.out.println("\n Main Menu \n 1.Visit URL \n 2.Go back in History \n 3.Go forward in History \n 4.Get url from position "
					+ "\n 5.View Sorted Url \n 6.Delete \n 7.Fetch History \n 8.Search Extension \n 9.Size \n 10.Update History "
					+ "\n 11.Write to File \n 12.Read File \n 13.Quit");
			System.out.println("Enter your choice: ");
			choice = in.nextInt();
			
			switch(choice)
			{
			case 1:
				String visitUrl;
				System.out.println("Enter the url you want to visit: ");
				visitUrl = reader.readLine();
				browserHistoryObject.visit(visitUrl);
				break;
			case 2:
				String backUrl;
				System.out.println("Enter the number of steps you want to move back: ");
				steps=in.nextInt();
				backUrl=browserHistoryObject.back(steps);
				System.out.println("Current url: "+ backUrl);
				break;
			case 3:
				String forwardUrl;
				System.out.println("Enter the number of steps you want to move forward: ");
				steps=in.nextInt();
				forwardUrl=browserHistoryObject.forward(steps);
				System.out.println("Current url: "+forwardUrl);
				break;
			case 4:
				int position;
				String urlInPosition;
				System.out.println("Enter the position of url you want to get: ");
				position=in.nextInt();
				urlInPosition=browserHistoryObject.getUrl(position-1);
				if (urlInPosition!=null)
					System.out.println(urlInPosition);
				break;
			case 5:
				browserHistoryObject.sortUrls();
				break;
			case 6:
				int urlDeleteIndex;
				String urlDelete;
				System.out.println("Enter the index of url you want to remove: ");
				urlDeleteIndex=in.nextInt();
				System.out.println("Enter the url you want to remove: ");
				urlDelete=reader.readLine();
				browserHistoryObject.deleteUrl(urlDeleteIndex, urlDelete);
				break;
			case 7:
				browserHistoryObject.fetchHistory();
				break;
			case 8:
				String extension;
				System.out.println("Enter the extension you want to search: ");
				extension=reader.readLine();
				browserHistoryObject.searchExtension(extension);
				break;
			case 9:
				browserHistoryObject.sizeHistory();
				break;
			case 10:
				int urlModify;
				String modifiedUrl;
				System.out.println("Enter the index of url you want to modify: ");
				urlModify=in.nextInt();
				System.out.println("Enter the modified url: ");
				modifiedUrl=reader.readLine();
				browserHistoryObject.urlModify(urlModify,modifiedUrl);
				break;
			case 11:
				browserHistoryObject.writeToFile();
				break;
			case 12:
				browserHistoryObject.readFile();
				break;
			case 13:
				System.out.println("Do you want to continue(Y/N): ");
				c=in.next().charAt(0);
				break;
			default:
				System.out.println("Wrong choice");
			}
			
		}while(c=='Y');
		System.out.println("Goodbye");
		in.close();

	}
}

