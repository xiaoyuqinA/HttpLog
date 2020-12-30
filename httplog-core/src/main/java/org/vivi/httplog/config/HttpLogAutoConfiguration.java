package org.vivi.httplog.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.vivi.httplog.flusher.Flusher;
import org.vivi.httplog.flusher.HttpLogFlusher;
import org.vivi.httplog.writer.FileWriter;
import org.vivi.httplog.writer.StreamWrite;
import org.vivi.httplog.writer.Writer;
import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Slf4j
@Configuration
@EnableConfigurationProperties(OrgViviHttpLogProperties.class)
@ConditionalOnProperty(name = "org.vivi.httplog.enabled", matchIfMissing = true)
public class HttpLogAutoConfiguration {


    @Bean(name="EmitterProcessor")
    public EmitterProcessor< String > getEmitterProcess(){
        log.info("create an bean called emitter proccessor");
        return  EmitterProcessor.create( );
    }

    @Bean
    public Supplier<Flux< String >> supplier(@Autowired @Qualifier("EmitterProcessor") EmitterProcessor< String > processor  ) {

        log.info("create an bean called supplier");
        return processor::log;

    }

    @Bean
    public Writer ogLogStreamWriter(){
        return  new StreamWrite();
    }

    @Bean
    public Writer fileWriter(){
        return new FileWriter();
    }


    @Bean
    public Flusher flusher(){
        return  new HttpLogFlusher();
    }

}
