package ru.stoupin.gateway;

import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import ru.stoupin.gateway.domain.Request;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class RequestContextToRequestConverter {

    public Request convert(RequestContext requestContext) {
        final HttpServletRequest httpServletRequest = requestContext.getRequest();
        Assert.notNull(httpServletRequest, "incorrect call. request is null");

        Request request = new Request();
        request.setRequestMethod(httpServletRequest.getMethod());
        request.setRequestServer(httpServletRequest.getServerName());
        request.setRequestUrl(httpServletRequest.getRequestURI());
        request.setCreated(Timestamp.valueOf(LocalDateTime.now()));

        return request;

    }

}
