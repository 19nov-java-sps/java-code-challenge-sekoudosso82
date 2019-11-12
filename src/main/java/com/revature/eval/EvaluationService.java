package com.revature.eval;

import java.util.List;
import java.util.Map;
import java.util.*;
public class EvaluationService 
{

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	
	public String reverse(String string) 
	{
		System.out.println("original string is: " +string);

		String reversString = "" ;
		for (int i = string.length()-1 ; i >= 0; i--)
		{
			reversString = reversString + string.charAt(i);
		}
		System.out.println("the reverse of this string is: " +reversString);
		return null;
	}

	
	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	
	Scanner sc = new Scanner(System.in);
	
	public String acronym(String phrase) 
	{
		System.out.println("Enter string to reverse:");
        String stringInput = sc.nextLine();
        
        String myAcronym = stringInput.replaceAll("\\B.|\\P{L}", "").toUpperCase();
        
        System.out.println("the acronym for this phrase is: " + myAcronym );
      	
		return null;
	}
	
	/**
	 * 3. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	
	public static int getScrabbleScore(String string) 
	{
        String stringInputToUppercase = string.toUpperCase(); // convert input to uppercase
        // System.out.println("the converting input to uppercase is: " + stringInputToUppercase);
        String s1 = "AEIOULNRST"; //1
        String s2 = "DG"; //2
        String s3 = "BCMP"; //3
        String s4 = "FHVWY"; //4
        String s5 = "K"; //5
        String s6 = "J,X"; //8
        String s7 = "QZ"; //10

        int counter = 0; // initialize a counter to compute the sum of different chars
        char[] charArray = stringInputToUppercase.toCharArray();

        for (char c : charArray )
        {
            if (s1.indexOf(c) != -1){ counter = counter + 1 ; }
            else if (s2.indexOf(c) != -1){ counter = counter + 2 ; }
            else if (s3.indexOf(c) != -1){ counter = counter + 3 ; }
            else if (s4.indexOf(c) != -1){ counter = counter + 4 ; }
            else if (s5.indexOf(c) != -1){ counter = counter + 5; }
            else if (s6.indexOf(c) != -1){ counter = counter + 8; }
            else if (s7.indexOf(c) != -1){ counter = counter + 10; }
        }
        System.out.println("total: " + counter);
        return 0;
    }
	
	
	/**
	 * 4. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return 
	 */
	
	public Map<String, Integer> wordCount(String string) 
	{
		// split the input string and add each element to a string array
        // use for loop to iterate over the array
        // if element is not in HashMap add it with value 1
        // else add 1 to the value

        String[] stringArray = string.split(" ");
        Map<String, Integer> myHashMap = new HashMap<String, Integer>();

        for (String s: stringArray )
        {
            if (myHashMap.containsKey(s))
            { myHashMap.put(s, myHashMap.get(s) +1 ); }
            else
            { myHashMap.put(s, 1); }
        }

        Set<String> keysSet = myHashMap.keySet();
        for (String s : keysSet)
        {   System.out.println( s +":" + myHashMap.get(s)+" " ); }
		return null;
	}
	
	/**
	 * 5. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T>
    {
		private List<T> sortedList;
		public int indexOf(T t)
        {

			// get the list size , our list is T
            int listSize = (sortedList.size() - 1);
            // start the search at the 2 ends of the list
            int lenftEnd = 0;
            int rightEnd = 0;
            // divide the list by 2 and iterate over each list
            while (lenftEnd <= rightEnd)
            {
                // calculate the middle ot each list
                int midPoint = (lenftEnd + rightEnd)/2;
                System.out.println("midPoint: "+ midPoint);
                // if search item is midPoint then return midPoint index
//                if (sortedList.indexOf(midPoint) == t)
                if (sortedList.indexOf(t) == midPoint)
                    {   return midPoint; }
                // search the item in other subList
                else if ( sortedList.indexOf(t)>0)
                    {   lenftEnd = midPoint + 1; }
                else
                    { rightEnd = midPoint -1 ; }
            }
            System.out.println(" found at " + sortedList.indexOf(t));
			return 0;

		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	
}
