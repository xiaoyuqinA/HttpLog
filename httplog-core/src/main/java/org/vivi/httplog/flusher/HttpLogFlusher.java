package org.vivi.httplog.flusher;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.vivi.httplog.formater.Formater;
import org.vivi.httplog.formater.HttpAccessLog;
import org.vivi.httplog.writer.Writer;


@Slf4j
public class HttpLogFlusher implements Flusher {
    @Autowired
    protected Writer[] httpLogWriter;

    @Autowired
    protected Formater httpLogFormater;

    @Override
    public boolean flus(HttpAccessLog httpAccessLog) {
        try {
            String text = httpLogFormater.format( httpAccessLog );
            for (Writer writer : httpLogWriter ) {
                writer.write(text);
            }
            return  true;
        }catch ( Exception e ) {
            log.error("http access log flush 失败,{}",e.getMessage(),e);
            return  false;
        }
    }

}
