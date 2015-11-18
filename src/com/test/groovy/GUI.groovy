package com.test.groovy

import groovy.swing.SwingBuilder

import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.JTextField

class GUI extends SwingBuilder{
	
	def frame
	def contentPane
	def lblZip
	def lblState
	def	lblCity
	def	lblForeCast
	def	lblFcDate
	def	lblFcWeatherID
	def	lblFcDesciption
	def	lblFcTemperature
	def	lblMorningLow
	def	lblDaytimeHigh
	def	lblPrecipNighttime
	def	lblPrecipDaytime
	
	def edt(){
		frame = new JFrame(
			title:'Weather Application',
			defaultCloseOperation:JFrame.EXIT_ON_CLOSE,
			size:[300,300],
			locationRelativeTo:null
			)
		
		contentPane = new JPanel()
		contentPane = frame.contentPane
		contentPane.layout = borderLayout()
		
		lblZip = new JLabel('Zip :')
		txtZip = new JTextField(columns:10)
		
		frame.show()
	}
	
}
