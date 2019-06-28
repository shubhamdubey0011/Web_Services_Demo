package com.Learning.WebServices;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class RegistrationFailureResponse {
	@JsonIgnoreProperties
	String FaultId;
	@JsonIgnoreProperties
	String fault;

}
