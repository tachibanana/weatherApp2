package com.test.groovy
import wslite.soap.*
class Services {

	//return GetCityForecastByZIPResult
	private def getCityForecastByZIP(zip){
		def client = new SOAPClient('http://wsf.cdyne.com/WeatherWS/Weather.asmx')
		def response = client.send(SOAPAction:'http://ws.cdyne.com/WeatherWS/GetCityForecastByZIP'){
			body{
				GetCityForecastByZIP(xmlns:'http://ws.cdyne.com/WeatherWS/'){ZIP(zip)}
			}
		}
		response.GetCityForecastByZIPResponse.GetCityForecastByZIPResult
	}
	
	//return GetCityWeatherByZIPResult
	private def getCityWeatherByZIP(zip){
		def client = new SOAPClient('http://wsf.cdyne.com/WeatherWS/Weather.asmx')
		def response = client.send(SOAPAction:'http://ws.cdyne.com/WeatherWS/GetCityWeatherByZIP'){
			body{
				GetCityWeatherByZIP(xmlns:'http://ws.cdyne.com/WeatherWS/'){ZIP(zip)}
			}
		}
		response.GetCityWeatherByZIPResponse.GetCityWeatherByZIPResult
	}
	
	//return GetWeatherInformationResult
	 def getWeatherInformation(){
		def client = new SOAPClient('http://wsf.cdyne.com/WeatherWS/Weather.asmx')
		def response = client.send(SOAPAction:'http://ws.cdyne.com/WeatherWS/GetWeatherInformation'){
			body{
				GetWeatherInformation(xmlns:'http://ws.cdyne.com/WeatherWS/')	
			}
			
		}
				
		response.GetWeatherInformationResponse.GetWeatherInformationResult		
	}
}
