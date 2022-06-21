package com.vanegas.retry.SpringRetry.service;

import java.net.URISyntaxException;
import java.time.LocalDateTime;

import javax.naming.ServiceUnavailableException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Service;

import com.vanegas.retry.SpringRetry.baeldung.ApiRetryException;

@Service
public class RetryExampleService {

	private static Logger log = LoggerFactory.getLogger(RetryExampleService.class);
    private final RetryTemplate retryTemplate;

    @Autowired
    public RetryExampleService(RetryTemplate retryTemplate) {
        this.retryTemplate = retryTemplate;
    }

    public String retryTemplateExample(String s) {
        String result;
        result = retryTemplate.execute(new RetryCallback<String, RuntimeException>() {
            @Override
            public String doWithRetry(RetryContext retryContext) {
                // do something in this service
                log.info(String.format("Retry retryTemplateExample %d", LocalDateTime.now().getSecond()));
                if (s.equals("error")) {
                    throw new ApiRetryException("Error in process");
                } else {
                    return "Hi " + s;
                }
            }
        });
        log.info("Returning {}", result);
        return result;
    }
}