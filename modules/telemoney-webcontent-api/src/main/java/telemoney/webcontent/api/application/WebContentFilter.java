package telemoney.webcontent.api.application;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;

public class WebContentFilter implements ContainerResponseFilter {
	private static final Log LOG = LogFactoryUtil.getLog(TelemoneyWebcontentApiApplication.class);

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {
		LOG.info("------------------- WEB CONTENT Response -------------------");
		LOG.info(responseContext.getEntity());
	}

}
