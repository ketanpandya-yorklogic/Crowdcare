package ketan.code.crowdcare2;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Crowdcare1Application {
	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		String titles[] = getInput();
		Displayer disp = new Displayer();
		
		for (String title: titles){
			new SearchThread(title, disp).run();
		}
	}
	
	private static String[] getInput(){
		List<String> alist = new ArrayList<String>();
		String str = null;
		String rarray[];
		
		for (int i=0; i < 5; i++){
			System.out.println("Enter title to search > ");
			str = input.nextLine();
			if (str.trim().length() > 0){
				alist.add(str);
			}
		}
		rarray = new String[alist.size()];
		return alist.toArray(rarray);
	}
}

class SearchThread extends Thread{
	private final String title;
	private final Displayer disp;
	
	SearchThread(String title, Displayer disp){
		this.title=title;
		this.disp=disp;
	}
	public void run()
	{
		Search search = new Search(title);
		disp.printResults(search.doWikiQuery(), title);
	}
}

class Displayer{
	synchronized void printResults(ArrayList<SearchResult> res, String title){
		System.out.println("Search result for --> "+title);
		for (SearchResult robj:res){
		       System.out.printf("Title:[%s] URL:[%s]%n",
		        		robj.getTitle(), robj.getUrl());					
		}
 	}
}




