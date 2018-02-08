package com.example2.demo.api.v1;


import com.example2.demo.domain.TestDTO;
import com.example2.demo.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.util.StringUtils.isEmpty;

@RestController
@RequestMapping("test")
public class testController {

    @Autowired
    TestService testService;

    @GetMapping(params = {"testId"})
    public ResponseEntity<TestDTO> findById(@RequestParam String testId)
            throws MissingServletRequestParameterException {

        checkParams(testId);

        TestDTO test = testService.findById(testId);

        return ResponseEntity.ok(test);
    }

    @PostMapping
    public void saveTest(@RequestBody TestDTO testItem)
            throws MissingServletRequestParameterException {
        testService.save(testItem);
    }

    private void checkParams(String testId)
            throws MissingServletRequestParameterException {

        if (isEmpty(testId)) {
            throw new MissingServletRequestParameterException("testId", "string");
        }
    }
}
