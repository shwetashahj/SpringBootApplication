package com.SMS.BookLibrary.Services;


import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.SMS.BookLibrary.Exception.DataNotFound;
import com.SMS.BookLibrary.Exception.UnAuthorizedException;
import com.SMS.BookLibrary.Model.Author;
import com.SMS.BookLibrary.Model.Book;
import com.SMS.BookLibrary.Model.Reponse;
import com.SMS.BookLibrary.Model.User;




@Service
public class BookServices {

	public Reponse<ArrayList<Book>> getAllBooks() {	
	    
		//Local Variable 
		ArrayList<Book> books = new ArrayList<>();
		Reponse<ArrayList<Book>> response = new Reponse<>();			
		
		//API calling to get book data
		final String url = "https://fakerestapi.azurewebsites.net/api/Books";
		RestTemplate restTemplate = new RestTemplate();
		Book[] result = restTemplate.getForObject(url, Book[].class);
		books = new ArrayList<Book>(Arrays.asList(result));
		//Get the JSON in String format to check
		//String result = restTemplate.getForObject(uri, String.class);
		
		
		
		/*How to add header in Rest Template
		 * 
			HttpHeaders headers = new HttpHeaders();
			
			//Adding content type
			headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
			       OR
			headers.setContentType(MediaType.APPLICATION_JSON);	
			
			//Creating a entity with our Header
			HttpEntity entity = new HttpEntity(headers);
			
			
			ResponseEntity<Book[]> res = restTemplate.exchange(url, HttpMethod.GET, entity, Book[].class);	
			books = new ArrayList<Book>(Arrays.asList(res.getBody()));
		 */
		
		//To print the JSON
		//System.out.println(Arrays.toString(result));
		
		
			//API calling to get Author data
			final String authorUrl = "https://fakerestapi.azurewebsites.net/api/Authors";
			RestTemplate authorRestTemplate = new RestTemplate();
		    Author[] authorResult = authorRestTemplate.getForObject(authorUrl, Author[].class);

		
     		HashMap<Integer,ArrayList<String>> authorMap = new HashMap<>();
		
     		   for(int i=0; i< authorResult.length; i++) {
     			  
     			   if(authorMap.containsKey(authorResult[i].getIdBook())) {
     				    
     				   ArrayList<String> authors = authorMap.get(authorResult[i].getIdBook());
     				   String firstName = authorResult[i].getFirstName();
     				   
     				   String lastName = authorResult[i].getLastName();
     				   
     				   String fullName = firstName.concat(" " + lastName);
     				   
     				   authors.add(fullName);
     				   authorMap.put(authorResult[i].getIdBook(),authors);
     				   
     			

     			  }else {
     				  
       				ArrayList<String> authors = new ArrayList<String>();
       				String firstName = authorResult[i].getFirstName();
  				   
  				   String lastName = authorResult[i].getLastName();
  				   
  				   String fullName = firstName.concat(" " + lastName);
  				   
  				   authors.add(fullName);
  				   authorMap.put(authorResult[i].getIdBook(),authors);

     			  }
				}
     		   
     		   
     		  for(Book book: books){
     				
     				if(authorMap.containsKey(book.getId())) {
     					
  
     					 book.setAuthors(authorMap.get(book.getId()));
     				}
     			}	
		
		
		
		response.setData(books);
		response.setMessage("Success");
		response.setSuccess(true);
		
		return response;
		
	}
	
	      
	
	
	public Reponse<ArrayList<Book>> getSpecificBooks(Integer minPage, Integer maxPage, String publishDate, String username, String password){
		

		 if(validateTheUser(username, password)) {
			 

		//Local Variable 
	    ArrayList<Book> books = new ArrayList<>();

	   ArrayList<Book>  specificBook = new ArrayList<>();
		Reponse<ArrayList<Book>> response = new Reponse<>();
		
		
		//API calling to get book data
		final String url = "https://fakerestapi.azurewebsites.net/api/Books";
		RestTemplate restTemplate = new RestTemplate();
		Book[] result = restTemplate.getForObject(url, Book[].class);
		books = new ArrayList<Book>(Arrays.asList(result));
		
			
		//API calling to get Author data
		final String authorUrl = "https://fakerestapi.azurewebsites.net/api/Authors";
		RestTemplate authorRestTemplate = new RestTemplate();
	    Author[] authorResult = authorRestTemplate.getForObject(authorUrl, Author[].class);

	
 		HashMap<Integer,ArrayList<String>> authorMap = new HashMap<>();
	
 		   for(int i=0; i< authorResult.length; i++) {
 			  
 			   if(authorMap.containsKey(authorResult[i].getIdBook())) {
 				    
 				   ArrayList<String> authors = authorMap.get(authorResult[i].getIdBook());
 				   String firstName = authorResult[i].getFirstName();
 				   
 				   String lastName = authorResult[i].getLastName();
 				   
 				   String fullName = firstName.concat(" " + lastName);
 				   
 				   authors.add(fullName);
 				   authorMap.put(authorResult[i].getIdBook(),authors);
 				   
 			

 			  }else {
 				  
   				   ArrayList<String> authors = new ArrayList<String>();
   				String firstName = authorResult[i].getFirstName();
				   
				   String lastName = authorResult[i].getLastName();
				   
				   String fullName = firstName.concat(" " + lastName);
				   
				   authors.add(fullName);
				   authorMap.put(authorResult[i].getIdBook(),authors);

 			  }
			}
 		   
 		  for(Book book: books){
				
 			// && book.getPublishDate() == "15-11-2019"
 			  
 			
 			  if(minPage != null && maxPage != null) {
 				  
 				 System.out.println("max");
 				  if(book.getPageCount()>minPage && book.getPageCount()<maxPage && book.getPublishDate().equals(publishDate)) {
 	 				 
// 					 DateTimeFormatter dateFormatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
// 					LocalDate fdtObj1 = LocalDate.parse("16-09-2016", dateFormatter1);
// 					System.out.println("Date object: "+fdtObj1);
// 					System.out.println("Date object: "+dateFormatter1.format(fdtObj1));
 	 				 // System.out.println(book.getPageCount());
 	 				  if(authorMap.containsKey(book.getId())) {
 	 					
 	                    book.setAuthors(authorMap.get(book.getId()));
 						
 						 specificBook.add(book);
 						 
 					}	  
 	 			  }  
 				  
 				  
 				  
 			  }else if(minPage == null && maxPage == null) {
 				  
 				 if( book.getPublishDate().equals(publishDate)) {
 	 				 
 	 				 System.out.println("heymin");
 	 				  if(authorMap.containsKey(book.getId())) {
 	 					
 	                    book.setAuthors(authorMap.get(book.getId()));
 						
 						 specificBook.add(book);
 						 
 					}	  
 	 			  }
 			  }else if(minPage == null) {
 				  
 				 if( book.getPageCount()<maxPage && book.getPublishDate().equals(publishDate)) {
 	 				 
 	 				 System.out.println("heymin");
 	 				  if(authorMap.containsKey(book.getId())) {
 	 					
 	                    book.setAuthors(authorMap.get(book.getId()));
 						
 						 specificBook.add(book);
 						 
 					}	  
 	 			  }
 			  }else if(maxPage == null) {
 				  
 				 System.out.println("max");
                   if( book.getPageCount()<minPage && book.getPublishDate().equals(publishDate)) {
 	 				 
 	 				 // System.out.println(book.getPageCount());
 	 				  if(authorMap.containsKey(book.getId())) {
 	 					
 	                    book.setAuthors(authorMap.get(book.getId()));
 						
 						 specificBook.add(book);
 						 
 					}	  
 	 			  }
 				  
 				  
 			  }
 			
				
			}	
	 		response.setData(specificBook);
	 		response.setMessage("Success");
	 		response.setSuccess(true);
 		
 		    return response;
		
		 }else {
			 
			 throw new UnAuthorizedException("Unathorized") ;
		 }
		
	}
	
	public Boolean validateTheUser(String username, String password) {
		
	            ArrayList<User> users = new ArrayList<>();

		        //API calling to get User data
				final String url = "https://fakerestapi.azurewebsites.net/api/Users";
				RestTemplate restTemplate = new RestTemplate();
				User[] result = restTemplate.getForObject(url, User[].class);
				users = new ArrayList<User>(Arrays.asList(result));
		
				for(User user: users) {
					
					if(user.getUserName().equals(username) && user.getPassword().equals(password)) {
						  System.out.println(username);
				            System.out.println(password);
						return true;
					}
				}
		
		         return false;
		
	}
	
	
}
