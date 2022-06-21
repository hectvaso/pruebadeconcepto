package com.vanegas.retry.SpringRetry;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vanegas.retry.SpringRetry.baeldung.ApiRetryException;
import com.vanegas.retry.SpringRetry.service.RetryExampleService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RetryTemplateExampleServiceTest {

	@Autowired
    private RetryExampleService retryTemplateExampleService;

    @Test(expected = ApiRetryException.class)
    public void retryTemplateExampleShouldThrowRuntime() throws Exception {
        retryTemplateExampleService.retryTemplateExample("error");
    }

    @Test
    public void retryTemplateExampleShouldReturnCorrectValue() throws Exception {
        String s = retryTemplateExampleService.retryTemplateExample("word");
        Assert.assertEquals("Hi word", s);
    }

}