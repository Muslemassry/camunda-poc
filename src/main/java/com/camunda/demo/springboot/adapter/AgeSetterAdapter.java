package com.camunda.demo.springboot.adapter;

import java.util.Random;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.camunda.demo.springboot.Constants;

@Component
@ConfigurationProperties
public class AgeSetterAdapter implements JavaDelegate {

  @Override
  public void execute(DelegateExecution ctx) throws Exception {
	
	// supposed to call some rest api or mq
    System.out.println("========>>> is being passed: " + (String)ctx.getVariable(Constants.VAR_PASSED_NAME));
    Random random = new Random();
    ctx.setVariable(Constants.VAR_GENERATED_AGE, random.ints(1, 50).findFirst().getAsInt());
  }

}
