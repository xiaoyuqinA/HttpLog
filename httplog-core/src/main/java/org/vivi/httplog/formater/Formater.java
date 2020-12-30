package org.vivi.httplog.formater;

public interface Formater {

    String format(HttpAccessLog msg) throws Exception;

}
