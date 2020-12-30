package org.vivi.httplog.writer;


import lombok.extern.slf4j.Slf4j;


@Slf4j
public class FileWriter implements Writer {
    @Override
    public boolean write(String msg) {
        log.info("access log:{}",msg);
        return true;
    }
}
