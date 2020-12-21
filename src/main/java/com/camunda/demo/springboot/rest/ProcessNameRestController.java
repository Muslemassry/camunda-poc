package com.camunda.demo.springboot.rest;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.variable.Variables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.camunda.demo.springboot.Constants;

@RestController
@RequestMapping("/precessName")
public class ProcessNameRestController {
  
  @Autowired
  private ProcessEngine camunda;

  @RequestMapping(method=RequestMethod.POST)
  public void placeOrderPOST(String name) {
	  precessName(name);
  }

  public ProcessInstance precessName(String name) {
    return camunda.getRuntimeService().startProcessInstanceByKey(
    		Constants.PROCESS_KEY,
    		Variables.putValue(Constants.VAR_PASSED_NAME, name));
  }
}
