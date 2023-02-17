package com.xyz.automationtestingdemo.testpackage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationTests {

	WebDriver driver;
	
	@Test
	public void sampleTest() throws InterruptedException, AWTException
	{
		ChromeOptions options = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		driver.get("https://www.safeway.com");
	    driver.manage().window().maximize();
        
        //Implicit Wait - Holds the execution globally for 20 secs until the element is available
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        
        driver.findElement(By.xpath("//button[text()='Accept All']")).click();
        List<WebElement> elements = driver.findElements(By.xpath("//div[contains(@aria-label,'Sign in to add')]"));
        for(int i =0;i<elements.size();i++)
        {
        	System.out.println(elements.get(i).getAttribute("aria-label"));
        }
        
		driver.findElement(By.xpath("//span[contains(@class,'sign-in')]")).click();
		driver.findElement(By.xpath("//a[contains(@class,'signIn') and @id='sign-in-modal-link']")).click();
		if (driver.findElements(By.xpath("//input[@name='userId']")).size() >=1)
		{
			driver.findElement(By.xpath("//input[@name='userId']")).sendKeys("xyz@gmail.com");
			driver.findElement(By.xpath("//input[@name='inputPassword']")).sendKeys("testing123");
			driver.findElement(By.xpath("//input[@id='btnSignIn']")).click();
		}
		Thread.sleep(5000);
		
		driver.quit();
		
		
		/*
		 * List<WebElement> eles = driver.findElements(By.xpath("")); Set<String>
		 * windows = driver.getWindowHandles(); String currentWindowHandle =
		 * driver.getWindowHandle(); for(String handle:windows) {
		 * driver.switchTo().window(handle).getTitle(); }
		 * driver.switchTo().window(windows.toArray()[2].toString());
		 * 
		 * Select ele = new Select(driver.findElement(By.xpath("")));
		 * ele.selectByIndex(0); ele.selectByValue("antartica");
		 * ele.selectByVisibleText("ANTARTICA");
		 * 
		 * Robot robot = new Robot(); robot.keyPress(KeyEvent.VK_CONTROL);
		 * robot.keyPress(KeyEvent.VK_A); robot.keyRelease(KeyEvent.VK_CONTROL);
		 * 
		 * Actions action = new Actions(driver);
		 * action.click(driver.findElement(By.xpath("")));
		 * action.dragAndDrop(source,dest);
		 */
		 
	}
	
	@Test
	public void javaCollectionsDemo()
	{
		//Arrays
		System.out.println("********Arrays*********");
		int[] arr = new int[3];
		for(int i=0;i<3;i++)
			arr[i]=i;
		for(int s: arr)
			System.out.println(s);
		
		String[] arr1 = new String[] {"Subba", "Automation"};
		for(int i=0;i<arr1.length;i++)
			System.out.println(arr1[i]);
		
		Arrays.sort(arr1);
		for(String s:arr1)
			System.out.println(s);
		
		Arrays.sort(arr1, Collections.reverseOrder());
		for(String s:arr1)
			System.out.println(s);
		
		System.out.println("********ArrayList*********");
		ArrayList<String> alist = new ArrayList<String>();
		alist.add("Testing");
		alist.add("Subba");
		alist.add("Automation");
		alist.add("Testing");
		alist.remove(1);
		Collections.sort(alist);
		Collections.sort(alist, Collections.reverseOrder());
		Collections.reverse(alist);
		for(String s:alist)
			System.out.println(s);
		
		System.out.println("********LinkedList*********");
		LinkedList<String> llist = new LinkedList<String>();
		llist.add("Testing");
		llist.add("Subba");
		llist.add("Automation");
		llist.add("Testing");
		Collections.sort(llist);
		for(String s:llist)
			System.out.println(s);
		
		//Set - Doesn't allow duplicate values
		//HashSet and LinkedHashSet allows null values but TreeSet doesn't allow null values
		//TreeSet - Sorts elements by default whereas HashSet ignores insertion order but LinkedHashSet considers the insertion order
		
		System.out.println("==============HashSet=============");
	  Set<String> hSet = new HashSet<String>();
	  hSet.add("India");
	  hSet.add("UK");
	  hSet.add("US");
	  hSet.add(null);
	  hSet.add("India");

	  for(String s: hSet)
	  {
		  System.out.println(s);  
	  }
		  
	  System.out.println("==============Linked HashSet=============");
	  Set<String> lhSet = new LinkedHashSet<String>();
	  lhSet.add("UK");
	  lhSet.add("US");
	  lhSet.add(null);
	  lhSet.add(null);
	  lhSet.add("India");
	  lhSet.add("India");

	  for(String s: lhSet)
	  {
		  System.out.println(s);  
	  }
	  
	  System.out.println("==============TreeSet=============");
	  TreeSet<String> tSet = new TreeSet<String>();
	  tSet.add("UK");
	  tSet.add("US");
	  //tSet.add(null);
	  tSet.add("India");
	  tSet.add("India");
	  TreeSet<String> desctSet = (TreeSet<String>)tSet.descendingSet();
	  for(String s: tSet)
	  {
		  System.out.println(s);  
	  }
	  for(String s: desctSet)
		  System.out.println(s);
	  
	  System.out.println("===========HashMap============");
	  Map<String, Integer> hmap = new HashMap<String, Integer>();
	  hmap.put("India", 91);
	  hmap.put("UK", 44);
	  hmap.put("US", 1);
	  hmap.put(null, null);
	  hmap.put("India", 92);
	  
	  for(Map.Entry m: hmap.entrySet())
	  {
		  System.out.println(m.getKey()+" "+m.getValue());  
	  }
	  
	  System.out.println("==============Linked HashMap==========="); 
	  	LinkedHashMap<Integer,String> hm=new LinkedHashMap<Integer,String>();  
	  	  
			  hm.put(100,"Amit");  
			  hm.put(101,"Vijay");  
			  hm.put(102,"Rahul");
			  hm.put(null,null); 
	  	  
			  for(Map.Entry<Integer, String> m: hm.entrySet()){  
				  System.out.println(m.getKey()+" "+m.getValue());  
			  } 
	
	  System.out.println("==============HashTable=============");
	  Hashtable<String, String> hTable = new Hashtable<String, String>();
	  hTable.put("", "India");
	  hTable.put("UK", "");
	  hTable.put("US", "");
	  //hTable.put(null, null);
	  hTable.put("India", "India");
	  
	  for(Map.Entry<String, String> m: hTable.entrySet())
	  {
		  System.out.println(m.getKey()+" "+m.getValue());  
	  }
	  
	  List<String> mList = new ArrayList<String>(hTable.keySet());
	  Collections.sort(mList);
	  for(String s:mList)
		  System.out.println(s);
	  Collections.reverse(mList);
	  for(String s:mList)
		  System.out.println(s);
		  
	  
	}
	
	@Test
	public void findDuplicates()
	{
		int duplicateCnt = 0;
		String[] arr = new String[] {"Subba", "Testing", "Automation", "Testing", "Subba"};
		for (int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if (arr[i].equals(arr[j]))
				{
					duplicateCnt++;
					System.out.println("Duplicate Element: " + arr[i]);
					break;
				}
			}
		}
		System.out.println(duplicateCnt);
		
		//Non-Duplicate
		int nonduplicatecount = 0;
		for (int i=0;i<arr.length;i++)
		{
			nonduplicatecount = 0;
			for(int j=0;j<arr.length;j++)
			{
				if (arr[i].equals(arr[j]))
				{
					nonduplicatecount++;
				}
			}
			if (nonduplicatecount ==1)
				System.out.println("Non-duplicate element: " + arr[i]);
		}
		
		HashSet<String> hset = new HashSet<String>();
		for(int i=0;i<arr.length;i++)
		{
			if(!(hset.add(arr[i])))
			{
				System.out.println("Duplicate Element: " + arr[i]);
			}
			else
				System.out.println("==NonDuplicate Element: " + arr[i]);
				
		}
		
		Hashtable<String, String> htable = new Hashtable<String, String>();
		for(int i=0;i<arr.length;i++)
		{
			if(htable.put(arr[i], "")!=null)
			{
				System.out.println("Duplicate Element: " + arr[i]);
			}
				
		}
		
		for(Map.Entry m: htable.entrySet())
			System.out.println(m.getKey() + "" + m.getValue());
	}
	
	@Test
	public void largestLine() throws IOException
	{
		Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a paragraph:");
        String paragraph = scanner.nextLine();
        String[] lines = paragraph.split("\\.");

        String maxWordsLine = "";
        int maxWordsCount = 0;
        for (String line : lines) {
            int wordsCount = line.trim().split("\\s+").length;
            if (wordsCount > maxWordsCount) {
                maxWordsLine = line;
                maxWordsCount = wordsCount;
            }
        }

        System.out.println("The line with the maximum number of words and count is:");
        System.out.println(maxWordsLine.trim());
        System.out.println(maxWordsCount);
        
        //Stream Class - Line with Max words in a paragraph or a file
        Stream<String> strLines = null;
        strLines = Files.lines(Paths.get("C:\\Users\\suvic\\Downloads\\TestingDocument.txt"));
        String[] sl = strLines.toArray(String[]::new); //Convert Stream object into an Array
        String lineWithMaxWords = null;
        int lineWithMaxCount = 0;
        for(String s: sl)
        {
        	String[] ss = s.split(" ");
        	if (ss.length > lineWithMaxCount)
        	{
        		lineWithMaxCount = ss.length;
        		lineWithMaxWords = s;
        	}
        		
        }
        System.out.println("Max Words Count: " + lineWithMaxCount);
        System.out.println("Max Words Line: " + lineWithMaxWords);
	}
	
}
