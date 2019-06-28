package com.Learning.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Cities 
{
	 private String temperature;

	    private String windDirectionDegree;

	    private String humidity;

	    private String weatherDescription;

	    private String windSpeed;

	    private String city;

	    public String gettemperature ()
	    {
	        return temperature;
	    }

	    public void settemperature (String Temperature)
	    {
	        this.temperature = temperature;
	    }

	    public String getwindDirectionDegree ()
	    {
	        return windDirectionDegree;
	    }

	    public void setwindDirectionDegree (String windDirectionDegree)
	    {
	        this.windDirectionDegree = windDirectionDegree;
	    }

	    public String gethumidity ()
	    {
	        return humidity;
	    }

	    public void sethumidity (String humidity)
	    {
	        this.humidity = humidity;
	    }

	    public String getweatherDescription ()
	    {
	        return weatherDescription;
	    }

	    public void setweatherDescription (String weatherDescription)
	    {
	        this.weatherDescription = weatherDescription;
	    }

	    public String getwindSpeed ()
	    {
	        return windSpeed;
	    }

	    public void setwindSpeed (String windSpeed)
	    {
	        this.windSpeed = windSpeed;
	    }

	    public String getcity ()
	    {
	        return city;
	    }

	    public void setcity (String city)
	    {
	        this.city = city;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [Temperature = "+temperature+", windDirectionDegree = "+windDirectionDegree+", humidity = "+humidity+", weatherDescription = "+weatherDescription+", windSpeed = "+windSpeed+", city = "+city+"]";
	    }
	
}
