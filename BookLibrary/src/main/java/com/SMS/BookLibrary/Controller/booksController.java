package com.SMS.BookLibrary.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.Unauthorized;

import com.SMS.BookLibrary.Exception.DataNotFound;
import com.SMS.BookLibrary.Exception.UnAuthorizedException;
import com.SMS.BookLibrary.Model.Book;
import com.SMS.BookLibrary.Model.Reponse;
import com.SMS.BookLibrary.Services.BookServices;



@RestController
@RequestMapping("/books")
public class booksController {
	
	///dependdny injection off service////
	@Autowired
	BookServices bookServices; 
	
	@RequestMapping("/getAll")
	public Reponse<ArrayList<Book>> getAllBooks(){
		
		return bookServices.getAllBooks();
		
		
	}

	
	
	
	//@RequestMapping("/get/{minPage}/{maxPage}/{publishDate}")
	@RequestMapping(value = "/getSpecificBook", method=RequestMethod.GET)
	public Reponse<ArrayList<Book>> getSpecificBook(@RequestParam(value="minPage", required = false) Integer minPage, @RequestParam(value="maxPage",required = false) Integer maxPage, 
			@RequestParam(value="publishDate",required = true) String publishDate, @RequestHeader String username, @RequestHeader String password) throws DataNotFound, MissingServletRequestParameterException, UnAuthorizedException{
		
		return bookServices.getSpecificBooks(minPage, maxPage, publishDate, username, password);
		
		
	}
}
