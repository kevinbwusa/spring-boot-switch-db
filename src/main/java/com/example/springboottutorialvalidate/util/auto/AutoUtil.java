package com.example.springboottutorialvalidate.util.auto;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AutoUtil {

    public void autoTest() {
        log.info("成功呼叫component方法");
    }
}
