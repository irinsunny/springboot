package com.nissan.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.InvalidNameException;

import org.springframework.stereotype.Component;
@Component
public class Validation {
public Boolean isNameValid(String name)
{
	boolean bool=false;
	try
	{
		Pattern namePattern =Pattern.compile("[^A-Za-z]");
		Matcher nameMatcher= namePattern.matcher(name);
		if(nameMatcher.find()) {
			throw new InvalidNameException("invalid name");
			
		}
		else
		{
			bool=true;
		}
	}catch(InvalidNameException e)
	{
		e.getMessage();
	}
	return bool;
}
public Boolean isAcoountValid(String acno)
{
	boolean bool=false;
	try
	{
		Pattern namePattern =Pattern.compile("[^0-9]");
		Matcher nameMatcher= namePattern.matcher(acno);
		if(nameMatcher.find()) {
			if(acno.length()==9){
			throw new InvalidNameException("invalid AccountNo");
			}
		}
		else
		{
			bool=true;
		}
	}catch(InvalidNameException e)
	{
		e.getMessage();
	}
	return bool;
}
public Boolean isBalanceValid(String balance)
{
	boolean bool=false;
	try
	{
		Pattern namePattern =Pattern.compile("[^0-9]");
		Matcher nameMatcher= namePattern.matcher(balance);
		if(nameMatcher.find()) {
			throw new InvalidNameException("invalid balance");
			
		}
		else
		{
			bool=true;
		}
	}catch(InvalidNameException e)
	{
		e.getMessage();
	}
	return bool;
}

}
