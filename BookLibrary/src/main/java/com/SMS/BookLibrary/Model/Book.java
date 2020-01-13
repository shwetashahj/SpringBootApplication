package com.SMS.BookLibrary.Model;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public class Book{
	
	
	/*
	 * @JsonProperty to map the variable with the Keys in JSON Response
	 * 
	 * */
	
	@JsonProperty(value = "ID")
	int id;
	
	@JsonProperty(value = "Title")
	String title;
	
	@JsonProperty(value = "Description")
	String description;
	
	@JsonProperty(value = "PageCount")
	int pageCount;
	
	@JsonProperty(value = "Excerpt")
	String excerpt;
	
	@JsonProperty(value = "PublishDate")
	String publishDate;
	
	
    ArrayList<String> authors;

    
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getPageCount() {
		return pageCount;
	}


	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}


	public String getExcerpt() {
		return excerpt;
	}


	public void setExcerpt(String excerpt) {
		this.excerpt = excerpt;
	}


	public String getPublishDate() {
		return publishDate;
	}


	public void setPublishDate(String publishDate) {
		
		/*
		 * How to convert time stamp into wanted date fornat
		 * 
				String line = "2013-10-27T13:00:00.325234Z";
				Timestamp ts = Timestamp.valueOf(line.replace("T"," ").replace("Z",""));
				 Date date=new Date(ts.getTime());  
				 SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-YYY");
		       System.out.println(dateFormat.format(date));  
		 * 
		 * */
		
		//Taking date from time stamp
		String date = publishDate.substring(0 , 10);
		
		//Spliting date month and year from string
		String [] splitDate = date.split("-");
		
		//Putting the date month and year in wanted format
		this.publishDate = splitDate[2] + "-" + splitDate[1] + "-" + splitDate[0];
		
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String dateInString = "23-11-2019";

        try {

            Date date1 = formatter.parse(dateInString);
            System.out.println(date1);
            
            
            
            
            // sSystem.out.println(formatter.format(date));

        } catch (Exception e) {
            e.printStackTrace();
        }

		
	}


	public ArrayList<String> getAuthors() {
		return authors;
	}


	public void setAuthors(ArrayList<String> authors) {
		this.authors = authors;
	}


	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", description=" + description + ", pageCount=" + pageCount
				+ ", excerpt=" + excerpt + ", publishDate=" + publishDate + ", authors=" + authors + "]";
	}
	
	
	
	
}
