package com.test.groovy

class MainClass {

	static main(args){
		
		 new Util().getWeatherInformations().description.each{
			 println it
		 }
		
	}
}
