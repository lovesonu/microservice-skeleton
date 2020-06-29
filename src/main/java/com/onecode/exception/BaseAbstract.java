package com.onecode.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.transaction.Transactional;
import java.util.Map;

/**
 * @author :One_Code
 */
@Transactional
public abstract class BaseAbstract {

    public void addSuccess(Map<String, Object> resMap, String string) {
        resMap.put(CommonConstant.BSTATUS, true);
        resMap.put(CommonConstant.IHTTPCODE, HttpStatus.OK.value());
    }
    public Integer getStatusCode(String s) {
        Integer statusCode = null;
        if (s.equals("create")) {
            statusCode = HttpStatus.CREATED.value();

        } else if (s.equals("update") || s.equals("delete") || s.equals("get")) {

            statusCode = HttpStatus.OK.value();

        } else if (s.equals(Constants.DATA_FOUND)) {

            statusCode = HttpStatus.FOUND.value();

        }
        return statusCode;
    }

    public HttpStatus getStatus(String s) {
        HttpStatus statusCode = null;
        if (s.equals("create")) {
            statusCode = HttpStatus.CREATED;
        } else if (s.equals("update") || s.equals("delete") || s.equals("get")) {
            statusCode = HttpStatus.OK;
        } else if (s.equals("RecordFound")) {
            statusCode = HttpStatus.FOUND;
        }
        return statusCode;
    }

    public void addError(String errorMessage, Map<String, Object> resMap) {
        resMap.put(Constants.MESSAGE, errorMessage);
        resMap.put(Constants.STATUS, false);
    }

    public void addRequiredParamError(Map<String, Object> resMap) {
        resMap.put(Constants.MESSAGE, "Required parameters must not be empty.");
        resMap.put(Constants.STATUS, false);
    }

    public void addServiceError(Map<String, Object> resMap) {
        resMap.put(Constants.MESSAGE, "Oops!!! Something went wrong. Please try again.");
        resMap.put(Constants.STATUS, false);
    }

    public ResponseEntity<Map<String, Object>> renderResponse(Map<String, Object> resMap) {
        return new ResponseEntity<>(resMap, HttpStatus.OK);
    }

    /**
     * @param params **params**.
     * @return boolean
     */
    protected boolean validateRequiredParams(String... params) {
        for (String param : params) {
            if (param == null || param.equalsIgnoreCase("")) {
                return false;
            }
        }
        return true;
    }
}
