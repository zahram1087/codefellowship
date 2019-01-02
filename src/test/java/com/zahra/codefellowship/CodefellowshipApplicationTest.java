package com.zahra.codefellowship;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CodefellowshipApplicationTest {


    
    @LocalServerPort
    private int port;

    @Autowired
    ApplicationUserController controller;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testHomeRout() {
        ResponseEntity<String> response =  this.restTemplate.getForEntity("http://localhost:" + port + "/", String.class);
        assertEquals("The response code should be 200", 200, response.getStatusCodeValue());
        assertTrue("response contain CODEFELLOWSHIP", response.toString().contains("<h2>CODEFELLOWSHIP</h2>"));
    }

    @Test
    public void testSignUpRout() {
        ResponseEntity<String> response = this.restTemplate.getForEntity("http://localhost:" + port + "/signup", String.class);
        assertEquals("The server should give back a 200 response", 200, response.getStatusCodeValue());
        assertTrue("There should be a form that makes a post to /signup within the page", response.toString().contains("<form action=\"/signup\" method=\"POST\">"));
    }

    @Test
    public void testLoginRout() {
        ResponseEntity<String> response = this.restTemplate.getForEntity("http://localhost:" + port + "/login", String.class);
        assertEquals("The server should give back a 200 response", 200, response.getStatusCodeValue());
        assertTrue("There should be a form that makes a post to /perform_login within the page", response.toString().contains("<form action=\"/perform_login\" method=\"POST\">"));
    }
}


