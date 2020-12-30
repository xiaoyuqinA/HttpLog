package org.vivi.httplog.writer;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import reactor.core.publisher.EmitterProcessor;


@Slf4j
public class StreamWrite implements Writer {

    @Autowired
    @Qualifier("EmitterProcessor")
    EmitterProcessor<String> processor;


    @Override
    public boolean write(String msg) {
        processor.onNext(  msg  );
        return  true;
    }

}
