package com.infy.springbootrestapicrud.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse<T> {
	private Integer statuscode;
	 private String msg;
	 private T resposedata;


}
