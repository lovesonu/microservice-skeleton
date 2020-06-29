package com.onecode.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "OneCode operations", tags = {"oneCode.com"})
@ApiResponses({@ApiResponse(code = 200, message = "Successful."),
        @ApiResponse(code = 204, message = "Successful, no content."),
        @ApiResponse(code = 400, message = "Bad request. Validation failure."),
        @ApiResponse(code = 201, message = "Entity created"), @ApiResponse(code = 404, message = "Entity not found"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 500, message = "Internal Server Error")})
@Validated
public class OneCodeController extends BaseController {

    @ApiOperation("Check availability ")
    @GetMapping(value = "/")
    public String home() {
        return "Welcome to one_code........!";
    }

}
