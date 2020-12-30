package org.vivi.httplog.formater;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HttpAccessLog implements Serializable {

    /**
     ************************************ http request  message ************************************
     */

    /**
     * request line , example: GET /index.html HTTP/1.1
     */
    private String requestLine;

    /**
     * request headers
     */
    private Map< String, List< String > > requestHeaders;

    /**
     * request body
     */
    private String requestBody;

    /**
     * ************************************ http response messages ************************************
     *
     */

    /**
     * status line , example: HTTP/1.1 200 ok
     */
    private String responseStatusLine;

    /**
     * response headers
     */
    private Map< String, List< String > > responseHeaders;


    /**
     * http response body
     */
    private String responseBody;


    /**
     * request start time
     */
    private String requestStartTime;

    /**
     * request end time
     */
    private String requestEndTime;

    /**
     * excute time for http handle,unit mill second
     */
    private long excuteTime;

}
