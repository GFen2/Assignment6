package garyfenton;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
public class Assignment6 {
	
	public static void main(String[] args) {
		
		File inputFile;
		Scanner fileInputScan = null;
		
		try
	    {
	      JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
	      int returnValue = jfc.showOpenDialog(null);

	      if (returnValue == JFileChooser.APPROVE_OPTION) {
	    	  inputFile = jfc.getSelectedFile();
	    	  
	    	  fileInputScan = new Scanner(inputFile);
	    	
	    	  ArrayList<String> listMCS = collectMCS(fileInputScan);
	    	  String MCSString = "";
	    	
	    	  for(int i = 0; i < listMCS.size(); i ++) {
	    		 
	    		  MCSString += listMCS.get(i) + "\n";
	    	  }
	    	  
	    	  System.out.println(MCSString);
	      }
	      
	    }
	    catch(FileNotFoundException s)
	    {
	      System.out.println("File does Not Exist Please Try Again: ");
	    }
	}
	
	public static ArrayList<String> collectMCS(Scanner fileInputScan) {
		
		Stack<String> stack = new Stack<String>();
		ArrayList<String> arrayList = new ArrayList<String>();
		int loc = 0;
		int forLoop = 0;
		int whileLoop = 0;
		int ifStatement = 0;
		boolean t = true;
		
		String codeLine = "";
		String possibleMCS = "";
		while (fileInputScan.hasNextLine()) {
			codeLine = fileInputScan.nextLine();
			
			codeLine = codeLine.trim();
			
			//System.out.println(codeLine);
			boolean method= false;
			if ((isCode(codeLine)) ) {
				
				String [] arr2 = codeLine.split(" ");
				
				if(codeLine.equals("/*")) {
					t = false;
				}
				if(t==false && codeLine.equals("*/")) {
					t = true;
					loc--;
				}
				if(t) {
				
				
				
				loc++;
				for(int i = 0; i < arr2.length; i++) {
					switch(arr2[i]) {
					  case "for":
					    forLoop++;
					    
					    break;
					  case "while":
					    whileLoop++;
					    
					    break;
					  case "if":
						ifStatement++;
						
						break;
					  case "void":
						
						method = true;
						
					  case "Int":
						
						method = true;
						break;
					  case "String":
						
						method = true;
						break;
					  case "Double":
						
						method = true;
						break;
					  case "Char":
						
						method = true;
						
						break;
						
					  default:
					    // code block
					}
				}
				if (!codeLine.equals("{") && !codeLine.equals("}")) {
					if (method == true) {
					possibleMCS = codeLine;
					}
				}
				else if (codeLine.equals("{")) {
					
					stack.push(possibleMCS);
					stack.toString();
				}
				else {
					arrayList.add(0, stack.pop());
				}
			}
		}
		}
		;
		System.out.println("The total number of lines is " + loc);
		System.out.println("The total number of if statements is " + ifStatement);
		System.out.println("The total number of for loops is " + forLoop);
		System.out.println("The total number of while loops is " + whileLoop);
		
		
		return arrayList;
			
	}
	
	public static boolean isCode(String str) {
		String[] arr = str.split("");
		if((str == "") || ((arr[0].equals("/") && (arr[1].equals("/"))))) {
			
			return false;
		}
		else {
			return true;
		}
	}
	
	

}
