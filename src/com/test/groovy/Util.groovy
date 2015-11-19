package com.test.groovy

class Util{
	
	private Services sv = new Services()
	
	//return CityForecast Object
	def getCityForecast(zip){
		def cityForecast = sv.getCityForecastByZIP(zip)
		def forecast = new Forecast(
			date:cityForecast.ForecastResult.Forecast.Date,
			weatherId:cityForecast.ForecastResult.Forecast.WeatherID,
			desciption:cityForecast.ForecastResult.Forecast.Desciption,
			tempMorningLow:cityForecast.ForecastResult.Forecast.Temperatures.MorningLow,
			tempDayTime:cityForecast.ForecastResult.Forecast.Temperatures.DaytimeHigh,
			probNightTime:cityForecast.ForecastResult.Forecast.ProbabilityOfPrecipiation.Nighttime,
			probDaytime:cityForecast.ForecastResult.Forecast.ProbabilityOfPrecipiation.Daytime
			)
		
		new CityForecast(
			success:cityForecast.Success,
			responseText:cityForecast.ResponseText,
			state:cityForecast.State,
			city:cityForecast.City,
			weatherStationCity:cityForecast.WeatherStationCity,
			forecast:forecast
			)
	}
	
	//return CityWeather Object
	def getCityWeather(zip){
		def cityWeather = sv.getCityWeatherByZIP(zip)
		new CityWeather(
			success:cityWeather.Success,
			responseText:cityWeather.ResponseText,
			state:cityWeather.State,
			city:cityWeather.City,
			weatherStationCity:cityWeather.WeatherStationCity,
			weatherId:cityWeather.WeatherID,
			description:cityWeather.Description,
			temperature:cityWeather.Temperature,
			relativeHumidity:cityWeather.RelativeHumidity,
			wind:cityWeather.Wind,
			pressure:cityWeather.Pressure,
			visibility:cityWeather.Visibility,
			windChill:cityWeather.WindChill,
			remarks:cityWeather.Remarks
			)
	}
		
	//return WeatherInformation Object
	def getWeatherInformations(){
		def weatherInformation = sv.getWeatherInformation()
		
		new WeatherInformation(
			weatherId:weatherInformation.WeatherDescription.WeatherID,
			description:weatherInformation.WeatherDescription.Description,
			pictureURL:weatherInformation.WeatherDescription.PictureURL
			)
	}

}
