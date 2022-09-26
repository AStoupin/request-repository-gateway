package ru.stoupin.gateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.stoupin.gateway.domain.Request;
import ru.stoupin.gateway.service.RequestService;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

@Slf4j
@Component
public class RegistryFilter  extends ZuulFilter {
    @Autowired
    private RequestService requestService;
    @Autowired
    private RequestContextToRequestConverter requestContextToRequestConverter;

    public RegistryFilter() {
        log.info("RegistryFilter created");
    }

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        Request request =  requestContextToRequestConverter.convert(ctx);
        requestService.registerRequest(request);

        return null;
    }


}
