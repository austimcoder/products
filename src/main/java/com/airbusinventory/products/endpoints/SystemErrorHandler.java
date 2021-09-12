package com.airbusinventory.products.endpoints;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SystemErrorHandler implements ErrorController {

	@RequestMapping("/error")
	protected String handleError(HttpServletRequest httpRequest) throws IOException {
		return String.format("<H1>%s</H1><H3>%s</H3>%s", httpRequest.getAttribute(RequestDispatcher.ERROR_STATUS_CODE),
				httpRequest.getAttribute(RequestDispatcher.ERROR_MESSAGE),
				httpRequest.getReader().lines().collect(Collectors.joining()));
	}

}
