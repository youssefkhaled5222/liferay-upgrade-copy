package com.ejada.telemoney.common.configs.services.impl;

import com.ejada.telemoney.common.configs.configuration.HeaderChannelConfiguration;
import com.ejada.telemoney.common.configs.enums.ACCESS;
import com.ejada.telemoney.common.configs.services.RoleChannelMapService;
import com.ejada.telemoney.common.configs.utils.ChannelRoleMappingParser;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.osgi.service.component.annotations.*;
import java.util.*;

@Component(
        immediate = true,
        configurationPid = "com.ejada.telemoney.common.configs.configuration.HeaderChannelConfiguration",
        configurationPolicy = ConfigurationPolicy.OPTIONAL,
        service = RoleChannelMapService.class
)
public class RoleChannelMapServiceImpl implements RoleChannelMapService {
    private static final Log LOG = LogFactoryUtil.getLog(RoleChannelMapServiceImpl.class);


    @Activate
    @Modified
    protected void activate(Map<String, Object> properties) {
        HeaderChannelConfiguration config =
                ConfigurableUtil.createConfigurable(HeaderChannelConfiguration.class, properties);
        _roleChannelMappings = ChannelRoleMappingParser.parse(config.roleChannelMappings());
    }

    @Override
    public  Set<String> getChannelsByRole(List<String> roles) {
        Map<String, Set<String>> mappings = _roleChannelMappings;
        Set<String> allowedChannels = new HashSet<>();
        try {
            for (String role : roles) {
                if (role== null) {
                    continue;
                }
                if(role.equalsIgnoreCase("Administrator"))
                {
                    allowedChannels.add(ACCESS.FULL_ACCESS.toString());
                    return allowedChannels;
                }

                String roleKey = role.trim().toLowerCase();
                Set<String> value = mappings.get(roleKey);

                if (value != null) {
                    allowedChannels.addAll(value);
                }
            }
        } catch (Exception e) {
            LOG.error("Unable to get channels for this roles " + roles + ", showing all channels", e);
            allowedChannels.add(ACCESS.NO_ACCESS.toString());
            return allowedChannels;
        }


        return allowedChannels;
    }

    private volatile Map<String, Set<String>> _roleChannelMappings = Collections.emptyMap();
}