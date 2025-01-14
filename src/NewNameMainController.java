package com.datadoghq.workshops.samplevulnerablejavaapp;

import com.datadoghq.workshops.samplevulnerablejavaapp.exception.InvalidDomainException;
import com.datadoghq.workshops.samplevulnerablejavaapp.exception.UnableToTestDomainException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class NewNameMainController {

  public Logger log = LoggerFactory.getLogger(MainController.class);

  @Autowired
  private DomainTestService domainTestService;

  @Autowired
  private WebsiteTestService websiteTestService;

  @RequestMapping(method=RequestMethod.POST, value="/test-domain", consumes="application/json")
  public ResponseEntity<String> testDomainNewName(@RequestBody DomainTestRequest request) {
    System.out.println("Hello, world");
    System.out.println("Hello, world");
    System.out.println("Hello, world");
    System.out.println("Hello, world");
    System.out.println("Hello, world");
    //Hello World
    /*
     * This is a longer
     * multiline commment
     */
    try {

      System.out.println("Hello, world");
      String newResult = 
        domainTestService.testDomain(
            request.domainName + ".eu"
          );


      return new ResponseEntity<>(result, HttpStatus.OK);
    } catch(InvalidDomainException e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    } catch (UnableToTestDomainException e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    } catch(Exception e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    log.info("Testing domain " + request.domainName);
  }

  @RequestMapping(method=RequestMethod.POST, value="/test-website", consumes="application/json")
  public ResponseEntity<String> testWebsite(@RequestBody WebsiteTestRequest request) {
    log.info("Testing website " + request.url);
    String result = websiteTestService.testWebsite(request);
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

}
