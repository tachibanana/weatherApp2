package com.test.groovy

import groovy.swing.SwingBuilder

import java.awt.BorderLayout
import java.awt.event.ActionListener

import javax.swing.JButton
import javax.swing.JComboBox
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JOptionPane
import javax.swing.JPanel
import javax.swing.JScrollPane
import javax.swing.JTextArea
import javax.swing.JTextField


class GUI extends SwingBuilder{
		
	//revalidate()
	def frame
	def contentPane
	def topPanel
	def centerPanel
	def bottomPanel
	def btnNext
	def btnPrev
	def cbo
	def lblZip
	def txtZip
	def btnOk
	def txArea
	def sp
	def counter
	def zip
	def max
	
	
	def edt(){
		frame = new JFrame(
			title:'Weather Application',
			defaultCloseOperation:JFrame.EXIT_ON_CLOSE,
			size:[500,330],
			locationRelativeTo:null
			)
		
		topPanel = new JPanel()
		centerPanel = new JPanel()
		bottomPanel = new JPanel()
		contentPane = new JPanel()
		contentPane = frame.contentPane
		contentPane.layout = borderLayout()
		contentPane.add(topPanel,BorderLayout.NORTH)
		contentPane.add(centerPanel,BorderLayout.CENTER)
		contentPane.add(bottomPanel,BorderLayout.SOUTH)
		
		lblZip = new JLabel('Zip :')
		txtZip = new JTextField(columns:10)			
		btnOk = new JButton(text:'submit')
		btnOk.addActionListener(clickSubmit as ActionListener)
		txArea = new JTextArea(13,40)
		txArea.setEditable(false)
		sp = new JScrollPane(txArea)
		cbo = new JComboBox()
		btnPrev = new JButton('Prev')
		btnPrev.addActionListener(clickPrev as ActionListener)
		btnNext = new JButton('Next')
		btnNext.addActionListener(clickNext as ActionListener)
		
		cbo.addItem('City Forecast')
		cbo.addItem('City Weather')
		cbo.addItem('Weather Information')
		
		topPanel.layout = flowLayout()
		topPanel.add(lblZip)
		topPanel.add(txtZip)
		topPanel.add(cbo)
		topPanel.add(btnOk)
		centerPanel.add(sp)		
		bottomPanel.add(btnPrev)
		bottomPanel.add(btnNext)

		frame.show()
	}
	
	
	def clickSubmit = {
		txArea.text = ''
		zip = txtZip.text
		counter = 0
		if(cbo.getSelectedIndex() == 0){
			def data = new Util().getCityForecast(txtZip.text)
			if(data.success.equals('true')){
				txArea.append("State : ${data.state}\nCity : ${data.city}\nWeather Station City: ${data.weatherStationCity}\n\nForecast :\n")
				txArea.append("Date : ${data.forecast.date[counter]}\nWeatherID : ${data.forecast.weatherId[counter]}\nDescription : ${data.forecast.desciption[counter]}")
				txArea.append("\n\nTemperatures :\nMorningLow : ${data.forecast.tempMorningLow[counter]}\nDayTime : ${data.forecast.tempDayTime[counter]}")
				txArea.append("\n\nProbabilityOfPrecipiation :\nNighttime : ${data.forecast.probNightTime[counter]}\nDaytime : ${data.forecast.probDaytime[counter]}")
			}else
				JOptionPane.showMessageDialog(frame , "Invalid Zip")
			
		}else if(cbo.getSelectedIndex() == 1){
			def data = new Util().getCityWeather(txtZip.text)
			if(data.success.equals('true')){
				txArea.append("State : ${data.state}\nCity : ${data.city}\nWeatherStationCity: ${data.weatherStationCity}\nWeatherID : ${data.weatherId} \nDescription : ${data.description}\nTemperature : ${data.temperature}\nRelativeHumidity: ${data.relativeHumidity}\nWind: ${data.wind}\nPressure: ${data.pressure}\nVisibility: ${data.visibility}\nWindChill: ${data.windChill}\nRemarks: ${data.remarks}")
			}else
				JOptionPane.showMessageDialog(frame , "Invalid Zip")
		}else if(cbo.getSelectedIndex() == 2){
			def data = new Util().getWeatherInformations()
				txArea.append("WeatherId : ${data.weatherId[counter]}\nDescription : ${data.description[counter]}")
		}
					
	}
	
	def clickNext = {
		txArea.text = ''
		counter ++
		if(cbo.getSelectedIndex() == 0){
			def data = new Util().getCityForecast(zip)
			if(data.success.equals('true')){
				txArea.append("State : ${data.state}\nCity : ${data.city}\nWeather Station City: ${data.weatherStationCity}\n\nForecast :\n")
				txArea.append("Date : ${data.forecast.date[counter]}\nWeatherID : ${data.forecast.weatherId[counter]}\nDescription : ${data.forecast.desciption[counter]}")
				txArea.append("\n\nTemperatures :\nMorningLow : ${data.forecast.tempMorningLow[counter]}\nDayTime : ${data.forecast.tempDayTime[counter]}")
				txArea.append("\n\nProbabilityOfPrecipiation :\nNighttime : ${data.forecast.probNightTime[counter]}\nDaytime : ${data.forecast.probDaytime[counter]}")
			}
			
		}else if(cbo.getSelectedIndex() == 1){
			def data = new Util().getCityWeather(zip)
			if(data.success.equals('true')){
				txArea.append("State : ${data.state}\nCity : ${data.city}\nWeatherStationCity: ${data.weatherStationCity}\nWeatherID : ${data.weatherId} \nDescription : ${data.description}\nTemperature : ${data.temperature}\nRelativeHumidity: ${data.relativeHumidity}\nWind: ${data.wind}\nPressure: ${data.pressure}\nVisibility: ${data.visibility}\nWindChill: ${data.windChill}\nRemarks: ${data.remarks}")
			}
		}else if(cbo.getSelectedIndex() == 2){
			def data = new Util().getWeatherInformations()
				txArea.append("WeatherId : ${data.weatherId[counter]}\nDescription : ${data.description[counter]}")
		}
		
	}
	def clickPrev = {
		txArea.text = ''
		if(counter != 0)
			counter --
		if(cbo.getSelectedIndex() == 0){
			def data = new Util().getCityForecast(zip)
			if(data.success.equals('true')){
				txArea.append("State : ${data.state}\nCity : ${data.city}\nWeather Station City: ${data.weatherStationCity}\n\nForecast :\n")
				txArea.append("Date : ${data.forecast.date[counter]}\nWeatherID : ${data.forecast.weatherId[counter]}\nDescription : ${data.forecast.desciption[counter]}")
				txArea.append("\n\nTemperatures :\nMorningLow : ${data.forecast.tempMorningLow[counter]}\nDayTime : ${data.forecast.tempDayTime[counter]}")
				txArea.append("\n\nProbabilityOfPrecipiation :\nNighttime : ${data.forecast.probNightTime[counter]}\nDaytime : ${data.forecast.probDaytime[counter]}")
			}
			
		}else if(cbo.getSelectedIndex() == 1){
			def data = new Util().getCityWeather(zip)
			if(data.success.equals('true')){
				txArea.append("State : ${data.state}\nCity : ${data.city}\nWeatherStationCity: ${data.weatherStationCity}\nWeatherID : ${data.weatherId} \nDescription : ${data.description}\nTemperature : ${data.temperature}\nRelativeHumidity: ${data.relativeHumidity}\nWind: ${data.wind}\nPressure: ${data.pressure}\nVisibility: ${data.visibility}\nWindChill: ${data.windChill}\nRemarks: ${data.remarks}")
			}
		}else if(cbo.getSelectedIndex() == 2){
			def data = new Util().getWeatherInformations()
				txArea.append("WeatherId : ${data.weatherId[counter]}\nDescription : ${data.description[counter]}")
		}
		
	}
	
		
}
