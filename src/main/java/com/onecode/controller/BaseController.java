package com.onecode.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.onecode.exception.BaseAbstract;
import com.onecode.exception.ResourceNotFoundException;

/**
 * @author :ONE_CODE
 */

public class BaseController extends BaseAbstract implements MessageSourceAware {

	private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

	private MessageSource messageSource;

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String, Object>> resourcesNotFoundHandler(
			ResourceNotFoundException resourceNotFoundException, HttpServletRequest req, Exception e) {
		String errorCode = resourceNotFoundException.getErrorCode();
		Map<String, Object> message = getmessage(errorCode);
		return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
	}

	private Map<String, Object> getmessage(String errorCode) {
		Map<String, Object> map = new HashMap<>();
		map.put("message", messageSource.getMessage(errorCode, null, Locale.US));
		map.put("statusCode", HttpStatus.NOT_FOUND.value());
		map.put("error", HttpStatus.NOT_FOUND);
		logger.info(messageSource.getMessage(errorCode, null, Locale.US), HttpStatus.NOT_FOUND.value(),
				HttpStatus.NOT_FOUND);
		return map;
	}

	@Override
	public void setMessageSource(MessageSource messageSource) {

		this.messageSource = messageSource;
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}