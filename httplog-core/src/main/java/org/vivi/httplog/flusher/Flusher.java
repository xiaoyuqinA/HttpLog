package org.vivi.httplog.flusher;

import org.vivi.httplog.formater.HttpAccessLog;

public interface Flusher {
    boolean flus(HttpAccessLog httpAccessLog);
}
