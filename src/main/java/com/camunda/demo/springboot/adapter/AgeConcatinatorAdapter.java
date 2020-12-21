package com.camunda.demo.springboot.adapter;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.camunda.demo.springboot.Constants;

@Component
@ConfigurationProperties
public class AgeConcatinatorAdapter implements JavaDelegate {
  @Autowired
  private ProcessEngine camunda;

  @Override
  public void execute(DelegateExecution ctx) throws Exception {
	
	// supposed to call some rest api or mq
	String finalMessage = (String)ctx.getVariable(Constants.VAR_PASSED_NAME)+ " is " + (Integer)ctx.getVariable(Constants.VAR_GENERATED_AGE) + " years old";
	ctx.setVariable(Constants.MSG_NAME_FINAL_MSG, finalMessage);
  }

}
