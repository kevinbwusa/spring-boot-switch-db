package com.example.springboottutorialvalidate.service.auto;

import com.example.springboottutorialvalidate.service.AutoServiceBase;
import org.springframework.stereotype.Service;

@Service
public class AutoService extends AutoServiceBase {

    public void run() {
        this.autoUtil.autoTest();
    }
}
